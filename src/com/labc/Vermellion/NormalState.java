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
			if(direction.toLowerCase().equals("north")) {
				if(player.current.getNeighbors()[SingletonMap.NORTH]!=null)
					player.current = player.current.getNeighbors()[SingletonMap.NORTH];
				else
					Start.ta.append("\nSeems like there is no access through there");
			}
			
			else if(direction.toLowerCase().equals("east")) {
				if(player.current.getNeighbors()[SingletonMap.EAST]!=null)
					player.current = player.current.getNeighbors()[SingletonMap.EAST];
				else
					Start.ta.append("\nSeems like there is no access through there");
			}
			
			else if(direction.toLowerCase().equals("south")) {
				if(player.current.getNeighbors()[SingletonMap.SOUTH]!=null)
					player.current = player.current.getNeighbors()[SingletonMap.SOUTH];
				else
					Start.ta.append("\nSeems like there is no access through there");
			}
			
			else if(direction.toLowerCase().equals("west")) {
				if(player.current.getNeighbors()[SingletonMap.WEST]!=null)
					player.current = player.current.getNeighbors()[SingletonMap.WEST];
				else
					Start.ta.append("\nSeems like there is no access through there");
			}
			else
				Start.ta.append("\nYou can't walk there for some odd reason...");
			
			player.current.player = player;
			player.THIRST-=20;
		}
		else {
			Start.ta.append("\nYou walked right through those who were trying to kill\n"
					+ "you facilitating their job. You really are a doubtful IQ person.");
			player.die(player);
		}
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
						Start.ta.append("\nThere is no "+who+" to talk to.");
				}
				else
					Start.ta.append("\nTalk to who?");
			}
			else
				Start.ta.append("\nTalk... What?");
		}
		else
			Start.ta.append("\nTalk to who?");
	}

	@Override
	public void die(Character player) {
		Start.ta.append("\nYou perished on Vermellion's lands. But you go down\n"
				+ "with a smile on your face because you know that this trip\n"
				+ "wasn't a failure, it was a learning experience.\n");
		Start.gameIsRunning = false;
	}

}
