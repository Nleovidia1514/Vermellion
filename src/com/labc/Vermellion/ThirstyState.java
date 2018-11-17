package com.labc.Vermellion;

import java.util.Scanner;

public class ThirstyState extends CharacterState{
	private static ThirstyState instance = new ThirstyState();
	
	public static ThirstyState instance() {
		return instance;
	}
	
	
	
	public boolean walk(String direction, Character player) {
		boolean success = false;
		if(!player.current.hasEnemy) {
			int dir = Start.rnd.nextInt(4);
			while(player.current.getNeighbors()[dir] == null)
				dir = Start.rnd.nextInt(4);
			
			player.current = player.current.getNeighbors()[dir];
			if(dir==SingletonMap.NORTH)
				Start.ta.setText("You're hallucinating and walked north instead.\n");
			
			else if(dir==SingletonMap.EAST)
				Start.ta.setText("You're hallucinating and walked east instead.\n");
			
			else if(dir==SingletonMap.SOUTH)
				Start.ta.setText("You're hallucinating and walked south instead\n");
			
			else if(dir==SingletonMap.WEST)
				Start.ta.setText("You're hallucinating and walked west instead.\n");
			
			success = true;
			player.current.accept(player);
		}
		else {
			Start.ta.setText("You walked right through those who were trying to kill "
					+ "you facilitating their job. You really are a doubtful IQ person.");
			player.die(player);
		}
		return success;
	}

	@Override
	public void decideWhatToDo(Scanner sn, Character player) {
		super.decideWhatToDo(sn, player);
		if(player.THIRST>25)
			player.setCharacterState(NormalState.instance());
	}
	
	@Override
	public void talkToNPC(Scanner sn, Character player) {
		Start.ta.setText("You're hallucinating because of the thirst and no one "
				+ "can understand what you're trying to say.");
	}
	
	@Override
	public void die(Character player) {
		Start.ta.append("\n\nYou perished from thirst on Vermellion's lands. But you go down "
				+ "with a smile on your face because you know that this trip "
				+ "wasn't a failure, it was a learning experience.");
		Start.gameIsRunning = false;
	}

}
