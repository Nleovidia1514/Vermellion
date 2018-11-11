package com.labc.Vermellion.Entities;

import com.labc.Vermellion.Entity;

public class Enemy extends EntityDecorator {
	
	protected Enemy(Entity entity) {
		super(entity);
	}
	
	public void create() {
		this.HP = 0;
		this.ATTACK = 0;
		this.name = null;
	}
	
	@Override
	public void beAttacked(int damage) {
	}

	@Override
	public void die() {
	}

	@Override
	public void beShot(int damage) {
	}
}
