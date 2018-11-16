package com.labc.Vermellion.Items.Equipamiento.Weapons;

import com.labc.Vermellion.Character;
import com.labc.Vermellion.Entity;
import com.labc.Vermellion.Start;
import com.labc.Vermellion.Items.Equipment; 	

public class Sword extends Equipment{

	public Sword(Character owner) {
		super(owner);
		this.Category = Equipment.weapon;
		this.Durability = 30;
		this.name = this.regularName = "Sword";
		this.HP = 40;
		this.MAGIC = 50;
		this.BLOCK = 50;
		this.STR = 35;
		this.BAGREDAD = 70;
		this.ACCURACY = 40;
		this.ILLUSION = 60;
		this.SNEAK = 55;
		this.Damage = 150;
		this.Description = "It belonged to a knight... maybe.";
		this.isStarter = true;
	}

	@Override
	public void beUsed(Entity mob) {
		if(mob!=null) {
			Start.ta.append(" using it with a grace never seen before.");
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
