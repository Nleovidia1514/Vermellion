package com.labc.Vermellion;

import java.util.Scanner;

public abstract class CharacterState {
	public abstract boolean walk(String direction, Character player);
	public abstract void talkToNPC(Scanner sn, Character player);
	public abstract void die(Character player);
	
	public void decideWhatToDo(Scanner sn, Character player) {
		String action;
		if(sn.hasNext()) {
			action = sn.next();
			if(action.equalsIgnoreCase("ATTACK") || action.equalsIgnoreCase("KILL"))
				player.attack(sn);
			
			else if(action.equalsIgnoreCase("LOOK") || action.equalsIgnoreCase("SEE")) 
				player.look(sn);
			
			else if(action.equalsIgnoreCase("DROP"))
				player.drop(sn);
			
			else if(action.equalsIgnoreCase("RUN"))
				player.run();
			
			else if(action.equalsIgnoreCase("SHOOT")) {
				if( sn.hasNext() ) {
					if(player.current.mob != null)
						player.shoot( sn.next() );
					else
						Start.ta.setText("There is nothing in here.");
				}
				else
					Start.ta.setText("Shoot what?");
			}
			
			else if(action.toUpperCase().contains("INV"))
				player.seeInv();
			
			else if(action.equalsIgnoreCase("STATS"))
				player.seeStats();
			
			else if(action.equalsIgnoreCase("WALK") || action.equalsIgnoreCase("GO")) {
				if( sn.hasNext() )
					player.walk(sn.nextLine().trim());
				else if(action.equalsIgnoreCase("WALK"))
					Start.ta.setText("Walk where?");
				else
					Start.ta.setText("Go where?");
			}
			
			else if(action.equalsIgnoreCase("PICKUP") || action.equalsIgnoreCase("TAKE") || action.equalsIgnoreCase("GRAB")) {
				if( sn.hasNext() )
					player.pickUpItem(sn.next());
				else if(action.equalsIgnoreCase("PICKUP"))
					Start.ta.setText("Pickup what?");
				else if(action.equalsIgnoreCase("TAKE"))
					Start.ta.setText("Take what?");
				else if(action.equalsIgnoreCase("GRAB"))
					Start.ta.setText("Grab what?");
			}
			
			else if(action.equalsIgnoreCase("USE")||action.equalsIgnoreCase("EAT")
					||action.equalsIgnoreCase("DRINK")) 
				player.useItem(sn,action);
			
			else if(action.equalsIgnoreCase("TALK")) 
				player.talkToNPC(sn);
			
			else if(action.equalsIgnoreCase("SUICIDE")) 
				player.die(player);
			
			else if(action.equalsIgnoreCase("EQUIP")) {
				player.equip(sn);
			}
			
			else if(action.toUpperCase().contains("UNEQ")) {
				player.unEquip(sn);
			}
			
			else if(action.equalsIgnoreCase("ZELDA")) {
				Start.background.stop();
				Start.battle.stop();
				Start.background = SoundFX.ZELDA;
				Start.battle = SoundFX.BATTLEZELDA;
				Start.ta.setText("Zelda soundtrack activated");
			}
				
			
			else if(action.equalsIgnoreCase("NORMAL")) {
				Start.background.stop();
				Start.battle.stop();
				Start.background = SoundFX.BACKGROUND;
				Start.battle = SoundFX.BATTLE;
				Start.ta.setText("Regular soundtrack activated");
			}
				
			
			else
				Start.ta.setText("You can't do that.");
		}
		else {
			Start.ta.setText("Are you a mute?");
			Start.ta.append(player.current.getShortDescription());
		}
		
		if(player.THIRST<=25)
			player.setCharacterState(ThirstyState.instance());
		
		if(player.THIRST<=0 || player.HP<=0) {
			player.die(player);
		}
		
	}
	
	
}
