package com.labc.Vermellion.Items.Consumables;

import com.labc.Vermellion.Character;
import com.labc.Vermellion.Items.Food;
import com.labc.Vermellion.Items.Useable;

public class Fungi extends Food implements Useable{

	public Fungi(Character owner) {
		super(owner);
		this.Heal = -30;
		this.Mana = 0;
		this.water = 5;
		this.prefix = "a";
		this.name = "Fungi";
		this.Description = "It looks like it could provide you a pea trifasica.";
	}

	@Override
	public void beUsed() {
		System.out.print("Suddenly you're in the sky and you've never felt more alive. ");
		super.beUsed();
	}

	@Override
	public void giveToNPC() {
		// TODO Auto-generated method stub
		
	}

}
