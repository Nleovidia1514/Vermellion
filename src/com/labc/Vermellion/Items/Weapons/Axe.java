package com.labc.Vermellion.Items.Weapons;

import com.labc.Vermellion.Items.Useable;
import com.labc.Vermellion.Items.Weapon;
import com.labc.Vermellion.Character;

public class Axe extends Weapon implements Useable{

	public Axe(Character owner) {
		super(owner);
		this.Durability = 6;
		this.name = "Axe";
		this.HP = 40;
		this.MAGIC = 0;
		this.ILLUSION = 5;
		this.STR = 35;
		this.BAGREDAD = 70;
		this.SNEAK = 5;
		this.BLOCK = 40;
		this.ACCURACY = 30;
		this.Damage = 120;
		this.Description = "This axe has blood stains on it.";
	}

	@Override
	public void beUsed() {
		// TODO Auto-generated method stub
		if( this.Owner.getCurrent().hasTree ) {
			chopTree();
			Durability--;
		}
		else
			System.out.println("You can't use your axe here.");
		
		if( Durability == 0 )
			broke();
	}
	
	private void chopTree() {
		this.Owner.getCurrent().hasTree = false;
		System.out.print("You chopped the tree. ");
		if( this.Owner.getCurrent().hasEnemy ) {
			System.out.println("and it fell on " + this.Owner.getCurrent().mob.getName() );
			this.Owner.getCurrent().mob.beAttacked(75);
		}
		if( this.Owner.getCurrent().hasRiver ) {
			System.out.println("The chopped tree fell on the river and now you can pass over it.");
			this.Owner.getCurrent().hasRiver = false;
		}	
	}

	@Override
	protected void broke() {
		// TODO Auto-generated method stub
		System.out.println("Your axe has broken.");
		this.Owner.getInventory().remove(this);
	}
}
