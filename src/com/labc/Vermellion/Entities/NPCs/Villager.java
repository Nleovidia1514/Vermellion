package com.labc.Vermellion.Entities.NPCs;

import java.util.Random;

import com.labc.Vermellion.Descriptions;
import com.labc.Vermellion.Item;
import com.labc.Vermellion.SoundFX;
import com.labc.Vermellion.Start;
import com.labc.Vermellion.Classes.TextFieldStates.PlayState;
import com.labc.Vermellion.Classes.TextFieldStates.VillagerState;
import com.labc.Vermellion.Entities.EntityDecorator;
import com.labc.Vermellion.Entities.NPC;
import com.labc.Vermellion.Items.ItemFactory;

public class Villager extends EntityDecorator{
	public static String[] itemNames = new String[] {"Axe","Dagger","Bow","Staff","Sword","Chestplate",
			"HylianShield","Robe","TShirt","Tunic","Hood","IronHelmet","Cap","Hat","Boots",
			"IronBoots","Sandals","Trousers","Chainmail"};
	
	public Villager(NPC npc) {
		super(npc);
	}
	@Override
	public void create() {
		super.create();
		this.HP = 50;
		this.name = "Villager";
	}

	@Override
	public void beAttacked(int damage) {
		Start.ta.append("\nYou attacked the villager dealing "+damage+" damage to him.");
		this.HP -= damage;
		if(this.HP<=0) {
			this.die();
		}
		else
			Start.ta.append("\nThe villager tries to run but it is pretty dumb.");
	}

	@Override
	public void die() {
		Start.ta.append("\nThe villager died.");
		this.position.mob = null;
		this.position.shortDescription = this.position.descripts.shortDescsAftFight.get(this.position.name);
		this.position.lookImage = this.position.image = Descriptions.picAfterFight.get(this.position.name);
		this.position.longDescription = this.position.descripts.longDescsAftFight.get(this.position.name);
		Start.pic.setIcon(this.position.image);
	}

	@Override
	public void beShot(int damage) {
		this.HP -= damage;
		if(this.HP<=0) {
			Start.ta.append("\n*Funny (and weird) villager noises.*");
			Start.ta.append("\nThe villager died.");
			this.die();
		}
		else	
			Start.ta.setText("*Scared villager noises*");
	}
	
	@Override
	public void talk() {
		Start.pic.setIcon(Descriptions.lookImage.get(this.position.name));
		if(!alreadyTalkedTo) {
			SoundFX.VILLAGER.loop(2, 0.6);
			Start.ta.setText("Villager noises Villager noises Villager noises "
					+ "Villager noises Villager noises Villager noises "
					+ "Villager noises Villager noises Villager noises "
					+ "Villager noises Villager noises Villager noises?\n\t"
					+ "Villager noises(YES) \n\tVillager noises(NO)");
			Start.tfState = VillagerState.instance();
		}
		else
			Start.ta.setText("Villager noises.");
	}
	
	public void makeDecision(String decision) {
		Random rnd = new Random();
		
		if(decision.trim().equalsIgnoreCase("YES") || decision.trim().equalsIgnoreCase("NO")) {
			if(decision.trim().equalsIgnoreCase("YES")) {
				Item RndItem = ItemFactory.getItem(Villager.itemNames[rnd.nextInt(Villager.itemNames.length)],this.position.player);
				this.position.player.inventory.add(RndItem);
				Start.ta.setText("*Happy villager noises^-^*");
				Start.ta.append("\n"+RndItem.getName()+" has been added to your inventory.");
				Start.tfState = PlayState.instance();
				this.alreadyTalkedTo = true;
			}
			else if(decision.trim().equalsIgnoreCase("NO")) {
				Start.ta.append("\n*Disappointed villager noises*"); 
				Start.tfState = PlayState.instance();
			}	
		}
		else {
			Start.ta.setText("Villager noisesVillager noisesVillager noises "
					+ "Villager noisesVillager noisesVillager noises "
					+ "Villager noisesVillager noisesVillager noises "
					+ "Villager noisesVillager noisesVillager noises");
			Start.ta.append("*Confused villager noises*");
		}
	}
}
