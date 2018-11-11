package com.labc.Vermellion.Entities.Enemies;

import com.labc.Vermellion.PoisonedState;
import com.labc.Vermellion.Start;
import com.labc.Vermellion.Entities.Enemy;
import com.labc.Vermellion.Entities.EntityDecorator;

public class GiantSnake extends EntityDecorator implements AttackAble{

	public GiantSnake(Enemy enemy) {
		super(enemy);
	}

	@Override
	public void beAttacked(int damage) {
		super.beAttacked(damage);
		Start.ta.setText("You attacked the snake and dealt\n"
				+ damage + " damage to it. Snakes are gross.");
		this.HP-=damage;
		if(this.HP<=0)
			this.attack();
		else
			Start.ta.append("\nSSSSSSSSSssssSSSs");
	}
	
	@Override
	public void die() {
		super.die();
		this.position.mob = null;
		this.position.hasEnemy = false;
		this.position.shortDescription = this.position.descripts.shortDescsAftFight.get(this.getName());
		this.position.longDescription = this.position.descripts.longDescsAftFight.get(this.getName());
		Start.ta.append("\nSSssssss...");
		Start.ta.append("\nThe giant snake died.");
	}
	
	@Override
	public void beShot(int damage) {
		super.beShot(damage);
		Start.ta.append("SSSSssSSSSSSSs!!>:(<");
		Start.ta.append("\nYou made "+damage+" damage to the "+this.name+".");
		this.HP -= damage;
		if(this.HP<=0) 
			die();
	}
	
	@Override
	public void create() {
		super.create();
		this.HP = this.HP + 1500;
		this.ATTACK = this.ATTACK + 300;
		this.name = "GiantSnake";
	}
	
	@Override
	public void talk() {
		Start.ta.append("\nSssssssssssSSssSsSs");
		this.attack();
	}

	@Override
	public void attack() {
		int totalDamage = position.player.getHP() - CalculateDamage();
		Start.ta.append("SSSSSSSsssSSSSsSSSS!!!!!");
		position.player.setHP(totalDamage);
		Poison();
		Start.ta.append("\nThe "+this.name+" dealt "+totalDamage+" damage to you.\n"
				+ "and poisoned you for 3 turns.");
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
