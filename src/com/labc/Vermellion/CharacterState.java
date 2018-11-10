package com.labc.Vermellion;

import java.util.Scanner;

public abstract class CharacterState {
	public abstract void walk(String direction, Character player);
	
	public void decideWhatToDo(Scanner sn, Character player) {
		String action;
		if(sn.hasNext()) {
			action = sn.next();
			if(action.equalsIgnoreCase("ATTACK"))
				player.attack();
			
			else if(action.equalsIgnoreCase("LOOK")) 
				System.out.println(player.current.getLongDescription());
			
			else if(action.equalsIgnoreCase("RUN"))
				player.run();
			
			else if(action.equalsIgnoreCase("SHOOT")) {
				if( sn.hasNext() ) {
					if(player.current.mob != null)
						player.shoot( sn.next() );
					else
						System.out.println("\nThere is nothing in here.");
				}
				else
					System.out.println("Shoot what?");
			}
			
			else if(action.equalsIgnoreCase("INVENTORY"))
				player.seeInv();
			
			else if(action.equalsIgnoreCase("STATS"))
				player.seeStats();
			
			else if(action.equalsIgnoreCase("WALK")) {
				if( sn.hasNext() )
					player.walk(sn.next().trim());
				else
					System.out.println("Walk where?");
			}
			
			else if(action.equalsIgnoreCase("PICKUP")) {
				if( sn.hasNext() )
					player.pickUpItem(sn.next());
				else
					System.out.println("Pick what up?");
			}
			else if(action.equalsIgnoreCase("USE")) {
				if( sn.hasNext() ) {
					String name = sn.next();
					Item item = null;
					for(int i=0;i<player.inventory.size();i++)
						if(name.equalsIgnoreCase(player.inventory.get(i).getName()))
							item = player.inventory.get(i);
					if( item == null )
						System.out.println("You don't have that item in your inventory.");
					else
						item.beUsed();
				}
				else 
					System.out.println("Use what?");
			}
				
			else
				System.out.println("You can't do that.");
		}
		else
			System.out.println("Are you a mute?");
		
		if(player.THIRST<25)
			player.setCharacterState(ThirstyState.instance());
	}
}
