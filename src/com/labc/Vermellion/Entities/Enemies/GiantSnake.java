package com.labc.Vermellion.Entities.Enemies;

import com.labc.Vermellion.Descriptions;
import com.labc.Vermellion.Item;
import com.labc.Vermellion.PoisonedState;
import com.labc.Vermellion.Start;
import com.labc.Vermellion.Entities.Enemy;
import com.labc.Vermellion.Entities.EntityDecorator;
import com.labc.Vermellion.Entities.NPCs.Villager;
import com.labc.Vermellion.Items.Equipment;
import com.labc.Vermellion.Items.ItemFactory;

public class GiantSnake extends EntityDecorator implements AttackAble{

	public GiantSnake(Enemy enemy) {
		super(enemy);
	}

	@Override
	public void beAttacked(int damage) {
		super.beAttacked(damage);
		Start.ta.append("\nYou attacked the snake and dealt "
				+ damage + " damage to it. Snakes are gross.");
		this.HP-=damage;
		if(this.HP<=0) {
			Start.ta.append("\nSSssssss...");
			this.die();
		}
			
		else
			this.attack();
	}
	
	@Override
	public void die() {
		this.position.mob = null;
		this.position.hasEnemy = false;
		this.position.shortDescription = this.position.descripts.shortDescsAftFight.get(this.getName());
		this.position.lookImage = this.position.image = Descriptions.picAfterFight.get(this.position.name);
		Start.pic.setIcon(Descriptions.picAfterFight.get(this.position.name));
		this.position.longDescription = this.position.descripts.longDescsAftFight.get(this.getName());
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
		Start.ta.append("\nSSSSssSSSSSSSs!!>:(<");
		this.HP -= damage;
		if(this.HP<=0) {
			Start.ta.append("\nSSssssss...");
			this.die();
		}
			
	}
	
	@Override
	public void create() {
		super.create();
		this.HP =  1500;
		this.ATTACK = 400;
		this.name = "GiantSnake";
	}
	
	@Override
	public void talk() {
		Start.ta.setText("SssssssssssSSssSsSs");
		this.attack();
	}

	@Override
	public void attack() {
		int totalDamage = (int) (position.player.getHP() - CalculateDamage());
		Start.ta.append("\nSSSSSSSsssSSSSsSSSS!!!!!");
		position.player.setHP(totalDamage);
		Poison();
		Start.ta.append("\nThe "+this.name+" dealt "+CalculateDamage()+" damage to you. "
				+ "and poisoned you for 3 turns.");
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
	
	private void Poison() {
		this.position.player.setCharacterState(PoisonedState.instance());
		PoisonedState.instance().turnsPoisoned = 3;
		PoisonedState.instance().turnsSuffered = 0;
	}
	
	private int CalculateDamage() {
		int damage = this.ATTACK-this.getPos().player.getResistance();
		if(damage < 0)
			damage = 0;
		return damage;
	}
}
