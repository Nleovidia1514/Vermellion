package com.labc.Vermellion;

import javax.swing.Icon;
import javax.swing.ImageIcon;

public class Tile implements Element{
	int x;
	int y;
	public String name, shortDescription = "There is nothing here", longDescription = "There is nothing you can do here";
	public Entity mob;
	public Character player;
	public boolean hasRiver, hasTree, hasLake, hasEnemy, canShoot;
	private Tile[] neighbors = new Tile[4];
	private String itemOnFloor;
	public Descriptions descripts;
	public ImageIcon image;
	public Icon lookImage;
	
	
	public Tile(int x , int y, String name, String itemOnF){
		this.name = name;
		this.x=x;
		this.y=y;
		this.hasEnemy=false;
		this.hasTree = true;
		this.player = null;
		this.itemOnFloor = itemOnF;
		this.canShoot = true;
	}
	
	public void initNeightbors(Tile[][] tile) {
		neighbors[SingletonMap.NORTH] = this.y==SingletonMap.MapSize-1?null:tile[x][y+1];
		neighbors[SingletonMap.SOUTH] = this.y==0?null:tile[x][y-1];
		neighbors[SingletonMap.EAST] = this.x==SingletonMap.MapSize-1?null:tile[x+1][y];
		neighbors[SingletonMap.WEST] = this.x==0?null:tile[x-1][y];
	}
	
	public void setDescs() {
		this.descripts = new Descriptions(this);
		this.shortDescription = descripts.shortDescs.get(name) ;
		this.longDescription = descripts.longDescs.get(name);
		this.mob = descripts.Entities.get(name);
	}
	
	public String getLongDescription() {
		return this.longDescription;
	}
	
	public String getShortDescription() {
		return this.shortDescription;
	}
	public Tile[] getNeighbors() {
		return this.neighbors;
	}
	
	public String getItemOnFloor() {
		return this.itemOnFloor;
	}
	
	public void setItemOnFloor(String itemonf) {
		this.itemOnFloor = itemonf;
	}
	
	public String getName() {
		return this.name;
	}

	@Override
	public void accept(Visitor v) {
		if(this.name.equals("mountain")) {
			Start.gameIsRunning = false;
		}
		Start.pic.setIcon(this.image);
		Start.TileTitle.setText(this.name.toUpperCase());
		Start.ta.append(this.getShortDescription());
		v.Visit(this);
	}
}
