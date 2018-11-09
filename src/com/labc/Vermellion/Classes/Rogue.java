package com.labc.Vermellion.Classes;

import com.labc.Vermellion.Tile;

import java.util.ArrayList;

import com.labc.Vermellion.Character;
import com.labc.Vermellion.Item;

public class Rogue extends Character{
	
	public Rogue(Tile starting) {
		super(starting);
		System.out.println("You grab the knives that were given to you by your father,\nthey are"
				+" sharp... very sharp. 'I will avenge you father'\nsuddenly"
				+" you feel ready to take on Vermellion's Wasteland...");
		this.HP = 175;
		this.MAGIC = 120;
		this.STR = 80;
		this.BAGREDAD = 35;
		this.SNEAK = 150;
		this.ILLUSION = 70;
		this.BLOCK = 30;
		this.ACCURACY = 100;
		this.bagSize = 20;
	}

	@Override
	protected void shoot(String target) {
		// TODO Auto-generated method stub
		
	}
}
