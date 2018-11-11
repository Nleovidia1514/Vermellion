package com.labc.Vermellion.Items.Weapons;

import com.labc.Vermellion.Character;
import com.labc.Vermellion.Items.Useable;
import com.labc.Vermellion.Items.Weapon;

public class Excalibur extends Weapon implements Useable{

	public Excalibur(Character owner) {
		super(owner);
		this.Durability = 100;
		this.name = "Excalibur";
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
	protected void broke() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void beUsed() {
		// TODO Auto-generated method stub
		
	}

}
