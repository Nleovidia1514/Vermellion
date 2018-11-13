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
		if(!player.current.hasEnemy) {
			int dir = rnd.nextInt(4);
			while(player.current.getNeighbors()[dir] == null)
				dir = rnd.nextInt(4);
			
			player.current = player.current.getNeighbors()[dir];
			if(dir==SingletonMap.NORTH)
				Start.ta.setText("You're hallucinating and walked north instead.");
			
			else if(dir==SingletonMap.EAST)
				Start.ta.setText("You're hallucinating and walked east instead.");
			
			else if(dir==SingletonMap.SOUTH)
				Start.ta.setText("You're hallucinating and walked south instead");
			
			else if(dir==SingletonMap.WEST)
				Start.ta.setText("You're hallucinating and walked west instead.");
			
			
		}
		else {
			Start.ta.setText("You walked right through those who were trying to kill\n"
					+ "you facilitating their job. You really are a doubtful IQ person.");
			player.die(player);
		}
	}

	@Override
	public void decideWhatToDo(Scanner sn, Character player) {
		super.decideWhatToDo(sn, player);
		if(player.THIRST>25)
			player.setCharacterState(NormalState.instance());
	}
	
	@Override
	public void talkToNPC(Scanner sn, Character player) {
		Start.ta.setText("You're hallucinating because of the thirst and no one\n"
				+ "can understand what you're trying to say.");
	}
	
	@Override
	public void die(Character player) {
		Start.ta.append("\nYou perished from thirst on Vermellion's lands. But you go down\n"
				+ "with a smile on your face because you know that this trip\n"
				+ "wasn't a failure, it was a learning experience.\n");
		Start.gameIsRunning = false;
	}

}
