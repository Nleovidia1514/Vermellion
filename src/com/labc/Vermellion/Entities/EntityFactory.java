package com.labc.Vermellion.Entities;

import com.labc.Vermellion.Entity;
import com.labc.Vermellion.Tile;
import com.labc.Vermellion.Entities.Enemies.Bandits;
import com.labc.Vermellion.Entities.Enemies.Bear;
import com.labc.Vermellion.Entities.Enemies.Cornieles;
import com.labc.Vermellion.Entities.Enemies.Creeper;
import com.labc.Vermellion.Entities.Enemies.GiantSnake;
import com.labc.Vermellion.Entities.Enemies.Minotaur;
import com.labc.Vermellion.Entities.Enemies.MrsSpider;
import com.labc.Vermellion.Entities.Enemies.Witch;
import com.labc.Vermellion.Entities.NPCs.Fairy;
import com.labc.Vermellion.Entities.NPCs.Goddess;
import com.labc.Vermellion.Entities.NPCs.SkullKid;
import com.labc.Vermellion.Entities.NPCs.Villager;

public class EntityFactory {

	public static Entity getEntity(String type,Tile tile) {
		Entity entity = null;
		if(type.equalsIgnoreCase(null))
			entity = null;
		//Enemies			
		else if(type.equalsIgnoreCase("CREEPER"))
			entity = new Creeper(new Enemy(new BasicEntity(tile)));
		
		else if(type.equalsIgnoreCase("Witch"))
			entity = new Witch(new Enemy(new BasicEntity(tile)));
		
		else if(type.equalsIgnoreCase("CREEPITCH"))
			entity = new Creeper(new Witch(new Enemy(new BasicEntity(tile))));
		
		else if(type.equalsIgnoreCase("CORNIELES"))
			entity = new Cornieles(new Enemy(new BasicEntity(tile)));
		
		else if(type.equalsIgnoreCase("BEAR"))
			entity = new Bear(new Enemy(new BasicEntity(tile)));
		
		else if(type.equalsIgnoreCase("BANDITS"))
			entity = new Bandits(new Enemy(new BasicEntity(tile)));
		
		else if(type.equalsIgnoreCase("GIANTSNAKE"))
			entity = new GiantSnake(new Enemy(new BasicEntity(tile)));
		
		else if(type.equalsIgnoreCase("MINOTAUR"))
			entity = new Minotaur(new Enemy(new BasicEntity(tile)));
		
		else if(type.equalsIgnoreCase("MRSSPIDER"))
			entity = new MrsSpider(new Enemy(new BasicEntity(tile)));
		
		//NPCs
		else if(type.equalsIgnoreCase("GODDESS"))
			entity = new Goddess(new NPC(new BasicEntity(tile)));
		
		else if(type.equalsIgnoreCase("SKULLKID"))
			entity = new SkullKid(new NPC(new BasicEntity(tile)));
		
		else if(type.equalsIgnoreCase("VILLAGER"))
			entity = new Villager(new NPC(new BasicEntity(tile)));
		
		else if(type.equalsIgnoreCase("FAIRY"))
			entity = new Fairy(new NPC(new BasicEntity(tile)));
		
		entity.create();
		return entity;
	}
}
