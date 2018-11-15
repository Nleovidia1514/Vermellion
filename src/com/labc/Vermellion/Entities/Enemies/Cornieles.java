package com.labc.Vermellion.Entities.Enemies;

import com.labc.Vermellion.Start;
import com.labc.Vermellion.Entities.Enemy;
import com.labc.Vermellion.Entities.EntityDecorator;
import com.labc.Vermellion.Items.Equipment;

public class Cornieles extends EntityDecorator implements AttackAble{

	public Cornieles(Enemy enemy) {
		super(enemy);
	}
	
	@Override
	public void attack() {
		int totalDamage = position.player.getHP()-CalculateDamage();
		Start.ta.append("\nUstedes son unos expertos.");
		position.player.setHP(totalDamage);
		Start.ta.append("\n"+this.name+" dealt "+CalculateDamage()+" damage to you.");
		for(String damage : this.position.player.equipment)
		{
			for(int i=0;i<this.position.player.inventory.size();i++) {
				Equipment piece = (Equipment) this.position.player.inventory.get(i);
				if(piece.getName().equalsIgnoreCase(damage) 
						&& piece.getCategory() != Equipment.weapon )
					piece.reduceDurability();
			}
		}
	}

	@Override
	public void beAttacked(int damage) {
		super.beAttacked(damage);
		Start.ta.append("\nSabeeeeiiiiis.");
		Start.ta.append("\nYou dealt "+damage+" damage to "+this.name+".");
		this.HP -= damage;
		if(this.HP<=0) {
			Start.ta.append("\nNo puede ser nonononono.");
			Start.ta.append("\nCornieles died.");
			die();
		}	
		else
			this.attack();
			
	}

	@Override
	public void die() {
		super.die();
		this.position.mob = null;
		this.position.hasEnemy = false;
		this.position.shortDescription = this.position.descripts.shortDescsAftFight.get(this.position.name);
		this.position.longDescription = this.position.descripts.longDescsAftFight.get(this.position.name);
	}
	
	@Override
	public void talk() {
		Start.ta.setText("No te voy a subir la nota sabeeeisss." );
		this.attack();
	}
	
	@Override
	public void create() {
		super.create();
		this.HP = this.HP + 300;
		this.ATTACK = this.ATTACK + 150;
		this.name = "Cornieles";
	}
	
	@Override
	public void beShot(int damage) {
		super.beShot(damage);
		this.HP = this.HP - damage;
		Start.ta.append("Sabeeeeeiiiis.");
		if(this.HP<=0) {
			this.die();
			Start.ta.append("\nNo puede ser nonononono.");
			Start.ta.append("\nCornieles died.");
		}
			
	}
	
	private int CalculateDamage() {
		int damage = this.ATTACK-this.getPos().player.getResistance();
		if(damage < 0)
			damage = 0;
		return damage;
	}
}
