package com.labc.Vermellion.Items.Equipamiento.LeggingPieces;

import com.labc.Vermellion.Character;
import com.labc.Vermellion.Entity;
import com.labc.Vermellion.Start;
import com.labc.Vermellion.Items.Equipment;

public class Trousers extends Equipment {
	
	public Trousers(Character owner) {
		super(owner);
		this.Category = Equipment.leggings;
		this.Durability = 15;
		this.name = this.regularName = "Trousers";
		this.HP = 25;
		this.MAGIC = 0;
		this.ILLUSION = 2;
		this.STR = 10;
		this.BAGREDAD = 40;
		this.SNEAK = 5;
		this.BLOCK = 5;
		this.ACCURACY = 5;
		this.RESISTANCE = 5;
		this.Description = "Typical pants a homeless person would use.";
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
