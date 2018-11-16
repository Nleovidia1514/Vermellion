package com.labc.Vermellion;

import java.util.Scanner;

public class NormalState extends CharacterState {
	private static NormalState instance = new NormalState(); 
	
	public static NormalState instance() {
		return instance;
	}

	@Override
	public void decideWhatToDo(Scanner sn, Character player) {
		super.decideWhatToDo(sn, player);
	}
	
	@Override
	public void walk(String direction, Character player) {
		if(!player.current.hasEnemy) {
			if(direction.toLowerCase().contains("north")) {
				if(player.current.getNeighbors()[SingletonMap.NORTH]!=null) {
					player.current = player.current.getNeighbors()[SingletonMap.NORTH];
					Start.ta.setText("You walked north\n\n");
					player.current.accept(player);
				}
					
				else
					Start.ta.setText("Seems like there is no access through there");
			}
			
			else if(direction.toLowerCase().contains("east")) {
				if(player.current.getNeighbors()[SingletonMap.EAST]!=null) {
					player.current = player.current.getNeighbors()[SingletonMap.EAST];
					Start.ta.setText("You walked east\n\n");
					player.current.accept(player);
				}
					
				else
					Start.ta.setText("Seems like there is no access through there");
			}
			
			else if(direction.toLowerCase().contains("south")) {
				if(player.current.getNeighbors()[SingletonMap.SOUTH]!=null) {
					player.current = player.current.getNeighbors()[SingletonMap.SOUTH];
					Start.ta.setText("You walked south\n\n");
					player.current.accept(player);
				}
					
				else
					Start.ta.setText("Seems like there is no access through there");
			}
			
			else if(direction.toLowerCase().contains("west")) {
				if(player.current.getNeighbors()[SingletonMap.WEST]!=null) {
					player.current = player.current.getNeighbors()[SingletonMap.WEST];
					Start.ta.setText("You walked west\n\n");
					player.current.accept(player);
				}
					
				else
					Start.ta.setText("Seems like there is no access through there");
			}
			else
				Start.ta.setText("You can't walk there for some odd reason...");
			
			player.THIRST-=20;
		}
		else {
			Start.ta.setText("You walked right through those who were trying to kill "
					+ "you facilitating their job. You really are a doubtful IQ person.");
			player.die(player);
		}
	}
	
	@Override
	public void talkToNPC(Scanner sn, Character player) {
		if(sn.hasNext()) {
			String to = sn.next();
			if(to.equalsIgnoreCase("to")) {
				if(sn.hasNext()){
					boolean okay = false;
					String[] wat = sn.nextLine().split(" ");
					for(String who : wat)
						if(player.current.mob.getName().toLowerCase().
								contains(who)) {
							player.current.mob.talk();
							okay = true;
						}
					if(okay = false)
						Start.ta.setText("There is no such being like that here");
				}
				else
					Start.ta.setText("Talk to who?");
			}
			else
				Start.ta.setText("Talk... What??");
		}
		else
			Start.ta.setText("Talk to who?");
	}

	@Override
	public void die(Character player) {
		Start.ta.append("\n\nYou perished on Vermellion's lands. But you go down "
				+ "with a smile on your face because you know that this trip "
				+ "wasn't a failure, it was a learning experience.\n");
		Start.gameIsRunning = false;
	}

}
