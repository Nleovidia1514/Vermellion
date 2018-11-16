package com.labc.Vermellion.Entities.Enemies;

import com.labc.Vermellion.Descriptions;
import com.labc.Vermellion.Entity;
import com.labc.Vermellion.Item;
import com.labc.Vermellion.Start;
import com.labc.Vermellion.Entities.EntityDecorator;
import com.labc.Vermellion.Entities.NPCs.Villager;
import com.labc.Vermellion.Items.Equipment;
import com.labc.Vermellion.Items.ItemFactory;

public class Creeper extends EntityDecorator implements AttackAble {
	
	public Creeper(Entity entity) {
		super(entity);
	}

	@Override
	public void attack() {
		int totalDamage = (int) (position.player.getHP() - CalculateDamage());
		Start.ta.append("\nPsssssssssst...");
		position.player.setHP(totalDamage);
		Start.ta.append("\nThe "+this.name+" exploded and dealt "+CalculateDamage()+" damage to you. " 
		+"Allahu akbar.");
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
		this.die();
	}

	@Override
	public void beAttacked(int damage) {
		super.beAttacked(damage);
		Start.ta.append("\nPssssssssstt... x_x");
		Start.ta.append("\nYou dealt "+damage+" damage to the Creeper.");
		this.HP -= damage;
		if(this.HP<=0) {
			Start.ta.append("\nPsssssssssst D:");
			this.die();
		}
		else
			this.attack();
	}

	@Override
	public void die() {
		this.position.mob = null;
		this.position.hasEnemy = false;
		this.position.shortDescription = this.position.descripts.shortDescsAftFight.get(this.position.name);
		this.position.longDescription = this.position.descripts.longDescsAftFight.get(this.position.name);
		this.position.lookImage = this.position.image = Descriptions.picAfterFight.get(this.position.name);
		Start.pic.setIcon(Descriptions.picAfterFight.get(this.position.name));
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
		Start.ta.setText("Pssssssssssssssssssssssssst.");
		this.attack();
	}
	
	@Override
	public void create() {
		super.create();
		this.HP = this.HP + 100;
		this.ATTACK = this.ATTACK + 250;
		this.name = "Green Creature";
	}
	
	@Override
	public void beShot(int damage) {
		super.beShot(damage);
		Start.ta.append("\nPssssssssstt... x_x");
		this.HP -= damage;
		if(this.HP<=0) {
			Start.ta.append("\nPsssssssssst D:");
			this.die();
			}
			
	}
	

	private int CalculateDamage() {
		int damage = this.ATTACK-this.getPos().player.getResistance();
		if(damage < 0)
			damage = 0;
		return damage;
	}

}
