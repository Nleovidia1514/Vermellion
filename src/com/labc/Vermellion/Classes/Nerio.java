package com.labc.Vermellion.Classes;

import com.labc.Vermellion.Tile;
import com.labc.Vermellion.Items.Equipment;
import com.labc.Vermellion.Items.ItemFactory;
import java.util.Random;
import com.labc.Vermellion.Character;
import com.labc.Vermellion.Start;
import com.labc.Vermellion.ThirstyState;

public class Nerio extends Character  {
	
	public Nerio(Tile starting) {
		super(starting);
		this.startingItem = (Equipment) ItemFactory.getItem("MIND", this);
		this.startingArmor = (Equipment) ItemFactory.getItem("TSHIRT", this);
		this.MAXHP = 300;
		this.MAXMAGIC = 50;
		this.STR = 200;
		this.BAGREDAD = 1000;
		this.SNEAK = 100;
		this.ILLUSION = 50;
		this.BLOCK = 40;
		this.ACCURACY = 100;
		this.RESISTANCE = 50;
		this.inventory.add(this.startingItem);
		this.inventory.add(this.startingArmor);
		this.startingArmor.equip();
		this.startingItem.equip();
		this.HP = this.MAXHP;
		this.MAGIC = this.MAXMAGIC;
		Start.ta.setText("You grab the glasses and put them on, you notice "
				+"how you start getting old and getting bagre, this is it. "
				+"The moment you've been waiting for has arrived "
				+ "'Si me traen un cachito yo soy generoso'\n\n");
	}

	@Override
	protected void shoot(String target) {
		Random rnd = new Random();
		if(this.current.canShoot) {
			if(this.MAGIC>=100) {
				if(this.current.mob.getName().toLowerCase().contains(target.toLowerCase())) {
					int calculateChance = 300/this.ACCURACY;
					if(rnd.nextInt(calculateChance)<=0) {
						Start.ta.setText("You put a 09 on "+this.current.mob.getName()+"'s exam and dealt "
								+this.BAGREDAD+" damage.");
						this.MAGIC -=100;
						this.current.mob.beShot(this.BAGREDAD);
					}
					else
						Start.ta.setText("You couldn't do it. You are so bagre.");
					
					this.current.canShoot = false;
				}
				else
					Start.ta.setText("There is no "+target+" here.");
			}
			else
				Start.ta.setText("You don't have enough MAGIC to do that.");
		}
		else
			Start.ta.setText("The grade for "+target+"'s exam is already put. :(");
	}

	@Override
	public void Visit(Tile tile) {
		if(tile.hasEnemy)
			Start.ta.append("\nYou think about what to do next "
					+ "while you watch youtube.");
		
		if(this.getCharacterstate() != ThirstyState.instance()
				&& tile.getName().equalsIgnoreCase("Wasteland")) {
			this.THIRST -=200 ;
		}
		
		else if(this.getCharacterstate() != ThirstyState.instance() &&
				tile.getName().equalsIgnoreCase("MountainSurroundings")) {
			this.THIRST -= 300;
		}
		
		tile.player = this;
	}	
}
