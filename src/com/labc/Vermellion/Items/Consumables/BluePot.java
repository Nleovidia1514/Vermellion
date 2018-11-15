package com.labc.Vermellion.Items.Consumables;

import com.labc.Vermellion.Character;
import com.labc.Vermellion.Entity;
import com.labc.Vermellion.Start;
import com.labc.Vermellion.Items.Food;

public class BluePot extends Food {

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
	public void beUsed(Entity mob) {
		if(mob == null) {
			Start.ta.setText("You drank the potion. It left you a bit dazzled. ");
			super.beUsed(mob);
		}
		else {
			Start.ta.append("\nYou threw the blue potion at the "+mob.getName()+"\n"
					+ "and achieved completely nothing. Great work!");
			mob.beAttacked(0);
		}
	}

	@Override
	public void giveToNPC() {
		// TODO Auto-generated method stub
		
	}

}
