package com.labc.Vermellion.Items.Consumables;

import com.labc.Vermellion.Character;
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
		this.Description = "Venezuelans love this beverage... or is it a smoothie?";
	}

	@Override
	public void beUsed() {
		System.out.print("Damn it tastes good. ");
		super.beUsed();
	}

	@Override
	public void giveToNPC() {
		// TODO Auto-generated method stub
		
	}

}
