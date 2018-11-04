package com.labc.Vermellion;

import java.util.Random;
import java.util.Scanner;

public class Start {
	private Tile starting;
	private Map map;
	private Random rnd = new Random();
	private String clase = "";
	private Scanner sn = new Scanner(System.in);
	
	public Start() {
		System.out.println("You wake up in the middle of nowhere with nothing\n"
				+"but your skills and a thirst for revenge. You look\n"
				+"around and see a number of tools:\n\na staff(STAFF)\ntwo knives(KNIVES)"
				+"\na sword(SWORD)\na pair of glasses(GLASSES)\nWhat do you grab?");
		this.map = new Map();
		this.starting = map.getTile(rnd.nextInt(Map.MapSize), rnd.nextInt(Map.MapSize));
		while(!clase.toLowerCase().equals("staff") && !clase.toLowerCase().equals("knives")
				&& !clase.toLowerCase().equals("sword") && !clase.toLowerCase().equals("glasses")) {
			clase = sn.nextLine();
			if(!clase.toLowerCase().equals("staff") && !clase.toLowerCase().equals("knives")
					&& !clase.toLowerCase().equals("sword") && !clase.toLowerCase().equals("glasses")) {
				System.out.println("You look for "+clase+" but you can't find one");
			}
		}	
		Singleton.getInstance(starting, clase);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Start();
	}
	
}

class Singleton 
{ 
	static Tile starting;
	static String clase;
	private volatile static Singleton obj; 

	private Singleton(Tile starting, String clase) {
		Singleton.starting = starting;
		Singleton.clase = clase;
		if(clase.toLowerCase().equals("staff")) 
			new Mage(starting);
		else if(clase.toLowerCase().equals("knives"))
			new Rogue(starting);
		else if(clase.toLowerCase().equals("sword"))
			new Fighter(starting);
		else if(clase.toLowerCase().equals("glasses"))
			new Nerio(starting);
		}

	public static Singleton getInstance(Tile starting, String clase) 
	{ 
		if (obj == null) 
		{ 
			synchronized (Singleton.class) 
			{ 
				if (obj==null) 
					obj = new Singleton(starting, clase); 
			} 
		} 
		return obj; 
	} 
} 
