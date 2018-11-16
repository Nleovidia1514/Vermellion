package com.labc.Vermellion.Entities.NPCs;

import com.labc.Vermellion.Descriptions;
import com.labc.Vermellion.Start;
import com.labc.Vermellion.Classes.TextFieldStates.GoddessState;
import com.labc.Vermellion.Classes.TextFieldStates.PlayState;
import com.labc.Vermellion.Entities.EntityDecorator;
import com.labc.Vermellion.Entities.NPC;
import com.labc.Vermellion.Items.ItemFactory;

public class Goddess extends EntityDecorator{

	public Goddess(NPC npc) {
		super(npc);
	}
	@Override
	public void create() {
		super.create();
		this.HP = 50;
		this.name = "Goddess";
	}

	@Override
	public void beAttacked(int damage) {
		this.HP -= damage;
		Start.ta.append("\nYou attacked the goddess dealing "+damage+" damage."
				+ " You really are a horrible person.");
		if(this.HP<=0) {
			Start.ta.append("\nThe goddess died and her body evaporated. You are astonished.");
			die();
		}
		else
			Start.ta.append("\nGoddess - Please kind mister stop. I am not looking for trouble.");
	}

	@Override
	public void die() {
		this.position.mob = null;
		this.position.shortDescription = this.position.descripts.shortDescsAftFight.get(this.position.name);
		this.position.lookImage = Descriptions.picAfterFight.get(this.position.name);
		this.position.longDescription = this.position.descripts.longDescsAftFight.get(this.position.name);
		Start.pic.setIcon(Descriptions.picAfterFight.get(this.position.name));
	}

	@Override
	public void beShot(int damage) {
		this.HP -= damage;
		if (this.HP<=0) {
			die();
			Start.ta.append("\nThe goddess died and her body evaporated. You are astonished.");
		}
		else
			Start.ta.append("\nThe goddess started crying as her death has been prophetized.");
	}
	@Override
	public void talk() {
		if(!this.alreadyTalkedTo) {
			Start.ta.setText("\nGoddess - Hello traveler. i have been expecting for a long time "
					+ "when i first sensed your arrival i knew you wouldn't "
					+ "have an easy path to you destination so i have built "
					+ "this in order to help you get through your savage journey."
					+ "\nWill you accept this gift?");
			
			Start.tfState = GoddessState.instance();
		}
		else
			Start.ta.setText("Goddess - I hope you overcome all the obstacles in your path traveler.");
	}
	
	public void makeDecision(String decision) {
		if(decision.trim().equalsIgnoreCase("YES") || decision.trim().equalsIgnoreCase("NO")) {
			if(decision.trim().equalsIgnoreCase("YES")) {
				this.position.player.inventory.add(ItemFactory.getItem("EXCALIBUR", this.position.player));
				Start.ta.setText("Take this gift as a sign of my gratitude "
						+ "for that which you have not yet done young adventurer. "
						+ "Grow wise and strong, i will be watching...");
				Start.ta.append("\nExcalibur has been added to your inventory.");
				this.alreadyTalkedTo = true;
				Start.tfState = PlayState.instance();
			}
			else if(decision.trim().equalsIgnoreCase("NO")) {
				Start.ta.setText("Goddess - Oh well... that is disappointing.");
				Start.tfState = PlayState.instance();
			}
		}
		else {
			Start.ta.setText("Goddess - Hello traveler. i have been expecting for a long time "
					+ "when i first sensed your arrival i knew you wouldn't "
					+ "have an easy path to you destination so i have built "
					+ "this in order to help you get through your savage journey."
					+ "\nWill you accept this gift?");
			Start.ta.append("\nGoddess - Sorry traveler. I can't quite understand your language.");
		}	
	}
	
	
}
