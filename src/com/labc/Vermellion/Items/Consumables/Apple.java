package com.labc.Vermellion.Items.Consumables;

import com.labc.Vermellion.Character;
import com.labc.Vermellion.Start;
import com.labc.Vermellion.Items.Food;
import com.labc.Vermellion.Items.Useable;

public class Apple extends Food implements Useable{

	public Apple(Character owner) {
		super(owner);
		this.Heal = 30;
		this.Mana = 0;
		this.water = 40;
		this.prefix = "an";
		this.name = "Apple";
		this.Description = "It's green?";
	}

	@Override
	public void giveToNPC() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void beUsed() {
		// TODO Auto-generated method stub
		Start.ta.append("\nYou ate the apple... it had an odd taste. ");
		super.beUsed();
	}

}
