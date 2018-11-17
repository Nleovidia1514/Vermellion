package com.labc.Vermellion.Entities.NPCs;

import com.labc.Vermellion.Descriptions;
import com.labc.Vermellion.SingletonMap;
import com.labc.Vermellion.SoundFX;
import com.labc.Vermellion.Start;
import com.labc.Vermellion.Tile;
import com.labc.Vermellion.Classes.TextFieldStates.FairyState;
import com.labc.Vermellion.Classes.TextFieldStates.PlayState;
import com.labc.Vermellion.Classes.TextFieldStates.TeleportState;
import com.labc.Vermellion.Entities.EntityDecorator;
import com.labc.Vermellion.Entities.NPC;
import com.labc.Vermellion.Items.ItemFactory;

public class Fairy extends EntityDecorator{
	
	public Fairy(NPC npc) {
		super(npc);
	}
	
	@Override
	public void create() {
		super.create();
		this.HP = 1000;
		this.name = "Fairy";
	}

	@Override
	public void beAttacked(int damage) {
		Start.ta.append("\nFairy - This is the last time i try to help anyone!");
		Start.ta.append("\nYou attacked the fairy dealing causing her to run from you."
				+ " The fairy escaped.");
		this.die();
	}

	@Override
	public void die() {
		this.position.mob = null;
		this.position.shortDescription = this.position.descripts.shortDescsAftFight.get(this.position.name);
		this.position.lookImage = this.position.image = Descriptions.picAfterFight.get(this.position.name);
		this.position.longDescription = this.position.descripts.longDescsAftFight.get(this.position.name);
		SoundFX.NAVI.loop(1, 0.6);
	}

	@Override
	public void beShot(int damage) {
		Start.ta.append("\nFairy - This is the last time i try to help anyone!");
		Start.ta.append("\nYou attacked the fairy dealing causing her to run from you."
				+ " The fairy escaped.");
		this.die();
	}
	
	@Override
	public void talk() {
		if(!this.alreadyTalkedTo) {
			SoundFX.HELLO.play(0.6);
			Start.ta.setText("\nFairy - Hello humble individual, as you can probably see, "
					+ "i am a fairy. The fairy of the forest to be precise. I've lived"
					+ " in these woods for a long time now and i have developed powers"
					+ " beyond humand comprehension. So i will ask you this once and only "
					+ "once. Are you required of my help humble induvidual?");
			
			Start.tfState = FairyState.instance();
		}
		else
			Start.ta.setText("Goddess - I hope you overcome all the obstacles in your path traveler.");
	}
	
	public void makeDecision(String decision) {
		if(decision.trim().equalsIgnoreCase("YES") || decision.trim().equalsIgnoreCase("NO")) {
			if(decision.trim().equalsIgnoreCase("YES")) {
				this.position.player.inventory.add(ItemFactory.getItem("EXCALIBUR", this.position.player));
				Start.ta.setText("Great. Then pay close attention, i can move your physical"
						+ " form to anywhere on this map all it takes is you to tell me where."
						+ " So? Where do you want to be teleported?\n"
						+ "-Lost woods.\n-Mystical lake.\n-Mountain base.\n-Village.\nChoose.");
				this.alreadyTalkedTo = true;
				Start.tfState = TeleportState.instance();
			}
			else if(decision.trim().equalsIgnoreCase("NO")) {
				Start.ta.setText("Goddess - Oh well... that is disappointing.");
				Start.ta.append("\nThe fairy made a *sight* noise and went away flying.");
				Start.tfState = PlayState.instance();
				this.die();
			}
		}
		else {
			Start.ta.setText("\nFairy - Hello humble individual, as you can probably see,"
					+ "i am a fairy. The fairy of the forest to be precise. I've lived"
					+ " in these woods for a long time now and i have developed powers"
					+ " beyond humand comprehension. So i will ask you this once and only"
					+ "once. Are you required of my help humble induvidual?");
			Start.ta.append("\nGoddess - Sorry individual. I can't quite understand your language.");
		}	
	}

	public void teleport(String decision) {
		String whereToTeleport = null;
		if(decision.toLowerCase().contains("woods")) 
			whereToTeleport = "woods";
		
		else if(decision.toLowerCase().contains("lake"))
			whereToTeleport = "lake";
		
		else if(decision.toLowerCase().contains("mountain"))
			whereToTeleport = "mountainView";
		
		else if(decision.toLowerCase().contains("village"))
			whereToTeleport = "village";
		
		else
			Start.ta.setText("You asked for this. Now choose something.");
		
		if(whereToTeleport!=null) {
			Tile toBeTPed = null;
			for(int i = 0; i<SingletonMap.MapSize;i++) {
				for(int j=0; j<SingletonMap.MapSize;j++) {
					if(SingletonMap.getInstance().getTile(i, j).getName().startsWith(whereToTeleport) && !toBeTPed.alreadyVisited) {
						toBeTPed = SingletonMap.getInstance().getTile(i, j);
						break;
					}
				}	
				if(toBeTPed!=null && toBeTPed.getName().startsWith(whereToTeleport) && !toBeTPed.alreadyVisited) 
					break;
			}
			if(toBeTPed == null) {
				Start.ta.setText("I am sorry traveler but where you want to go is no longer"
						+ " a possibility. I'll see you next time individual. Byeeeee!");
			}
			else {
				this.position.player.setCurrent(toBeTPed);
				Start.ta.setText("Byeeeeeeeee traveleeerr, be carefuuulll...!");
				toBeTPed.accept(this.position.player);
			}
			this.die();
			Start.tfState = PlayState.instance();
		}
	}
		
				
}

