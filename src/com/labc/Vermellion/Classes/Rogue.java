package com.labc.Vermellion.Classes;

import com.labc.Vermellion.Tile;
import com.labc.Vermellion.Visitor;
import com.labc.Vermellion.Items.Equipment;
import com.labc.Vermellion.Items.ItemFactory;

import java.util.Random;
import com.labc.Vermellion.Character;
import com.labc.Vermellion.Start;
import com.labc.Vermellion.ThirstyState;

public class Rogue extends Character{
	
	public Rogue(Tile starting) {
		super(starting);
		this.startingItem = (Equipment) ItemFactory.getItem("DAGGER", this);
		this.MAXHP = 175;
		this.MAXMAGIC = 120;
		this.STR = 80;
		this.BAGREDAD = 35;
		this.SNEAK = 150;
		this.ILLUSION = 70;
		this.BLOCK = 30;
		this.ACCURACY = 100;
		this.RESISTANCE = 20;
		this.bagSize = 20;
		this.inventory.add(this.startingItem);
		this.startingItem.equip();
		this.HP = this.MAXHP;
		this.MAGIC = this.MAXMAGIC;
		Start.ta.setText("You grab the knives that were given to you by your father, they are"
				+" sharp... very sharp. 'I will avenge you father' suddenly"
				+" you feel ready to take on Vermellion's Wasteland...\n\n");
	}

	@Override
	protected void shoot(String target) {
		Random rnd = new Random();
		if(this.current.canShoot) {
			if(this.current.mob.getName().toLowerCase().contains(target.toLowerCase())) {
				int calculateChance = 300/this.ACCURACY;
				if(rnd.nextInt(calculateChance)<=0) {
					Start.ta.setText("You threw a dagger to "+this.current.mob.getName()+"'s throat and dealt "
							+this.BAGREDAD+" damage.");
					this.current.mob.beShot(this.BAGREDAD);
				}
				else
					Start.ta.setText("You missed the dagger throw. You are so bagre.");
				
				this.current.canShoot = false;
			}
			else
				Start.ta.setText("There is no "+target+" here.");
		}
		else
			Start.ta.setText("You already threw your dagger.");
	}

	@Override
	public void Visit(Tile tile) {
		Start.ta.setText(tile.getShortDescription());
		if(tile.hasEnemy)
			Start.ta.append("\nYou make playful moves with your dagger "
					+ "as you can't wait to slice something's throat..");
		
		if(this.getCharacterstate() != ThirstyState.instance()
				&& tile.getName().equalsIgnoreCase("Wasteland")) {
			this.THIRST -=200;
		}
		
		else if(this.getCharacterstate() != ThirstyState.instance() &&
				tile.getName().equalsIgnoreCase("MountainSurroundings")) {
			this.THIRST -=300;
		}
		
		tile.player = this;
	}
}
