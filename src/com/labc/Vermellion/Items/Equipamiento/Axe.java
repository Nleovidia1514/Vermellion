package com.labc.Vermellion.Items.Equipamiento;

import com.labc.Vermellion.Items.Equipment;
import com.labc.Vermellion.Character;
import com.labc.Vermellion.Entity;
import com.labc.Vermellion.Start;

public class Axe extends Equipment{

	public Axe(Character owner) {
		super(owner);
		this.Category = Equipment.weapon;
		this.Durability = 15;
		this.name = "Axe";
		this.HP = 40;
		this.MAGIC = 0;
		this.ILLUSION = 5;
		this.BAGREDAD = 70;
		this.SNEAK = 5;
		this.BLOCK = 20;
		this.ACCURACY = 30;
		this.Damage = 120;
		this.Description = "This axe has blood stains on it.";
	}

	@Override
	public void beUsed(Entity mob) {
		if(mob == null) {
			if( this.getOwner().getCurrent().hasTree ) {
				chopTree();
				this.Durability--;
			}
			else
				Start.ta.setText("You can't use your axe here.");
		}
		else {
			this.Durability--;
			mob.beAttacked(this.Damage);
		}
			
		if( this.Durability == 0 )
			broke();
	}
	
	private void chopTree() {
		this.getOwner().getCurrent().hasTree = false;
		Start.ta.append("\nYou chopped the tree. ");
		if( this.getOwner().getCurrent().hasEnemy ) {
			Start.ta.append("\nand it fell on " + this.getOwner().getCurrent().mob.getName() );
			this.getOwner().getCurrent().mob.beAttacked(75);
		}
		if( this.getOwner().getCurrent().hasRiver ) {
			Start.ta.append("\nThe chopped tree fell on the river and now you can pass over it.");
			this.getOwner().getCurrent().hasRiver = false;
		}	
	}


	
	
}
