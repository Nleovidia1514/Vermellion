package com.labc.Vermellion.Items.Equipamiento.ChestPieces;

import com.labc.Vermellion.Character;
import com.labc.Vermellion.Entity;
import com.labc.Vermellion.Start;
import com.labc.Vermellion.Items.Equipment;

public class HylianShield extends Equipment {

	public HylianShield(Character owner) {
		super(owner);
		this.Category = Equipment.chestplate;
		this.name = this.regularName = "Hylian Shield";
		this.Durability = 250;
		this.HP = 120;
		this.MAGIC = 55;
		this.ACCURACY = 25;
		this.STR = 35;
		this.BAGREDAD = 65;
		this.BLOCK = 150;
		this.SNEAK = 20;
		this.ILLUSION = 15;
		this.Damage = 70;
		this.RESISTANCE = 75;
		this.Description = "This is a heavy piece of armor!";
		this.isStarter = false;
	}

	@Override
	public void beUsed(Entity mob) {
		if(mob!=null) {
			Start.ta.append(" hitting it with the shield.");
			mob.beAttacked(this.Damage);
			this.Durability--;
		}
		else
			Start.ta.setText("You can't use that item like that.");
		
		if(this.Durability == 0) {
			this.broke();
		}
	}
}
