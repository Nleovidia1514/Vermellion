package com.labc.Vermellion.Entities.NPCs;

import java.util.Random;

import com.labc.Vermellion.Item;
import com.labc.Vermellion.SingletonMap;
import com.labc.Vermellion.Start;
import com.labc.Vermellion.Classes.TextFieldStates.PlayState;
import com.labc.Vermellion.Classes.TextFieldStates.VillagerState;
import com.labc.Vermellion.Entities.EntityDecorator;
import com.labc.Vermellion.Entities.NPC;
import com.labc.Vermellion.Items.ItemFactory;

public class Villager extends EntityDecorator{

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
		super.beAttacked(damage);
		Start.ta.setText("*Scared villager noises*");
		this.HP -= damage;
		if(this.HP<=0)
			die();
		else
			Start.ta.append("\nThe villager tries to run but it is pretty dumb.");
	}

	@Override
	public void die() {
		this.position.mob = null;
		this.position.hasEnemy = false;
		this.position.shortDescription = this.position.descripts.shortDescsAftFight.get(this.position.name);
		this.position.longDescription = this.position.descripts.longDescsAftFight.get(this.position.name);
		Start.ta.append("\n*Funny (and weird) villager noises.*");
	}

	@Override
	public void beShot(int damage) {
		super.beShot(damage);
		Start.ta.setText("*Scared villager noises*");
		this.HP -= damage;
		if(this.HP<=0)
			die();
	}
	
	@Override
	public void talk() {
		Start.ta.setText("Villager noisesVillager noisesVillager noises\n"
				+ "Villager noisesVillager noisesVillager noises\n"
				+ "Villager noisesVillager noisesVillager noises\n"
				+ "Villager noisesVillager noisesVillager noises");
		Start.tfState = VillagerState.instance(); 
	}
	
	public void makeDecision(String decision) {
		Random rnd = new Random();
		
		if(decision.trim().equalsIgnoreCase("YES") || decision.trim().equalsIgnoreCase("NO")) {
			if(decision.trim().equalsIgnoreCase("YES")) {
				Item RndItem = ItemFactory.getItem(SingletonMap.getInstance()
						.getItemNames()[rnd.nextInt(SingletonMap.getInstance()
								.getItemNames().length)],this.position.player);
				this.position.player.inventory.add(RndItem);
				Start.ta.append("\n"+RndItem.getName()+" has been added to your inventory.");
				Start.tfState = PlayState.instance();
			}
			else if(decision.trim().equalsIgnoreCase("NO")) {
				Start.ta.append("\n*Disappointed villager noises*");
				Start.tfState = PlayState.instance();
			}
			else
				Start.ta.append("*Confused villager noises*");
		}
	}
}
