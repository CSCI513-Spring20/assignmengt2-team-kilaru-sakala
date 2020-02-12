import java.awt.Point;

public class Ship {
	Point currentLocation;
    OceanMap oceanMap;
    int[][] myGrid;

	public Ship(OceanMap oceanMap) {
		this.oceanMap = oceanMap;
	    this.currentLocation = oceanMap.getShipLocation();
	    this.myGrid = oceanMap.getMap();
	}
	
	public Point getShipLocation() {
		return this.currentLocation;
	}
	//[(this.currentLocation.x) + 1][this.currentLocation.y]
	public void goEast() {
		if (this.currentLocation.x<9) {
			if(this.myGrid[(this.currentLocation.x) + 1][this.currentLocation.y] != 1){
				this.currentLocation.x++;
			}
		}
	}

	public void goWest() {
		if(this.currentLocation.x >0){
			if(this.myGrid[(this.currentLocation.x) - 1][this.currentLocation.y] != 1){
				this.currentLocation.x--;
			}
		}   
	}

	public void goNorth() {
		if(this.currentLocation.y>0){
			if(this.myGrid[this.currentLocation.x][this.currentLocation.y-1] != 1){
				this.currentLocation.y--;
			}
		}    
	}

	public void goSouth() {
		if(this.currentLocation.y<9){
			if(this.myGrid[this.currentLocation.x][this.currentLocation.y+1] != 1){
				this.currentLocation.y++;
			}
		} 
	}
}
