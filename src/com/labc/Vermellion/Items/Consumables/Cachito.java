package com.labc.Vermellion.Items.Consumables;

import com.labc.Vermellion.Character;
import com.labc.Vermellion.Entity;
import com.labc.Vermellion.Start;
import com.labc.Vermellion.Items.Food;
import com.labc.Vermellion.Items.Useable;

public class Cachito extends Food {

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
	public void beUsed(Entity mob) {
		if(mob==null) {
			Start.ta.setText("It had no fucking ham in it. ");
			super.beUsed(mob);
		}
		else {
			Start.ta.append("\nYou ate the cachito in fron of the "+mob.getName()+" and\n"
					+ "made it hungry. You're so clever.");
			mob.beAttacked(1);
		}
	}

	@Override
	public void giveToNPC() {
		// TODO Auto-generated method stub
		
	}

}
