package com.labc.Vermellion.Items.Weapons;

import com.labc.Vermellion.Character;
import com.labc.Vermellion.Items.Useable;
import com.labc.Vermellion.Items.Weapon;

public class Knive extends Weapon implements Useable{

	public Knive(Character owner) {
		super(owner);
		this.Durability = 10;
		this.name = "Knive";
		this.HP = 15;
		this.MAGIC = 30;
		this.SNEAK = 90;
		this.STR = 30;
		this.BAGREDAD = 90;
		this.BLOCK = 15;
		this.ACCURACY = 40; 
		this.ILLUSION = 65;
		this.Damage = 90;
		this.Description = "These knives look like they could slice someone's throat.";
	}

	@Override
	public void beUsed() {
		// TODO Auto-generated method stub
		
	}

}
