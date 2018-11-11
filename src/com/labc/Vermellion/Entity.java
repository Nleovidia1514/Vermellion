package com.labc.Vermellion;

public abstract class Entity {
	protected int HP;
	protected Tile position;
	protected String name;
	protected int ATTACK;
	protected boolean alreadyTalkedTo;
	
	protected Entity(Tile position) {
		this.position = position;
	}
	
	public abstract void beAttacked(int damage);
	public abstract void die();
	public abstract void beShot(int damage);
	public abstract void create();
	public abstract void talk();
	
	public String getName() {
		return this.name;
	}
	
	public Tile getPos() {
		return this.position;
	}
	
	public void setHP(int HP) {
		this.HP = HP;
	}

}
