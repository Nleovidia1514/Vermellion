package com.labc.Vermellion.Entities;

public class EnemyDecorator extends Enemy {
	
	protected Enemy enemy;
	
	public EnemyDecorator(Enemy enemy) {
		super(enemy.getPos());
		this.enemy = enemy;
	}

	@Override
	public void attack() {
		this.enemy.attack();
	}

	@Override
	public void beAttacked(int damage) {
		this.enemy.beAttacked(damage);
	}

	@Override
	public void die() {
		this.enemy.die();
	}

	@Override
	public void create() {
		this.enemy.create();
	}

	@Override
	public void beShot(int damage) {
		this.enemy.beShot(damage);
	}

}
