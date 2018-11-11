package com.labc.Vermellion.Entities.Enemies;

import com.labc.Vermellion.Entities.Enemy;
import com.labc.Vermellion.Entities.EntityDecorator;

public class Cornieles extends EntityDecorator implements AttackAble{

	public Cornieles(Enemy enemy) {
		super(enemy);
	}
	
	@Override
	public void attack() {
		int totalDamage = position.player.getHP()-CalculateDamage();
		System.out.println("\nUstedes son unos expertos.");
		position.player.setHP(totalDamage);
		System.out.println(this.name+" dealt "+totalDamage+" damage to you.");
	}

	@Override
	public void beAttacked(int damage) {
		super.beAttacked(damage);
		System.err.println("\nSabeeeeiiiiis.");
		System.out.println("You made "+damage+" damage to "+this.name+".");
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
		System.err.println("\nNo puede ser nonononono.");
		System.out.println("Cornieles died.");
	}
	
	@Override
	public void talk() {
		System.err.println("No te voy a subir la nota sabeeeisss." );
		this.attack();
	}
	
	@Override
	public void create() {
		super.create();
		this.HP = this.HP + 300;
		this.ATTACK = this.ATTACK + 150;
		this.name = "Cornieles";
	}
	
	@Override
	public void beShot(int damage) {
		super.beShot(damage);
		this.HP = this.HP - damage;
		System.out.println("\nSabeeeeeiiiis.");
		if(this.HP<=0)
			this.die();
	}
	
	private int CalculateDamage() {
		int damage = this.ATTACK-this.getPos().player.getResistance();
		if(damage < 0)
			damage = 0;
		return damage;
	}
}
