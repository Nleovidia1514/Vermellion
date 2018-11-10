package com.labc.Vermellion.Items;

import com.labc.Vermellion.Item;
import com.labc.Vermellion.Character;

public abstract class Food extends Item {
	protected int Heal;
	protected int Mana;
	protected int water;
	
	public Food(Character owner) {
		super(owner);
	}
	
	public abstract void giveToNPC();
	
	@Override
	public void beUsed() {
		int hphealed = 0, magicrestored = 0; int thirstrestored = 0;
		for(int i = 0; i<this.Heal;i++)
			if (this.Owner.getHP() < this.Owner.getMaxHP()) {
				this.Owner.setHP(this.Owner.getHP()+1);
				hphealed++;
			}
		
		for(int i = 0; i<this.Mana;i++)
			if (this.Owner.getMagic() < this.Owner.getMaxMagic()) {
				this.Owner.setMagic(this.Owner.getMagic()+1);
				magicrestored++;
			}
		
		for( int i = 0; i<this.water; i++)
			if(this.Owner.getThirst() < this.Owner.getMaxThirst() ){
				this.Owner.setThirst(this.Owner.getThirst()+1);
				thirstrestored++;
			}
			
		this.Owner.inventory.remove(this);
		System.out.println("You restored "+hphealed+" HP, "+magicrestored+" MAGIC"
				+ " and "+thirstrestored+" thirst");
	}
}
