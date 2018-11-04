package com.labc.Vermellion;

public class Tile {
	private int x, y;
	private String description = "There is nothing here";
	private boolean hasEnemy;
	private boolean hasNPC;
	private Tile[] neighbors = new Tile[4];
	
	public Tile(int x , int y) {
		this.x=x;
		this.y=y;
		this.hasEnemy=false;
		this.hasNPC=false;
	}
	
	public void setDesc(String desc) {
		this.description = desc;
	}
	
	public void initNeightbors(Tile[][] tile) {
		neighbors[Map.NORTH] = this.y==Map.MapSize-1?null:tile[x][y+1];
		neighbors[Map.SOUTH] = this.y==0?null:tile[x][y-1];
		neighbors[Map.EAST] = this.x==Map.MapSize-1?null:tile[x+1][y];
		neighbors[Map.WEST] = this.x==0?null:tile[x-1][y];
	}
	
	public Tile[] getNeighbors() {
		return this.neighbors;
	}

}
