package com.labc.Vermellion.Entities.Enemies;

import com.labc.Vermellion.Descriptions;
import com.labc.Vermellion.Item;
import com.labc.Vermellion.Start;
import com.labc.Vermellion.Entities.BasicEntity;
import com.labc.Vermellion.Entities.Enemy;
import com.labc.Vermellion.Entities.EntityDecorator;
import com.labc.Vermellion.Items.Equipment;
import com.labc.Vermellion.Items.ItemFactory;

public class Bear extends EntityDecorator implements AttackAble{

	public Bear(Enemy enemy) {
		super(enemy);
	}

	@Override
	public void attack() {
		int totalDamage = (int) (position.player.getHP()-(CalculateDamage()));
		Start.ta.append("\n*Angry bear sounds*");
		position.player.setHP(totalDamage);
		Start.ta.append("\nThe bear dealt "+CalculateDamage()+" damage to you.");
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
		super.beAttacked(damage);
		Start.ta.append("\n*Hurted bear sounds*");
		Start.ta.append("\nYou dealt "+damage+" damage to the "+this.name+".");
		this.HP -= damage;
		if(this.HP<=0) {
			Start.ta.append("\n*Sad bear sounds*");
			this.die();
		}
		else
			this.attack();
			
	}
	
	@Override 
	public void beShot(int damage) {
		super.beShot(damage);
		this.HP = this.HP - damage;
		Start.ta.append("\n*Shot at bear sounds*");
		if(this.HP<=0) {
			Start.ta.append("\n*Sad bear sounds*");
			this.die();
		}
			
	}

	@Override
	public void die() {
		super.die();
		this.position.mob = null;
		this.position.hasEnemy = false;
		this.position.shortDescription = this.position.descripts.shortDescsAftFight.get(this.position.name);
		this.position.lookImage = Descriptions.picAfterFight.get(this.position.name);
		Start.pic.setIcon(Descriptions.picAfterFight.get(this.position.name));
		this.position.longDescription = this.position.descripts.longDescsAftFight.get(this.position.name);
		if(this.position.player.inventory.size()<this.position.player.getBagSize()) {
			Item itemDropped = ItemFactory.getItem(BasicEntity.goodDrops[Start.rnd.nextInt(BasicEntity.goodDrops.length)], this.position.player);
			this.position.player.inventory.add(itemDropped);
			Start.ta.append("\nThe "+this.name+" died and dropped "+itemDropped.getName()+" and it was added to your inventory.");
		}
		else
			Start.ta.append("\nThe "+this.name+" died. Your inventory is full.");
	}
	
	@Override 
	public void talk() {
		Start.ta.setText("*Confused bear sounds*");
		this.attack();
	}
	
	@Override
	public void create() {
		super.create();
		this.HP = this.HP + 400;
		this.ATTACK = this.ATTACK + 300;
		this.name = "Bear";
	}
	
	
	private int CalculateDamage() {
		int damage = this.ATTACK-this.getPos().player.getResistance();
		if(damage < 0)
			damage = 0;
		return damage;
	}
}
