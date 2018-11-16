package com.labc.Vermellion;

import java.awt.Image;
import java.util.HashMap;

import javax.swing.ImageIcon;

import com.labc.Vermellion.Entities.EntityFactory;

public class Descriptions {
	public HashMap<String,String> shortDescs = new HashMap<String,String>();
	public HashMap<String,String> shortDescsAftFight = new HashMap<String,String>(); 
	public HashMap<String,String> longDescs = new HashMap<String,String>();
	public HashMap<String,String> longDescsAftFight = new HashMap<String,String>();
	public HashMap<String,Entity> Entities = new HashMap<String,Entity>();
	public static HashMap<String,ImageIcon> picBeforeFight = new HashMap<String,ImageIcon>();
	public static ImageIcon bandits = new ImageIcon("images/Bandits.jpg"), 
			GiantSnake = new ImageIcon("images/GiantSnake.jpg"),
			mountainView = new ImageIcon("images/mountainView.jpg"), 
			Minotaur = new ImageIcon("images/Minotaur.jpg"),
			SkullKid = new ImageIcon("images/SkullKid.jpg"),
			Forest = new ImageIcon("images/Forest.jpg"),
			Villager = new ImageIcon("images/Villager.jpg"),
			LadyofTheLake = new ImageIcon("images/LadyofTheLake.jpg"),
			Lake = new ImageIcon("images/Lake.jpg"),
			Cave = new ImageIcon("images/Cave.jpg"),
			Bear = new ImageIcon("images/Bear.jpg"),
			Swamp = new ImageIcon("images/Swamp.jpg"),
			OldLady = new ImageIcon("images/OldLady.jpg"),
			Witch = new ImageIcon("images/Witch.jpg"),
			Creeper = new ImageIcon("images/Creeper.jpg");
	
