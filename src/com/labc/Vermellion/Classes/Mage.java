package com.labc.Vermellion.Classes;

import com.labc.Vermellion.Character;
import com.labc.Vermellion.Start;
import com.labc.Vermellion.ThirstyState;
import com.labc.Vermellion.Tile;
import com.labc.Vermellion.Visitor;
import com.labc.Vermellion.Items.Equipment;
import com.labc.Vermellion.Items.ItemFactory;

import java.util.Random;

public class Mage extends Character{
	
	public Mage(Tile starting) {
		super(starting);
		this.startingItem = (Equipment) ItemFactory.getItem("STAFF", this);
		this.MAXHP = 175;
		this.MAXMAGIC = 200;
		this.STR = 60;
		this.BAGREDAD = 100;
		this.SNEAK = 70;
		this.ILLUSION = 150;
		this.BLOCK = 50;
		this.bagSize = 30;
		this.ACCURACY = 140;
		this.RESISTANCE = 10;
		this.inventory.add(this.startingItem);
		this.startingItem.equip();
		this.HP = this.MAXHP;
		this.MAGIC = this.MAXMAGIC;
		Start.ta.setText("You feel an outburst of power running through your body "
				+ "you suddenly feel like the world is yours "
				+ "and you're ready to take on Vermellion's wasteland...\n\n");
	}

	@Override
	protected void shoot(String target) {
		Random rnd = new Random();
		if(this.MAGIC>=30) {
			if(this.current.canShoot) {
				if(this.current.mob.getName().toLowerCase().contains(target.toLowerCase())) {
					int calculateChance = 300/this.ACCURACY;
					if(rnd.nextInt(calculateChance)<=0) {
						Start.ta.setText("You shot a fireball to "+this.current.mob.getName()+" and dealt "
								+this.BAGREDAD+" damage.");
						this.current.mob.beShot(this.BAGREDAD);
					}
					else
						Start.ta.setText("You missed the fireball. You are so bagre.");
					
					this.MAGIC -=30;
					this.current.canShoot = false;
				}
				else
					Start.ta.setText("There is no "+target+" here.");
			}
			else
				Start.ta.setText("You don't have the time to conjure another fireball.");
		}
		else
			Start.ta.setText("You don't have enough MAGIC to do that.");
	}

	@Override
	public void Visit(Tile tile) {
		if(tile.hasEnemy)
			Start.ta.append("\nYou read your spell book as you prepare for "
					+ "what's next.");
		
		if(this.getCharacterstate() != ThirstyState.instance()
				&& tile.getName().equalsIgnoreCase("Wasteland")) {
			this.THIRST -=200;
		}
		
		else if(this.getCharacterstate() != ThirstyState.instance() &&
				tile.getName().equalsIgnoreCase("MountainSurroundings")) {
			this.THIRST -= 300;
		}
		
		tile.player = this;
	}
}
