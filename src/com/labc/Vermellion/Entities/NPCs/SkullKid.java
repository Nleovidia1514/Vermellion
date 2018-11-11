package com.labc.Vermellion.Entities.NPCs;

import com.labc.Vermellion.Start;
import com.labc.Vermellion.Classes.TextFieldStates.PlayState;
import com.labc.Vermellion.Classes.TextFieldStates.SariasSongState;
import com.labc.Vermellion.Classes.TextFieldStates.SkullKidState;
import com.labc.Vermellion.Entities.EntityDecorator;
import com.labc.Vermellion.Entities.NPC;
import com.labc.Vermellion.Items.ItemFactory;

public class SkullKid extends EntityDecorator{
	public String decision;
	public String song;

	public SkullKid(NPC npc) {
		super(npc);
	}
	@Override
	public void create() {
		super.create();
		this.HP = this.HP + 100;
		this.name = "Skullkid";
	}

	@Override
	public void beAttacked(int damage) {
		super.beAttacked(damage);
		this.HP -= damage;
		Start.ta.setText("\nYou attacked the SkullKid dealing "+damage+" damage. He's just a kid.");
		if(this.HP<=0)
			die();
		else
			Start.ta.append("\nSkullKid - Please don't do it sir. Im just a kid.");
		
	}

	@Override
	public void die() {
		super.die();
		Start.ta.append("\nThe kid died and disappeared. Nothing makes sense.");
		this.position.mob = null;
		this.position.hasEnemy = false;
		this.position.shortDescription = this.position.descripts.shortDescsAftFight.get(this.position.name);
		this.position.longDescription = this.position.descripts.longDescsAftFight.get(this.position.name);
	}

	@Override
	public void beShot(int damage) {
		super.beShot(damage);
		Start.ta.append("\nSkullKid - FUCK");
		this.HP -= damage;
	}
	@Override
	public void talk() {
		if(!this.alreadyTalkedTo) {
			Start.tfState = SkullKidState.instance();
			Start.ta.setText("SkullKid - Hello adventurer. I am the SkullKid, inhabitant and\n"
					+ "protector of these magic woods. I like to call myself\n"
					+ "a trickster so i have a little game for you. If you\n"
					+ "can play these woods' characteristic song correctly, i will\n"
					+ "give you a reward. So do you accept this game?");
		}
		else 
			Start.ta.append("\nSkullKid - That really was a fun game, wasn't it adventurer?");
		
	}
	
	public void playSong(String song) {
		String sariasSong = "abajo derecha izquierda abajo derecha izquierda";
		if(song.equalsIgnoreCase("stop") || song.equalsIgnoreCase(sariasSong)) {
			if(song.equalsIgnoreCase(sariasSong)) {
				Start.ta.append("\nSkullKid - That really is a beatiful song. Isn't it adventurer?\n");
				this.position.player.inventory.add(ItemFactory.getItem("MAJORASMASK",this.position.player));
				Start.ta.append("\nMajora's mask has been added to your inventory.");
				this.alreadyTalkedTo = true;
				Start.tfState = PlayState.instance();
			}
			else if(song.equalsIgnoreCase("stop")) {
				Start.ta.append("\nSkullKid - Oh well... that is disappointing.");
				Start.tfState = PlayState.instance();
			}
				
		}
		else 
			Start.ta.append("\nSkullKid - that is not a song i recognize chief!");
	}
	
	public void makeDecision(String decision) {
		if(decision.trim().equalsIgnoreCase("YES") || decision.trim().equalsIgnoreCase("NO")) {
			if(decision.trim().equalsIgnoreCase("YES")) {
				Start.ta.setText("\nSkull kid - Oh, how exciting. Time to show me what you can do.\n"
						+ "Here, take my ocarina and start playing.");
				Start.tfState = SariasSongState.instance();
			}
			else if(decision.trim().equalsIgnoreCase("NO")) {
				Start.ta.append("\nSkullKid - Oh well... that is disappointing.");
				Start.tfState = PlayState.instance();
			}
			
			else {
				Start.ta.append("\nSkullKid - Sorry adventurer. I can't quite understand your language.");
			}
				
		}
	}
}
