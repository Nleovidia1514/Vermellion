package com.labc.Vermellion;

import java.util.HashMap;


public class Descriptions {
	public HashMap<String,String> shortDescs = new HashMap<String,String>();
	public HashMap<String,String> longDescs = new HashMap<String,String>();
	public HashMap<String,Entity> Entities = new HashMap<String,Entity>();
	
	public Descriptions(Tile dis) {
		shortDescs.put("bandits","YOU FEEL SOMETHING ISN'T RIGHT... YOU WALK FOR A LITTLE BIT\n"
				+"BEFORE A GROUP OF BANDITS JUMPS YOU AND TRIES TO TAKE EVERYTHING\n"
				+"YOU OWN. 'This one is tender booooiiiiissss' YOU HEAR ONE OF THE BANDITS SAY\n"
				+"WHAT WILL YOU DO?");
		longDescs.put("bandits","THERE ARE "+dis.getItemOnFloor()+" ON THE FLOOR ");
		
		
		shortDescs.put("wasteland","YOU FIND YOURSELF IN A STRANGE PLACE");
	}
	
}
