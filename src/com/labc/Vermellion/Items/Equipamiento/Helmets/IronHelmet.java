package com.labc.Vermellion.Items.Equipamiento.Helmets;

import com.labc.Vermellion.Character;
import com.labc.Vermellion.Entity;
import com.labc.Vermellion.Start;
import com.labc.Vermellion.Items.Equipment;

public class IronHelmet extends Equipment{
	
	public IronHelmet(Character owner) {
		super(owner);
		this.Category = Equipment.helmet;
		this.Durability = 70;
		this.name = this.regularName = "Iron helmet";
		this.HP = 50;
		this.MAGIC = 25;
		this.ILLUSION = 30;
		this.STR = 15;
		this.BAGREDAD = 40;
		this.SNEAK = 5;
		this.BLOCK = 20;
		this.ACCURACY = 0;
		this.RESISTANCE = 25;
		this.Description = "Worn by knights that seek to withstand great damages.";
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
