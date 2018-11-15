package com.labc.Vermellion.Items.Consumables;

import com.labc.Vermellion.Character;
import com.labc.Vermellion.Entity;
import com.labc.Vermellion.Start;
import com.labc.Vermellion.Items.Food;


public class GreenPot extends Food {

	public GreenPot(Character owner) {
		super(owner);
		this.Heal = 100;
		this.Mana = 100;
		this.water = 100;
		this.prefix = "a";
		this.name = "GreenPot";
		this.isDrinkable = true;
		this.Description = "It's definitly green.";
	}

	@Override
	public void beUsed(Entity mob) {
		if(mob == null) {
			Start.ta.setText("You almost vomit but you managed not too. ");
			super.beUsed(mob);
		}
		else {
			Start.ta.append("\nYou threw the potion to the "+mob.getName()+" and\n"
					+ "managed to hurt it a little bit.");
			mob.beAttacked(25);
		}
	}

	@Override
	public void giveToNPC() {
		// TODO Auto-generated method stub
		
	}

}
