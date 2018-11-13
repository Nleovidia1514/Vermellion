package com.labc.Vermellion.Items.Consumables;

import com.labc.Vermellion.Character;
import com.labc.Vermellion.Start;
import com.labc.Vermellion.Items.Food;
import com.labc.Vermellion.Items.Useable;

public class Cachito extends Food implements Useable {

	public Cachito(Character owner) {
		super(owner);
		this.Heal = 70;
		this.Mana = 20;
		this.water = 0;
		this.prefix = "a";
		this.name = "Cachito";
		this.isEatable = true;
		this.Description = "The legends say this afrodisiac was once used to bribe teachers.";
	}

	@Override
	public void beUsed() {
		Start.ta.setText("It had no fucking ham in it. ");
		super.beUsed();
	}

	@Override
	public void giveToNPC() {
		// TODO Auto-generated method stub
		
	}

}
