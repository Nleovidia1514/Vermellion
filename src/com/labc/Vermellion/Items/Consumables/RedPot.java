package com.labc.Vermellion.Items.Consumables;

import com.labc.Vermellion.Character;
import com.labc.Vermellion.Entity;
import com.labc.Vermellion.Start;
import com.labc.Vermellion.Items.Food;

public class RedPot extends Food {

	public RedPot(Character owner) {
		super(owner);
		this.Heal = 150;
		this.Mana = 0;
		this.water = 15;
		this.prefix = "a";
		this.name = "RedPot";
		this.isDrinkable = true;
		this.Description = "It bubbles a little bit like a soda.";
	}

	@Override
	public void beUsed(Entity mob) {
		if(mob == null) {
			Start.ta.setText("It had a funny taste but you feel spectacular. ");
			super.beUsed(mob);
		}
		else {
			Start.ta.append("\nYou threw the potion and revitalized the "+mob.getName()+".");
			mob.beAttacked(-30);
		}
	}

	@Override
	public void giveToNPC() {
		// TODO Auto-generated method stub
		
	}

}
