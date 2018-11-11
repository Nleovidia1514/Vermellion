package com.labc.Vermellion.Items.Weapons;

import com.labc.Vermellion.Character;
import com.labc.Vermellion.Items.Useable;
import com.labc.Vermellion.Items.Weapon;

public class Sword extends Weapon implements Useable{

	public Sword(Character owner) {
		super(owner);
		this.Durability = 30;
		this.name = "Sword";
		this.HP = 40;
		this.MAGIC = 50;
		this.BLOCK = 50;
		this.STR = 35;
		this.BAGREDAD = 70;
		this.ACCURACY = 40;
		this.ILLUSION = 60;
		this.SNEAK = 55;
		this.Damage = 120;
		this.Description = "It belonged to a knight... maybe.";
	}

	@Override
	public void beUsed() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void broke() {
		// TODO Auto-generated method stub
		
	}

}
