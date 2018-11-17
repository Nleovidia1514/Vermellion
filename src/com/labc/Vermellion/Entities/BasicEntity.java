package com.labc.Vermellion.Entities;

import com.labc.Vermellion.Entity;
import com.labc.Vermellion.Tile;

public class BasicEntity extends Entity{
	public static String[] goodDrops = new String[] {"Chestplate","HylianShield","IronBoots",
			"IronHelmet","Chainmail","Sword","Bow","Staff","Dagger","Greenpot"};
	public static String[] normalDrops = new String[] {"Robe","TShirt","Tunic","Boots","Sandals",
			"Cap","Hat","Hood","Trousers","Axe","Dagger","RedPot","SpaghettiOs"};
	
	protected BasicEntity(Tile position) {
		super(position);
	}
	
	@Override
	public void create() {
		this.HP = 0;
		this.name = null;
	}

	@Override
	public void beAttacked(int damage) {
		this.HP -= damage;
	}

	@Override
	public void die() {
		this.position.mob = null;
	}

	@Override
	public void beShot(int damage) {
		this.HP -= damage;
	}

	@Override
	public void talk() {
		System.err.println("hello.");
	}

}
