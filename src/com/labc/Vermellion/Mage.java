package com.labc.Vermellion;

public class Mage extends Character {
	
	public Mage(Tile starting) {
		super(starting);
		System.out.println("You feel an outburst of power running through your body\nyou suddenly feel like the world is yours"
				+ "\nand you're ready to take on Vermellion's wasteland...");
		this.HP = 175;
		this.MAGIC = 200;
		this.DEX = 40;
		this.STR = 60;
		this.BAGREDAD = 10;
		this.DIRTYNESS = 35;
		this.bagSize = 30;
	}

}
