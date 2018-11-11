package com.labc.Vermellion.Items.Consumables;

import com.labc.Vermellion.Character;
import com.labc.Vermellion.Start;
import com.labc.Vermellion.Items.Food;
import com.labc.Vermellion.Items.Useable;

public class RedPot extends Food implements Useable {

	public RedPot(Character owner) {
		super(owner);
		this.Heal = 150;
		this.Mana = 0;
		this.water = 15;
		this.prefix = "a";
		this.name = "RedPot";
		this.Description = "It bubbles a little bit like a soda.";
	}

	@Override
	public void beUsed() {
		Start.ta.append("\nIt had a funny taste but you feel spectacular. ");
		super.beUsed();
	}

	@Override
	public void giveToNPC() {
		// TODO Auto-generated method stub
		
	}

}
