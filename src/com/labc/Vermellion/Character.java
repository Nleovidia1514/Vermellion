package com.labc.Vermellion;

import java.util.ArrayList;
import java.util.Scanner;
import com.labc.Vermellion.Items.ItemFactory;

public abstract class Character implements Visitor {
	protected int MAXHP, MAXMAGIC, HP, MAGIC, STR, BAGREDAD, ILLUSION, SNEAK,
	BLOCK, ACCURACY, MAXTHIRST, THIRST, RESISTANCE;
	protected int bagSize;
	protected Tile current;
	public ArrayList<Item> inventory;
	private CharacterState state;
	
	protected Character(Tile starting) {
		this.current = starting;
		current.player = this;
		this.inventory = new ArrayList<Item>();
		this.MAXTHIRST = this.THIRST = 500;
		this.state = NormalState.instance();
	}
	
	protected void attack(Scanner sn) {
		if(sn.hasNext()) {
			if(this.current.mob != null && 
					this.current.mob.getName().toLowerCase().contains(sn.next().toLowerCase()))
				this.current.mob.beAttacked(this.STR);
			else
				Start.ta.setText("You attacked but hit the air LUL");
			this.THIRST-=15;
		}
		else
			Start.ta.setText("Attack what?");
		
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
		this.current.accept(this);
		this.THIRST-=30;
	}
	
	protected void pickUpItem(String item) {
		try {
			if( this.current.mob == null) {
				if( item.equalsIgnoreCase(this.current.getItemOnFloor()) ) {
					if( inventory.size() >= this.bagSize )
						Start.ta.setText("Your inventory is full");
					else {
						inventory.add(ItemFactory.getItem(item,this));
						this.current.setItemOnFloor(null);
						this.current.longDescription = this.current.shortDescription;
						Start.ta.setText("You picked the "+item+" up");
					}
						
				}
				else
					Start.ta.setText("There is no "+item+" around here");
			}
			else
				Start.ta.setText("You can't pick anything up there is something trying to kill you");
		}catch(NullPointerException e) {
			Start.ta.setText("\nThere is no "+item+" around here");
		}
	}
	
	protected void seeInv() {
		Start.ta.setText(inventory.get(0).getName()+" - "+inventory.get(0).getDescription());
		for(int i=1;i<inventory.size();i++)
			Start.ta.append("\n"+inventory.get(i).getName()+" - "+inventory.get(i).getDescription());
			
	}
	
	protected void seeStats() {
		Start.ta.setText("MaxHP: "+this.HP);
		Start.ta.append("\nMaxMAGIC: "+this.MAGIC);
		Start.ta.append("\nSTR: "+this.STR);
		Start.ta.append("\nSNEAK: "+this.SNEAK);
		Start.ta.append("\nBLOCK: "+this.BLOCK);
		Start.ta.append("\nACCURACY: "+this.ACCURACY);
		Start.ta.append("\nILLUSION: "+this.ILLUSION);
		Start.ta.append("\nBAGREDAD: "+this.BAGREDAD);
		Start.ta.append("\nRESISTANCE: "+this.RESISTANCE);
	}
	
	protected void talkToNPC(Scanner sn,Character player ) {
		this.state.talkToNPC(sn, player);
	}
	
	protected void die(Character player) {
		this.state.die(player);
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
