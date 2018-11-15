package com.labc.Vermellion.Items.Equipamiento;

import com.labc.Vermellion.Items.Equipment;
import com.labc.Vermellion.Character;
import com.labc.Vermellion.Entity;
import com.labc.Vermellion.Start;

public class Mind extends Equipment {
	
	public Mind(Character owner) {
		super(owner);
		this.Category = Equipment.weapon;
		this.Durability = 250;
		this.name = "Mind";
		this.HP = 20;
		this.MAGIC = 300;
		this.SNEAK = 20;
		this.STR = 20;
		this.BAGREDAD = 0;
		this.BLOCK = 25;
		this.ILLUSION = 100;
		this.ACCURACY = 65;
		this.RESISTANCE = 20;
		this.Description = "The most powerful tool a person can have.";
		this.isStarter = true;
	}

	@Override
	public void beUsed(Entity mob) {
		if(mob!=null) {
			Start.ta.append("\nYou taught programming to the "+mob.getName()+" causing"
					+ "them to be bagres and lose a quarter of their total HP.");
			mob.beAttacked(mob.getHP()/4);
			this.Durability--;
		}
		else
			Start.ta.setText("You can't use that item like that.");
		
		
		if(this.Durability == 0) {
			this.broke();
		}
	}


}
