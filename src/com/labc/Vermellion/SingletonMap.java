package com.labc.Vermellion;

import java.util.Random;

public class SingletonMap {
	public static int NORTH=0, EAST=1, SOUTH=2, WEST=3;
	public static int MapSize = 8;
	private Tile[][] tile = new Tile[MapSize][MapSize];
	private Random rnd = new Random();
	private static String[] Easynames = new String[]{"bandits","forest","lake","plains","swamp","village","sabeis"};
	private static String[] Hardnames = new String[] {"wasteland","woods","forest","cave"};
	private static String[] itemNames = new String[]{"Apple","Bluepot","Cachito","Chicha","Fungi",
	"GreenPot","RedPot","SpaghettiOs","Axe"};
	private volatile static SingletonMap obj; 

	private SingletonMap() {
		innitMap();
		}
	
	private void innitMap() {
		for(int i=0;i<MapSize;i++) 
			for(int j=0;j<MapSize/2;j++) 
				tile[i][j] = new Tile(i,j,Easynames[rnd.nextInt(Easynames.length)],
						itemNames[rnd.nextInt(itemNames.length)]);

		for(int i=0;i<MapSize;i++) 
			for(int j=MapSize/2;j<MapSize;j++)
				tile[i][j] = new Tile(i,j,Hardnames[rnd.nextInt(Hardnames.length)],
						itemNames[rnd.nextInt(itemNames.length)]);
			
		
		for(int i=0;i<MapSize;i++)
			for(int j=0;j<MapSize;j++)
				tile[i][j].initNeightbors(tile);
		
		innitMountain();
		Descriptions.innitPics();
		
		for(int i = 0; i<MapSize;i++)
			for(int j= 0; j<MapSize;j++) {
			tile[i][j].setDescs();
			tile[i][j].image = Descriptions.picBeforeFight.get(tile[i][j].getName());
			tile[i][j].lookImage = Descriptions.lookImage.get(tile[i][j].getName());
			//System.out.println(tile[i][j].getName());
			}
		
		for(int i = MapSize-1; i>=0;i--) {
			for(int j=0; j<MapSize;j++) {
				System.out.format("%-20s",tile[j][i].getName()+"\t");
			}
			System.out.println("\n");
		}
			
	}
	
	private void innitMountain() {
		int RndX = rnd.nextInt(MapSize), RndY = rnd.nextInt(MapSize) ;
		Tile mountain;
		Tile[] mountainSurroundings;
		while( RndY<MapSize/2 )
			RndY = rnd.nextInt(MapSize);
		mountain = tile[RndX][RndY];
		mountain.name = "mountain";
		mountainSurroundings = mountain.getNeighbors();
		for(Tile neighbors : mountainSurroundings) {
			if(neighbors != null && neighbors != mountain ) {
				neighbors.name = "mountainSurroundings";
				//System.out.println("Sourrounding: "+neighbors.x+","+neighbors.y);
				}
			}
		for(Tile neighbors : mountainSurroundings) {
			if(neighbors!=null) {
				for(Tile neighbors2 : neighbors.getNeighbors()) {
					if(neighbors2!=null && !neighbors2.name.equalsIgnoreCase("mountainSurroundings")
							&& neighbors2 != mountain) {
						if(neighbors2 == neighbors.getNeighbors()[SingletonMap.NORTH])
							neighbors2.name = "mountainViewSouth";
						else if(neighbors2 == neighbors.getNeighbors()[SingletonMap.SOUTH])
							neighbors2.name = "mountainViewNorth";
						else if(neighbors2 == neighbors.getNeighbors()[SingletonMap.WEST])
							neighbors2.name = "mountainViewEast";
						else if(neighbors2 == neighbors.getNeighbors()[SingletonMap.EAST])
							neighbors2.name = "mountainViewWest";
						
						if(neighbors2.getNeighbors()[SingletonMap.NORTH]!=null && neighbors2.getNeighbors()[SingletonMap.WEST]!=null &&
								neighbors2.getNeighbors()[SingletonMap.NORTH].getName().equals("mountainSurroundings")
								&& neighbors2.getNeighbors()[SingletonMap.WEST].getName().equals("mountainSurroundings"))
							neighbors2.name = "mountainViewNorthWest";
						
						else if(neighbors2.getNeighbors()[SingletonMap.NORTH]!=null && neighbors2.getNeighbors()[SingletonMap.EAST]!=null&&
								neighbors2.getNeighbors()[SingletonMap.NORTH].getName().equals("mountainSurroundings")
								&& neighbors2.getNeighbors()[SingletonMap.EAST].getName().equals("mountainSurroundings"))
							neighbors2.name = "mountainViewNorthEast";
						
						else if(neighbors2.getNeighbors()[SingletonMap.SOUTH]!=null && neighbors2.getNeighbors()[SingletonMap.EAST]!=null&&
								neighbors2.getNeighbors()[SingletonMap.SOUTH].getName().equals("mountainSurroundings")
								&& neighbors2.getNeighbors()[SingletonMap.EAST].getName().equals("mountainSurroundings"))
							neighbors2.name = "mountainViewSouthEast";
						
						else if(neighbors2.getNeighbors()[SingletonMap.SOUTH]!=null && neighbors2.getNeighbors()[SingletonMap.WEST]!=null&&
								neighbors2.getNeighbors()[SingletonMap.SOUTH].getName().equals("mountainSurroundings")
								&& neighbors2.getNeighbors()[SingletonMap.WEST].getName().equals("mountainSurroundings"))
							neighbors2.name = "mountainViewSouthWest";
						//System.out.println(neighbors2.getName()+": "+neighbors2.x+","+neighbors2.y);
					}
				}
			}
		}
	}

	public static SingletonMap getInstance() 
	{ 
		if (obj == null) 
		{ 
			obj = new SingletonMap(); 
		} 
		return obj; 
	} 
	
	public Tile getTile(int x,int y) {
		return tile[x][y];
	}
	
	public String[] getItemNames() {
		return itemNames;
	}
	
	public String[] getTileNames() {
		return Easynames;
	}
}
