package com.labc.Vermellion.Entities.Enemies;

import java.util.Random;

import com.labc.Vermellion.Entity;
import com.labc.Vermellion.Start;
import com.labc.Vermellion.Entities.EntityDecorator;

public class Bandits extends EntityDecorator implements AttackAble {

	public Bandits(Entity entity) {
		super(entity);
	}
	
	@Override
	public void attack() {
		Random rnd = new Random();
		int totalDamage = position.player.getHP()-CalculateDamage(), itemStolen;
		Start.ta.append("\nThe bandits try to steal items from you.");
		if(position.player.inventory.size()>0) {
			itemStolen = rnd.nextInt(position.player.inventory.size());
			if(position.player.inventory.get(itemStolen).isStarter) {
				Start.ta.append("\nThe bandits dealed "+CalculateDamage()+" damage to you\n"
						+ " and couldn't steal your item because it is binded to you by\n"
						+ "powers they do not understand.");
			}
			else {
				Start.ta.append("\nThe bandits dealed "+CalculateDamage()+" damage to you\n and"
						+ " stole "+position.player.inventory.get(itemStolen).getName()
						+ " from your inventory.");
				position.player.inventory.remove(itemStolen);
			}
		}
		else		
			Start.ta.append("\nThe bandits dealed "+CalculateDamage()+" damage to you and"
					+ " couldn't steal anything because you're poor");
		position.player.setHP(totalDamage);
		
	}

	@Override
	public void beAttacked(int damage) {
		Start.ta.setText("*Gruntled bandits sounds*");
		Start.ta.append("\nYou made "+damage+" damage to the "+this.name+".");
		this.HP -= damage;
		if(this.HP<=0) {
			die();
			Start.ta.append("\nBandits started to scatter.");
			Start.ta.append("\nThe bandits died.");
		}
		else
			this.attack();
	}
	
	@Override 
	public void beShot(int damage) {
		this.HP = this.HP - damage;
		Start.ta.append("\n*Gruntled bandits sounds*");
		if(this.HP<=0) {
			this.die();
			Start.ta.append("\nBandits started to scatter.");
			Start.ta.append("\nThe bandits died.");
		}
	}

	@Override
	public void die() {
		this.position.mob = null;
		this.position.hasEnemy = false;
		this.position.shortDescription = this.position.descripts.shortDescsAftFight.get(this.position.name);
		this.position.longDescription = this.position.descripts.longDescsAftFight.get(this.position.name);
	}
	
	@Override
	public void talk() {
		Start.ta.setText("This' no time to talk. Shut the fuck up bitch.");
		this.attack();
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
