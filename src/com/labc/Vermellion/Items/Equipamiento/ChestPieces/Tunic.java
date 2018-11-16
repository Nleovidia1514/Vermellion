package com.labc.Vermellion.Items.Equipamiento.ChestPieces;

import com.labc.Vermellion.Character;
import com.labc.Vermellion.Entity;
import com.labc.Vermellion.Start;
import com.labc.Vermellion.Items.Equipment;

public class Tunic extends Equipment{

	public Tunic(Character owner) {
		super(owner);
		this.Category = Equipment.chestplate;
		this.name = this.regularName = "Tunic";
		this.Durability = 25;
		this.HP = 40;
		this.MAGIC = 100;
		this.ACCURACY = 50;
		this.STR = 0;
		this.BAGREDAD = 65;
		this.BLOCK = 0;
		this.SNEAK = 45;
		this.ILLUSION = 100;
		this.Damage = 0;
		this.RESISTANCE = 25;
		this.Description = "This is an armor piece used by mages primarily!";
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
