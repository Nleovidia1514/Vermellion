package com.labc.Vermellion.Entities;

import com.labc.Vermellion.Entity;
import com.labc.Vermellion.Tile;
import com.labc.Vermellion.Entities.Enemies.Bandits;
import com.labc.Vermellion.Entities.Enemies.Bear;
import com.labc.Vermellion.Entities.Enemies.Cornieles;
import com.labc.Vermellion.Entities.Enemies.Creeper;
import com.labc.Vermellion.Entities.Enemies.GiantSnake;
import com.labc.Vermellion.Entities.Enemies.Witch;
import com.labc.Vermellion.Entities.NPCs.Goddess;
import com.labc.Vermellion.Entities.NPCs.SkullKid;
import com.labc.Vermellion.Entities.NPCs.Villager;

public class EntityFactory {

	public static Entity getEntity(String type,Tile tile) {
		Entity enemy = null;
		if(type.equalsIgnoreCase(null))
			enemy = null;
		//Enemies			
		else if(type.equalsIgnoreCase("CREEPER"))
			enemy = new Creeper(new Enemy(new BasicEntity(tile)));
		
		else if(type.equalsIgnoreCase("Witch"))
			enemy = new Witch(new Enemy(new BasicEntity(tile)));
		
		else if(type.equalsIgnoreCase("CREEPITCH"))
			enemy = new Creeper(new Witch(new Enemy(new BasicEntity(tile))));
		
		else if(type.equalsIgnoreCase("CORNIELES"))
			enemy = new Cornieles(new Enemy(new BasicEntity(tile)));
		
		else if(type.equalsIgnoreCase("BEAR"))
			enemy = new Bear(new Enemy(new BasicEntity(tile)));
		
		else if(type.equalsIgnoreCase("BANDITS"))
			enemy = new Bandits(new Enemy(new BasicEntity(tile)));
		
		else if(type.equalsIgnoreCase("GIANTSNAKE"))
			enemy = new GiantSnake(new Enemy(new BasicEntity(tile)));
		//NPCs
		else if(type.equalsIgnoreCase("GODDESS"))
			enemy = new Goddess(new NPC(new BasicEntity(tile)));
		
		else if(type.equalsIgnoreCase("SKULLKID"))
			enemy = new SkullKid(new NPC(new BasicEntity(tile)));
		
		else if(type.equalsIgnoreCase("VILLAGER"))
			enemy = new Villager(new NPC(new BasicEntity(tile)));
		
		enemy.create();
		return enemy;
	}
}
