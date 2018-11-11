package com.labc.Vermellion.Entities.Enemies;

import com.labc.Vermellion.Entity;
import com.labc.Vermellion.Entities.EntityDecorator;

public class Creeper extends EntityDecorator implements AttackAble {
	
	public Creeper(Entity entity) {
		super(entity);
	}

	@Override
	public void attack() {
		int totalDamage = position.player.getHP() - CalculateDamage();
		System.err.println("\nPsssssssssst...");
		position.player.setHP(totalDamage);
		System.out.println("The "+this.name+" dealt "+totalDamage+" damage to you.");
		this.die();
	}

	@Override
	public void beAttacked(int damage) {
		super.beAttacked(damage);
		System.err.println("\nPssssssssstt... x_x");
		this.HP -= damage;
		if(this.HP<=0) 
			die();
		else
			this.attack();
	}

	@Override
	public void die() {
		super.die();
		this.position.mob = null;
		this.position.hasEnemy = false;
		this.position.shortDescription = this.position.descripts.shortDescsAftFight.get(this.position.name);
		this.position.longDescription = this.position.descripts.longDescsAftFight.get(this.position.name);
		System.out.println("\nPsssssssssst D:");
		System.out.println("The creeper died.");
	}
	
	@Override
	public void talk() {
		System.err.println("Pssssssssssssssssssssssssst.");
		this.attack();
	}
	
	@Override
	public void create() {
		super.create();
		this.HP = this.HP + 100;
		this.ATTACK = this.ATTACK + 200;
		this.name = "Creeper";
	}
	
	@Override
	public void beShot(int damage) {
		super.beShot(damage);
		System.err.println("\nPssssssssstt... x_x");
		System.out.println("You made "+damage+" damage to the "+this.name+".");
		this.HP -= damage;
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
