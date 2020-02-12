import java.awt.Point;
import java.util.Random;

public class OceanMap{
	
	int dimension;
	int islandCount;
	int[][] myGrid;
	Random rand = new Random(); 
	Point currentLocation;
	
	public OceanMap(int dimension, int islandCount) {
		this.dimension = dimension;
		this.islandCount = islandCount;
		
		myGrid = new int[this.dimension][this.islandCount];
	    for(int x = 0; x < this.dimension; x++)
	    	for(int y = 0; y < this.islandCount; y++)
	    		myGrid[x][y] = 0;
	    
	    placeIslands();
	    currentLocation = placeShip();
	}

	
	// Return generated map
	public int[][] getMap(){
		 return myGrid;
	 }
	
	
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
	
	public Point placeShip(){
		boolean isShipPlaced = false;
		int xPosition = rand.nextInt(10);
		int yPosition = rand.nextInt(10); 
		while(!isShipPlaced){
	        if(myGrid[xPosition][yPosition] == 0){
	        	isShipPlaced = true;
	        	myGrid[xPosition][yPosition] = 2;
	        }
	     }
	     return new Point(xPosition,yPosition);
	}
	
	
	public Point getShipLocation() {
		return currentLocation;  
	}
	
	
}
