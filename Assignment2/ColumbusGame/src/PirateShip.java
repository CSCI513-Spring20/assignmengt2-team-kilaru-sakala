import java.awt.Point;
import java.util.Random;
import java.util.Observable;
import java.util.Observer;

public class PirateShip implements Observer{
	Point currentShipPosition; //Current position of the ship
	Point currentPirateShipLocation; //Current position of the pirate ship
    OceanMap oceanMap;
    int[][] myGrid;
    Random rand = new Random(); 

    //COnstructor of the class
	public PirateShip(OceanMap oceanMap) {
		this.oceanMap = oceanMap;
	    this.myGrid = oceanMap.getMap();
	}
	
	//returns the pirate ship current position
	public Point getPirateShipLocation() {
		return this.currentPirateShipLocation;
	}
	
	// initial positions of the pirate ships
	public void placePirateShip(){
		boolean isPirateShipPlaced = false;
		int xPosition = 0;
		int yPosition = 0;
		while(!isPirateShipPlaced){
			xPosition = rand.nextInt(10);
			yPosition = rand.nextInt(10);
			while(myGrid[xPosition][yPosition] == 3){
				xPosition = rand.nextInt(10);
				yPosition = rand.nextInt(10);
			}
	        if(myGrid[xPosition][yPosition] == 0 && myGrid[xPosition][yPosition] != 2 && myGrid[xPosition][yPosition] != 3){
	        	isPirateShipPlaced = true;
	        	myGrid[xPosition][yPosition] = 3;
	        }
	     }
		this.currentPirateShipLocation = new Point(xPosition,yPosition);
	}
	
	@Override
	public void update(Observable o, Object arg) {
		if(o instanceof Ship){
			this.currentShipPosition = ((Ship)o).getShipLocation();
			movePirateShip();
		  }
		
	}
	
	//updates the position of pirate ship based on movement of ship
	public void movePirateShip(){  
		int ship_x = this.currentShipPosition.x;
		int ship_y = this.currentShipPosition.y;
		int pship_x = this.currentPirateShipLocation.x; 
		int pship_y = this.currentPirateShipLocation.y;
		
		if (pship_x <9 && (pship_x - ship_x < 0) && pship_y<9 && (pship_y - ship_y < 0)) {
			if(this.myGrid[(pship_x) + 1][pship_y + 1] != 1) {
				this.currentPirateShipLocation.x++;
				this.currentPirateShipLocation.y++;
			}
		}
		
		else if(pship_x <9 && (pship_x - ship_x < 0) && pship_y >0 && (pship_y - ship_y > 0)) {
			if(this.myGrid[(pship_x) + 1][pship_y - 1] != 1) {
				this.currentPirateShipLocation.x++;
				this.currentPirateShipLocation.y--;
			}
		}
		else if(pship_x >0 && (pship_x - ship_x > 0) && pship_y >0 && (pship_y - ship_y > 0)) {
			if(this.myGrid[(pship_x) - 1][pship_y - 1] != 1) {
				this.currentPirateShipLocation.x--;
				this.currentPirateShipLocation.y--;
			}
		}
		else if(pship_x >0 && (pship_x - ship_x > 0) && pship_y <9 && (pship_y - ship_y < 0)) {
			if(this.myGrid[(pship_x) - 1][pship_y + 1] != 1) {
				this.currentPirateShipLocation.x--;
				this.currentPirateShipLocation.y++;
			}
		}
		else if(pship_x <9 && (pship_x - ship_x < 0)) {
			if(this.myGrid[(pship_x) + 1][pship_y] != 1) {
				this.currentPirateShipLocation.x++;
			}	 
		 }
		 else if (pship_x >0 && (pship_x - ship_x > 0)){
			 if(this.myGrid[(pship_x) - 1][pship_y] != 1) {
				 this.currentPirateShipLocation.x--;
			 }	 
		 }
		 
		 else if (pship_y <9 && (pship_y - ship_y < 0)) {
			 if(this.myGrid[(pship_x)][pship_y +1] != 1) {
				 this.currentPirateShipLocation.y++;
			 }	 
		 }
		 else if (pship_y >0 && (pship_y - ship_y > 0)){
			if(this.myGrid[(pship_x)][pship_y - 1] != 1) {
				this.currentPirateShipLocation.y--;
			} 
		 }
		
	}
}
