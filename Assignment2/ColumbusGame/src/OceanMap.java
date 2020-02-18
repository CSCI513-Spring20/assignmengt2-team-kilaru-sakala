import java.awt.Point;
import java.util.Random;

public class OceanMap{
	
	int dimension;
	int islandCount;
	int[][] myGrid;
	Random rand = new Random(); 
	Point currentShipLocation;
	
	//Constructor of the class to initialize grid and place the ship
	public OceanMap(int dimension, int islandCount) {
		this.dimension = dimension;
		this.islandCount = islandCount;
		
		myGrid = new int[this.dimension][this.islandCount];
	    for(int x = 0; x < this.dimension; x++)
	    	for(int y = 0; y < this.islandCount; y++)
	    		myGrid[x][y] = 0;
	    
	    placeIslands();
	    currentShipLocation = placeShip();
	}

	
	// Return generated map
	public int[][] getMap(){
		 return myGrid;
	 }
	
	
	// To place  islands on the grid
	public void placeIslands(){
		int count = this.islandCount;
		do{
			int x = rand.nextInt(10);
			int y = rand.nextInt(10);
			if(myGrid[x][y] == 0){
				myGrid[x][y] = 1;
				count--;
			}
		}while(count>0);
	}
	
	// To place ship on the grid
	public Point placeShip(){
		boolean isShipPlaced = false;
		int xPosition = 0;
		int yPosition = 0; 
		while(!isShipPlaced){
			xPosition = rand.nextInt(10);
			yPosition = rand.nextInt(10); 
	        if(myGrid[xPosition][yPosition] == 0){
	        	isShipPlaced = true;
	        	myGrid[xPosition][yPosition] = 2;
	        }
	     }
	     return new Point(xPosition,yPosition);
	}
	
	
	// returns the current ship position
	public Point getShipLocation() {
		return currentShipLocation;  
	}
	
	
}
