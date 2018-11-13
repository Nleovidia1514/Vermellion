package com.labc.Vermellion.Classes;

import java.util.Random;

import com.labc.Vermellion.Character;
import com.labc.Vermellion.Start;
import com.labc.Vermellion.ThirstyState;
import com.labc.Vermellion.Tile;
import com.labc.Vermellion.Visitor;
import com.labc.Vermellion.Items.ItemFactory;

public class Archer extends Character {

	public Archer(Tile starting) {
		super(starting);
		Start.ta.setText("You grab the bow from the floor, you think it feels\n"
				+ "familiar, the string is tense. This brings you back and\n"
				+ "makes you remenber things you'd rather not, it is time to\n"
				+ "look for revenge on Vermellion's wasteland.\n\n");
		this.MAXHP = HP = 170;
		this.MAXMAGIC = MAGIC = 50;
		this.STR = 60;
		this.BAGREDAD = 150;
		this.SNEAK = 70;
		this.ILLUSION = 40;
		this.BLOCK = 60;
		this.ACCURACY = 200;
		this.RESISTANCE = 15;
		this.bagSize = 30;
		this.inventory.add(ItemFactory.getItem("BOW", this));
	}

	@Override
	protected void shoot(String target) {
		Random rnd = new Random();
		if(this.current.canShoot) {
			if(this.current.mob.getName().toLowerCase().contains(target.toLowerCase())) {
				int calculateChance = 300/this.ACCURACY;
				if(rnd.nextInt(calculateChance)<=0) {
					Start.ta.setText("You shot an arrow\n"
							+ "and hit "+this.current.mob.getName()+" dealing "+this.BAGREDAD+" damage.");
					this.current.mob.beShot(this.BAGREDAD);
				}
				else
					Start.ta.setText("You missed the shot. You are so bagre.");
				
				this.current.canShoot = false;
			}
			else
				Start.ta.setText("There is no "+target+" around here.");
		}
		else
			Start.ta.setText("You already shot your arrow.");
	}

	@Override
	public void Visit(Tile tile) {
		Start.ta.setText(tile.getShortDescription());
		if(tile.hasEnemy)
			Start.ta.append("\nYou lurk in the shadows and analyze the picture.");
		
		if(this.getCharacterstate() != ThirstyState.instance()
				&& tile.getName().equalsIgnoreCase("Wasteland")) {
			this.THIRST = 40;
		}
		
		else if(this.getCharacterstate() != ThirstyState.instance() &&
				tile.getName().equalsIgnoreCase("MountainSurroundings")) {
			this.THIRST = 60;
		}
		
		tile.player = this;
	}
}
