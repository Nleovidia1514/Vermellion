package com.labc.Vermellion;

import java.util.Random;
import java.util.Scanner;

public class ThirstyState extends CharacterState{
	private static ThirstyState instance = new ThirstyState();
	
	public static ThirstyState instance() {
		return instance;
	}
	
	
	
	public void walk(String direction, Character player) {
		Random rnd = new Random();
		int dir = rnd.nextInt(4);
		while(player.current.getNeighbors()[dir] == null)
			dir = rnd.nextInt(4);
		
		player.current = player.current.getNeighbors()[dir];
		if(dir==SingletonMap.NORTH)
			System.out.println("\nYou're hallucinating and walked north instead.");
		
		else if(dir==SingletonMap.EAST)
			System.out.println("\nYou're hallucinating and walked east instead.");
		
		else if(dir==SingletonMap.SOUTH)
			System.out.println("\nYou're hallucinating and walked south instead");
		
		else if(dir==SingletonMap.WEST)
			System.out.println("\nYou're hallucinating and walked west instead.");
	}

	@Override
	public void decideWhatToDo(Scanner sn, Character player) {
		super.decideWhatToDo(sn, player);
		if(player.THIRST>25)
			player.setCharacterState(NormalState.instance());
	}
	
	@Override
	public void talkToNPC(Scanner sn, Character player) {
		System.out.println("You're hallucinating and no one can understand what you're trying to say.");
	}
	
	@Override
	public void die(Character player) {
		System.out.println("You perished from thirst on Vermellion's lands. But you go down\n"
				+ "with a smile on your face because you know that this trip\n"
				+ "wasn't a failure, it was a learning adventure.\n");
		Start.gameIsRunning = false;
	}

}
