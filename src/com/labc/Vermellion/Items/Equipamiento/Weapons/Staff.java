package com.labc.Vermellion.Items.Equipamiento.Weapons;

import com.labc.Vermellion.Character;
import com.labc.Vermellion.Entity;
import com.labc.Vermellion.Start;
import com.labc.Vermellion.Items.Equipment;

public class Staff extends Equipment {

	public Staff(Character owner) {
		super(owner);
		this.Category = Equipment.weapon;
		this.name = this.regularName = "Staff";
		this.Durability = 100;
		this.HP = 25;
		this.MAGIC = 200;
		this.ACCURACY = 50;
		this.STR = 15;
		this.BAGREDAD = 100;
		this.BLOCK = 30;
		this.SNEAK = 40;
		this.ILLUSION = 200;
		this.Damage = 120;
		this.Description = "You shall not pass!";
		this.isStarter = true;
	}

	@Override
	public void beUsed(Entity mob) {
		if(mob!=null) {
			Start.ta.append(" throwing a basic spell to the "+mob.getName()+".");
			mob.beAttacked(this.Damage);
			this.MAGIC -=15;
			this.Durability--;
		}
		else
			Start.ta.setText("You can't use that item like that.");
		
		if(this.Durability == 0) {
			this.broke();
		}
	}

	

}
