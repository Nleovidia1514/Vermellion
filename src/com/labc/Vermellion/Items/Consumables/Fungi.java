package com.labc.Vermellion.Items.Consumables;

import com.labc.Vermellion.Character;
import com.labc.Vermellion.Entity;
import com.labc.Vermellion.Start;
import com.labc.Vermellion.Items.Food;

public class Fungi extends Food{

	public Fungi(Character owner) {
		super(owner);
		this.Heal = 30;
		this.Mana = 0;
		this.water = 5;
		this.prefix = "a";
		this.name = "Fungi";
		this.isEatable = true;
		this.Description = "It looks like it could provide you a pea trifasica.";
	}

	@Override
	public void beUsed(Entity mob) {
		if(mob == null) {
			Start.ta.setText("Suddenly you're in the sky and you've never felt more alive. ");
			super.beUsed(mob);
		}
		else {
			Start.ta.append("\nYou made the "+mob.getName()+" and is now hallucinating and\n"
					+ "doing weird stuff");
			mob.die();
		}
	}

	@Override
	public void giveToNPC() {
		// TODO Auto-generated method stub
		
	}

}
