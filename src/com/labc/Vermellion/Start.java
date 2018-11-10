package com.labc.Vermellion;

import java.io.IOException;
import java.util.Random;
import java.util.Scanner;
import com.labc.Vermellion.Classes.Archer;
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
	
	public Start() throws IOException {
		this.gameIsRunning = true;
		System.out.println("You wake up in the middle of nowhere with nothing\n"
				+"but your skills and a thirst for revenge. You look\n"
				+"around and see a number of tools:\n\nA staff\nA dagger"
				+"\nA sword\nA pair of glasses\nA bow\nWhat do you grab?");
		//this.Player = Singleton.getInstance(starting, clase);
		map = SingletonMap.getInstance();
		this.starting = map.getTile(rnd.nextInt(SingletonMap.MapSize), rnd.nextInt(SingletonMap.MapSize));
		
		while(!clase.equalsIgnoreCase("staff") && !clase.equalsIgnoreCase("Dagger")
				&& !clase.equalsIgnoreCase("sword") && !clase.equalsIgnoreCase("glasses")
				&& !clase.equalsIgnoreCase("BOW")) {
			clase = sn.nextLine();
			if(clase.equalsIgnoreCase("staff"))
				Player = new Mage(starting);
			else if(clase.equalsIgnoreCase("dagger"))
				Player = new Rogue(starting);
			else if(clase.equalsIgnoreCase("sword"))
				Player = new Fighter(starting);
			else if(clase.equalsIgnoreCase("glasses"))
				Player = new Nerio(starting);
			else if(clase.equalsIgnoreCase("bow"))
				Player = new Archer(starting);
			else
				System.out.println("You look for "+clase+" but you can't find one");
		}	
		while(gameIsRunning) {
			System.out.println(Player.current.getShortDescription());
			System.out.println("\nHP - "+Player.getHP()+"\n"
			+"MAGIC - "+Player.getMagic()+"\n"
			+"THIRST - "+Player.THIRST);
			changeGameState(sn.nextLine());
		}
	}
	
	private void changeGameState(String action) {
		Scanner sn1 = new Scanner(action);
		Player.decideWhatToDo(sn1);
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		new Start();
	}

}
