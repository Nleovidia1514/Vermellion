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
			String descBeforeFight = "\nSomething isn't right... you don't know what\n"
					+ "it is but you will soon find out. Suddenly a pack of bandits\n"
					+ "attacks you and tries to steal everything you own. What will you do?";
			String descAfterFight = "\nThere are remains of bandits on the floor.";
			shortDescs.put("bandits",descBeforeFight);
			longDescs.put("bandits",descBeforeFight
					+ "\tThere is "+dis.getItemOnFloor()+" on the floor but you don't have\n"
					+ "time to pick it up.");
			longDescsAftFight.put("bandits", descAfterFight
					+ "\n\tThere is "+dis.getItemOnFloor()+" on the floor.");
			shortDescsAftFight.put("bandits",descAfterFight);
			Entities.put("bandits",EntityFactory.getEntity("BANDITS", dis));
			dis.hasEnemy = true;
		}
		
		else if(dis.getName().equalsIgnoreCase("wasteland")) {
			String descBeforeFight ="\nYou find yourself in a strange place.\n"
					+ "There are no trees in here even though you just came out of a forest\n"
					+ "suddenly the thirst hits you and you start hallucinating. A 3 meters tall\n"
					+ "snake is Zizzing to you and it lookss like it's anxious to eat you\n"
					+ "for dinner. What will you do?";
			String descAfterFight =	"\nThe giant snake lies dead on the ground\n"
					+ "and you realize that i was just protecting it's eggs.\n"
					+ "You really are a horrible person, aren't you?";		
			shortDescs.put("wasteland",descBeforeFight);
			longDescs.put("wasteland",descBeforeFight+"\tThere is"+dis.getItemOnFloor()+" on the floor.");
			shortDescsAftFight.put("wasteland",descAfterFight);
			longDescsAftFight.put("wasteland",descAfterFight+"There is "+dis.getItemOnFloor()+" on the floor.");
			Entities.put("wasteland", EntityFactory.getEntity("GIANTSNAKE", dis));
			dis.hasTree = false;
			dis.hasEnemy = true;
		}
			
		else if(dis.getName().equalsIgnoreCase("woods")) {
			String descBeforeFight = "\nYou enter a place crowded with trees, after\n"
					+ "walking for a few hours you hear the sound of an ocarina\n"
					+ "and decide to see what it is... When you get close to the\n"
					+ "sound you see a weird looking kid with a mask on. What will you do?";
			String descAfterFight = "\nThe funny looking kid lies dead on the floor.";
			shortDescs.put("woods", descBeforeFight);
			shortDescsAftFight.put("woods", descAfterFight);
			longDescs.put("woods", descBeforeFight+"\nThere is too much foliage for you too see anything.");
			longDescsAftFight.put("forest", "The kid is lying on the floor covered in blood since\n"
					+ "you didn't hesitate to put and end to his beautiful life.");
			Entities.put("woods", EntityFactory.getEntity("SKULLKID", dis));
			dis.hasNPC = true;
		}
		
		
		else if(dis.getName().startsWith("mountainView")) {
			if(dis.getName().equalsIgnoreCase("mountainViewNorth")) {
				shortDescs.put("mountainViewNorth", "\nA huge mountain can be seen rising to the north.");
				longDescs.put("mountainViewNorth", "\nA huge mountain can be seen rising to the north.\n"
						+ "\tThere is"+dis.getItemOnFloor()+" on the floor");
			}
			else if(dis.getName().equalsIgnoreCase("mountainViewSouth")) {
				shortDescs.put("mountainViewSouth", "\nA huge mountain can be seen rising to the south.");
				longDescs.put("mountainViewSouth", "\nA huge mountain can be seen rising to the south.\n"
						+ "\tThere is"+dis.getItemOnFloor()+" on the floor");
			}
			else if(dis.getName().equalsIgnoreCase("mountainViewWest")) {
				shortDescs.put("mountainViewWest", "\nA huge mountain can be seen rising to the west.");
				longDescs.put("mountainViewWest", "\nA huge mountain can be seen rising to the west.\n"
						+ "\tThere is"+dis.getItemOnFloor()+" on the floor");
			}
			else if (dis.getName().equalsIgnoreCase("mountainViewEast")) {
				shortDescs.put("mountainViewEast", "\nA huge mountain can be seen rising to the east.");
				longDescs.put("mountainViewEast", "\nA huge mountain can be seen rising to the east.\n"
						+ "\tThere is"+dis.getItemOnFloor()+" on the floor");
			}	
		}
		
		else if(dis.getName().equalsIgnoreCase("mountainSurroundings")) {
			shortDescs.put("mountainSurroundings","\nAfter climbing the mountain base for 5 hours\n"
					+ "the last drop of sweat drops from your forehead, you're dehydrated. You need\n"
					+ "to drink water before you die from dehydration. A minotaur just appeared\n"
					+ "It tells you that it is the protector of this mountain and that you will\n"
					+ "climb it over his dead body... So be it. What will you do?");
			longDescs.put("mountainSurroundings","\nThere is no item to be seen around here.");
			shortDescsAftFight.put("mountainSurroundings","The minotaur was a strong foe but now\n"
					+ "it lies dead on the ground. It was no match for your power.");
			longDescs.put("mountainSurroundings", "The minotaur was a strong foe but now\n"
					+ "it lies dead on the ground. It was no match for your power.");
			Entities.put("mountainSurroundings", EntityFactory.getEntity("MINOTAUR", dis));	
			dis.hasTree = false;
			dis.hasEnemy = true;
		}
		
		else if(dis.getName().equalsIgnoreCase("mountain")) {
			
		}
	}
}
