package com.labc.Vermellion.Items.Equipamiento.ChestPieces;

import com.labc.Vermellion.Character;
import com.labc.Vermellion.Entity;
import com.labc.Vermellion.Start;
import com.labc.Vermellion.Items.Equipment;

public class Chestplate extends Equipment{

	public Chestplate(Character owner) {
		super(owner);
		this.Category = Equipment.chestplate;
		this.name = this.regularName = "Chestplate";
		this.Durability = 50;
		this.HP = 75;
		this.MAGIC = 25;
		this.ACCURACY = 30;
		this.STR = 30;
		this.BAGREDAD = 50;
		this.BLOCK = 80;
		this.SNEAK = 0;
		this.ILLUSION = 0;
		this.Damage = 0;
		this.RESISTANCE = 40;
		this.Description = "This is a heavy piece of armor!";
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
