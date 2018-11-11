package com.labc.Vermellion.Classes;

import com.labc.Vermellion.Tile;
import java.util.Random;
import com.labc.Vermellion.Character;
import com.labc.Vermellion.Start;

public class Nerio extends Character {
	
	public Nerio(Tile starting) {
		super(starting);
		Start.ta.setText("\nYou grab the glasses and put them on, you notice\n"
				+"how you start getting old and getting bagre, this is it.\n"
				+"The moment you've been waiting for has arrived\n"
				+ "'Si me traen un cachito yo soy generoso'\n\n");
		this.HP = 300;
		this.MAGIC = 50;
		this.STR = 200;
		this.BAGREDAD = 1000;
		this.SNEAK = 100;
		this.ILLUSION = 50;
		this.BLOCK = 40;
		this.ACCURACY = 100;
		this.RESISTANCE = 50;
		this.bagSize = 30;
	}

	@Override
	protected void shoot(String target) {
		Random rnd = new Random();
		if(this.current.canShoot) {
			if(this.current.mob.getName().toLowerCase().contains(target.toLowerCase())) {
				int calculateChance = 300/this.ACCURACY;
				if(rnd.nextInt(calculateChance)<=0) {
					Start.ta.setText("\nYou put a 09 on "+target+"'s exam and dealt "
							+this.BAGREDAD+" damage.");
					this.current.mob.beShot(this.BAGREDAD);
				}
				else
					Start.ta.append("\nYou couldn't do it. You are so bagre.");
				
				this.current.canShoot = false;
			}
			else
				Start.ta.append("\nThere is no "+target+" here.");

		}
		else
			Start.ta.append("\nThe grade for "+target+"'s exam is already put. :(");
	}	
}
