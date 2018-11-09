package com.labc.Vermellion.Items;

import com.labc.Vermellion.Item;
import com.labc.Vermellion.Character;

public abstract class Tool extends Item{
	protected int Durability;
	
	protected Tool(Character owner) {
		super(owner);
	}
	
	protected abstract void broke();
}
