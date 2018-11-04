package com.labc.Vermellion;

public abstract class Tool extends Item{
	protected int Durability;
	
	public Tool(Character owner) {
		super(owner);
	}
	
	protected abstract void beUsed();
	
}
