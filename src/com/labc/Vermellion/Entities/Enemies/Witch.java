package com.labc.Vermellion.Entities.Enemies;

import com.labc.Vermellion.PoisonedState;
import com.labc.Vermellion.Start;
import com.labc.Vermellion.Entities.Enemy;
import com.labc.Vermellion.Entities.EntityDecorator;
import com.labc.Vermellion.Items.Equipment;

public class Witch extends EntityDecorator implements AttackAble{
	
	public Witch(Enemy enemy) {
		super(enemy);
		this.HP = 150;
		this.ATTACK = 90;
		this.name = "Witch";
	}

	@Override
	public void attack() {
		int totalDamage = this.position.player.getHP() - CalculateDamage();
		int z = 0;
		if(z == 0 ) {
			Poison();
		}
		else {
			Start.ta.append("\nThe witch attacks you and deals "+CalculateDamage()+" damage.");
			this.position.player.setHP(totalDamage);
			for(String damage : this.position.player.equipment)
			{
				for(int i=0;i<this.position.player.inventory.size();i++) {
					Equipment piece = (Equipment) this.position.player.inventory.get(i);
					if(piece.getName().equalsIgnoreCase(damage) 
							&& piece.getCategory() != Equipment.weapon )
						piece.reduceDurability();
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
		Start.ta.append("\nThe witch makes disturbing noises, this let's you know that you're hurting her."
				+ " for "+damage+" damage.");
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
		Start.ta.setText("Eat this apple young adventurer. It will make you feel better. >:)");
		Start.ta.append("\nThe witch poisoned you for 5 turns");
		this.Poison();
	}
	
	@Override
	public void create() {
		this.HP = this.HP + 200;
		this.ATTACK = this.ATTACK + 40;
		this.name = "Witch";
	}
	
	@Override 
	public void beShot(int damage) {
		Start.ta.append("\nThe witch makes disturbing noises, this let's you know that you're hurting her");
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
}
