package com.labc.Vermellion.Items.Equipamiento.Weapons;

import com.labc.Vermellion.Character;
import com.labc.Vermellion.Entity;
import com.labc.Vermellion.Start;
import com.labc.Vermellion.Items.Equipment;

public class Excalibur extends Equipment{

	public Excalibur(Character owner) {
		super(owner);
		this.Category = Equipment.weapon;
		this.Durability = 100;
		this.name = this.regularName = "Excalibur";
		this.HP = 80;
		this.MAGIC = 60;
		this.ILLUSION = 5;
		this.STR = 250;
		this.BAGREDAD = 10;
		this.SNEAK = 5;
		this.BLOCK = 60;
		this.ACCURACY = 15;
		this.Damage = 300;
		this.Description = "This sword was once set in stone and was taken out exclusively for you.";
	}


	@Override
	public void beUsed(Entity mob) {
		if(mob!=null) {
			Start.ta.append("\nThe Excalibur sword hits like a truck.");
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
