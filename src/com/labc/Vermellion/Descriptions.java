package com.labc.Vermellion;

import java.util.HashMap;


public class Descriptions {
	public HashMap<String,String> shortDescs = new HashMap<String,String>();
	public HashMap<String,String> shortDescsAftFight = new HashMap<String,String>(); 
	public HashMap<String,String> longDescs = new HashMap<String,String>();
	public HashMap<String,Entity> Entities = new HashMap<String,Entity>();
	
	public Descriptions(Tile dis) {
		shortDescs.put("bandits","\nSomething isn't right... you don't know what\n"
				+ "it is but you will soon find out. Suddenly a pack of bandits\n"
				+ "attacks you and tries to steal everything you own. What will you do?");
		longDescs.put("bandits","\nThere is "+dis.getItemOnFloor()+" on the floor but you don't have\n"
				+ "time to pick it up.");
		shortDescsAftFight.put("bandits","\nThere are remains of bandits on the floor.");
		
		shortDescs.put("wasteland","\nYou find yourself in a strange place.\n"
				+ "There are no trees in here even though you just came out of a forest\n"
				+ "suddenly the thirst hits you and you start hallucinating. What will you do?");
	}
	
}
