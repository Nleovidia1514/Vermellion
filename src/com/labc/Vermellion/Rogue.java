package com.labc.Vermellion;

public class Rogue extends Character{
	
	public Rogue(Tile starting) {
		super(starting);
		System.out.println("You grab the knives that were given to you by your father,\nthey are"
				+" sharp... very sharp. 'I will avenge you father'\nsuddenly"
				+" you feel ready to take on Vermellions Wasteland...");
		this.HP = 175;
		this.MAGIC = 120;
		this.DEX = 110;
		this.STR = 80;
		this.BAGREDAD = 35;
		this.DIRTYNESS = 70;
		this.bagSize = 20;
	}
}
