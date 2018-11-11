package com.labc.Vermellion.Entities.NPCs;

import java.util.Scanner;

import com.labc.Vermellion.Entities.EntityDecorator;
import com.labc.Vermellion.Entities.NPC;
import com.labc.Vermellion.Items.ItemFactory;

public class SkullKid extends EntityDecorator{

	public SkullKid(NPC npc) {
		super(npc);
	}
	@Override
	public void create() {
		this.HP = this.HP + 100;
		this.name = "Skullkid";
	}

	@Override
	public void beAttacked(int damage) {
		System.err.println("SkullKid - Please don't do it sir. Im just a kid.");
		System.out.println("You attacked the SkullKid dealing "+damage+". He's just a kid.");
		this.HP -= damage;
		if(this.HP<=0)
			die();
	}

	@Override
	public void die() {
		System.out.println("The kid died and disappeared. Nothing makes sense.");
		this.position.mob = null;
		this.position.hasEnemy = false;
		this.position.shortDescription = this.position.descripts.shortDescsAftFight.get(this.position.name);
		this.position.longDescription = this.position.descripts.longDescsAftFight.get(this.position.name);
	}

	@Override
	public void beShot(int damage) {
		System.err.println("SkullKid - FUCK");
		this.HP -= damage;
	}
	@Override
	public void talk() {
		Scanner sn2 = new Scanner(System.in);
		if(!this.alreadyTalkedTo) {
			System.err.println("SkullKid - Hello adventurer. I am the SkullKid, inhabitant and\n"
					+ "protector of these magic woods. I like to call myself\n"
					+ "a trickster so i have a little game for you. If you\n"
					+ "can play these woods' characteristic song correctly, i will\n"
					+ "give you a reward. So do you accept this game?");
			String decision = "";
			while(!decision.trim().equalsIgnoreCase("YES") && !decision.trim().equalsIgnoreCase("NO")) {
				decision = sn2.nextLine();
				if(decision.trim().equalsIgnoreCase("YES")) {
					String song = "";
					String sariasSong = "abajo derecha izquierda abajo derecha izquierda";
					System.err.println("\nSkull kid - Oh, how exciting. Time to show me what you can do.\n"
							+ "Here, take my ocarina and start playing.");
					while(!song.equalsIgnoreCase("exit") && !song.equalsIgnoreCase(sariasSong)) {
						song = sn2.nextLine();
						if(song.equalsIgnoreCase(sariasSong)) {
							System.out.println(song);
							System.err.println("SkullKid - That really is a beatiful song. Isn't it adventurer?");
							this.position.player.inventory.add(ItemFactory.getItem("MAJORASMASK",this.position.player));
							System.out.println("Majora's mask has been added to your inventory.");
							this.alreadyTalkedTo = true;
						}
						else
							System.err.println("SkullKid - that is not a song i recognize chief!");
					}
					System.err.println("\nSkullKid - Oh well... that is disappointing.");
				}
				else if(decision.trim().equalsIgnoreCase("NO")) 
					System.err.println("\nSkullKid - Oh well... that is disappointing.");
				
				else
					System.err.println("\nSkullKid - Sorry adventurer. I can't quite understand your language.");
			}
		}
		else
			System.err.println("SkullKid - That really was a fun game, wasn't it adventurer?");
		
	}
}