	public Descriptions(Tile dis) {
		if(dis.getName().equalsIgnoreCase("bandits")) {
			String descBeforeFight = "Something isn't right... you don't know what "
					+ "it is but you will soon find out. Suddenly a pack of bandits "
					+ "attacks you and tries to steal everything you own. What will you do?";
			String descAfterFight = "There are remains of bandits on the floor.";
			shortDescs.put("bandits",descBeforeFight);
			longDescs.put("bandits",descBeforeFight
					+ "\n\tThere is "+dis.getItemOnFloor()+" on the floor but you don't have\n"
					+ "time to pick it up.");
			longDescsAftFight.put("bandits", descAfterFight
					+ "\n\tThere is "+dis.getItemOnFloor()+" on the floor.");
			shortDescsAftFight.put("bandits",descAfterFight);
			Entities.put("bandits",EntityFactory.getEntity("BANDITS", dis));
			dis.hasEnemy = true;
		}
		
		else if(dis.getName().equalsIgnoreCase("wasteland")) {
			String descBeforeFight ="You find yourself in a strange place. "
					+ "There are no trees in here even though you just came out of a forest "
					+ "suddenly the thirst hits you and you start hallucinating. A 3 meters tall "
					+ "snake is Zizzing to you and it lookss like it's anxious to eat you "
					+ "for dinner. What will you do?";
			String descAfterFight =	"The giant snake lies dead on the ground "
					+ "and you realize that i was just protecting it's eggs. "
					+ "You really are a horrible person, aren't you?";		
			shortDescs.put("wasteland",descBeforeFight);
			longDescs.put("wasteland",descBeforeFight+"\n\tThere is"+dis.getItemOnFloor()+" on the floor.");
			shortDescsAftFight.put("wasteland",descAfterFight);
			longDescsAftFight.put("wasteland",descAfterFight+"There is "+dis.getItemOnFloor()+" on the floor.");
			Entities.put("wasteland", EntityFactory.getEntity("GIANTSNAKE", dis));
			dis.hasTree = false;
			dis.hasEnemy = true;
		}
			
		else if(dis.getName().equalsIgnoreCase("woods")) {
			String descBeforeFight = "You enter a place crowded with trees, after "
					+ "walking for a few hours you hear the sound of an ocarina "
					+ "and decide to see what it is... When you get close to the "
					+ "sound you see a weird looking kid with a mask on. What will you do?";
			String descAfterFight = "The funny looking kid lies dead on the floor.";
			shortDescs.put("woods", descBeforeFight);
			shortDescsAftFight.put("woods", descAfterFight);
			longDescs.put("woods", descBeforeFight+"\nThere is too much foliage for you too see anything.");
			longDescsAftFight.put("woods", "The kid is lying on the floor covered in blood since "
					+ "you didn't hesitate to put and end to his beautiful life.");
			Entities.put("woods", EntityFactory.getEntity("SKULLKID", dis));
		}
		
		else if(dis.getName().equalsIgnoreCase("lake")) {
			shortDescs.put("lake","There is a small lake surrounded by trees here.");
			longDescs.put("lake","While you take a closer look you notice a human figure"
					+ " below the surface of the lake and suddenly the most beatiful "
					+ "woman you've ever seen rises from the Bottom. She looks like a "
					+ "goddess... maybe she is one.");
			shortDescsAftFight.put("lake", shortDescs.get("lake"));
			longDescsAftFight.put("lake", shortDescs.get("lake")+"\n\tThere is "+dis.getItemOnFloor()
					+ " on the floor.");
			Entities.put("lake", EntityFactory.getEntity("GODDESS", dis));
			dis.hasLake = true;
		}
		
		else if(dis.getName().equalsIgnoreCase("cave")) {
			String DescsBeforeFight = "You walk into an interesting part of the forest, things are humid"
					+ ", insects are biting and there is a cave right in front of you. What will you do?";
			shortDescs.put("cave", DescsBeforeFight);
			longDescs.put("cave","After taking a look inside the cave you see a bear taking a nap. When you walk"
					+ " you break a stick that was on the floor and awaken the bear. It is now agressive and "
					+ "trying to get you out of it's lair.\n\tThere is "+dis.getItemOnFloor()+" on the floor.");
			shortDescsAftFight.put("cave", DescsBeforeFight);
			longDescsAftFight.put("cave", "The bear lies dead on the ground inside the cave. You killed it"
					+ " while it was trying to protect it's house...\n\tThere is "+dis.getItemOnFloor()+" on the floor.");
			Entities.put("cave", EntityFactory.getEntity("BEAR", dis));
			dis.hasRiver = true;
		}
		
		else if(dis.getName().equalsIgnoreCase("swamp")) {
			String DescBeforeFight = "You walk into a dirty swamp with a dirty smell and dirty"
					+ " insects getting all over you. After walking a little bit you notice a "
					+ "small hut in the middle of the swamp. What will you do?";
			String DescAftFight = "The witch is already rotting. Apparently she should've been dead"
					+ " a long time ago but was alive due to her witchery.";
			shortDescs.put("swamp",DescBeforeFight);
			longDescs.put("swamp", "You take a look at the hut and decide to knock. ''knock knock''"
					+ " an old lady comes out from it. Her nose is very long and has warts all"
					+ " over her face. What will you do?\n\tThere is "+dis.getItemOnFloor()+" on the floor.");
			shortDescsAftFight.put("swamp", DescAftFight);
			longDescsAftFight.put("swamp", DescAftFight+"\n\tThere is "+dis.getItemOnFloor()+" on the floor.");
			Entities.put("swamp", EntityFactory.getEntity("WITCH", dis));
			dis.hasLake = true;
		}
		
		else if(dis.getName().equalsIgnoreCase("plains")) {
			String DescBeforeFight = "The place where you ended up is a plain land as you explore"
					+ " a little bit, you encounter a green creature walking towards you. What will you do?";
			String DescAftFight = "There is a big hole in the ground";
			shortDescs.put("plains",DescBeforeFight);
			longDescs.put("plains",DescBeforeFight+"\n\tThere is "+dis.getItemOnFloor()+" on the floor.");
			shortDescsAftFight.put("plains", DescAftFight);
			longDescsAftFight.put("plains", DescAftFight+"\n\tThere is "+dis.getItemOnFloor()+" on the floor.");
			Entities.put("plains", EntityFactory.getEntity("CREEPER", dis));
			dis.hasEnemy = true;
		}
		
		else if(dis.getName().startsWith("mountainView")) {
			if(dis.getName().equalsIgnoreCase("mountainViewNorth")) {
				shortDescs.put("mountainViewNorth", "A huge mountain can be seen rising to the north.");
				longDescs.put("mountainViewNorth", "A huge mountain can be seen rising to the north.\n"
						+ "\tThere is"+dis.getItemOnFloor()+" on the floor");
			}
			else if(dis.getName().equalsIgnoreCase("mountainViewSouth")) {
				shortDescs.put("mountainViewSouth", "A huge mountain can be seen rising to the south.");
				longDescs.put("mountainViewSouth", "A huge mountain can be seen rising to the south.\n"
						+ "\tThere is"+dis.getItemOnFloor()+" on the floor");
			}
			else if(dis.getName().equalsIgnoreCase("mountainViewWest")) {
				shortDescs.put("mountainViewWest", "A huge mountain can be seen rising to the west.");
				longDescs.put("mountainViewWest", "A huge mountain can be seen rising to the west.\n"
						+ "\tThere is"+dis.getItemOnFloor()+" on the floor");
			}
			else if (dis.getName().equalsIgnoreCase("mountainViewEast")) {
				shortDescs.put("mountainViewEast", "A huge mountain can be seen rising to the east.");
				longDescs.put("mountainViewEast", "A huge mountain can be seen rising to the east.\n"
						+ "\tThere is"+dis.getItemOnFloor()+" on the floor");
			}
			else if (dis.getName().equalsIgnoreCase("mountainViewSouthEast")){
				shortDescs.put("mountainViewSouthEast", "A huge mountain can be seen rising to the Southeast.");
				longDescs.put("mountainViewSouthEast", "A huge mountain can be seen rising to the Southeast.\n"
						+ "\tThere is"+dis.getItemOnFloor()+" on the floor");
			}
			else if (dis.getName().equalsIgnoreCase("mountainViewSouthWest")){
				shortDescs.put("mountainViewSouthWest", "A huge mountain can be seen rising to the Southwest.");
				longDescs.put("mountainViewSouthWest", "A huge mountain can be seen rising to the SouthWest.\n"
						+ "\tThere is"+dis.getItemOnFloor()+" on the floor");
			}
			else if (dis.getName().equalsIgnoreCase("mountainViewNorthWest")){
				shortDescs.put("mountainViewNorthWest", "A huge mountain can be seen rising to the NorthWest.");
				longDescs.put("mountainViewNorthWest", "A huge mountain can be seen rising to the Northwest.\n"
						+ "\tThere is"+dis.getItemOnFloor()+" on the floor");
			}
			else if (dis.getName().equalsIgnoreCase("mountainViewNorthEast")){
				shortDescs.put("mountainViewNorthEast", "A huge mountain can be seen rising to the Northeast.");
				longDescs.put("mountainViewNorhtEast", "A huge mountain can be seen rising to the Northeast.\n"
						+ "\tThere is"+dis.getItemOnFloor()+" on the floor");
			}
		}
		
		else if(dis.getName().equalsIgnoreCase("mountainSurroundings")) {
			shortDescs.put("mountainSurroundings","After climbing the mountain base for 5 hours "
					+ "the last drop of sweat drops from your forehead, you're dehydrated. You need "
					+ "to drink water before you die from dehydration. A minotaur just appeared "
					+ "It tells you that it is the protector of this mountain and that you will "
					+ "climb it over his dead body... So be it. What will you do?");
			longDescs.put("mountainSurroundings","There is no item to be seen around here.");
			shortDescsAftFight.put("mountainSurroundings","The minotaur was a strong foe but now"
					+ "it lies dead on the ground. It was no match for your power.");
			longDescs.put("mountainSurroundings", "The minotaur was a strong foe but now"
					+ "it lies dead on the ground. It was no match for your power.");
			Entities.put("mountainSurroundings", EntityFactory.getEntity("MINOTAUR", dis));	
			dis.hasTree = false;
			dis.hasEnemy = true;
		}
		
		else if(dis.getName().equalsIgnoreCase("forest")) {
			shortDescs.put("forest","You are in a forest.");
			longDescs.put("forest","\tThere is "+dis.getItemOnFloor()+" on the floor.");
			shortDescsAftFight.put("forest","You are in a forest.");
			longDescsAftFight.put("forest","\tThere is"+dis.getItemOnFloor()+" on the floor.");
		}
		
		else if(dis.getName().equalsIgnoreCase("mountain")) {
			
		}
	}
	
