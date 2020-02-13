import java.awt.Point;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class OceanExplorer extends Application{
	
	final int dimension = 10;
	final int scale = 50;
	final int islandCount = 10;
	Pane root;
	Scene scene;
	Image shipImage, pirateShipImage, island;
	ImageView shipImageView, pirateShipImageView;
	Ship ship;
	Point startPosition;
	int[][] islandMap;
	OceanMap oceanMap;
	
	PirateShip pirateShip;


	@Override
	public void start(Stage oceanStage) throws Exception {
		oceanMap = new OceanMap(dimension, islandCount);
		islandMap = oceanMap.getMap();
		root = new AnchorPane();
		drawMap();
		
		ship = new Ship(oceanMap);
		
		loadShipImage();
		
		scene = new Scene(root, 500, 500);
		oceanStage.setTitle("Christopher columbus Sails The Blue Ocean");
		oceanStage.setScene(scene);
		oceanStage.show();
		startSailing();
		
		
	}
	
	public void drawMap() {
		for (int x = 0; x < dimension; x++) {
			for (int y = 0; y < dimension; y++) {
				Rectangle rect = new Rectangle(x * scale, y * scale, scale, scale);
				rect.setStroke(Color.BLACK); 
				if(islandMap[x][y] == 1) {
					island = new Image("\\island.jpg", 50, 50, true, true);
					ImagePattern imagePattern = new ImagePattern(island);
					rect.setFill(imagePattern);
                    //rect.setFill(Color.GREEN);
				}
				else {
					rect.setFill(Color.PALETURQUOISE);
				}
				root.getChildren().add(rect); 

			}
		}
	}
	
	public void loadShipImage() {
		shipImage = new Image("\\ship.png", 50, 50, true, true);
		shipImageView = new ImageView(shipImage);
		shipImageView.setX(oceanMap.getShipLocation().x * scale);
		shipImageView.setY(oceanMap.getShipLocation().y * scale);
		//root.getChildren().add(shipImageView);
		
		pirateShipImage = new Image("\\pirateShip.png", 50, 50, true, true);
		pirateShipImageView = new ImageView(pirateShipImage);
		pirateShipImageView.setX(oceanMap.getPirateShipLocation().x * scale);
		pirateShipImageView.setY(oceanMap.getPirateShipLocation().y * scale);
		
		root.getChildren().add(shipImageView);
		root.getChildren().add(pirateShipImageView);
	}
	
	private void startSailing() {
		scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
			@Override
			public void handle(KeyEvent ke) {
				switch (ke.getCode()) {
				case RIGHT:
					ship.goEast();
					break;
				case LEFT:
					ship.goWest();
					break;
				case UP:
					ship.goNorth();
					break;
				case DOWN:
					ship.goSouth();
					break;
				default:
					break;
				}
				shipImageView.setX(ship.getShipLocation().x * scale);
				shipImageView.setY(ship.getShipLocation().y * scale);
			}
		});

	}
	
	public static void main(String[] args) {
		launch(args);

	}

}
