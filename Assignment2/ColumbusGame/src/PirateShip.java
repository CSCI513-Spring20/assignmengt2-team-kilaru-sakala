import java.awt.Point;

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
	
	public Point getShipLocation() {
		return this.currentPirateShipLocation;
	}

	@Override
	public void update(Ship ship) {
		if(ship instanceof Ship){
			currentShipPosition = ((Ship)ship).getShipLocation();
			movePirateShip();
		  }
		
	}
	
	public void movePirateShip(){
		
	}
}
