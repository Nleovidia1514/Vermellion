package com.labc.Vermellion.Items.Equipamiento.FootwearPieces;

import com.labc.Vermellion.Character;
import com.labc.Vermellion.Entity;
import com.labc.Vermellion.Start;
import com.labc.Vermellion.Items.Equipment;

public class Boots extends Equipment{
	
	public Boots(Character owner) {
		super(owner);
		this.Category = Equipment.footWear;
		this.Durability = 40;
		this.name = this.regularName = "Boots";
		this.HP = 20;
		this.MAGIC = 25;
		this.ILLUSION = 10;
		this.STR = 15;
		this.BAGREDAD = 40;
		this.SNEAK = 20;
		this.BLOCK = 0;
		this.ACCURACY = 20;
		this.RESISTANCE = 5;
		this.Description = "Dirty old boots worn by rogues and hunters to blend.";
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
