package com.labc.Vermellion.Entities.Enemies;

import com.labc.Vermellion.Start;
import com.labc.Vermellion.Entities.Enemy;
import com.labc.Vermellion.Entities.EntityDecorator;

public class Minotaur extends EntityDecorator implements AttackAble {

	public Minotaur(Enemy enemy) {
		super(enemy);
	}

	@Override
	public void beAttacked(int damage) {
		super.beAttacked(damage);
		Start.ta.setText("You attacked the minotaur and dealt\n"
				+ damage + " damage to it. Does he fuck humans or horses?.");
		this.HP-=damage;
		if(this.HP<=0)
			this.attack();
		else
			Start.ta.append("\nYou will pay for that human!");
	}
	
	@Override
	public void die() {
		super.die();
		this.position.mob = null;
		this.position.hasEnemy = false;
		this.position.shortDescription = this.position.descripts.shortDescsAftFight.get(this.getName());
		this.position.longDescription = this.position.descripts.longDescsAftFight.get(this.getName());
		Start.ta.append("\nYou... deem... worthy... of it... x_x");
		Start.ta.append("\nThe minotaur died.");
	}
	
	@Override
	public void beShot(int damage) {
		super.beShot(damage);
		Start.ta.setText("You dealt "+ damage + " damage to the minotaur.\n"
						+ "Now it looks confused LUL.");
		this.HP-=damage;
		if(this.HP<=0)
			this.attack();
		else
			Start.ta.append("\nYou will pay for that human?");
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
		Start.ta.append("\nDon't you even dream about it human!!");
		this.attack();
	}

	@Override
	public void attack() {
		int totalDamage = position.player.getHP() - CalculateDamage();
		Start.ta.append("CHARGEEEEEEEEE!!!!");
		position.player.setHP(totalDamage);
		Start.ta.append("\nThe "+this.name+" dealt "+totalDamage+" damage to you\n"
				+ "and let you a bit dazzled.");
	}
	
	private int CalculateDamage() {
		int damage = this.ATTACK-this.getPos().player.getResistance();
		if(damage < 0)
			damage = 0;
		return damage;
	}
}