package com.labc.Vermellion.Items.Equipamiento.Helmets;

import com.labc.Vermellion.Character;
import com.labc.Vermellion.Entity;
import com.labc.Vermellion.Start;
import com.labc.Vermellion.Items.Equipment;

public class Hood extends Equipment {
	
	public Hood(Character owner) {
		super(owner);
		this.Category = Equipment.helmet;
		this.Durability = 40;
		this.name = this.regularName = "Hood";
		this.HP = 25;
		this.MAGIC = 50;
		this.ILLUSION = 150;
		this.STR = 20;
		this.BAGREDAD = 100;
		this.SNEAK = 20;
		this.BLOCK = 0;
		this.ACCURACY = 20;
		this.RESISTANCE = 5;
		this.Description = "Worn by rogues and hunters to avoid them from being recognized.";
	}


	@Override
	public void beUsed(Entity mob) {
		if(mob!=null) {
			Start.ta.append(" but did nothing because you can't use this item against an entity.");
		}
		else
			Start.ta.setText("You can't use that item like that.");
		
		
		if(this.Durability == 0) {
			this.broke();
		}
	}
}
