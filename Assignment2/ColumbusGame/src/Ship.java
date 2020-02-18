import java.awt.Point;
import java.util.LinkedList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

public class Ship extends Observable{
	List<Observer> observers = new LinkedList<Observer>();
	Point currentShipLocation;
    OceanMap oceanMap;
    int[][] myGrid;

    //Constructor of the class 
	public Ship(OceanMap oceanMap) {
		this.oceanMap = oceanMap;
	    this.currentShipLocation = oceanMap.getShipLocation();
	    this.myGrid = oceanMap.getMap();
	}
	
	// returns the current ship position
	public Point getShipLocation() {
		return this.currentShipLocation;
	}
	
	//Event handler: When the right arrow is pressed
	public void goEast() {
		if (this.currentShipLocation.x<9) {
			if(this.myGrid[(this.currentShipLocation.x) + 1][this.currentShipLocation.y] != 1){
				this.currentShipLocation.x++;
				notifyObservers();
			}
		}
	}
	
	//Event handler: When the left arrow is pressed
	public void goWest() {
		if(this.currentShipLocation.x >0){
			if(this.myGrid[(this.currentShipLocation.x) - 1][this.currentShipLocation.y] != 1){
				this.currentShipLocation.x--;
				notifyObservers();
			}
		}   
	}
	
	//Event handler: When the up arrow is pressed
	public void goNorth() {
		if(this.currentShipLocation.y>0){
			if(this.myGrid[this.currentShipLocation.x][this.currentShipLocation.y-1] != 1){
				this.currentShipLocation.y--;
				notifyObservers();
			}
		}    
	}
	
	//Event handler: When the down arrow is pressed
	public void goSouth() {
		if(this.currentShipLocation.y<9){
			if(this.myGrid[this.currentShipLocation.x][this.currentShipLocation.y+1] != 1){
				this.currentShipLocation.y++;
				notifyObservers();
			}
		} 
	}

	// Registers the observer pirate ship with the ship
	public void registerObserver(Observer o) {
		observers.add(o);
		
	}
	
	// Removes the observer pirate ship with the ship
	public void removeObserver(Observer o) {
		if(observers.contains(o))
			observers.remove(o);
		
	}

	//Notifies the observer when the ship position is changed
	public void notifyObservers() {
		for (Observer pirateShipObserver: observers)
			pirateShipObserver.update(this, pirateShipObserver);
		
	}
}
