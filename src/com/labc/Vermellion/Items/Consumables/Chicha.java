package com.labc.Vermellion.Items.Consumables;

import com.labc.Vermellion.Character;
import com.labc.Vermellion.Entity;
import com.labc.Vermellion.Start;
import com.labc.Vermellion.Items.Food;

public class Chicha extends Food {

	public Chicha(Character owner) {
		super(owner);
		this.Heal = 60;
		this.Mana = 30;
		this.water = 50;
		this.prefix = "a";
		this.name = "Chicha";
		this.isDrinkable = true;
		this.isEatable = true;
		this.Description = "Venezuelans love this beverage... or is it a smoothie?";
	}

	@Override
	public void beUsed(Entity mob) {
		if(mob == null) {
			Start.ta.setText("Damn it tastes good. ");
			super.beUsed(mob);
		}
		else {
			Start.ta.append("\nYou drank the chicha in fron of the "+mob.getName()+" and\n"
					+ "made it sooo envy. Chicha is glorious.");
			mob.beAttacked(10);
		}
	}

	@Override
	public void giveToNPC() {
		// TODO Auto-generated method stub
		
	}

}
