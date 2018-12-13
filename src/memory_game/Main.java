package memory_game;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javafx.animation.FadeTransition;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;


public class Main extends Application{
	private static final int NUM_OF_PAIRS = 8;
	private static final int NUM_PER_ROW = 4;
	private Tile selected = null;
	private int clickCount = 2; //Number of mouse clicks allowed

	private Parent createContent() {
		Pane root = new Pane();
		root.setPrefSize(300, 300);
		
		//Create ArrayList of Tiles
		int c = 0;	
		List<Tile> tiles = new ArrayList<>();
		for (int i = 0; i < NUM_OF_PAIRS; i++) {
			tiles.add(new Tile(c));
			tiles.add(new Tile(c));
			c++;
		}
		

		//Shuffle the list and place the tiles in X and Y directions
		Collections.shuffle(tiles);
		for (int i = 0; i < tiles.size(); i++) {		
			Tile tile = tiles.get(i);
			tile.setTranslateX(50 * (i % NUM_PER_ROW));
			tile.setTranslateY(50 * (i / NUM_PER_ROW));							
			root.getChildren().add(tile);			
		}

		return root;

	}

	public void start(Stage primaryStage) {
		primaryStage.setScene(new Scene(createContent()));
		primaryStage.show();
	}	
	
private class Tile extends StackPane {
		
		private Text text = new Text();
		private Circle circle = new Circle(50, 50, 20);

		// Method to create a tile
		public Tile(int value) {
			
			/* HELP! (show the pairs with colors)
			if (value == 0) {circle.setFill(Color.BLUE);}
			if (value == 1) {circle.setFill(Color.AQUA);}
			if (value == 2) {circle.setFill(Color.RED);}
			if (value == 3) {circle.setFill(Color.GOLD);}
			if (value == 4) {circle.setFill(Color.GRAY);}
			if (value == 5) {circle.setFill(Color.GREEN);}
			if (value == 6) {circle.setFill(Color.ORCHID);}
			if (value == 7) {circle.setFill(Color.PERU);}*/
			

			circle.setStroke(Color.BLACK);
			circle.setFill(Color.BISQUE);

			text.setText(value+"");
			text.setFont(Font.font(30));

			setAlignment(Pos.CENTER);
			getChildren().addAll(circle, text);

			setOnMouseClicked(this::handleMouseClick);
			close();
		}

		//Create MouseClick eventHandler
		public void handleMouseClick(MouseEvent event) {
			if (isOpen() || clickCount == 0)
				return;

			clickCount--;

			if (selected == null) {
				selected = this;
				open(() -> {});
			}
			else {
				open(() -> {
					if (!hasSameValue(selected)) {
						selected.close();
						this.close();
					}

					selected = null;
					clickCount = 2;
				});
			}
		}

		//Check to see if a tile is visible
		public boolean isOpen() {
			return text.getOpacity() == 1;
		}
		
		//Create fading transition from invisible to visible
		public void open(Runnable action) {
			FadeTransition ft = new FadeTransition(Duration.seconds(0.5), text);			
			ft.setToValue(1);			
			ft.setOnFinished(e -> action.run());			
			ft.play();
		}
		
		//Create fading transition from visible to invisible
		public void close() {
			FadeTransition ft = new FadeTransition(Duration.seconds(0.5), text);
			ft.setToValue(0);
			ft.play();
		}

		//Check if the tiles have the same value
		public boolean hasSameValue(Tile other) {
			return text.getText().equals(other.text.getText());
		}
		
		//Check if the game is ended
	}

	public static void main(String[] args) {
		launch(args);
	}

}
