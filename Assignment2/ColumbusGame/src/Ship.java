import java.awt.Point;

public class Ship {
	Point currentShipLocation;
    OceanMap oceanMap;
    int[][] myGrid;

	public Ship(OceanMap oceanMap) {
		this.oceanMap = oceanMap;
	    this.currentShipLocation = oceanMap.getShipLocation();
	    this.myGrid = oceanMap.getMap();
	}
	
	public Point getShipLocation() {
		return this.currentShipLocation;
	}
	
	public void goEast() {
		if (this.currentShipLocation.x<9) {
			if(this.myGrid[(this.currentShipLocation.x) + 1][this.currentShipLocation.y] != 1){
				this.currentShipLocation.x++;
			}
		}
	}

	public void goWest() {
		if(this.currentShipLocation.x >0){
			if(this.myGrid[(this.currentShipLocation.x) - 1][this.currentShipLocation.y] != 1){
				this.currentShipLocation.x--;
			}
		}   
	}

	public void goNorth() {
		if(this.currentShipLocation.y>0){
			if(this.myGrid[this.currentShipLocation.x][this.currentShipLocation.y-1] != 1){
				this.currentShipLocation.y--;
			}
		}    
	}

	public void goSouth() {
		if(this.currentShipLocation.y<9){
			if(this.myGrid[this.currentShipLocation.x][this.currentShipLocation.y+1] != 1){
				this.currentShipLocation.y++;
			}
		} 
	}
}
