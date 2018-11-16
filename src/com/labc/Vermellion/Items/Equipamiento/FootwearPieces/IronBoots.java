package com.labc.Vermellion.Items.Equipamiento.FootwearPieces;

import com.labc.Vermellion.Character;
import com.labc.Vermellion.Entity;
import com.labc.Vermellion.Start;
import com.labc.Vermellion.Items.Equipment;

public class IronBoots extends Equipment {
	
	public IronBoots(Character owner) {
		super(owner);
		this.Category = Equipment.footWear;
		this.Durability = 80;
		this.name = this.regularName = "Iron boots";
		this.HP = 60;
		this.MAGIC = 25;
		this.ILLUSION = 15;
		this.STR = 25;
		this.BAGREDAD = 5;
		this.SNEAK = 0;
		this.BLOCK = 25;
		this.ACCURACY = 0;
		this.RESISTANCE = 30;
		this.Damage = 60;
		this.Description = "Worn by knights that seek to withstand great damages.";
	}


	@Override
	public void beUsed(Entity mob) {
		if(mob!=null) {
			Start.ta.append(" by kicking it.");
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
