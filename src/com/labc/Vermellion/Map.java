package com.labc.Vermellion;

import java.lang.reflect.Array;

public class Map {
	public static int NORTH=0, EAST=1, SOUTH=2, WEST=3;
	public static int MapSize = 16;
	private Tile[][] tile;
	
	public Map() {
		tile = new Tile[MapSize][MapSize];
		for(int i=0;i<MapSize;i++)
			for(int j=0;j<MapSize;j++)
				tile[j][i] = new Tile(i,j);
		
		for(int i=0;i<MapSize;i++)
			for(int j=0;j<MapSize;j++)
				tile[j][i].initNeightbors(tile);
	}
	
	public Tile getTile(int x,int y) {
		return tile[x][y];
	}
}
