package com.labc.Vermellion.Items.Consumables;

import com.labc.Vermellion.Character;
import com.labc.Vermellion.Entity;
import com.labc.Vermellion.Start;
import com.labc.Vermellion.Items.Food;

public class SpaghettiOs extends Food {

	public SpaghettiOs(Character owner) {
		super(owner);
		this.Heal = 200;
		this.Mana = 100;
		this.water = 50;
		this.prefix = "";
		this.name = "SpaghettiOs";
		this.isEatable = true;
		this.Description = "Every american child's favorite breakfast.";
	}

	@Override
	public void beUsed(Entity mob) {
		if(mob == null) {
			Start.ta.setText("You consumed the "+this.name+" and you feel like a child in El Imperio. ");
			super.beUsed(mob);
		}
		else {
			Start.ta.append("The "+mob.getName()+" seem happy for your gift but they will still try to kill you.");
			mob.beAttacked(0);
		}
	}

	@Override
	public void giveToNPC() {
		// TODO Auto-generated method stub
		
	}
	
}
