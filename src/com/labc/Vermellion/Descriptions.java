package com.labc.Vermellion;

import java.util.HashMap;

import com.labc.Vermellion.Entities.EntityFactory;

public class Descriptions {
	public HashMap<String,String> shortDescs = new HashMap<String,String>();
	public HashMap<String,String> shortDescsAftFight = new HashMap<String,String>(); 
	public HashMap<String,String> longDescs = new HashMap<String,String>();
	public HashMap<String,String> longDescsAftFight = new HashMap<String,String>();
	public HashMap<String,Entity> Entities = new HashMap<String,Entity>();
	
	public Descriptions(Tile dis) {
		if(dis.getName().equalsIgnoreCase("bandits")) {
			shortDescs.put("bandits","\nSomething isn't right... you don't know what\n"
					+ "it is but you will soon find out. Suddenly a pack of bandits\n"
					+ "attacks you and tries to steal everything you own. What will you do?");
			longDescs.put("bandits","\nThere is "+dis.getItemOnFloor()+" on the floor but you don't have\n"
					+ "time to pick it up.");
			longDescsAftFight.put("bandits","\nThere is "+dis.getItemOnFloor()+" on the floor.");
			shortDescsAftFight.put("bandits","\nThere are remains of bandits on the floor.");
			
			Entities.put("bandits",EntityFactory.getEntity("BANDITS", dis));
		}
		
		else if(dis.getName().equalsIgnoreCase("wasteland")) {
			shortDescs.put("wasteland","\nYou find yourself in a strange place.\n"
					+ "There are no trees in here even though you just came out of a forest\n"
					+ "suddenly the thirst hits you and you start hallucinating. What will you do?");
		}
			
		else if(dis.getName().equalsIgnoreCase("woods")) {
			shortDescs.put("woods", "\nYou enter a place crowded with trees, after\n"
					+ "walking for a few hours you hear the sound of an ocarina\n"
					+ "and decide to see what it is... When you get close to the\n"
					+ "you see a weird looking kid with a mask on. What will you do?");
			shortDescsAftFight.put("woods", "\nThe funny looking kid lies dead on the floor.");
			longDescs.put("woods", "\nThere is too much foliage for you too see anything.");
			longDescsAftFight.put("forest", "The kid is lying on the floor covered in blood since\n"
					+ "you didn't hesitate to put and end to his beautiful life");
			Entities.put("woods", EntityFactory.getEntity("SKULLKID", dis));
		}
	}
		
	
}
