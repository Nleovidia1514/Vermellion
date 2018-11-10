package com.labc.Vermellion;

public class NotPoisoned extends CharacterState {
	private static NotPoisoned instance = new NotPoisoned(); 
	
	public static NotPoisoned instance() {
		return instance;
	}

	@Override
	public void walk(String direction, Character player) {
		if(direction.toLowerCase().equals("north")) {
			if(player.current.getNeighbors()[SingletonMap.NORTH]!=null)
				player.current = player.current.getNeighbors()[SingletonMap.NORTH];
			else
				System.out.println("Seems like there is no access through there");
		}
		
		else if(direction.toLowerCase().equals("east")) {
			if(player.current.getNeighbors()[SingletonMap.EAST]!=null)
				player.current = player.current.getNeighbors()[SingletonMap.EAST];
			else
				System.out.println("Seems like there is no access through there");
		}
		
		else if(direction.toLowerCase().equals("south")) {
			if(player.current.getNeighbors()[SingletonMap.SOUTH]!=null)
				player.current = player.current.getNeighbors()[SingletonMap.SOUTH];
			else
				System.out.println("Seems like there is no access through there");
		}
		
		else if(direction.toLowerCase().equals("west")) {
			if(player.current.getNeighbors()[SingletonMap.WEST]!=null)
				player.current = player.current.getNeighbors()[SingletonMap.WEST];
			else
				System.out.println("Seems like there is no access through there");
		}
		else
			System.out.println("You can't walk there for some odd reason...");
		
		player.current.player = player;
		System.out.println(player.current.x+","+player.current.y);
	}

}
