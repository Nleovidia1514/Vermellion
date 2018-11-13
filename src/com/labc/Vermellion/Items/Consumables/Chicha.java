package com.labc.Vermellion.Items.Consumables;

import com.labc.Vermellion.Character;
import com.labc.Vermellion.Start;
import com.labc.Vermellion.Items.Food;
import com.labc.Vermellion.Items.Useable;

public class Chicha extends Food implements Useable{

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
	public void beUsed() {
		Start.ta.setText("Damn it tastes good. ");
		super.beUsed();
	}

	@Override
	public void giveToNPC() {
		// TODO Auto-generated method stub
		
	}

}
