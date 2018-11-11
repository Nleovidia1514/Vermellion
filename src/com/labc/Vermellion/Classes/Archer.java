package com.labc.Vermellion.Classes;

import java.util.Random;

import com.labc.Vermellion.Character;
import com.labc.Vermellion.Start;
import com.labc.Vermellion.Tile;

public class Archer extends Character {

	public Archer(Tile starting) {
		super(starting);
		Start.ta.setText("\nYou grab the bow from the floor, you think it feels\n"
				+ "familiar, the string is tense. This brings you back and\n"
				+ "makes you remenber things you'd rather not, it is time to\n"
				+ "look for revenge on Vermellion's wasteland.\n\n");
		this.MAXHP = HP = 170;
		this.MAXMAGIC = MAGIC = 50;
		this.STR = 60;
		this.BAGREDAD = 150;
		this.SNEAK = 70;
		this.ILLUSION = 40;
		this.BLOCK = 60;
		this.ACCURACY = 200;
		this.RESISTANCE = 15;
		this.bagSize = 30;
	}

	@Override
	protected void shoot(String target) {
		Random rnd = new Random();
		if(this.current.canShoot) {
			if(this.current.mob.getName().toLowerCase().contains(target.toLowerCase())) {
				int calculateChance = 300/this.ACCURACY;
				if(rnd.nextInt(calculateChance)<=0) {
					Start.ta.setText("\nYou shot an arrow\n"
							+ "and hit "+target+" dealing "+this.BAGREDAD+" damage.");
					this.current.mob.beShot(this.BAGREDAD);
				}
				else
					Start.ta.append("\nYou missed the shot. You are so bagre.");
				
				this.current.canShoot = false;
			}
			else
				Start.ta.append("\nThere is no "+target+" around here.");
		}
		else
			Start.ta.append("\nYou already shot your arrow.");
	}
}
