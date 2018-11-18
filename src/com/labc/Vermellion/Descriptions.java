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
	public static HashMap<String,ImageIcon> lookImage = new HashMap<String,ImageIcon>();
	public static HashMap<String,ImageIcon> picAfterFight = new HashMap<String,ImageIcon>();
	public static ImageIcon bandits = new ImageIcon("images/Bandits.jpg"), Ded = new ImageIcon("images/Ded.jpg"),
			ChooseClass = new ImageIcon("images/ChooseClass.jpg"), 
			GiantSnake = new ImageIcon("images/GiantSnake.jpg"),
			DeadGiantSnake = new ImageIcon("images/DeadGiantSnake.jpg"),
			mountainView = new ImageIcon("images/mountainView.jpg"), 
			Minotaur = new ImageIcon("images/Minotaur.jpg"),
			DeadMinotaur = new ImageIcon("images/DeadMinotaur.jpg"),
			SkullKid = new ImageIcon("images/SkullKid.jpg"),
			lookSkullKid = new ImageIcon("images/lookSkullKid.jpg"),
			LostWoods = new ImageIcon("images/LostWoods.jpg"),
			Forest = new ImageIcon("images/Forest.jpg"),
			Forest1 = new ImageIcon("images/Forest1.jpg"),
			Villager = new ImageIcon("images/Villager.jpg"),
			Village = new ImageIcon("images/Village.jpg"),
			LadyofTheLake = new ImageIcon("images/LadyofTheLake.jpg"),
			Lake = new ImageIcon("images/Lake.jpg"),
			Cave = new ImageIcon("images/Cave.jpg"),
			Bear = new ImageIcon("images/Bear.jpg"),
			Swamp = new ImageIcon("images/Swamp.jpg"),
			OldLady = new ImageIcon("images/OldLady.jpg"),
			Witch = new ImageIcon("images/Witch.jpg"),
			Creeper = new ImageIcon("images/Creeper.jpg"),
			CreeperHole = new ImageIcon("images/CreeperHole.jpg"),
			Adult = new ImageIcon("images/Adult.jpg"),
			Forest3 = new ImageIcon("images/Forest3.jpg"),
			Fairy = new ImageIcon("images/Fairy.jpg"),
			MountainTop = new ImageIcon("images/Mountaintop.jpg"),
			MrsSpider = new ImageIcon("images/MrsSpider.jpg"),
			Spiderweb = new ImageIcon("images/Spiderweb.jpg");
	
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
		
		else if(dis.getName().equalsIgnoreCase("spider web")) {
			String descBeforeFight = "This part of the forest is very green and very dark"
					+ " it looks like the sun hasn't been here for a very long time, there"
					+ " are hundreds of spider web in every tree around you. But in front of you"
					+ " there is a huge spider web that you suppose it's the giant spider's.";
			String descAfterFight = "The misses spider lies dead on the ground with her"
					+ " numerous legs contracted over herself. It's not a pretty view.";
			shortDescs.put("spider web", descBeforeFight);
			longDescs.put("spider web", descBeforeFight+"\n\tThere is "+dis.getItemOnFloor()+" on the floor.");
			shortDescsAftFight.put("spider web",descAfterFight);
			longDescsAftFight.put("spider web", descAfterFight+"\n\tThere is "+dis.getItemOnFloor()+" on the floor.");
			Entities.put("spider web", EntityFactory.getEntity("MRSSPIDER",dis));
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
		
		else if(dis.getName().equalsIgnoreCase("village")) {
			String DescBeforeFight = "You walk into a village with a few small houses and some"
					+ " amusement building like a church and a library, A weird person (if that's"
					+ " how you wanna call it) greets you in a weird way. It appears to be a villager,"
					+ " you think it is trying to tell you something but it only is making weird"
					+ " villager noises. What will you do?";
			String DescAfterFight = "You are in a beatiful village.";
			shortDescs.put("village", DescBeforeFight);
			longDescs.put("village", DescBeforeFight+"\n\tThere is "+dis.getItemOnFloor()+" on the floor.");
			shortDescsAftFight.put("village", DescAfterFight);
			longDescsAftFight.put("village", DescAfterFight+"\n\tThere is "+dis.getItemOnFloor()+" on the floor.");
			Entities.put("village", EntityFactory.getEntity("VILLAGER", dis));
		}
		
		else if(dis.getName().equalsIgnoreCase("sabeis")) {
			String DescBeforeFight = "You hear strange noises and you decide to investigate,"
					+ " after walking around for a bit, you see someone in the middle of the"
					+ " forest. he appears to be deep down into his own thoughts, repeating"
					+ "what you think might be his name ''Cornieles...Cornieles...Cornieles..''What will you do?";
			String DescAfterFight = "Cornieles lies slept on the ground. He looks like he won't wake up anytime soon.";
			shortDescs.put("sabeis", DescBeforeFight);
			longDescs.put("sabeis", DescBeforeFight+"\n\tThere is "+dis.getItemOnFloor()+" on the floor.");
			shortDescsAftFight.put("sabeis", DescAfterFight);
			longDescsAftFight.put("sabeis", DescAfterFight+"\n\tThere is "+dis.getItemOnFloor()+" on the floor.");
			Entities.put("sabeis", EntityFactory.getEntity("CORNIELES", dis));
			dis.hasEnemy = true;
		}
		
		else if (dis.getName().equals("magical forest")) {
			String DescBeforeFight = "As you enter the thick part of the forest you just stumbled"
					+ " upon with, you see a small woman that looks more like a girl. You're pretty"
					+ " sure that she is a fairy of the forest, you could approach her but you don't"
					+ " know what might happen. What will you do?";
			String DescAfterFight = "The fairy left leaving you alone in the woods. The atmosphere"
					+ " of the place now has a weird sparkling.";
			shortDescs.put("magical forest", DescBeforeFight);
			longDescs.put("magical forest", DescBeforeFight+"\n\tThere is "+dis.getItemOnFloor()+" on the floor.");
			shortDescsAftFight.put("magical forest", DescAfterFight);
			longDescsAftFight.put("magical forest", DescAfterFight+"\n\tThere is "+dis.getItemOnFloor()+" on the floor.");
			Entities.put("magical forest", EntityFactory.getEntity("FAIRY", dis));
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
			shortDescs.put("mountain", "You reached the top of the mountain overcoming"
					+ " every obstacle put in front of you during your journey. This trip"
					+ " made you a very powerful individual and now you feel ready to take onto"
					+ " your next adventure.\n\n\n\tTHANKS FOR PLAYING!");
		}
	}
	
	public static void innitPics() {
		Ded.setImage(Ded.getImage().getScaledInstance(364, 361, Image.SCALE_SMOOTH));
		ChooseClass.setImage(ChooseClass.getImage().getScaledInstance(364, 361, Image.SCALE_SMOOTH));
		bandits.setImage(bandits.getImage().getScaledInstance(364, 361, Image.SCALE_SMOOTH));
		GiantSnake.setImage(GiantSnake.getImage().getScaledInstance(364, 361, Image.SCALE_SMOOTH));
		mountainView.setImage(mountainView.getImage().getScaledInstance(364, 361, Image.SCALE_SMOOTH));
		Minotaur.setImage(Minotaur.getImage().getScaledInstance(364, 361, Image.SCALE_SMOOTH));
		SkullKid.setImage(SkullKid.getImage().getScaledInstance(364, 361, Image.SCALE_SMOOTH));
		lookSkullKid.setImage(lookSkullKid.getImage().getScaledInstance(364, 361, Image.SCALE_SMOOTH));
		Forest.setImage(Forest.getImage().getScaledInstance(364, 361, Image.SCALE_SMOOTH));
		Villager.setImage(Villager.getImage().getScaledInstance(364, 361, Image.SCALE_SMOOTH));
		Village.setImage(Village.getImage().getScaledInstance(364, 361, Image.SCALE_SMOOTH));
		Lake.setImage(Lake.getImage().getScaledInstance(364, 361, Image.SCALE_SMOOTH));
		LadyofTheLake.setImage(LadyofTheLake.getImage().getScaledInstance(364, 361, Image.SCALE_SMOOTH));
		Cave.setImage(Cave.getImage().getScaledInstance(364, 361, Image.SCALE_SMOOTH));
		Bear.setImage(Bear.getImage().getScaledInstance(364, 361, Image.SCALE_SMOOTH));
		Swamp.setImage(Swamp.getImage().getScaledInstance(364, 361, Image.SCALE_SMOOTH));
		OldLady.setImage(OldLady.getImage().getScaledInstance(364, 361, Image.SCALE_SMOOTH));
		Witch.setImage(Witch.getImage().getScaledInstance(364, 361, Image.SCALE_SMOOTH));
		Creeper.setImage(Creeper.getImage().getScaledInstance(364, 361, Image.SCALE_SMOOTH));
		DeadGiantSnake.setImage(DeadGiantSnake.getImage().getScaledInstance(364, 361, Image.SCALE_SMOOTH));
		DeadMinotaur.setImage(DeadMinotaur.getImage().getScaledInstance(364, 361, Image.SCALE_SMOOTH));
		LostWoods.setImage(LostWoods.getImage().getScaledInstance(364, 361, Image.SCALE_SMOOTH));
		CreeperHole.setImage(CreeperHole.getImage().getScaledInstance(364, 361, Image.SCALE_SMOOTH));
		Forest3.setImage(Forest3.getImage().getScaledInstance(364, 361, Image.SCALE_SMOOTH));
		Adult.setImage(Adult.getImage().getScaledInstance(364, 361, Image.SCALE_SMOOTH));
		Fairy.setImage(Fairy.getImage().getScaledInstance(364, 361, Image.SCALE_SMOOTH));
		MountainTop.setImage(MountainTop.getImage().getScaledInstance(364, 361, Image.SCALE_SMOOTH));
		MrsSpider.setImage(MrsSpider.getImage().getScaledInstance(364, 361, Image.SCALE_SMOOTH));
		Spiderweb.setImage(Spiderweb.getImage().getScaledInstance(364, 361, Image.SCALE_SMOOTH));
		
		//Pics before fight
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
		picBeforeFight.put("village", Village);
		picBeforeFight.put("sabeis", Adult);
		picBeforeFight.put("magical forest", Fairy);
		picBeforeFight.put("spider web", MrsSpider);
		
		//Look image
		lookImage.put("bandits", bandits);
		lookImage.put("wasteland", GiantSnake);
		lookImage.put("mountainViewNorth", mountainView);
		lookImage.put("mountainViewEast", mountainView);
		lookImage.put("mountainViewSouth", mountainView);
		lookImage.put("mountainViewWest", mountainView);
		lookImage.put("mountainViewNorthWest", mountainView);
		lookImage.put("mountainViewNorthEast", mountainView);
		lookImage.put("mountainViewSouthWest", mountainView);
		lookImage.put("mountainViewSouthEast", mountainView);
		lookImage.put("mountainSurroundings", Minotaur);
		lookImage.put("woods", lookSkullKid);
		lookImage.put("forest", Forest);
		lookImage.put("lake", LadyofTheLake);
		lookImage.put("cave", Bear);
		lookImage.put("swamp", OldLady);
		lookImage.put("plains", Creeper);
		lookImage.put("village", Villager);
		lookImage.put("sabeis", Adult);
		lookImage.put("magical forest", Fairy);
		lookImage.put("spider web", MrsSpider);
		
		//Pic after fight
		picAfterFight.put("bandits", Forest1);
		picAfterFight.put("wasteland", DeadGiantSnake);
		picAfterFight.put("mountainViewNorth", mountainView);
		picAfterFight.put("mountainViewEast", mountainView);
		picAfterFight.put("mountainViewSouth", mountainView);
		picAfterFight.put("mountainViewWest", mountainView);
		picAfterFight.put("mountainViewNorthWest", mountainView);
		picAfterFight.put("mountainViewNorthEast", mountainView);
		picAfterFight.put("mountainViewSouthWest", mountainView);
		picAfterFight.put("mountainViewSouthEast", mountainView);
		picAfterFight.put("mountainSurroundings", DeadMinotaur);
		picAfterFight.put("woods", LostWoods);
		picAfterFight.put("forest", Forest);
		picAfterFight.put("lake", Lake);
		picAfterFight.put("cave", Cave);
		picAfterFight.put("swamp", Swamp);
		picAfterFight.put("plains", CreeperHole);
		picAfterFight.put("village", Village);
		picAfterFight.put("sabeis", Forest3);
		picAfterFight.put("magical forest", Forest1);
		picAfterFight.put("spider web", Spiderweb);
	}
}
