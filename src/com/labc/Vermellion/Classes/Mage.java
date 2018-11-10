package com.labc.Vermellion.Classes;

import com.labc.Vermellion.Character;
import com.labc.Vermellion.Item;
import com.labc.Vermellion.Tile;
import com.labc.Vermellion.Entities.Enemy;

import java.util.ArrayList;

import com.labc.*;

public class Mage extends Character {
	
	public Mage(Tile starting) {
		super(starting);
		System.out.println("You feel an outburst of power running through your body\n"
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
	}

	@Override
	protected void shoot(String target) {
		// TODO Auto-generated method stub
		
	}
}
