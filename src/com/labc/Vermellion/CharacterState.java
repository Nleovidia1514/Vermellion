package com.labc.Vermellion;

import java.util.Scanner;

public abstract class CharacterState {
	public abstract void walk(String direction, Character player);
	public abstract void talkToNPC(Scanner sn, Character player);
	public abstract void die(Character player);
	
	public void decideWhatToDo(Scanner sn, Character player) {
		String action;
		if(player.getCharacterstate() != ThirstyState.instance()
				&& player.current.getName().equalsIgnoreCase("Wasteland")) {
			player.THIRST = 25;
		}
		
		else if(player.getCharacterstate() != ThirstyState.instance() &&
				player.current.getName().equalsIgnoreCase("MountainSurroundings")) {
			player.THIRST = 30;
		}
		if(sn.hasNext()) {
			action = sn.next();
			if(action.equalsIgnoreCase("ATTACK"))
				player.attack(sn);
			
			else if(action.equalsIgnoreCase("LOOK")) 
				Start.ta.setText(player.current.getLongDescription());
			
			else if(action.equalsIgnoreCase("RUN"))
				player.run();
			
			else if(action.equalsIgnoreCase("SHOOT")) {
				if( sn.hasNext() ) {
					if(player.current.mob != null)
						player.shoot( sn.next() );
					else
						Start.ta.append("\nThere is nothing in here.");
				}
				else
					Start.ta.append("\nShoot what?");
			}
			
			else if(action.equalsIgnoreCase("INVENTORY"))
				player.seeInv();
			
			else if(action.equalsIgnoreCase("STATS"))
				player.seeStats();
			
			else if(action.equalsIgnoreCase("WALK")) {
				if( sn.hasNext() )
					player.walk(sn.next().trim());
				else
					Start.ta.append("\nWalk where?");
			}
			
			else if(action.equalsIgnoreCase("PICKUP")) {
				if( sn.hasNext() )
					player.pickUpItem(sn.next());
				else
					Start.ta.append("\nPick what up?");
			}
			else if(action.equalsIgnoreCase("USE")||action.equalsIgnoreCase("EAT")
					||action.equalsIgnoreCase("DRINK")) {
				if( sn.hasNext() ) {
					String name = sn.next();
					Item item = null;
					for(int i=0;i<player.inventory.size();i++)
						if(player.inventory.get(i).getName().toLowerCase().
								contains(name.toLowerCase()))
							item = player.inventory.get(i);
					if( item == null )
						Start.ta.append("\nYou don't have that item in your inventory.");
					else
						item.beUsed();
				}
				else 
					Start.ta.append("\nUse what?");
			}
			
			else if(action.equalsIgnoreCase("TALK")) {
				player.talkToNPC(sn, player);
			}
			
			else if(action.equalsIgnoreCase("SUICIDE")) {
				player.die(player);
			}
			
			else
				Start.ta.append("\nYou can't do that.");
		}
		else
			Start.ta.append("\nAre you a mute?");
		
		if(player.THIRST<=25)
			player.setCharacterState(ThirstyState.instance());
		
		if(player.THIRST<=0 || player.HP<=0) {
			player.die(player);
		}
	}
}
