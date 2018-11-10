package com.labc.Vermellion.Entities.Enemies;

import com.labc.Vermellion.Entities.Enemy;
import com.labc.Vermellion.Entities.EnemyDecorator;

public class GiantSnake extends EnemyDecorator{

	public GiantSnake(Enemy enemy) {
		super(enemy);
	}

}
