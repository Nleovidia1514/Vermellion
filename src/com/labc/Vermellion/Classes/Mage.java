package com.labc.Vermellion.Classes;

import com.labc.Vermellion.Character;
import com.labc.Vermellion.Tile;
import java.util.Random;

public class Mage extends Character {
	
	public Mage(Tile starting) {
		super(starting);
		System.out.println("\nYou feel an outburst of power running through your body\n"
				+ "you suddenly feel like the world is yours\n"
				+ "and you're ready to take on Vermellion's wasteland...");
		this.MAXHP = HP = 175;
		this.MAXMAGIC = MAGIC = 200;
		this.STR = 60;
		this.BAGREDAD = 10;
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
		if(this.current.canShoot) {
			if(target.equalsIgnoreCase(this.current.mob.getName())) {
				int calculateChance = 300/this.ACCURACY;
				if(rnd.nextInt(calculateChance)<=0) {
					System.out.println("\nYou shot a fireball to "+target+" and dealt "
							+this.BAGREDAD+" damage.");
					this.current.mob.beShot(this.BAGREDAD);
				}
				else
					System.out.println("You missed the shot. You are so bagre.");
				
				this.current.canShoot = false;
			}
			else
				System.out.println("\nThere is no "+target+" here.");
		}
		else
			System.out.println("\nYou don't have the time to conjure another fireball.");
		
	}
}
