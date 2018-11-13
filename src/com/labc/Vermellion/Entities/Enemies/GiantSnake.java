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
		if(this.HP<=0) {
			this.die();
			Start.ta.append("\nSSssssss...");
			Start.ta.append("\nThe giant snake died.");
		}
			
		else
			this.attack();
	}
	
	@Override
	public void die() {
		super.die();
		this.position.mob = null;
		this.position.hasEnemy = false;
		this.position.shortDescription = this.position.descripts.shortDescsAftFight.get(this.getName());
		this.position.longDescription = this.position.descripts.longDescsAftFight.get(this.getName());
	}
	
	@Override
	public void beShot(int damage) {
		super.beShot(damage);
		Start.ta.append("SSSSssSSSSSSSs!!>:(<");
		this.HP -= damage;
		if(this.HP<=0) {
			Start.ta.append("\nSSssssss...");
			this.die();
			Start.ta.append("\nThe giant snake died.");
		}
			
	}
	
	@Override
	public void create() {
		super.create();
		this.HP =  1500;
		this.ATTACK = 300;
		this.name = "GiantSnake";
	}
	
	@Override
	public void talk() {
		Start.ta.setText("SssssssssssSSssSsSs");
		this.attack();
	}

	@Override
	public void attack() {
		int totalDamage = position.player.getHP() - CalculateDamage();
		Start.ta.append("\nSSSSSSSsssSSSSsSSSS!!!!!");
		position.player.setHP(totalDamage);
		Poison();
		Start.ta.append("\nThe "+this.name+" dealt "+CalculateDamage()+" damage to you.\n"
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