	public static void innitPics() {
		bandits.setImage(bandits.getImage().getScaledInstance(364, 361, Image.SCALE_SMOOTH));
		GiantSnake.setImage(GiantSnake.getImage().getScaledInstance(364, 361, Image.SCALE_SMOOTH));
		mountainView.setImage(mountainView.getImage().getScaledInstance(364, 361, Image.SCALE_SMOOTH));
		Minotaur.setImage(Minotaur.getImage().getScaledInstance(364, 361, Image.SCALE_SMOOTH));
		SkullKid.setImage(SkullKid.getImage().getScaledInstance(364, 361, Image.SCALE_SMOOTH));
		Forest.setImage(Forest.getImage().getScaledInstance(364, 361, Image.SCALE_SMOOTH));
		Villager.setImage(Villager.getImage().getScaledInstance(364, 361, Image.SCALE_SMOOTH));
		LadyofTheLake.setImage(LadyofTheLake.getImage().getScaledInstance(364, 361, Image.SCALE_SMOOTH));
		Cave.setImage(Cave.getImage().getScaledInstance(364, 361, Image.SCALE_SMOOTH));
		Bear.setImage(Bear.getImage().getScaledInstance(364, 361, Image.SCALE_SMOOTH));
		Swamp.setImage(Swamp.getImage().getScaledInstance(364, 361, Image.SCALE_SMOOTH));
		OldLady.setImage(OldLady.getImage().getScaledInstance(364, 361, Image.SCALE_SMOOTH));
		Witch.setImage(Witch.getImage().getScaledInstance(364, 361, Image.SCALE_SMOOTH));
		Creeper.setImage(Creeper.getImage().getScaledInstance(364, 361, Image.SCALE_SMOOTH));
		
		picBeforeFight.put("bandits", bandits);
		picBeforeFight.put("wasteland", GiantSnake);
		picBeforeFight.put("mountainViewNorth", mountainView);
		picBeforeFight.put("mountainViewEast", mountainView);
		picBeforeFight.put("mountainViewSouth", mountainView);
		picBeforeFight.put("mountainViewWest", mountainView);
		picBeforeFight.put("mountainViewNorthWest", mountainView);
		picBeforeFight.put("mountainViewNorthEast", mountainView);
		picBeforeFight.put("mountainViewSouthWest", mountainView);
		picBeforeFight.put("mountainViewSouthEast", mountainView);
		picBeforeFight.put("mountainSurroundings", Minotaur);
		picBeforeFight.put("woods", SkullKid);
		picBeforeFight.put("forest", Forest);
		picBeforeFight.put("lake", Lake);
		picBeforeFight.put("cave", Cave);
		picBeforeFight.put("swamp", Swamp);
		picBeforeFight.put("plains", Creeper);
	}
}
