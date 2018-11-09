package com.labc.Vermellion.Entities.Enemies;

import com.labc.Vermellion.Tile;
import com.labc.Vermellion.Entities.Enemy;

public class Witch extends Enemy{
	
	public Witch(Tile position) {
		super(position);
		this.HP = 150;
		this.ATTACK = 30;
		this.name = "Witch";
	}

	@Override
	public void attack() {
		// TODO Auto-generated method stub
		int z = 0;
		if(z == 0 ) {
			System.out.println("The witch curses you and lowers your maxHP to 100");
			this.position.player.setHP(100);
		}
		else {
			System.out.println("The witch attacks you and deals "+this.ATTACK+" damage");
			this.position.player.setHP(this.position.player.getHP()-25);
		}
			
			
	}

	@Override
	public void beAttacked(int damage) {
		// TODO Auto-generated method stub
		System.out.print("The witch makes disturbing noises, this let's you know that you're hurting her"
				+ " for "+damage+" damage ");
		this.HP = HP-damage;
		if(this.HP<=0) 
			die();
		else
			this.attack();
	}

	@Override
	public void die() {
		// TODO Auto-generated method stub
		System.out.println("and died");
		this.position.hasEnemy = false;
		this.position.enemy = null;
	}

}
