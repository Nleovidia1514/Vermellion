package com.labc.Vermellion.Entities.Enemies;

import com.labc.Vermellion.Start;
import com.labc.Vermellion.Entities.Enemy;
import com.labc.Vermellion.Entities.EntityDecorator;
import com.labc.Vermellion.Items.Equipment;

public class Bear extends EntityDecorator implements AttackAble{

	public Bear(Enemy enemy) {
		super(enemy);
	}

	@Override
	public void attack() {
		int totalDamage = position.player.getHP()-(CalculateDamage());
		Start.ta.append("\n*Angry bear sounds*");
		position.player.setHP(totalDamage);
		Start.ta.append("\nThe bear dealed "+CalculateDamage()+" damage to you.");
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

	@Override
	public void beAttacked(int damage) {
		super.beAttacked(damage);
		Start.ta.append("\n*Hurted bear sounds*");
		Start.ta.append("\nYou dealt "+damage+" damage to the "+this.name+".");
		this.HP -= damage;
		if(this.HP<=0) {
			Start.ta.append("\n*Sad bear sounds*");
			Start.ta.append("\nThe bear died.");
			this.die();
		}
		else
			this.attack();
			
	}
	
	@Override 
	public void beShot(int damage) {
		super.beShot(damage);
		this.HP = this.HP - damage;
		Start.ta.append("\n*Shot at bear sounds*");
		if(this.HP<=0) {
			Start.ta.append("\n*Sad bear sounds*");
			Start.ta.append("\nThe bear died.");
			this.die();
		}
			
	}

	@Override
	public void die() {
		super.die();
		this.position.mob = null;
		this.position.hasEnemy = false;
		this.position.shortDescription = this.position.descripts.shortDescsAftFight.get(this.position.name);
		this.position.longDescription = this.position.descripts.longDescsAftFight.get(this.position.name);
	}
	
	@Override 
	public void talk() {
		Start.ta.setText("*Confused bear sounds*");
		this.attack();
	}
	
	@Override
	public void create() {
		super.create();
		this.HP = this.HP + 400;
		this.ATTACK = this.ATTACK + 150;
		this.name = "Bear";
	}
	
	
	private int CalculateDamage() {
		int damage = this.ATTACK-this.getPos().player.getResistance();
		if(damage < 0)
			damage = 0;
		return damage;
	}
}
