import java.awt.Point;
import java.util.Observable;
import java.util.Observer;

public class PirateShip implements Observer{
	Point currentShipPosition; //Current position of the ship
	Point currentPirateShipLocation; //Current position of the pirate ship
    OceanMap oceanMap;
    int[][] myGrid;

	public PirateShip(OceanMap oceanMap) {
		this.oceanMap = oceanMap;
	    this.currentPirateShipLocation = oceanMap.getPirateShipLocation();
	    this.myGrid = oceanMap.getMap();
	}
	
	public Point getPirateShipLocation() {
		return this.currentPirateShipLocation;
	}
	
	@Override
	public void update(Observable o, Object arg) {
		if(o instanceof Ship){
			this.currentShipPosition = ((Ship)o).getShipLocation();
			movePirateShip();
		  }
		
	}
	
	//@Override
	public void update(Ship ship) {
		if(ship instanceof Ship){
			this.currentShipPosition = ((Ship)ship).getShipLocation();
			movePirateShip();
		  }
		
	}
	
	public void movePirateShip(){
		
		if (this.currentPirateShipLocation.x - this.currentShipPosition.x < 0) {
			this.currentPirateShipLocation.x++;
		}
		else {
			this.currentPirateShipLocation.x--;
		 }
		 
		if (this.currentPirateShipLocation.y - this.currentShipPosition.y < 0) {
			 this.currentPirateShipLocation.y++;
		 }
		 else {
			 this.currentPirateShipLocation.y--;
		 }
		
	}

	

}
