package com.labc.Vermellion.Items.Equipamiento.Weapons;

import com.labc.Vermellion.Character;
import com.labc.Vermellion.Entity;
import com.labc.Vermellion.Start;
import com.labc.Vermellion.Items.Equipment;

public class Bow extends Equipment{

	public Bow(Character owner) {
		super(owner);
		this.Category = Equipment.weapon;
		this.Durability = 16;
		this.name = this.regularName = "Bow";
		this.HP = 15;
		this.MAGIC = 50;
		this.BLOCK = 5;
		this.STR = 20;
		this.BAGREDAD = 100;
		this.SNEAK = 50;
		this.ACCURACY = 150;
		this.ILLUSION = 60;
		this.Damage = 70;
		this.Description = "It has a weird essence on it and you don't know what it is.";
		this.isStarter = true;
	}

	@Override
	public void beUsed(Entity mob) {
		if(mob != null) {
			Start.ta.append(" using it like a stick.");
			mob.beAttacked(this.Damage);
			this.Durability--;
		}
		else {
			Start.ta.setText("You can't use the bow like that.");
		}
		
		if(this.Durability == 0) {
			this.broke();
		}
	}

}
