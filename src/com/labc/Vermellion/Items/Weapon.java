package com.labc.Vermellion.Items;

import com.labc.Vermellion.Items.Tool;
import com.labc.Vermellion.Character;

public abstract class Weapon extends Tool{
	protected int Damage;
	
	public Weapon(Character owner) {
		super(owner);
	}
	
	protected abstract void broke();

}
