package com.labc.Vermellion.Entities;

import com.labc.Vermellion.Tile;

public class BasicEnemy extends Enemy {

	protected BasicEnemy(Tile position) {
		super(position);
	}

	@Override
	public void attack() {
		this.position.player.setHP(this.position.player.getHP() - this.ATTACK);
	}

	@Override
	public void beAttacked(int damage) {
		this.HP = this.HP - damage;
	}

	@Override
	public void die() {
		this.position.enemy = null;
	}

	@Override
	public void create() {
		this.HP = 0;
		this.ATTACK = 0;
		this.name = null;
	}

}
