package com.labc.Vermellion;

import java.io.FileNotFoundException;
import java.util.Random;
import java.util.Scanner;

import com.labc.Vermellion.Classes.Fighter;
import com.labc.Vermellion.Classes.Mage;
import com.labc.Vermellion.Classes.Nerio;
import com.labc.Vermellion.Classes.Rogue;

public class Start {
	private Tile starting;
	private SingletonMap map;
	public static Random rnd = new Random();
	private String clase = "";
	private Scanner sn = new Scanner(System.in);
	private Character Player;
	private boolean gameIsRunning;
	
	public Start() throws FileNotFoundException {
		this.gameIsRunning = true;
		System.out.println("You wake up in the middle of nowhere with nothing\n"
				+"but your skills and a thirst for revenge. You look\n"
				+"around and see a number of tools:\n\na staff(STAFF)\ntwo knives(KNIVES)"
				+"\na sword(SWORD)\na pair of glasses(GLASSES)\nWhat do you grab?");
		//this.Player = Singleton.getInstance(starting, clase);
		map = SingletonMap.getInstance();
		this.starting = map.getTile(rnd.nextInt(SingletonMap.MapSize), rnd.nextInt(SingletonMap.MapSize));
		
		while(!clase.toLowerCase().equals("staff") && !clase.toLowerCase().equals("knives")
				&& !clase.toLowerCase().equals("sword") && !clase.toLowerCase().equals("glasses")) {
			clase = sn.nextLine();
			if(clase.toLowerCase().equals("staff"))
				Player = new Mage(starting);
			else if(clase.toLowerCase().equals("knives"))
				Player = new Rogue(starting);
			else if(clase.toLowerCase().equals("sword"))
				Player = new Fighter(starting);
			else if(clase.toLowerCase().equals("glasses"))
				Player = new Nerio(starting);
			else
				System.out.println("You look for "+clase+" but you can't find one");
		}	
		while(gameIsRunning) {
			System.out.println(Player.current.getShortDescription());
			changeGameState(sn.nextLine());
		}
	}
	
	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		new Start();
	}
	
	private void changeGameState(String action) {
		Scanner sn1 = new Scanner(action);
		Player.decideWhatToDo(sn1);
	}
}
