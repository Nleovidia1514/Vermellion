package com.labc.Vermellion;

import java.util.ArrayList;
import java.util.Scanner;

import com.labc.Vermellion.Items.ItemFactory;

public abstract class Character {
	protected int HP, MAGIC, STR, BAGREDAD, ILLUSION, SNEAK, BLOCK, ACCURACY;
	protected int bagSize;
	protected Tile current;
	public ArrayList<Item> inventory;
	private ItemFactory itemFact;
	
	protected Character(Tile starting) {
		this.current = starting;
		current.player = this;
		this.inventory = new ArrayList<Item>();
		this.itemFact  = new ItemFactory(this);
	}
	
	protected void attack() {
		// TODO Auto-generated method stub
		if(current.hasEnemy)
			this.current.enemy.beAttacked(this.STR);
		else
			System.out.println("You attacked but hit the air LUL");
	}
	
	public void decideWhatToDo(Scanner sn) {
		String action;
		if(sn.hasNext()) {
			action = sn.next();
			if(action.equalsIgnoreCase("ATTACK"))
				attack();
			
			else if(action.equalsIgnoreCase("LOOK")) 
				System.out.println(this.current.getLongDescription());
			
			else if(action.equalsIgnoreCase("RUN"))
				run();
			
			else if(action.equalsIgnoreCase("SHOOT")) {
				if( sn.hasNext() ) 
					shoot( sn.next() );
				else
					System.out.println("Shoot what?");
			}
			
			else if(action.equalsIgnoreCase("INVENTORY"))
				seeInv();
			
			else if(action.equalsIgnoreCase("STATS"))
				seeStats();
			
			else if(action.equalsIgnoreCase("WALK")) {
				if( sn.hasNext() )
					walk(sn.next().trim());
				else
					System.out.println("Walk where?");
			}
			
			else if(action.equalsIgnoreCase("PICKUP")) {
				if( sn.hasNext() )
					pickUpItem(sn.next());
				else
					System.out.println("Pick what up?");
			}
			else if(action.equalsIgnoreCase("USE")) {
				if( sn.hasNext() ) {
					String name = sn.next();
					Item item = null;
					for(int i=0;i<inventory.size();i++)
						if(name.equalsIgnoreCase(inventory.get(i).toString()))
							item = inventory.get(i);
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
	}
	
	protected abstract void shoot(String target);

	protected void walk(String direction) {
		
		if(direction.toLowerCase().equals("north")) {
			if(current.getNeighbors()[SingletonMap.NORTH]!=null)
				this.current = current.getNeighbors()[SingletonMap.NORTH];
			else
				System.out.println("Seems like there is no access through there");
		}
		
		else if(direction.toLowerCase().equals("east")) {
			if(current.getNeighbors()[SingletonMap.EAST]!=null)
				this.current = current.getNeighbors()[SingletonMap.EAST];
			else
				System.out.println("Seems like there is no access through there");
		}
		
		else if(direction.toLowerCase().equals("south")) {
			if(current.getNeighbors()[SingletonMap.SOUTH]!=null)
				this.current = current.getNeighbors()[SingletonMap.SOUTH];
			else
				System.out.println("Seems like there is no access through there");
		}
		
		else if(direction.toLowerCase().equals("west")) {
			if(current.getNeighbors()[SingletonMap.WEST]!=null)
				this.current = current.getNeighbors()[SingletonMap.WEST];
			else
				System.out.println("Seems like there is no access through there");
		}
		else
			System.out.println("You can't walk there for some odd reason...");
		
		current.player = this;
		System.out.println(this.current.x+","+this.current.y);
	}

	protected void run() {
		String direction = null;
		int i = Start.rnd.nextInt(4);
		while(this.current.getNeighbors()[i]==null)
			i = Start.rnd.nextInt(4);
		this.current = this.current.getNeighbors()[i];
		direction = i==0 ? "north" : direction;
		direction = i==1 ? "east" : direction;
		direction = i==2 ? "south" : direction;
		direction = i==3 ? "west" : direction;
		System.out.println("You ran to the "+direction);
	}
	
	protected void pickUpItem(String item) {
		if( item.equalsIgnoreCase(this.current.getItemOnFloor().toString()) ) {
			if( inventory.size() >= this.bagSize )
				System.out.println("Your inventory is full");
			else {
				inventory.add(itemFact.getItem(item));
				System.out.println("You picked the "+item+" up");
			}
				
		}
		else
			System.out.println(" There is no "+item+" around here");
	}
	
	protected void seeInv() {
		for(int i=0;i<inventory.size();i++)
			System.out.println(inventory.get(i).toString()+" - "+inventory.get(i).getDescription());
	}
	
	protected void seeStats() {
		System.out.println("HP: "+this.HP);
		System.out.println("MAGIC: "+this.MAGIC);
		System.out.println("STR: "+this.STR);
		System.out.println("SNEAK: "+this.SNEAK);
		System.out.println("BLOCK: "+this.BLOCK);
		System.out.println("ACCURACY: "+this.ACCURACY);
		System.out.println("ILLUSION: "+this.ILLUSION);
		System.out.println("BAGREDAD: "+this.BAGREDAD);
	}
	
	public Tile getCurrent() {
		return this.current;
	}
	
	public void setHP(int HP) {
		this.HP = HP;
	}
	
	public int getHP() {
		return this.HP;
	}
	
	public void setMagic(int Magic) {
		this.MAGIC = Magic;
	}
	
	public int getMagic() {
		return this.MAGIC;
	}
	
	public void setSTR(int STR) {
		this.STR = STR;
	}
	
	public int getSTR() {
		return this.STR;
	}
	
	public void setBagredad(int Bagredad) {
		this.BAGREDAD = Bagredad;
	}
	
	public int getBagredad() {
		return this.BAGREDAD;
	}
	
	public void setIllusion(int Illusion) {
		this.ILLUSION = Illusion;
	}
	
	public int getIllusion() {
		return this.ILLUSION;
	}
	
	public void setSneak(int Sneak) {
		this.SNEAK = Sneak;
	}
	
	public int getSneak() {
		return this.SNEAK;
	}
	
	public void setBlock(int Block) {
		this.BLOCK = Block;
	}
	
	public int getBlock() {
		return this.BLOCK;
	}
	public void setAccuracy(int Accuracy) {
		this.ACCURACY = Accuracy;
	}
	
	public int getAccuracy() {
		return this.ACCURACY;
	}
	
	public ArrayList<Item> getInventory() {
		return this.inventory;
	}
}
