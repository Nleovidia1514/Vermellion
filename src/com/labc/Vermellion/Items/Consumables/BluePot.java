package com.labc.Vermellion.Items.Consumables;

import com.labc.Vermellion.Character;
import com.labc.Vermellion.Start;
import com.labc.Vermellion.Items.Food;
import com.labc.Vermellion.Items.Useable;

public class BluePot extends Food implements Useable {

	public BluePot(Character owner) {
		super(owner);
		this.Heal = 0;
		this.Mana = 80;
		this.water = 15;
		this.prefix = "a";
		this.name = "BluePot";
		this.isDrinkable = true;
		this.Description = "It has a label on it... 'Made in China'.";
	}

	@Override
	public void beUsed() {
		Start.ta.setText("You drank the potion. It left you a bit dazzled. ");
		super.beUsed();
	}

	@Override
	public void giveToNPC() {
		// TODO Auto-generated method stub
		
	}

}
