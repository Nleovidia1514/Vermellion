package com.labc.Vermellion.Items;

import com.labc.Vermellion.Item;
import com.labc.Vermellion.Character;

public abstract class Food extends Item {
	protected int Heal;
	protected int Mana;
	
	public Food(Character owner) {
		super(owner);
	}
	
	public abstract void giveToNPC();
}
