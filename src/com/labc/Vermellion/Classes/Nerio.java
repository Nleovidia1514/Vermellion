package com.labc.Vermellion.Classes;

import com.labc.Vermellion.Tile;

import java.util.ArrayList;
import java.util.Scanner;

import com.labc.Vermellion.Character;
import com.labc.Vermellion.Item;
import com.labc.Vermellion.Entities.*;

public class Nerio extends Character {
	
	public Nerio(Tile starting) {
		super(starting);
		System.out.println("You grab the glasses and put them on, you notice\n"
				+"how you start getting old and getting bagre, this is it.\n"
				+"The moment you've been waiting for has arrived\n"
				+ "'Si me traen un cachito yo soy generoso'");
		this.HP = 300;
		this.MAGIC = 50;
		this.STR = 200;
		this.BAGREDAD = 1000;
		this.SNEAK = 100;
		this.ILLUSION = 50;
		this.BLOCK = 40;
		this.ACCURACY = 100;
		this.bagSize = 30;
	}

	@Override
	protected void shoot(String target) {
		// TODO Auto-generated method stub
		
	}	
}
