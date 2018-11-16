package com.labc.Vermellion;

import java.util.ArrayList;
import java.util.Scanner;

import com.labc.Vermellion.Items.Equipment;
import com.labc.Vermellion.Items.ItemFactory;

public abstract class Character implements Visitor {
	protected int MAXHP, MAXMAGIC, MAGIC, STR, BAGREDAD, ILLUSION, SNEAK,
	BLOCK, ACCURACY, MAXTHIRST, THIRST, RESISTANCE;
	protected double HP;
	protected int bagSize;
	protected Tile current;
	protected Equipment startingItem;
	public ArrayList<Item> inventory;
	public String[] equipment = new String[5];
	private CharacterState state;
	
	protected Character(Tile starting) {
		this.current = starting;
		current.player = this;
		this.inventory = new ArrayList<Item>();
		this.MAXTHIRST = this.THIRST = 500;
		this.state = NormalState.instance();
	}
	
	
	public void decideWhatToDo(Scanner sn) {
		this.state.decideWhatToDo(sn, this);
	}
	
	protected abstract void shoot(String target);

	protected void walk(String direction) {
		this.state.walk(direction,this);
	}
	
	protected void talkToNPC(Scanner sn ) {
		this.state.talkToNPC(sn, this);
	}
	
	protected void die(Character player) {
		this.state.die(player);
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
		Start.ta.setText("You ran to the "+direction+".\n");
		this.current.accept(this);
		this.THIRST-=30;
	}
	
	protected void drinkWater(Scanner sn) {
		if(sn.hasNext()) {
			if(sn.next().equalsIgnoreCase("from")) {
				if(sn.hasNext()) {
					String waterSource = sn.next().toLowerCase();
					int thirstRestored = 0;
					if((waterSource.equalsIgnoreCase("lake") || waterSource.equalsIgnoreCase("swmap")) && this.current.hasLake)
						while(thirstRestored<100 && this.THIRST<this.MAXTHIRST) {
							thirstRestored ++;
							this.THIRST++;
							this.HP-=0.5;
							Start.ta.setText("You drank water from the "+waterSource+" and restored "
									+thirstRestored+" thirst but lost half of that from your health.");
						}
					else if((waterSource.equalsIgnoreCase("river") || waterSource.equalsIgnoreCase("stream")) && this.current.hasRiver)
						while(thirstRestored<100 && this.THIRST<this.MAXTHIRST) {
							thirstRestored ++;
							this.THIRST++;
							this.HP-=0.5;
							Start.ta.setText("You drank water from the "+waterSource+" and restored "
									+thirstRestored+" thirst but lost half of that from your health.");
						}
					else
						Start.ta.setText("You can't drink water from there.");
				}
				else
					Start.ta.setText("Drink water from where?");
			}
			else
				Start.ta.setText("You know basic english right?");
		}
		else
			Start.ta.setText("Drink water from where?");
	}
	
	protected void seeStats() {
		Start.ta.setText("MaxHP: "+this.MAXHP);
		Start.ta.append("\nMaxMAGIC: "+this.MAXMAGIC);
		Start.ta.append("\nSTR: "+this.STR);
		Start.ta.append("\nSNEAK: "+this.SNEAK);
		Start.ta.append("\nBLOCK: "+this.BLOCK);
		Start.ta.append("\nACCURACY: "+this.ACCURACY);
		Start.ta.append("\nILLUSION: "+this.ILLUSION);
		Start.ta.append("\nBAGREDAD: "+this.BAGREDAD);
		Start.ta.append("\nRESISTANCE: "+this.RESISTANCE);
	}
	
	protected void equip(Scanner sn) {
		if(sn.hasNext()) {
			Equipment itemToBeEquipped = null;
			String itemToEquip = sn.next().toLowerCase();
			for(int i = 0; i<inventory.size();i++)
				if(inventory.get(i).getClass().getSimpleName().toLowerCase().contains(itemToEquip)) {
					try {
						itemToBeEquipped = (Equipment) inventory.get(i);
						itemToBeEquipped.equip();
						break;
					}catch(Exception e) {
						itemToBeEquipped = (Equipment) inventory.get(i);
						Start.ta.setText("You can't equip that item.");
						break;
					}		
				}
				if(itemToBeEquipped == null)
					Start.ta.setText("You don't have that item in your possesion.");
		}
		else
			Start.ta.setText("Equip what...?");
	}
	
	protected void unEquip(Scanner sn) {
		if(sn.hasNext()) {
			Equipment itemToBeUnEquipped = null;
			String itemToUnEquip = sn.next().toLowerCase();
			for(int i = 0; i<inventory.size();i++) {
				if(inventory.get(i).getClass().getSimpleName().toLowerCase().contains(itemToUnEquip)) {
						itemToBeUnEquipped = (Equipment) inventory.get(i);
						itemToBeUnEquipped.unEquip();
					}		
			}
			if(itemToBeUnEquipped == null)
				Start.ta.setText("You don't have that item in your possesion");
		}
		else
			Start.ta.setText("Unequip what...?");
	}
	
