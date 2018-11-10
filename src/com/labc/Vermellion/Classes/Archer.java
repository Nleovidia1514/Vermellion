package com.labc.Vermellion.Classes;

import java.util.Random;

import com.labc.Vermellion.Character;
import com.labc.Vermellion.Tile;

public class Archer extends Character {

	public Archer(Tile starting) {
		super(starting);
		System.out.println("\nYou grab the bow from the floor, you think it feels\n"
				+ "familiar, the string is tense. This brings you back and\n"
				+ "makes you remenber things you'd rather not, it is time to\n"
				+ "look for revenge on Vermellion's wasteland.");
		this.MAXHP = HP = 170;
		this.MAXMAGIC = MAGIC = 50;
		this.STR = 60;
		this.BAGREDAD = 150;
		this.SNEAK = 70;
		this.ILLUSION = 40;
		this.BLOCK = 60;
		this.ACCURACY = 200;
		this.RESISTANCE = 60;
		this.bagSize = 30;
	}

	@Override
	protected void shoot(String target) {
		Random rnd = new Random();
		if(target.equalsIgnoreCase(this.current.enemy.getName())) {
			int calculateChance = 300/this.ACCURACY;
			if(rnd.nextInt(calculateChance)<=0) {
				this.current.enemy.beShot(this.BAGREDAD);
				System.out.println("\nYou shot an arrow\n"
						+ "and hit "+target+" dealing "+this.BAGREDAD+" damage.");
			}
			else
				System.out.println("\nYou missed the shot. You are so bagre.");
		}
		else
			System.out.println("\nThere is no "+target+" around here.");
	}
}
