package com.labc.Vermellion.Items.Equipamiento.Helmets;

import com.labc.Vermellion.Character;
import com.labc.Vermellion.Entity;
import com.labc.Vermellion.Start;
import com.labc.Vermellion.Items.Equipment;

public class Cap extends Equipment{
	
	public Cap(Character owner) {
		super(owner);
		this.Category = Equipment.helmet;
		this.Durability = 25;
		this.name = this.regularName = "Cap";
		this.HP = 20;
		this.MAGIC = 20;
		this.ILLUSION = 60;
		this.STR = 25;
		this.BAGREDAD = 70;
		this.SNEAK = 20;
		this.BLOCK = 0;
		this.ACCURACY = 0;
		this.RESISTANCE = 15;
		this.Description = "A cap from Las Aguilas del Zulia.";
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
