package com.labc.Vermellion.Items.Equipamiento;

import com.labc.Vermellion.Character;
import com.labc.Vermellion.Entity;
import com.labc.Vermellion.Start;
import com.labc.Vermellion.Items.Equipment;

public class MajorasMask extends Equipment {

	public MajorasMask(Character owner) {
		super(owner);
		this.Category = Equipment.helmet;
		this.Durability = 500;
		this.name = "Majoras Mask";
		this.HP = 50;
		this.MAGIC = 200;
		this.ILLUSION = 150;
		this.STR = 35;
		this.BAGREDAD = 50;
		this.SNEAK = 5;
		this.BLOCK = 40;
		this.ACCURACY = 0;
		this.RESISTANCE = 25;
		this.Description = "This mask is funny looking and has weird properties.";
	}


	@Override
	public void beUsed(Entity mob) {
		if(mob!=null) {
			Start.ta.append(" and imposed it's magic powers over it dealing a "
					+ "third of it's total HP damage to it");
			mob.beAttacked(mob.getHP()/3);
			this.Durability--;
		}
		else
			Start.ta.setText("You can't use that item like that.");
		
		
		if(this.Durability == 0) {
			this.broke();
		}
	}


}
