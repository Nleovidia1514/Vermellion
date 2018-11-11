package com.labc.Vermellion.Entities.NPCs;

import com.labc.Vermellion.Entities.EntityDecorator;
import com.labc.Vermellion.Entities.NPC;

public class Villager extends EntityDecorator{

	public Villager(NPC npc) {
		super(npc);
		// TODO Auto-generated constructor stub
	}
	@Override
	public void create() {
		this.HP = 50;
		this.name = "Goddess";
	}

	@Override
	public void beAttacked(int damage) {
		this.HP -= damage;
	}

	@Override
	public void die() {
		this.position.mob = null;
		this.position.hasEnemy = false;
		this.position.shortDescription = this.position.descripts.shortDescsAftFight.get(this.position.name);
		this.position.longDescription = this.position.descripts.longDescsAftFight.get(this.position.name);
	}

	@Override
	public void beShot(int damage) {
		this.HP -= damage;
	}
}
