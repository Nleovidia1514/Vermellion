package com.labc.Vermellion.Entities.Enemies;

import com.labc.Vermellion.Descriptions;
import com.labc.Vermellion.Item;
import com.labc.Vermellion.Start;
import com.labc.Vermellion.Entities.Enemy;
import com.labc.Vermellion.Entities.EntityDecorator;
import com.labc.Vermellion.Entities.NPCs.Villager;
import com.labc.Vermellion.Items.Equipment;
import com.labc.Vermellion.Items.ItemFactory;

public class Minotaur extends EntityDecorator implements AttackAble {

	public Minotaur(Enemy enemy) {
		super(enemy);
	}

	@Override
	public void beAttacked(int damage) {
		super.beAttacked(damage);
		Start.ta.append("\nYou attacked the minotaur and dealt "
				+ damage + " damage to it. Does he fuck humans or horses?.");
		this.HP-=damage;
		if(this.HP<=0)
			this.die();
		else {
			Start.ta.append("\nMinotaur - You will pay for that human!");
			this.attack();
		}
	}
	
	@Override
	public void die() {
		super.die();
		this.position.mob = null;
		this.position.hasEnemy = false;
		this.position.shortDescription = this.position.descripts.shortDescsAftFight.get(this.getName());
		this.position.lookImage = this.position.image = Descriptions.picAfterFight.get(this.position.name);
		Start.pic.setIcon(Descriptions.picAfterFight.get(this.position.name));
		this.position.longDescription = this.position.descripts.longDescsAftFight.get(this.getName());
		Start.ta.append("\nYou... deem... worthy... of it... x_x");
		if(this.position.player.inventory.size()<this.position.player.getBagSize()) {
			Item itemDropped = ItemFactory.getItem(Villager.itemNames[Start.rnd.nextInt(Villager.itemNames.length)], this.position.player);
			this.position.player.inventory.add(itemDropped);
			Start.ta.append("The "+this.name+" died and dropped "+itemDropped.getName()+" and it was added to your inventory.");
		}
		else
			Start.ta.append("\nThe "+this.name+" died. Your inventory is full.");
	}
	
	@Override
	public void beShot(int damage) {
		super.beShot(damage);
		Start.ta.setText("The minotaur looks confused LUL.");
		this.HP-=damage;
		if(this.HP<=0)
			this.die();
		else {
			Start.ta.append("\nYou will pay for that human...?");
		}
	}
	
	@Override
	public void create() {
		super.create();
		this.HP = this.HP + 2500;
		this.ATTACK = this.ATTACK + 450;
		this.name = "Minotaur";
	}
	
	@Override
	public void talk() {
		Start.ta.setText("\nDon't you even dream about it human!!");
		this.attack();
	}

	@Override
	public void attack() {
		int totalDamage = (int) (position.player.getHP() - CalculateDamage());
		Start.ta.append("\nCHARGEEEEEEEEE!!!!");
		position.player.setHP(totalDamage);
		Start.ta.append("\nThe "+this.name+" dealt "+CalculateDamage()+" damage to you"
				+ " and let you a bit dazzled.");
		for(String damage : this.position.player.equipment)
		{
			for(int i=0;i<this.position.player.inventory.size();i++) {
				try{
					Equipment piece = (Equipment) this.position.player.inventory.get(i);
					if(piece.getName().equalsIgnoreCase(damage) 
							&& piece.getCategory() != Equipment.weapon )
						piece.reduceDurability();
				}catch(Exception e) {}
			}
		}
	}
	
	private int CalculateDamage() {
		int damage = this.ATTACK-this.getPos().player.getResistance();
		if(damage < 0)
			damage = 0;
		return damage;
	}
}
