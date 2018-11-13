package com.labc.Vermellion.Classes;

import java.util.Random;

import com.labc.Vermellion.Character;
import com.labc.Vermellion.Start;
import com.labc.Vermellion.ThirstyState;
import com.labc.Vermellion.Tile;
import com.labc.Vermellion.Items.ItemFactory;

public class Fighter extends Character {
	
	public Fighter(Tile starting) {
		super(starting);
		Start.ta.setText("You see the sword and you inmediatly remember\n"
				+ "the honor of your family, you can't let them down\n"
				+ "you will do whatever it takes to put your family name\n"
				+ "uphigh. You feel ready to take on Vermellion's wasteland.\n\n");
		this.MAXHP = HP = 250;
		this.MAXMAGIC = MAGIC = 50;
		this.STR = 130;
		this.BAGREDAD = 35;
		this.SNEAK = 40;
		this.ILLUSION = 40;
		this.BLOCK = 150;
		this.ACCURACY = 80;
		this.RESISTANCE = 30;
		this.bagSize = 25;
		this.inventory.add(ItemFactory.getItem("SWORD", this));
	}

	@Override
	protected void shoot(String target) {
		Random rnd = new Random();
		if(this.current.canShoot) {
			if(this.current.mob.getName().toLowerCase().contains(target.toLowerCase())) {
				int calculateChance = 300/this.ACCURACY;
				if(rnd.nextInt(calculateChance)<=0) {
					Start.ta.setText("You shot an arrow from your wrist crossbow\n"
							+ "and hit "+this.current.mob.getName()+" dealing "+this.BAGREDAD+" damage.");
					this.current.mob.beShot(this.BAGREDAD);
				}
				else
					Start.ta.setText("You missed the shot. You are so bagre.");
				
				this.current.canShoot = false;
			}
			else
				Start.ta.setText("There is no "+target+" around here.");
		}
		else
			Start.ta.setText("You don't have the time to set your crossbow.");
	}

	@Override
	public void Visit(Tile tile) {
		Start.ta.setText(tile.getShortDescription());
		if(tile.hasEnemy)
			Start.ta.append("\nYour honor makes you anxious to fight but\n"
					+ "decide to think before you act.");
		
		if(this.getCharacterstate() != ThirstyState.instance()
				&& tile.getName().equalsIgnoreCase("Wasteland")) {
			this.THIRST = 40;
		}
		
		else if(this.getCharacterstate() != ThirstyState.instance() &&
				tile.getName().equalsIgnoreCase("MountainSurroundings")) {
			this.THIRST = 60;
		}
		
		tile.player = this;
	}

	
}
