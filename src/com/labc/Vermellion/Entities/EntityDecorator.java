package com.labc.Vermellion.Entities;

import com.labc.Vermellion.Entity;

public class EntityDecorator extends Entity {
	
	protected Entity entity;
	
	public EntityDecorator(Entity entity) {
		super(entity.getPos());
		this.entity = entity;
	}

	@Override
	public void beAttacked(int damage) {
		this.entity.beAttacked(damage);
	}

	@Override
	public void die() {
		this.entity.die();
	}

	@Override
	public void create() {
		this.entity.create();
	}

	@Override
	public void beShot(int damage) {
		this.entity.beShot(damage);
	}

	@Override
	public void talk() {
		this.entity.talk();
	}

}
