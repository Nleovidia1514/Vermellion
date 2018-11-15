package com.labc.Vermellion.Items.Consumables;

import com.labc.Vermellion.Character;
import com.labc.Vermellion.Entity;
import com.labc.Vermellion.Start;
import com.labc.Vermellion.Items.Food;

public class Apple extends Food {

	public Apple(Character owner) {
		super(owner);
		this.Heal = 30;
		this.Mana = 0;
		this.water = 40;
		this.prefix = "an";
		this.name = "Apple";
		this.isEatable = true;
		this.Description = "It's green?";
	}

	@Override
	public void giveToNPC() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void beUsed(Entity mob) {
		if(mob == null) {
			Start.ta.setText("You ate the apple... it had an odd taste. ");
			super.beUsed(mob);
		}
		else {
			Start.ta.setText("You threw the apple ti}o the "+mob.getName()+" and got it mad");
			mob.beAttacked(0);
		}
	}

}
