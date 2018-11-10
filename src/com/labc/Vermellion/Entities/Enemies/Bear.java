package com.labc.Vermellion.Entities.Enemies;

import com.labc.Vermellion.Entities.Enemy;
import com.labc.Vermellion.Entities.EnemyDecorator;

public class Bear extends EnemyDecorator{

	public Bear(Enemy enemy) {
		super(enemy);
	}

	@Override
	public void attack() {
		// TODO Auto-generated method stub
		System.out.println("*Angry bear sounds*");
		position.player.setHP(position.player.getHP()-200);
	}

	@Override
	public void beAttacked(int damage) {
		// TODO Auto-generated method stub
		System.out.println("*Hurted bear sounds*");
		System.out.println("You made "+damage+" to the "+this.name);
		this.HP -= damage;
		if(this.HP<=0) 
			die();
		else
			this.attack();
			
	}

	@Override
	public void die() {
		// TODO Auto-generated method stub
		this.position.enemy = null;
		this.position.hasEnemy = false;
		System.out.println("*Sad bear sounds*");
	}
	
	@Override
	public void create() {
		super.create();
		this.HP = this.HP + 400;
		this.ATTACK = this.ATTACK + 150;
		this.name = "Bear";
	}
}
