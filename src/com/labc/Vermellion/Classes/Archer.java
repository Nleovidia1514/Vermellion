package com.labc.Vermellion.Classes;

import java.util.Random;

import com.labc.Vermellion.Character;
import com.labc.Vermellion.Start;
import com.labc.Vermellion.ThirstyState;
import com.labc.Vermellion.Tile;
import com.labc.Vermellion.Visitor;
import com.labc.Vermellion.Items.Equipment;
import com.labc.Vermellion.Items.ItemFactory;

public class Archer extends Character {
	
	public Archer(Tile starting) {
		super(starting);
		this.startingItem = (Equipment) ItemFactory.getItem("BOW", this);
		this.MAXHP = 170;
		this.MAXMAGIC = 50;
		this.STR = 60;
		this.BAGREDAD = 150;
		this.SNEAK = 70;
		this.ILLUSION = 40;
		this.BLOCK = 60;
		this.ACCURACY = 200;
		this.RESISTANCE = 15;
		this.bagSize = 30;
		this.inventory.add(this.startingItem);
		this.startingItem.equip();
		this.HP = this.MAXHP;
		this.MAGIC = this.MAXMAGIC;
		Start.ta.setText("You grab the bow from the floor, you think it feels "
				+ "familiar, the string is tense. This brings you back and "
				+ "makes you remenber things you'd rather not, it is time to "
				+ "look for revenge on Vermellion's wasteland.\n\n");
	}

	@Override
	protected void shoot(String target) {
		Random rnd = new Random();
		if(this.current.canShoot) {
			if(this.current.mob.getName().toLowerCase().contains(target.toLowerCase())) {
				int calculateChance = 300/this.ACCURACY;
				if(rnd.nextInt(calculateChance)<=0) {
					Start.ta.setText("You shot an arrow "
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
		if(tile.hasEnemy)
			Start.ta.append("\nYou lurk in the shadows and analyze the picture.");
		
		if(this.getCharacterstate() != ThirstyState.instance()
				&& tile.getName().equalsIgnoreCase("Wasteland")) {
			this.THIRST -= 200;
		}
		
		else if(this.getCharacterstate() != ThirstyState.instance() &&
				tile.getName().equalsIgnoreCase("MountainSurroundings")) {
			this.THIRST -= 300;
		}
		
		tile.player = this;
	}
}
