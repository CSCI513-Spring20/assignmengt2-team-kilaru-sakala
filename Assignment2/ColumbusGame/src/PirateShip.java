import java.awt.Point;

public class PirateShip {
	Point currentPirateShipLocation;
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
}
