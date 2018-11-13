package com.labc.Vermellion.Items.Weapons;

import com.labc.Vermellion.Items.Useable;
import com.labc.Vermellion.Items.Weapon;
import com.labc.Vermellion.Character;

public class Mind extends Weapon implements Useable {
	
	public Mind(Character owner) {
		super(owner);
		this.Durability = 30;
		this.name = "Mind";
		this.HP = 20;
		this.MAGIC = 300;
		this.SNEAK = 20;
		this.STR = 20;
		this.BAGREDAD = 0;
		this.BLOCK = 25;
		this.ILLUSION = 100;
		this.ACCURACY = 65;
		this.Damage = 80;
		this.Description = "The most powerful tool a person can have.";
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
