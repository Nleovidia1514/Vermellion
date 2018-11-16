package com.labc.Vermellion.Entities.Enemies;

import java.util.Random;

import com.labc.Vermellion.Descriptions;
import com.labc.Vermellion.Entity;
import com.labc.Vermellion.Item;
import com.labc.Vermellion.SingletonMap;
import com.labc.Vermellion.Start;
import com.labc.Vermellion.Entities.EntityDecorator;
import com.labc.Vermellion.Entities.NPCs.Villager;
import com.labc.Vermellion.Items.Equipment;
import com.labc.Vermellion.Items.ItemFactory;

public class Bandits extends EntityDecorator implements AttackAble {

	public Bandits(Entity entity) {
		super(entity);
	}
	
	@Override
	public void attack() {
		Random rnd = new Random();
		int totalDamage = (int) position.player.getHP()-CalculateDamage();
		Start.ta.append("\nThe bandits try to steal items from you.");
		if(position.player.inventory.size()>0) {
			Item itemStolen = this.position.player.inventory.get(rnd.nextInt(position.player.inventory.size()));
			if(itemStolen.isStarter) {
				Start.ta.append("\nThe bandits dealed "+CalculateDamage()+" damage to you"
						+ " and couldn't steal your item because it is binded to you by "
						+ "powers they do not understand.");
			}
			else {
				Start.ta.append("\nThe bandits dealed "+CalculateDamage()+" damage to you and"
						+ " stole "+itemStolen.getName()
						+ " from your inventory.");
				position.player.inventory.remove(itemStolen);
				if(itemStolen.getClass().getSuperclass().getSimpleName().equalsIgnoreCase("Equipment")){
					Equipment itemThatWasStolen = (Equipment) itemStolen;
					if(this.position.player.equipment[itemThatWasStolen.getCategory()].equalsIgnoreCase(itemThatWasStolen.getClass().getSimpleName()))
					{
						itemThatWasStolen.getOwner().setMaxHP(itemThatWasStolen.getOwner().getMaxHP()-itemThatWasStolen.HP);
						itemThatWasStolen.getOwner().setSTR(itemThatWasStolen.getOwner().getSTR()-itemThatWasStolen.STR);
						itemThatWasStolen.getOwner().setResistance(itemThatWasStolen.getOwner().getResistance()-itemThatWasStolen.RESISTANCE);
						itemThatWasStolen.getOwner().setMaxMagic(itemThatWasStolen.getOwner().getMaxMagic()-itemThatWasStolen.MAGIC);
						itemThatWasStolen.getOwner().setIllusion(itemThatWasStolen.getOwner().getIllusion()-itemThatWasStolen.ILLUSION);
						itemThatWasStolen.getOwner().setBagredad(itemThatWasStolen.getOwner().getBagredad()-itemThatWasStolen.BAGREDAD);
						itemThatWasStolen.getOwner().setSneak(itemThatWasStolen.getOwner().getSneak()-itemThatWasStolen.SNEAK);
						itemThatWasStolen.getOwner().setBlock(itemThatWasStolen.getOwner().getBlock()-itemThatWasStolen.BLOCK);
						itemThatWasStolen.getOwner().setAccuracy(itemThatWasStolen.getOwner().getAccuracy()-itemThatWasStolen.ACCURACY);
						itemThatWasStolen.getOwner().equipment[itemThatWasStolen.getCategory()] = null;
						Start.ta.append("\nYour stolen item has been unequipped.");
					}
				}
			}
		}
		else		
			Start.ta.append("\nThe bandits dealed "+CalculateDamage()+" damage to you and"
					+ " couldn't steal anything because you're poor");
		position.player.setHP(totalDamage);
		
		for(String damage : this.position.player.equipment)
		{
			for(int i=0;i<this.position.player.inventory.size();i++) {
				try {
					Equipment piece = (Equipment) this.position.player.inventory.get(i);
					if(piece.getName().equalsIgnoreCase(damage) 
							&& piece.getCategory() != Equipment.weapon )
						piece.reduceDurability();
				}catch(Exception e) {}
			}
		}
	}

	@Override
	public void beAttacked(int damage) {
		Start.ta.append("\n*Gruntled bandits sounds*");
		Start.ta.append("\nYou dealt "+damage+" damage to the "+this.name+".");
		this.HP -= damage;
		if(this.HP<=0) {
			Start.ta.append("\nBandits started to scatter.");
			Start.ta.append("\nThe bandits died.");
			die();
		}
		else
			this.attack();
	}
	
	@Override 
	public void beShot(int damage) {
		this.HP = this.HP - damage;
		Start.ta.append("\n*Gruntled bandits sounds*");
		if(this.HP<=0) {
			Start.ta.append("\nBandits started to scatter.");
			this.die();
		}
	}

	@Override
	public void die() {
		Start.pic.setIcon(Descriptions.picAfterFight.get(this.position.name));
		this.position.mob = null;
		this.position.hasEnemy = false;
		this.position.shortDescription = this.position.descripts.shortDescsAftFight.get(this.position.name);
		this.position.longDescription = this.position.descripts.longDescsAftFight.get(this.position.name);
		this.position.lookImage = this.position.image = Descriptions.picAfterFight.get(this.position.name);
		if(this.position.player.inventory.size()<this.position.player.getBagSize()) {
			Item itemDropped = ItemFactory.getItem(Villager.itemNames[Start.rnd.nextInt(Villager.itemNames.length)], this.position.player);
			this.position.player.inventory.add(itemDropped);
			Start.ta.append("The "+this.name+" died and dropped "+itemDropped.getName()+" and it was added to your inventory.");
		}
		else
			Start.ta.append("\nThe "+this.name+" died. Your inventory is full.");
	}
	
	@Override
	public void talk() {
		Start.ta.setText("This' no time to talk. Shut the fuck up bitch.");
		this.attack();
	}
	
	@Override
	public void create() {
		super.create();
		this.HP = this.HP + 200;
		this.ATTACK = this.ATTACK + 200;
		this.name = "Bandits";
	}
	
	private int CalculateDamage() {
		int damage = this.ATTACK-this.getPos().player.getResistance();
		if(damage < 0)
			damage = 0;
		return damage;
	}
}
