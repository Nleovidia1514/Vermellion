package com.labc.Vermellion.Entities.Enemies;

import com.labc.Vermellion.Entities.Enemy;
import com.labc.Vermellion.Entities.EntityDecorator;

public class GiantSnake extends EntityDecorator implements AttackAble{

	public GiantSnake(Enemy enemy) {
		super(enemy);
	}

	@Override
	public void attack() {
		// TODO Auto-generated method stub
		
	}

}
