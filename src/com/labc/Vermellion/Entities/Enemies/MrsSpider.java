package com.labc.Vermellion.Entities.Enemies;

import com.labc.Vermellion.Descriptions;
import com.labc.Vermellion.Item;
import com.labc.Vermellion.Start;
import com.labc.Vermellion.Entities.BasicEntity;
import com.labc.Vermellion.Entities.Enemy;
import com.labc.Vermellion.Entities.EntityDecorator;
import com.labc.Vermellion.Items.Equipment;
import com.labc.Vermellion.Items.ItemFactory;

public class MrsSpider extends EntityDecorator implements AttackAble{

	public MrsSpider(Enemy entity) {
		super(entity);
		// TODO Auto-generated constructor stub
	}
	@Override
	public void beAttacked(int damage) {
		super.beAttacked(damage);
		Start.ta.append("\nYou attacked the misses spider and dealt "
				+ damage + ". She can't stop dancing apparently.");
		this.HP-=damage;
		if(this.HP<=0)
			this.die();
		else {
			Start.ta.append("\nYou'll see, insignificant human!");
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
		Start.ta.append("\nI will be reborn in one of my children and... i... wil..."
				+ "come...back... x_x");
		if(this.position.player.inventory.size()<this.position.player.getBagSize()) {
			Item itemDropped = ItemFactory.getItem(BasicEntity.goodDrops[Start.rnd.nextInt(BasicEntity.goodDrops.length)], this.position.player);
			this.position.player.inventory.add(itemDropped);
			Start.ta.append("\nThe "+this.name+" died and dropped "+itemDropped.getName()+". It was added to your inventory.");
		}
		else
			Start.ta.append("\nThe "+this.name+" died. Your inventory is full.");
	}
	
	@Override
	public void beShot(int damage) {
		super.beShot(damage);
		Start.ta.append("\nMisses spider has no clue where that came from xd.");
		this.HP-=damage;
		if(this.HP<=0)
			this.die();
	}
	
	@Override
	public void create() {
		super.create();
		this.HP = this.HP + 1500;
		this.ATTACK = this.ATTACK + 400;
		this.name = "Misses spider";
	}
	
	@Override
	public void talk() {
		if(!this.alreadyTalkedTo) {
			Start.ta.setText("MISSES SPIDER - HAHA! I'VE BEEN WAITING FOR THIS MOMENT SINCE I WAS A LITTLE EGG. "
					+ "THE MOMENT WHERE AN UNLUCKY LIVING BEING WALKS INTO MY SPIDER "
					+ "WEB AND LOSES IT'S LIFE. NOW THAT MOMENT HAS ARRIVED, AND YOU,"
					+ " MY DEAR FRIEND, ARE THE UNLUCKY LIVING BEING THIS TIME. SAY GOODBYE"
					+ " TO YOUR INSIGNIFICANT LIFE!!");
			this.alreadyTalkedTo = true;
		}
		else
			Start.ta.setText("MISSES SPIDER - YOU'RE AS STUPID AS YOU LOOK!");
	}

	@Override
	public void attack() {
		int totalDamage = (int) (position.player.getHP() - CalculateDamage());
		Start.ta.append("\nTAKE THAT STUPID BEING.");
		position.player.setHP(totalDamage);
		Start.ta.append("\nThe "+this.name+" dealt "+CalculateDamage()+" damage to you"
				+ " and it felt good for some reason. You're starting to think you might"
				+ " be a sadistic person.");
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
