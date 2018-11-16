package com.labc.Vermellion.Items.Equipamiento.FootwearPieces;

import com.labc.Vermellion.Character;
import com.labc.Vermellion.Entity;
import com.labc.Vermellion.Start;
import com.labc.Vermellion.Items.Equipment;

public class Sandals extends Equipment {

	public Sandals(Character owner) {
		super(owner);
		this.Category = Equipment.footWear;
		this.Durability = 20;
		this.name = this.regularName = "Sandals";
		this.HP = 25;
		this.MAGIC = 40;
		this.ILLUSION = 40;
		this.STR = 5;
		this.BAGREDAD = 60;
		this.SNEAK = 20;
		this.BLOCK = 0;
		this.ACCURACY = 5;
		this.RESISTANCE = 5;
		this.Description = "A piece of footwear worn only by the bagres of bagres.";
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
