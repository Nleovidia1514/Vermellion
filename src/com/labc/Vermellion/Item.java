package com.labc.Vermellion;

import com.labc.Vermellion.Items.Useable;

public abstract class Item implements Useable {
	protected int HP, MAGIC, ILLUSION, SNEAK, BLOCK, STR, BAGREDAD, ACCURACY;
	protected String Description;
	protected Character Owner;
	protected String name;
	public String prefix;
	public boolean isStarter, isDrinkable, isEatable;;
	
	public Item(Character owner) {
		this.Owner = owner;
		this.isStarter = false;
		this.isDrinkable = false;
		this.isEatable = false;
	}
	
	public String getDescription() {
		return this.Description;
	}
	
	public abstract void beUsed();
	
	public String getName() {
		return this.name;
	}
}
