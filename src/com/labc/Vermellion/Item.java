package com.labc.Vermellion;

public class Item {
	protected int Quantity;
	protected int HP, MAGIC, DEX, STR, BAGREDAD, DIRTYNESS;
	protected int Size;
	protected String Description;
	protected Character Owner;
	
	public Item(Character owner) {
		this.Owner = owner;
	}
	
}
