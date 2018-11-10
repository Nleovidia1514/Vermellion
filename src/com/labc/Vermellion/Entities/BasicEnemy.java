package com.labc.Vermellion.Entities;

import com.labc.Vermellion.Tile;

public class BasicEnemy extends Enemy {

	protected BasicEnemy(Tile position) {
		super(position);
	}

	@Override
	public void attack() {
		int totalDamage = this.position.player.getHP() - CalculateDamage();
		this.position.player.setHP(totalDamage);
	}

	@Override
	public void beAttacked(int damage) {
		this.HP = this.HP - damage;
	}

	@Override
	public void die() {
		this.position.mob = null;
	}

	@Override
	public void create() {
		this.HP = 0;
		this.ATTACK = 0;
		this.name = null;
	}

	@Override
	public void beShot(int damage) {
		this.HP = this.HP - damage;
	}
	
	private int CalculateDamage() {
		int damage = this.ATTACK-this.getPos().player.getResistance();
		if(damage < 0)
			damage = 0;
		return damage;
	}
}
