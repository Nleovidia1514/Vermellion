package com.labc.Vermellion;

import java.util.Scanner;

public class PoisonedState extends CharacterState {
	private static PoisonedState instance = new PoisonedState();
	public int turnsPoisoned;
	public int turnsSuffered = 0;
	
	public static PoisonedState instance() {
		return instance;
	}
	
	@Override
	public void decideWhatToDo(Scanner sn, Character player) {
		super.decideWhatToDo(sn, player);
		
		turnsSuffered++;
		
		if(turnsSuffered == turnsPoisoned) {
			player.setCharacterState(NormalState.instance());
			turnsSuffered = 0;
			turnsPoisoned = 0;
		}
		
		player.setHP(player.getHP()-10);
		Start.ta.append("\nYou lost 10 HP because of the poison");
	}
	
	@Override
	public boolean walk(String direction, Character player) {
		boolean success = false;
		if(!player.current.hasEnemy) {
			if(direction.toLowerCase().contains("north")) {
				if(player.current.getNeighbors()[SingletonMap.NORTH]!=null) {
					Start.ta.setText("You walked north\n\n");
					player.current = player.current.getNeighbors()[SingletonMap.NORTH];
					player.current.accept(player);
					success = true;
				}
					
				else
					Start.ta.setText("Seems like there is no access through there");
			}
			
			else if(direction.toLowerCase().contains("east")) {
				if(player.current.getNeighbors()[SingletonMap.EAST]!=null) {
					Start.ta.setText("You walked east\n\n");
					player.current = player.current.getNeighbors()[SingletonMap.EAST];
					player.current.accept(player);
					success = true;
				}
					
				else
					Start.ta.setText("Seems like there is no access through there");
			}
			
			else if(direction.toLowerCase().contains("south")) {
				if(player.current.getNeighbors()[SingletonMap.SOUTH]!=null) {
					Start.ta.setText("You walked south\n\n");
					player.current = player.current.getNeighbors()[SingletonMap.SOUTH];
					player.current.accept(player);
					success = true;
				}
					
				else
					Start.ta.setText("Seems like there is no access through there");
			}
			
			else if(direction.toLowerCase().contains("west")) {
				if(player.current.getNeighbors()[SingletonMap.WEST]!=null) {
					Start.ta.setText("You walked west\n\n");
					player.current = player.current.getNeighbors()[SingletonMap.WEST];
					player.current.accept(player);
					success = true;
				}
					
				else
					Start.ta.setText("Seems like there is no access through there");
			}
			else
				Start.ta.setText("You must specify a compass direction to go in.");
			
			player.THIRST-=20;
		}
		else {
			Start.ta.setText("You walked right through those who were trying to kill "
					+ "you facilitating their job. You really are a doubtful IQ person.");
			player.die(player);
		}
		return success;
	}
	
	@Override
	public void talkToNPC(Scanner sn, Character player) {
		if(sn.hasNext()) {
			String to = sn.next();
			if(to.equalsIgnoreCase("to")) {
				if(sn.hasNext()) {
					String who = sn.next();
					if(player.current.mob.getName().toLowerCase().
							contains(who.toLowerCase()))
						player.current.mob.talk();
					else
						Start.ta.setText("There is no such being like that here.");
				}
				else
					Start.ta.setText("Talk to who?");
			}
			else
				Start.ta.setText("Talk... What?");
		}
		else
			Start.ta.setText("Talk to who?");
	}
	
	@Override
	public void die(Character player) {
		Start.ta.append("\n\nYou perished from poison on Vermellion's lands. "
				+ "But you go down with a smile on your face because you "
				+ "know that this trip wasn't a failure, it was a learning experience.");
		Start.gameIsRunning = false;
	}

}
