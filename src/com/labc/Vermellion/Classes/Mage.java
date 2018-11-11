package com.labc.Vermellion.Classes;

import com.labc.Vermellion.Character;
import com.labc.Vermellion.Start;
import com.labc.Vermellion.Tile;
import java.util.Random;

public class Mage extends Character {
	
	public Mage(Tile starting) {
		super(starting);
		Start.ta.setText("\nYou feel an outburst of power running through your body\n"
				+ "you suddenly feel like the world is yours\n"
				+ "and you're ready to take on Vermellion's wasteland...\n\n");
		this.MAXHP = HP = 175;
		this.MAXMAGIC = MAGIC = 200;
		this.STR = 60;
		this.BAGREDAD = 100;
		this.SNEAK = 70;
		this.ILLUSION = 150;
		this.BLOCK = 50;
		this.bagSize = 30;
		this.ACCURACY = 140;
		this.RESISTANCE = 10;
	}

	@Override
	protected void shoot(String target) {
		Random rnd = new Random();
		if(this.MAGIC>=30) {
			if(this.current.canShoot) {
				if(this.current.mob.getName().toLowerCase().contains(target.toLowerCase())) {
					int calculateChance = 300/this.ACCURACY;
					if(rnd.nextInt(calculateChance)<=0) {
						Start.ta.setText("\nYou shot a fireball to "+target+" and dealt "
								+this.BAGREDAD+" damage.");
						this.current.mob.beShot(this.BAGREDAD);
					}
					else
						Start.ta.append("\nYou missed the fireball. You are so bagre.");
					
					this.MAGIC -=30;
					this.current.canShoot = false;
				}
				else
					Start.ta.append("\nThere is no "+target+" here.");
			}
			else
				Start.ta.append("\nYou don't have the time to conjure another fireball.");
		}
		else
			Start.ta.append("\nYou don't have enough MAGIC to do that.");
	}
}
