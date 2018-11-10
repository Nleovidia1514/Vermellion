package com.labc.Vermellion.Items.Consumables;

import com.labc.Vermellion.Character;
import com.labc.Vermellion.Items.Food;
import com.labc.Vermellion.Items.Useable;

public class Cachito extends Food implements Useable {

	public Cachito(Character owner) {
		super(owner);
		this.Heal = 70;
		this.Mana = 20;
		this.name = "Cachito";
		this.Description = "The legends say this afrodisiac was once used to bribe teachers.";
	}

	@Override
	public void beUsed() {
		System.out.print("It had no fucking ham in it. ");
		super.beUsed();
	}

	@Override
	public void giveToNPC() {
		// TODO Auto-generated method stub
		
	}

}
