package com.labc.Vermellion.Entities;

import com.labc.Vermellion.Entity;
import com.labc.Vermellion.Tile;

public abstract class Enemy extends Entity implements AttackAble{
	protected int ATTACK;
	
	protected Enemy(Tile position) {
		super(position);
	}
	
	public abstract void create();
}
