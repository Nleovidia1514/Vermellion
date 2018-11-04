package com.labc.Vermellion;

public class Character {
	protected int HP, MAGIC, DEX, STR, BAGREDAD, DIRTYNESS;
	protected int bagSize;
	protected Tile starting;
	
	protected Character(Tile starting) {
		this.starting = starting;
	}

}
