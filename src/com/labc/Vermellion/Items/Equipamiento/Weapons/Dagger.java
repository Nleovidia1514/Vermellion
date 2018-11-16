package com.labc.Vermellion.Items.Equipamiento.Weapons;

import com.labc.Vermellion.Character;
import com.labc.Vermellion.Entity;
import com.labc.Vermellion.Start;
import com.labc.Vermellion.Items.Equipment;

public class Dagger extends Equipment {

	public Dagger(Character owner) {
		super(owner);
		this.Category = Equipment.weapon;
		this.Durability = 25;
		this.name = this.regularName = "Dagger";
		this.HP = 15;
		this.MAGIC = 30;
		this.SNEAK = 90;
		this.STR = 30;
		this.BAGREDAD = 90;
		this.BLOCK = 15;
		this.ACCURACY = 40; 
		this.ILLUSION = 65;
		this.Damage = 90;
		this.Description = "It looks like it could slice someone's throat.";
		this.isStarter = true;
	}

	@Override
	public void beUsed(Entity mob) {
		if(mob!=null) {
			Start.ta.append("\nYou slice some throats while you laugh of joy.");
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
