package com.labc.Vermellion.Items.Weapons;

import com.labc.Vermellion.Character;
import com.labc.Vermellion.Items.Useable;
import com.labc.Vermellion.Items.Weapon;

public class Bow extends Weapon implements Useable{

	public Bow(Character owner) {
		super(owner);
		this.Durability = 16;
		this.name = "Bow";
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
	}

	@Override
	public void beUsed() {
		// TODO Auto-generated method stub
		
	}

	

}
