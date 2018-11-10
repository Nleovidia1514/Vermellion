package com.labc.Vermellion;

import java.util.ArrayList;
import java.util.Scanner;
import com.labc.Vermellion.Items.ItemFactory;

public abstract class Character {
	protected int MAXHP, MAXMAGIC, HP, MAGIC, STR, BAGREDAD, ILLUSION, SNEAK,
	BLOCK, ACCURACY, MAXTHIRST, THIRST, RESISTANCE;
	protected int bagSize;
	protected Tile current;
	public ArrayList<Item> inventory;
	private ItemFactory itemFact;
	private CharacterState state;
	
	protected Character(Tile starting) {
		this.current = starting;
		current.player = this;
		this.inventory = new ArrayList<Item>();
		this.itemFact  = new ItemFactory(this);
		this.MAXTHIRST = this.THIRST = 150;
		this.state = NormalState.instance();
	}
	
	protected void attack() {
		// TODO Auto-generated method stub
		if(current.mob != null)
			this.current.mob.beAttacked(this.STR);
		else
			System.out.println("You attacked but hit the air LUL");
	}
	
	public void decideWhatToDo(Scanner sn) {
		this.state.decideWhatToDo(sn, this);
	}
	
	protected abstract void shoot(String target);

	protected void walk(String direction) {
		this.state.walk(direction,this);
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
		System.out.println("\nYou ran to the "+direction);
		this.THIRST-=30;
	}
	
	protected void pickUpItem(String item) {
		try {
			if( this.current.mob == null) {
				if( item.equalsIgnoreCase(this.current.getItemOnFloor()) ) {
					if( inventory.size() >= this.bagSize )
						System.out.println("\nYour inventory is full");
					else {
						inventory.add(itemFact.getItem(item));
						this.current.setItemOnFloor(null);
						System.out.println("\nYou picked the "+item+" up");
					}
						
				}
				else
					System.out.println("\nThere is no "+item+" around here");
			}
			else
				System.out.println("\nYou can't pick anything up there is something trying to kill you");
		}catch(NullPointerException e) {
			System.out.println(" There is no "+item+" around here");
		}
	}
	
	protected void seeInv() {
		for(int i=0;i<inventory.size();i++)
			System.out.println(inventory.get(i).getName()+" - "+inventory.get(i).getDescription());
	}
	
	protected void seeStats() {
		System.out.println("MaxHP: "+this.HP);
		System.out.println("MaxMAGIC: "+this.MAGIC);
		System.out.println("STR: "+this.STR);
		System.out.println("SNEAK: "+this.SNEAK);
		System.out.println("BLOCK: "+this.BLOCK);
		System.out.println("ACCURACY: "+this.ACCURACY);
		System.out.println("ILLUSION: "+this.ILLUSION);
		System.out.println("BAGREDAD: "+this.BAGREDAD);
		System.out.println("RESISTANCE: "+this.RESISTANCE);
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
	public void setMaxHP(int maxHP) {
		this.MAXHP = maxHP;
	}
	
	public int getMaxHP() {
		return this.MAXHP;
	}
	
	public void setMaxMagic(int maxMagic) {
		this.MAXMAGIC = maxMagic;
	}
	
	public int getMaxMagic() {
		return this.MAXMAGIC;
	}
	
	public void setResistance(int Resistance) {
		this.RESISTANCE = Resistance;
	}
	
	public int getResistance() {
		return this.RESISTANCE;
	}
	
	public void setCharacterState(CharacterState state) {
		this.state = state;
	}
	
	public CharacterState getCharacterstate() {
		return this.state;
	}
	
	public void setThirst(int thirst) {
		this.THIRST = thirst;
	}
	
	public int getThirst() {
		return this.THIRST;
	}
	
	public int getMaxThirst() {
		return this.MAXTHIRST;
	}
	
	public ArrayList<Item> getInventory() {
		return this.inventory;
	}
}
