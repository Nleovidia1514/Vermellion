package com.labc.Vermellion.Items.Equipamiento.LeggingPieces;

import com.labc.Vermellion.Character;
import com.labc.Vermellion.Entity;
import com.labc.Vermellion.Start;
import com.labc.Vermellion.Items.Equipment;

public class Chainmail extends Equipment {
	
	public Chainmail(Character owner) {
		super(owner);
		this.Category = Equipment.leggings;
		this.Durability = 40;
		this.name = this.regularName = "Chainmail";
		this.HP = 45;
		this.MAGIC = 15;
		this.ILLUSION = 5;
		this.STR = 25;
		this.BAGREDAD = 10;
		this.SNEAK = 0;
		this.BLOCK = 15;
		this.ACCURACY = 10;
		this.RESISTANCE = 20;
		this.Description = "Chain pants highly resistant to hits.";
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
