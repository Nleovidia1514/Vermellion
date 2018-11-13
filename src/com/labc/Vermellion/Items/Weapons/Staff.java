package com.labc.Vermellion.Items.Weapons;

import com.labc.Vermellion.Character;
import com.labc.Vermellion.Items.Useable;
import com.labc.Vermellion.Items.Weapon;

public class Staff extends Weapon implements Useable {

	public Staff(Character owner) {
		super(owner);
		this.name = "Staff";
		this.Durability = 35;
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
	public void beUsed() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void broke() {
		// TODO Auto-generated method stub
		
	}

}
