package com.labc.Vermellion.Entities.NPCs;

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
		super.beAttacked(damage);
		this.HP -= damage;
		Start.ta.setText("\nYou attacked the goddess dealing "+damage+" damage."
				+ " You really are a horrible person.");
		if(this.HP<=0)
			die();
		else
			Start.ta.append("\nGoddess - Please kind mister stop. I am not looking for trouble.");
	}

	@Override
	public void die() {
		super.die();
		Start.ta.append("\nThe goddess died and her body evaporated. You are astonished.");
		this.position.mob = null;
		this.position.hasEnemy = false;
		this.position.shortDescription = this.position.descripts.shortDescsAftFight.get(this.position.name);
		this.position.longDescription = this.position.descripts.longDescsAftFight.get(this.position.name);
	}

	@Override
	public void beShot(int damage) {
		super.beShot(damage);
		Start.ta.append("\nThe goddess started crying as her death has been prophetized.");
		this.HP -= damage;
		if (this.HP<=0)
			die();
	}
	@Override
	public void talk() {
		if(!this.alreadyTalkedTo) {
			Start.ta.setText("\nGoddess - Hello traveler. i have been expecting for a long time\n"
					+ "when i first sensed your arrival i knew you wouldn't\n"
					+ "have an easy path to you destination so i have built\n"
					+ "this in order to help you get through your savage journey."
					+ "\nWill you accept this gift?");
			
			Start.tfState = GoddessState.instance();
		}
		else
			Start.ta.append("\nGoddess - I hope you overcome all the obstacles in your path traveler.");
	}
	
	public void makeDecision(String decision) {
		if(decision.trim().equalsIgnoreCase("YES") || decision.trim().equalsIgnoreCase("NO")) {
			if(decision.trim().equalsIgnoreCase("YES")) {
				this.position.player.inventory.add(ItemFactory.getItem("EXCALIBUR", this.position.player));
				Start.ta.append("\nExcalibur has been added to your inventory.");
				this.alreadyTalkedTo = true;
				Start.tfState = PlayState.instance();
			}
			else if(decision.trim().equalsIgnoreCase("NO")) {
				Start.ta.append("\nGoddess - Oh well... that is disappointing.");
				Start.tfState = PlayState.instance();
			}
				
			else
				Start.ta.append("\nGoddess - Sorry traveler. I can't quite understand your language.");
		}
	}

}
