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
	
	public void movePirateShip(){  
		int ship_x = this.currentShipPosition.x;
		int ship_y = this.currentShipPosition.y;
		int pship_x = this.currentPirateShipLocation.x; 
		int pship_y = this.currentPirateShipLocation.y;
		
		if (pship_x <9 && (pship_x - ship_x < 0)) {
			if(this.myGrid[(pship_x) + 1][pship_y] != 1) {
				this.currentPirateShipLocation.x++;
			}
		}
		else if(pship_x>0 && (pship_x - ship_x > 0)){
			if(this.myGrid[(pship_x) - 1][pship_y] != 1){
				this.currentPirateShipLocation.x--;
			}
		 }
		 
		if (pship_y<9 && (pship_y - ship_y < 0)) {
			if(this.myGrid[pship_x][pship_y+1] != 1){
				this.currentPirateShipLocation.y++;
			}
		 }
		 else if(pship_y>0 && (pship_y - ship_y > 0)){
			 if(this.myGrid[pship_x][pship_y-1] != 1) {
				 this.currentPirateShipLocation.y--;
			 }
		 }	
	}
}
