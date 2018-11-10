package com.labc.Vermellion;

import com.labc.Vermellion.Items.Useable;

public abstract class Item implements Useable {
	protected int HP, MAGIC, ILLUSION, SNEAK, BLOCK, STR, BAGREDAD, ACCURACY;
	protected String Description;
	protected Character Owner;
	protected String name;
	public String prefix;
	
	public Item(Character owner) {
		this.Owner = owner;
	}
	
	public String getDescription() {
		return this.Description;
	}
	
	@Override
	public String toString() {
		return this.name;
	}
	
	public abstract void beUsed();
}
