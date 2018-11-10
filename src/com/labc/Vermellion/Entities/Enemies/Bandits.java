package com.labc.Vermellion.Entities.Enemies;

import java.util.Random;

import com.labc.Vermellion.Entities.Enemy;
import com.labc.Vermellion.Entities.EnemyDecorator;

public class Bandits extends EnemyDecorator {

	public Bandits(Enemy enemy) {
		super(enemy);
	}
	
	@Override
	public void attack() {
		Random rnd = new Random();
		super.attack();
		int totalDamage = position.player.getHP()-CalculateDamage(), itemStolen;
		System.out.println("\nThe bandits try to steal items from you.");
		if(position.player.inventory.size()>0) {
			itemStolen = rnd.nextInt(position.player.inventory.size());
			System.out.println("The bandits dealed "+CalculateDamage()+" damage to you and"
					+ " stole "+position.player.inventory.get(itemStolen).getName()
					+ " from your inventory.");
			position.player.inventory.remove(itemStolen);
		}
		else		
			System.out.println("The bandits dealed "+CalculateDamage()+" damage to you and"
					+ " couldn't steal anything because you're poor");
		position.player.setHP(totalDamage);
		
	}

	@Override
	public void beAttacked(int damage) {
		super.beAttacked(damage);
		System.out.println("*Gruntled bandits sounds*");
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
		System.out.println("*Gruntled bandits sounds");
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
		System.out.println("\nBandits started to scatter.");
		System.out.println("The bandits died.");
	}
	
	
	@Override
	public void create() {
		super.create();
		this.HP = this.HP + 200;
		this.ATTACK = this.ATTACK + 50;
		this.name = "Bandits";
	}
	
	
	private int CalculateDamage() {
		int damage = this.ATTACK-this.getPos().player.getResistance();
		if(damage < 0)
			damage = 0;
		return damage;
	}
}
