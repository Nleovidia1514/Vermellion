package com.labc.Vermellion.Items.Equipamiento.ChestPieces;

import com.labc.Vermellion.Character;
import com.labc.Vermellion.Entity;
import com.labc.Vermellion.Start;
import com.labc.Vermellion.Items.Equipment;

public class TShirt extends Equipment {

	public TShirt(Character owner) {
		super(owner);
		this.Category = Equipment.chestplate;
		this.name = this.regularName = "TShirt";
		this.Durability = 25;
		this.HP = 40;
		this.MAGIC = 25;
		this.ACCURACY = 30;
		this.STR = 40;
		this.BAGREDAD = 70;
		this.BLOCK = 15;
		this.SNEAK = 25;
		this.ILLUSION = 25;
		this.Damage = 0;
		this.RESISTANCE = 30;
		this.Description = "This is an armor piece used by intellectual beings!";
		this.isStarter = false;
	}

	@Override
	public void beUsed(Entity mob) {
		if(mob!=null) {
			Start.ta.append(" but did nothing because you can't use this item against an entity..");
		}
		else
			Start.ta.setText("You can't use that item like that.");
		
		if(this.Durability == 0) {
			this.broke();
		}
	}
}
