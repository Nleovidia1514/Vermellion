package com.labc.Vermellion.Items.Equipamiento.Helmets;

import com.labc.Vermellion.Character;
import com.labc.Vermellion.Entity;
import com.labc.Vermellion.Start;
import com.labc.Vermellion.Items.Equipment;

public class Hat extends Equipment {
	
	public Hat(Character owner) {
		super(owner);
		this.Category = Equipment.helmet;
		this.Durability = 40;
		this.name = this.regularName = "Hat";
		this.HP = 20;
		this.MAGIC = 40;
		this.ILLUSION = 40;
		this.STR = 0;
		this.BAGREDAD = 50;
		this.SNEAK = 10;
		this.BLOCK = 5;
		this.ACCURACY = 15;
		this.RESISTANCE = 15;
		this.Description = "A pointy hat typical of a sorcerer.";
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
