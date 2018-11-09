package com.labc.Vermellion;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Random;
import java.util.Scanner;

public class SingletonMap {
	public static int NORTH=0, EAST=1, SOUTH=2, WEST=3;
	public static int MapSize = 16;
	private Tile[][] tile = new Tile[MapSize][MapSize];
	private Scanner sn;
	private Random rnd = new Random();
	private String[] names = new String[200], itemNames = new String[]{"Apple","Bluepot",
			"Cachito","Chicha","Fungi","GreenPot","RedPot","SpaghettiOs","Axe","Bow",
			"Knive","Mind","Staff","Sword"};

	private volatile static SingletonMap obj; 

	private SingletonMap() throws FileNotFoundException {
		names[0] = "bandits";
		for(int i=0;i<MapSize;i++)
			for(int j=0;j<MapSize;j++) 
				tile[i][j] = new Tile(i,j,names[0],itemNames[rnd.nextInt(itemNames.length)]);
	
		for(int i=0;i<MapSize;i++)
			for(int j=0;j<MapSize;j++)
				tile[i][j].initNeightbors(tile);
		
		}

	public static SingletonMap getInstance() throws FileNotFoundException 
	{ 
		if (obj == null) 
		{ 
			synchronized (SingletonMap.class) 
			{ 
				if (obj==null) 
					obj = new SingletonMap(); 
			} 
		} 
		return obj; 
	} 
	
	private void setShortDescs(Tile[][] tile) throws FileNotFoundException {
		File[] descs = new File("descs/shorts").listFiles();
		int i=0;
		String description="";
		while(i<MapSize*MapSize) {
			for(File descriptions : descs) {
				description="";
				sn = new Scanner(descriptions);
				while(sn.hasNextLine())
					description = description + "\n" + sn.nextLine();
						
				//System.out.println(description);
				int z=0, k=0;
				while(tile[z][k].shortDescriptionSet()) {
					z = Start.rnd.nextInt(MapSize);
					k = Start.rnd.nextInt(MapSize);
				}
				
				i++;
			}
		}
	}
	
	private void setItemsOnFloor(Tile[][] tile) {
		for(Tile[] tiles : tile)
			for(Tile tiles1 : tiles);
				
	}
	
	public Tile getTile(int x,int y) {
		return tile[x][y];
	}
}
