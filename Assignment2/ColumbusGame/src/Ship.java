import java.awt.Point;
import java.util.LinkedList;
import java.util.List;

public class Ship implements Observable{
	List<Observer> observers = new LinkedList<Observer>();
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
				notifyObservers();
			}
		}
	}

	public void goWest() {
		if(this.currentShipLocation.x >0){
			if(this.myGrid[(this.currentShipLocation.x) - 1][this.currentShipLocation.y] != 1){
				this.currentShipLocation.x--;
				notifyObservers();
			}
		}   
	}

	public void goNorth() {
		if(this.currentShipLocation.y>0){
			if(this.myGrid[this.currentShipLocation.x][this.currentShipLocation.y-1] != 1){
				this.currentShipLocation.y--;
				notifyObservers();
			}
		}    
	}

	public void goSouth() {
		if(this.currentShipLocation.y<9){
			if(this.myGrid[this.currentShipLocation.x][this.currentShipLocation.y+1] != 1){
				this.currentShipLocation.y++;
				notifyObservers();
			}
		} 
	}

	@Override
	public void registerObserver(Observer o) {
		observers.add(o);
		
	}

	@Override
	public void removeObserver(Observer o) {
		if(observers.contains(o))
			observers.remove(o);
		
	}

	@Override
	public void notifyObservers() {
		for (Observer pirateShipObserver: observers)
			pirateShipObserver.update(this);
		
	}
}
