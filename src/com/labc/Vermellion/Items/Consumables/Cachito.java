package com.labc.Vermellion.Items.Consumables;

import com.labc.Vermellion.Character;
import com.labc.Vermellion.Items.Food;
import com.labc.Vermellion.Items.Useable;

public class Cachito extends Food implements Useable {

	public Cachito(Character owner) {
		super(owner);
		this.Heal = 70;
		this.Mana = 20;
		this.name = "Cachito";
		this.Description = "The legends say this afrodisiac was once used to bribe teachers.";
	}

	@Override
	public void beUsed() {
		System.out.println("It had no fucking ham in it. You healed "+this.Heal+" HP "
				+ "and restored "+this.Mana+" MAGIC.");
		this.Owner.setHP(this.Owner.getHP()+this.Heal);
		this.Owner.setMagic(this.Owner.getMagic()+this.Mana);
		this.Owner.inventory.remove(this);
	}

	@Override
	public void giveToNPC() {
		// TODO Auto-generated method stub
		
	}

}
