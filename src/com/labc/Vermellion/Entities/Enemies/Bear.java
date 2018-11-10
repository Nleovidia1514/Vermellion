package com.labc.Vermellion.Entities.Enemies;

import com.labc.Vermellion.Entities.Enemy;
import com.labc.Vermellion.Entities.EnemyDecorator;

public class Bear extends EnemyDecorator{

	public Bear(Enemy enemy) {
		super(enemy);
	}

	@Override
	public void attack() {
		super.attack();
		int totalDamage = position.player.getHP()-(CalculateDamage());
		System.out.println("*Angry bear sounds*");
		position.player.setHP(totalDamage);
		System.out.println("The bear dealed "+totalDamage+" damage to you.");
	}

	@Override
	public void beAttacked(int damage) {
		super.beAttacked(damage);
		System.out.println("*Hurted bear sounds*");
		System.out.println("You made "+damage+" damage to the "+this.name+".");
		this.HP -= damage;
		if(this.HP<=0) 
			die();
		else
			this.attack();
			
	}
	
	@Override 
	public void beShot(int damage) {
		super.beShot(damage);
		this.HP = this.HP - damage;
		System.out.println("\n*Shot at bear sounds*");
		if(this.HP<=0)
			this.die();
	}

	@Override
	public void die() {
		super.die();
		this.position.mob = null;
		this.position.hasEnemy = false;
		this.position.shortDescription = this.position.descripts.shortDescsAftFight.get(this.position.name);
		this.position.longDescription = this.position.descripts.longDescsAftFight.get(this.position.name);
		System.out.println("*Sad bear sounds*");
		System.out.println("The bear died.");
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
