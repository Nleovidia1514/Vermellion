package com.labc.Vermellion.Items.Weapons;

import com.labc.Vermellion.Character;
import com.labc.Vermellion.Items.Useable;
import com.labc.Vermellion.Items.Weapon;

public class MajorasMask extends Weapon implements Useable {

	public MajorasMask(Character owner) {
		super(owner);
		this.Durability = 500;
		this.name = "Majora's Mask";
		this.HP = 50;
		this.MAGIC = 200;
		this.ILLUSION = 150;
		this.STR = 35;
		this.BAGREDAD = 50;
		this.SNEAK = 5;
		this.BLOCK = 40;
		this.ACCURACY = 0;
		this.Damage = 150;
		this.Description = "This mask is funny looking and has weird properties.";
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
