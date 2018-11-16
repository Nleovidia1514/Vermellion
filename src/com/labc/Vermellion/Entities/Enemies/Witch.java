package com.labc.Vermellion.Entities.Enemies;

import com.labc.Vermellion.Descriptions;
import com.labc.Vermellion.PoisonedState;
import com.labc.Vermellion.Start;
import com.labc.Vermellion.Classes.TextFieldStates.PlayState;
import com.labc.Vermellion.Classes.TextFieldStates.WitchState;
import com.labc.Vermellion.Entities.Enemy;
import com.labc.Vermellion.Entities.EntityDecorator;
import com.labc.Vermellion.Items.Equipment;

public class Witch extends EntityDecorator implements AttackAble{
	
	public Witch(Enemy enemy) {
		super(enemy);
	}

	@Override
	public void attack() {
		int totalDamage = (int) (this.position.player.getHP() - CalculateDamage());
		if(!this.position.player.getCharacterstate().equals(PoisonedState.instance()) ) {
			Poison();
		}
		else {
			Start.ta.append("\nThe witch attacks you and deals "+CalculateDamage()+" damage.");
			this.position.player.setHP(totalDamage);
			for(String damage : this.position.player.equipment)
			{
				for(int i=0;i<this.position.player.inventory.size();i++) {
					try {
						Equipment piece = (Equipment) this.position.player.inventory.get(i);
						if(piece.getName().equalsIgnoreCase(damage) 
								&& piece.getCategory() != Equipment.weapon )
							piece.reduceDurability();
					}catch(Exception e) {}
				}
			}
		}
	}
	
	private void Poison() {
		this.position.player.setCharacterState(PoisonedState.instance());
		PoisonedState.instance().turnsSuffered = 0;
		PoisonedState.instance().turnsPoisoned = 5;
	}

	@Override
	public void beAttacked(int damage) {
		if(this.name.equalsIgnoreCase("OLD LADY")) {
			Start.ta.append("\nThe old lady made disturbing noises and turns into a witch. "
					+ "Who would've said so?");
			this.name = "Witch";
			this.position.hasEnemy = true;
			Start.pic.setIcon(Descriptions.Witch);
		}
		else {
			Start.ta.append("\nThe witch makes disturbing noises, this let's you know that you're hurting her."
					+ " for "+damage+" damage.");
		}
		this.HP = this.HP-damage;
		if(this.HP<=0) {
			this.die();
			Start.ta.append("\nThe witch died.");
		}
		else
			this.attack();
	}

	@Override
	public void die() {
		this.position.shortDescription = this.position.descripts.shortDescsAftFight.get(this.position.name);
		this.position.longDescription = this.position.descripts.longDescsAftFight.get(this.position.name);
		this.position.hasEnemy = false;
		this.position.mob = null;
	}
	
	@Override
	public void talk() {
		if(!this.alreadyTalkedTo) {
			Start.ta.setText("Eat this apple young adventurer. It will make you feel better. >:)"
					+ "\n\tWill you accept it?");
			Start.tfState = WitchState.instance();
		}
		else {
			Start.ta.setText("I won't talk to you bitch.");
			this.attack();
		}
	}
	
	@Override
	public void create() {
		super.create();
		this.HP = this.HP + 200;
		this.ATTACK = this.ATTACK + 40;
		this.name = "Old lady";
	}
	
	@Override 
	public void beShot(int damage) {
		if(this.name.equalsIgnoreCase("OLD LADY")) {
			Start.ta.setText("Old Lady - Oh you're a clever one, aren't ya?");
			Start.ta.append("The old lady resulted to be a witch. Who would've guessed?");
			this.position.hasEnemy = true;
			this.name = "Witch";
			Start.pic.setIcon(Descriptions.Witch);
			Start.tfState = PlayState.instance();
			this.alreadyTalkedTo = true;
		}
		else {
			Start.ta.append("\nThe witch makes disturbing noises, this let's you know that you're hurting her");
		}
		this.HP = this.HP-damage;
		if(this.HP<=0) 
			die();
	}
	
	private int CalculateDamage() {
		int damage = this.ATTACK-this.getPos().player.getResistance();
		if(damage < 0)
			damage = 0;
		return damage;
	}
	
	public void makeDecision(String decision) {
		if(decision.trim().equalsIgnoreCase("YES") || decision.trim().equalsIgnoreCase("NO")) {
			if(decision.trim().equalsIgnoreCase("YES")) {
				this.Poison();
				Start.ta.setText("Old lady - HAHAHAHAHAHAAHAH! You fool!");
				Start.ta.append("\nThe old lady poisoned you for 5 turns. She resulted to be a witch."
						+ " Who would've guessed?");
			}
			else if(decision.trim().equalsIgnoreCase("NO")) {
				Start.ta.setText("Old lady - Well that's too bad... i was hoping we could do this the easy way"
						+ " >:(");
				Start.ta.append("\nThe old lady resulted to be a witch and now she is trying to kill you."
						+ " Who would've guessed?");
			}
		}
		else {
			Start.ta.setText("OldLady - I don't have time for your nonsense stupid kid.");
			Start.ta.append("\nThe old lady resulted to be a witch and now she is tyring to kill you."
					+ " Who would've guessed?");
		}
		this.position.hasEnemy = true;
		this.name = "Witch";
		Start.pic.setIcon(Descriptions.Witch);
		Start.tfState = PlayState.instance();
		this.alreadyTalkedTo = true;
	}
}
