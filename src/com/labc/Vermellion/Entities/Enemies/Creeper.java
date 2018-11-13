package com.labc.Vermellion.Entities.Enemies;

import com.labc.Vermellion.Entity;
import com.labc.Vermellion.Start;
import com.labc.Vermellion.Entities.EntityDecorator;

public class Creeper extends EntityDecorator implements AttackAble {
	
	public Creeper(Entity entity) {
		super(entity);
	}

	@Override
	public void attack() {
		int totalDamage = position.player.getHP() - CalculateDamage();
		Start.ta.append("\nPsssssssssst...");
		position.player.setHP(totalDamage);
		Start.ta.append("\nThe "+this.name+" exploded and dealt "+CalculateDamage()+" damage to you.\n" 
		+"Allahu akbar.");
		this.die();
	}

	@Override
	public void beAttacked(int damage) {
		super.beAttacked(damage);
		Start.ta.setText("Pssssssssstt... x_x");
		this.HP -= damage;
		if(this.HP<=0) {
			Start.ta.append("\nPsssssssssst D:");
			Start.ta.append("\nThe creeper died.");
			this.die();
		}
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
		
	}
	
	@Override
	public void talk() {
		Start.ta.setText("Pssssssssssssssssssssssssst.");
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
		Start.ta.append("\nPssssssssstt... x_x");
		this.HP -= damage;
		if(this.HP<=0) {
			this.die();
			Start.ta.append("\nPsssssssssst D:");
			Start.ta.append("\nThe creeper died.");
		}
			
	}
	

	private int CalculateDamage() {
		int damage = this.ATTACK-this.getPos().player.getResistance();
		if(damage < 0)
			damage = 0;
		return damage;
	}

}
