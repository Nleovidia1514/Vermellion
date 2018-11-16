package com.labc.Vermellion.Items.Equipamiento.ChestPieces;

import com.labc.Vermellion.Character;
import com.labc.Vermellion.Entity;
import com.labc.Vermellion.Start;
import com.labc.Vermellion.Items.Equipment;

public class Robe extends Equipment{

	public Robe(Character owner) {
		super(owner);
		this.Category = Equipment.chestplate;
		this.name = this.regularName = "Robe";
		this.Durability = 35;
		this.HP = 45;
		this.MAGIC = 40;
		this.ACCURACY = 50;
		this.STR = 25;
		this.BAGREDAD = 60;
		this.BLOCK = 30;
		this.SNEAK = 40;
		this.ILLUSION = 40;
		this.Damage = 0;
		this.RESISTANCE = 20;
		this.Description = "This is an armor piece used by rogues and hunters!";
		this.isStarter = false;
	}

	@Override
	public void beUsed(Entity mob) {
		if(mob!=null) {
			Start.ta.append("but did nothing becausse you can't use this item against an entity..");
		}
		else
			Start.ta.setText("You can't use that item like that.");
		
		if(this.Durability == 0) {
			this.broke();
		}
	}
}
