package com.labc.Vermellion.Classes;

import java.util.ArrayList;

import com.labc.Vermellion.Character;
import com.labc.Vermellion.Item;
import com.labc.Vermellion.Tile;

public class Fighter extends Character {
	
	public Fighter(Tile starting) {
		super(starting);
		System.out.println("You see the sword and you inmediatly remember\n"
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
		this.bagSize = 25;
	}

	@Override
	protected void shoot(String target) {
		// TODO Auto-generated method stub
		
	}
}
