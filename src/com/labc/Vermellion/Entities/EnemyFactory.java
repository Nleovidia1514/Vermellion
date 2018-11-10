package com.labc.Vermellion.Entities;

import com.labc.Vermellion.Tile;
import com.labc.Vermellion.Entities.Enemies.Bear;
import com.labc.Vermellion.Entities.Enemies.Cornieles;
import com.labc.Vermellion.Entities.Enemies.Creeper;
import com.labc.Vermellion.Entities.Enemies.Witch;

public class EnemyFactory {

	public static Enemy getEnemy(String type,Tile tile) {
		Enemy enemy = null;
		if(type.equalsIgnoreCase(null))
			enemy = null;
					
		else if(type.equalsIgnoreCase("CREEPER"))
			enemy = new Creeper(new BasicEnemy(tile));
		
		else if(type.equalsIgnoreCase("Witch"))
			enemy = new Witch(new BasicEnemy(tile));
		
		else if(type.equalsIgnoreCase("CREEPITCH"))
			enemy = new Creeper(new Witch(new BasicEnemy(tile)));
		
		else if(type.equalsIgnoreCase("CORNIELES"))
			enemy = new Cornieles(new BasicEnemy(tile));
		
		else if(type.equalsIgnoreCase("BEAR"))
			enemy = new Bear(new BasicEnemy(tile));
		
		enemy.create();
		return enemy;
	}
}
