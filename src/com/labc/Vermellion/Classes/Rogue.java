package com.labc.Vermellion.Classes;

import com.labc.Vermellion.Tile;
import java.util.Random;
import com.labc.Vermellion.Character;
import com.labc.Vermellion.Start;

public class Rogue extends Character{
	
	public Rogue(Tile starting) {
		super(starting);
		Start.ta.setText("\nYou grab the knives that were given to you by your father,\nthey are"
				+" sharp... very sharp. 'I will avenge you father'\nsuddenly"
				+" you feel ready to take on Vermellion's Wasteland...\n\n");
		this.HP = 175;
		this.MAGIC = 120;
		this.STR = 80;
		this.BAGREDAD = 35;
		this.SNEAK = 150;
		this.ILLUSION = 70;
		this.BLOCK = 30;
		this.ACCURACY = 100;
		this.RESISTANCE = 20;
		this.bagSize = 20;
	}

	@Override
	protected void shoot(String target) {
		Random rnd = new Random();
		if(this.current.canShoot) {
			if(this.current.mob.getName().toLowerCase().contains(target.toLowerCase())) {
				int calculateChance = 300/this.ACCURACY;
				if(rnd.nextInt(calculateChance)<=0) {
					Start.ta.setText("\nYou threw a dagger to "+target+"'s throat and dealt "
							+this.BAGREDAD+" damage.");
					this.current.mob.beShot(this.BAGREDAD);
				}
				else
					Start.ta.append("\nYou missed the dagger throw. You are so bagre.");
				
				this.current.canShoot = false;
			}
			else
				Start.ta.append("\nThere is no "+target+" here.");
		}
		else
			Start.ta.append("\nYou already threw your dagger.");
	}
}
