package com.labc.Vermellion.Entities.Enemies;

import com.labc.Vermellion.Start;
import com.labc.Vermellion.Entities.Enemy;
import com.labc.Vermellion.Entities.EntityDecorator;

public class Cornieles extends EntityDecorator implements AttackAble{

	public Cornieles(Enemy enemy) {
		super(enemy);
	}
	
	@Override
	public void attack() {
		int totalDamage = position.player.getHP()-CalculateDamage();
		Start.ta.append("\nUstedes son unos expertos.");
		position.player.setHP(totalDamage);
		Start.ta.append("\n"+this.name+" dealt "+totalDamage+" damage to you.");
	}

	@Override
	public void beAttacked(int damage) {
		super.beAttacked(damage);
		Start.ta.append("\nSabeeeeiiiiis.");
		Start.ta.append("\nYou made "+damage+" damage to "+this.name+".");
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
		Start.ta.append("\nNo puede ser nonononono.");
		Start.ta.append("\nCornieles died.");
	}
	
	@Override
	public void talk() {
		Start.ta.append("\nNo te voy a subir la nota sabeeeisss." );
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
		Start.ta.append("\nSabeeeeeiiiis.");
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
