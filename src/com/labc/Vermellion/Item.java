package com.labc.Vermellion;

import com.labc.Vermellion.Items.Useable;

public abstract class Item implements Useable {
	protected String Description;
	private Character Owner;
	protected String name;
	public String prefix;
	public boolean isStarter, isDrinkable, isEatable;
	
	public Item(Character owner) {
		this.Owner = owner;
		this.isStarter = false;
		this.isDrinkable = false;
		this.isEatable = false;
	}
	
	public String getDescription() {
		return this.Description;
	}
	
	public String getName() {
		return this.name;
	}

	public Character getOwner() {
		return Owner;
	}

	public void setOwner(Character owner) {
		Owner = owner;
	}
	

}
