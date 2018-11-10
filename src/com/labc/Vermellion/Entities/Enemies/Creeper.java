package com.labc.Vermellion.Entities.Enemies;

import com.labc.Vermellion.Tile;
import com.labc.Vermellion.Entities.Enemy;
import com.labc.Vermellion.Entities.EnemyDecorator;

public class Creeper extends EnemyDecorator {
	
	public Creeper(Enemy enemy) {
		super(enemy);
	}

	@Override
	public void attack() {
		super.attack();
		int totalDamage = position.player.getHP() - CalculateDamage();
		System.out.println("\nPsssssssssst...");
		position.player.setHP(totalDamage);
		System.out.println("The "+this.name+" dealt "+totalDamage+" damage to you.");
	}

	@Override
	public void beAttacked(int damage) {
		super.beAttacked(damage);
		System.out.println("\nPssssssssstt... x_x");
		System.out.println("You made "+damage+" damage to the "+this.name+".");
		this.HP -= damage;
		if(this.HP<=0) 
			die();
		else
			this.attack();
			
	}

	@Override
	public void die() {
		super.die();
		this.position.enemy = null;
		this.position.hasEnemy = false;
		System.out.println("\nPsssssssssst D:");
		System.out.println("The creeper died.");
	}
	
	@Override
	public void create() {
		super.create();
		this.HP = this.HP + 100;
		this.ATTACK = this.ATTACK + 150;
		this.name = "Creeper";
	}
	
	@Override
	public void beShot(int damage) {
		super.beShot(damage);
		System.out.println("\nPssssssssstt... x_x");
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
