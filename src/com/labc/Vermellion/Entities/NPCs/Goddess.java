package com.labc.Vermellion.Entities.NPCs;

import java.util.Scanner;

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
		System.out.println("\nYou attacked the goddess dealing "+damage+" damage."
				+ " You really are a horrible person.");
		this.HP -= damage;
		if(this.HP<=0)
			die();
		else
			System.err.println("Goddess - Please kind mister stop. I am not looking for trouble.");
	}

	@Override
	public void die() {
		super.die();
		System.out.println("The goddess died and her body evaporated. You are astonished.");
		this.position.mob = null;
		this.position.hasEnemy = false;
		this.position.shortDescription = this.position.descripts.shortDescsAftFight.get(this.position.name);
		this.position.longDescription = this.position.descripts.longDescsAftFight.get(this.position.name);
	}

	@Override
	public void beShot(int damage) {
		super.beShot(damage);
		System.out.println("The goddess started crying as her death has been prophetized.");
		this.HP -= damage;
		if (this.HP<=0)
			die();
	}
	@Override
	public void talk() {
		Scanner sn2 = new Scanner(System.in);
		if(!this.alreadyTalkedTo) {
			System.err.println("\nGoddess - Hello traveler. i have been expecting for a long time\n"
					+ "when i first sensed your arrival i knew you wouldn't\n"
					+ "have an easy path to you destination so i have built\n"
					+ "this in order to help you get through your savage journey."
					+ "\nWill you accept this gift?");
			
			String decision = "";
			while(!decision.trim().equalsIgnoreCase("YES") || decision.trim().equalsIgnoreCase("NO")) {
				decision = sn2.nextLine();
				if(decision.trim().equalsIgnoreCase("YES")) {
				this.position.player.inventory.add(ItemFactory.getItem("EXCALIBUR", this.position.player));
				System.out.println("\nExcalibur has been added to your inventory.");
				this.alreadyTalkedTo = true;
				}
				else if(decision.trim().equalsIgnoreCase("NO")) 
					System.err.println("\nGoddess - Oh well... that is disappointing.");
				
				else
					System.err.println("\nGoddess - Sorry traveler. I can't quite understand your language.");
			}
		}
		else
			System.err.println("\nGoddess - I hope you overcome all the obstacles in your path traveler.");
	}

}
