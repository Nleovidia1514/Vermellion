package com.labc.Vermellion.Classes;

import java.util.Random;

import com.labc.Vermellion.Character;
import com.labc.Vermellion.Tile;

public class Fighter extends Character {
	
	public Fighter(Tile starting) {
		super(starting);
		System.out.println("\nYou see the sword and you inmediatly remember\n"
				+ "the honor of your family, you can't let them down\n"
				+ "you will do whatever it takes to put your family name\n"
				+ "uphigh. You feel ready to take on Vermellion's wasteland.");
		this.MAXHP = HP = 250;
		this.MAXMAGIC = MAGIC = 50;
		this.STR = 130;
		this.BAGREDAD = 35;
		this.SNEAK = 40;
		this.ILLUSION = 40;
		this.BLOCK = 150;
		this.ACCURACY = 80;
		this.RESISTANCE = 50;
		this.bagSize = 25;
	}

	@Override
	protected void shoot(String target) {
		Random rnd = new Random();
		if(target.equalsIgnoreCase(this.current.enemy.getName())) {
			int calculateChance = 300/this.ACCURACY;
			if(rnd.nextInt(calculateChance)<=0) {
				this.current.enemy.beShot(this.BAGREDAD);
				System.out.println("\nYou shot an arrow from your wrist crossbow\n"
						+ "and hit "+target+" dealing "+this.BAGREDAD+" damage.");
			}
			else
				System.out.println("\nYou missed the shot. You are so bagre.");
		}
		else
			System.out.println("\nThere is no "+target+" around here.");
	}
}
