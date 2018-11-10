package com.labc.Vermellion.Entities.Enemies;

import com.labc.Vermellion.PoisonedState;
import com.labc.Vermellion.Entities.Enemy;
import com.labc.Vermellion.Entities.EnemyDecorator;

public class Witch extends EnemyDecorator{
	
	public Witch(Enemy enemy) {
		super(enemy);
		this.HP = 150;
		this.ATTACK = 90;
		this.name = "Witch";
	}

	@Override
	public void attack() {
		super.attack();
		int totalDamage = this.position.player.getHP() - CalculateDamage();
		int z = 0;
		if(z == 0 ) {
			System.out.println("The witch poisons you for 5 moves.");
			this.position.player.setCharacterState(PoisonedState.instance());
			PoisonedState.instance().turnsPoisoned = 5;
		}
		else {
			System.out.println("The witch attacks you and deals "+totalDamage+" damage to you.");
			this.position.player.setHP(totalDamage);
		}
	}

	@Override
	public void beAttacked(int damage) {
		System.out.print("\nThe witch makes disturbing noises, this let's you know that you're hurting her"
				+ " for "+damage+" damage.");
		this.HP = this.HP-damage;
		if(this.HP<=0) 
			die();
		else
			this.attack();
	}

	@Override
	public void die() {
		System.out.println("The witch died.");
		this.position.shortDescription = this.position.descripts.shortDescsAftFight.get(this.position.name);
		this.position.longDescription = this.position.descripts.longDescsAftFight.get(this.position.name);
		this.position.hasEnemy = false;
		this.position.mob = null;
	}
	
	@Override
	public void create() {
		this.HP = this.HP + 200;
		this.ATTACK = this.ATTACK + 40;
		this.name = "Witch";
	}
	
	@Override 
	public void beShot(int damage) {
		System.out.print("\nThe witch makes disturbing noises, this let's you know that you're hurting her");
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
