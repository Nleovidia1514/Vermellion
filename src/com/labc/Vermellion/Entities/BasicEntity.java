package com.labc.Vermellion.Entities;

import com.labc.Vermellion.Entity;
import com.labc.Vermellion.Tile;

public class BasicEntity extends Entity{

	protected BasicEntity(Tile position) {
		super(position);
	}
	
	@Override
	public void create() {
		this.HP = 0;
		this.name = null;
	}

	@Override
	public void beAttacked(int damage) {
		this.HP -= damage;
	}

	@Override
	public void die() {
		this.position.mob = null;
	}

	@Override
	public void beShot(int damage) {
		this.HP -= damage;
	}

	@Override
	public void talk() {
		System.err.println("hello.");
	}

}