	protected void pickUpItem(String item) {
		Item itemToBePickedUp;
		try {
			if(!this.current.hasEnemy) {
				if( this.current.getItemOnFloor().toLowerCase().contains(item.toLowerCase())) {
					if( inventory.size() >= this.bagSize )
						Start.ta.setText("Your inventory is full");
					else {
						itemToBePickedUp = ItemFactory.getItem(this.current.getItemOnFloor(), this);
						inventory.add(itemToBePickedUp);
						this.current.setItemOnFloor(null);
						this.current.longDescription = this.current.shortDescription;
						Start.ta.setText("You picked the "+itemToBePickedUp.getClass().getSimpleName()+" up");
					}	
				}
				else
					Start.ta.setText("There is no "+item+" around here");
			}
			else
				Start.ta.setText("You can't pick anything up if there is something trying to kill you");
		}catch(NullPointerException e) {
			Start.ta.setText("\nThere is no "+item+" around here");
		}
	}
	
	protected void seeInv() {
		Start.ta.setText(inventory.get(0).getName()+" - "+inventory.get(0).getDescription());
		for(int i=1;i<inventory.size();i++)
			Start.ta.append("\n"+inventory.get(i).getName()+" - "+inventory.get(i).getDescription());
	}
	
	protected void attack(Scanner sn) {
		Entity mobToAttack;
		Item itemToAttackWith = null;
		if(sn.hasNext()) {
			if(this.current.mob!=null && this.current.mob.getName().toLowerCase().contains(sn.next().toLowerCase())) {
				mobToAttack = this.current.mob;
				if(sn.hasNext()) {
					if(sn.hasNext() && sn.next().equalsIgnoreCase("with")) {
						String instrument = sn.next().toLowerCase();
						if(instrument.contains("hand") || instrument.contains("fist")) {
							Start.ta.setText("You attacked "+current.mob.getName()+" with your fists.");
							mobToAttack.beAttacked(this.STR);
						}
						else {
							for(int i=0;i<inventory.size();i++)
								if(inventory.get(i).getName().toLowerCase().contains(instrument)) {
									itemToAttackWith = inventory.get(i);
									break;
								}
							if(itemToAttackWith == null)
								Start.ta.setText("You don't have anything like that in your possesion.");
						
							else if(itemToAttackWith.getClass().getSuperclass().getSimpleName().equalsIgnoreCase("Equipment"))
							{
								if(this.equipment[Equipment.weapon].equalsIgnoreCase(itemToAttackWith.getClass().getSimpleName())) {
									Start.ta.setText("You attacked "+current.mob.getName()+" with "+equipment[Equipment.weapon]+".");
									itemToAttackWith.beUsed(mobToAttack);
								}
								else if( ( itemToAttackWith.getClass().getSimpleName().equalsIgnoreCase("Mind") && this.equipment[Equipment.helmet].equalsIgnoreCase("Mind") )  || 
										( itemToAttackWith.getClass().getSimpleName().equalsIgnoreCase("MajorasMask") && this.equipment[Equipment.helmet].equalsIgnoreCase("MajorasMask") ))
								{
									Start.ta.setText("You attacked " + current.mob.getName()+ "with " + this.equipment[Equipment.helmet]+".");
									itemToAttackWith.beUsed(mobToAttack);
								}
								else
									Start.ta.setText("You don't have that equipped as a weapon.");
							}
							else
							{
								Start.ta.setText("You attacked "+current.mob.getName()+" with "+instrument+".");
								itemToAttackWith.beUsed(mobToAttack);
							}
						}
					}
					else
						Start.ta.setText("Attack "+this.current.mob.getName()+" with what?");
				}
				else
					Start.ta.setText("Attack "+this.current.mob.getName()+" with what?");
			}
			else
				Start.ta.setText("There is no such being like that near here.");
		}
		else
			Start.ta.setText("Attack what?");
	}
	
	protected void useItem(Scanner sn, String action) {
		if( sn.hasNext() ) {
			String name = sn.next();
			if(name.equalsIgnoreCase("water")) {
				this.drinkWater(sn);
			}
			else {
				Item item = null;
				for(int i=0;i<this.inventory.size();i++)
					if(this.inventory.get(i).getName().toLowerCase().
							contains(name.toLowerCase()))
						item = this.inventory.get(i);
				if( item == null )
					Start.ta.append("\nYou don't have that item in your inventory.");
				else {
					if(action.equalsIgnoreCase("USE"))
						item.beUsed(null);
					else if(action.equalsIgnoreCase("EAT")) {
						if(item.isEatable)
							item.beUsed(null);
						else
							Start.ta.setText("You can't eat that dude.");
					}
					else if(action.equalsIgnoreCase("DRINK")) {
						if(item.isDrinkable)
							item.beUsed(null);
						else
							Start.ta.setText("You can't drink that dude.");
					}
				}
			}
		}
		else if(action.equalsIgnoreCase("EAT"))
			Start.ta.setText("Eat what?");
		else if (action.equalsIgnoreCase("DRINK"))
			Start.ta.setText("Drink what?");
		else 
			Start.ta.setText("Use what?");
	}
	
	public Tile getCurrent() {
		return this.current;
	}
	
	public void setHP(double HP) {
		this.HP = HP;
	}
	
	public double getHP() {
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
