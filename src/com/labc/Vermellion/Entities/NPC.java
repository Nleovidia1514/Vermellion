package com.labc.Vermellion.Entities;

import com.labc.Vermellion.Entity;

public class NPC extends EntityDecorator {
	
	public NPC(Entity entity) {
		super(entity);
	}
	
	public void create() {
		this.HP = 0;
		this.ATTACK = 0;
		this.alreadyTalkedTo = false;
		this.name = null;
	}

	@Override
	public void beAttacked(int damage) {
		this.beAttacked(damage);
	}

	@Override
	public void die() {
		this.die();
	}

	@Override
	public void beShot(int damage) {
		this.beShot(damage);
	}

}
