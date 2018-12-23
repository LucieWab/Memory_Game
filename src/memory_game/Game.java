package memory_game;


import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javafx.animation.FadeTransition;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;



public class Game extends Application{
	//Create the variables that we need for the programm
	private static final int NUM_OF_PAIRS = 8;
	private static final int NUM_PER_ROW = 4;
	private Tile selected = null;
	private int clickCount = 2; //Number of mouse clicks allowed
	private int counter = 0; //increase when a pair is founded
	private Stage stage;

	public Scene startScene()
	{
		//Set the music from a .mp3 file
		String uriString = new File("src/memory_game/theme.mp3").toURI().toString();
		    MediaPlayer player = new MediaPlayer( new Media(uriString));
		    player.play();
		    player.setAutoPlay(true);
		    
		//Create the Pane withe the Labels and the Buttons    
		Pane root = new Pane();
		Label nameGame = new Label("****THE MEMORY'S GAME****");

		Label instruction = new Label("\r\n" + 
				"    The objective is to collect every pairs of numbers.\r\n" + "\r\n" +
				"    Click on two circles to see if the numbers are the same. \r\n" + "\r\n" +
				"    If you successfully match a pair the numbers will remain visible\r\n" + "\r\n" +
				"    When you click on two circles that do not match, the numbers will disappear.\r\n" + "\r\n" +
				"    The trick is to remember which numbers are where.\r\n" + "\r\n" +
				"    You win when you find every pairs of numbers.\r\n" + "\r\n" +
				"    GOOD LUCK");


		Button button1 = new Button("START THE GAME");
		button1.setOnAction( e-> stage.setScene(gameScene()));

		nameGame.setLayoutX(150);

		instruction.setLayoutX(200);
		instruction.setLayoutY(75);

		button1.setLayoutX(300);
		button1.setLayoutY(450);

		nameGame.setFont(Font.font ("Century Schoolbook", 30));
		instruction.setFont(Font.font ("Century Schoolbook", 15));
		button1.setStyle("    -fx-background-color: \r\n" + 
				"        #090a0c,\r\n" + 
				"        linear-gradient(#38424b 0%, #1f2429 20%, #191d22 100%),\r\n" + 
				"        linear-gradient(#20262b, #191d22),\r\n" + 
				"        radial-gradient(center 50% 0%, radius 100%, rgba(114,131,148,0.9), rgba(255,255,255,0));\r\n" + 
				"    -fx-background-radius: 5,4,3,5;\r\n" + 
				"    -fx-background-insets: 0,1,2,0;\r\n" + 
				"    -fx-text-fill: white;\r\n" + 
				"    -fx-effect: dropshadow( three-pass-box , rgba(0,0,0,0.6) , 5, 0.0 , 0 , 1 );\r\n" + 
				"    -fx-font-family: \"Arial\";\r\n" + 
				"    -fx-text-fill: linear-gradient(white, #d0d0d0);\r\n" + 
				"    -fx-font-size: 12px;\r\n" + 
				"    -fx-padding: 10 20 10 20;");

		nameGame.setTextFill(Color.DARKSLATEBLUE);
		instruction.setTextFill(Color.CADETBLUE);
		button1.setTextFill(Color.CHOCOLATE);

		root.getChildren().addAll(button1, nameGame, instruction);
		button1.setPadding(new Insets(7, 7, 7, 7));

		return new Scene(root,850,600);
	}

	public Scene endScene()
	{
		//Set the end music		
		 String uriString = new File("src/memory_game/tortuga.mp3").toURI().toString();
				    MediaPlayer player = new MediaPlayer( new Media(uriString));
				    player.setAutoPlay(true);

		//Create the pane with the Labels and add the Buttons
		Pane root = new Pane();
		Label message = new Label("CONGRATULATION !");
		message.setLayoutY(150);
		message.setFont(Font.font ("Century Schoolbook", 30));
		message.setTextFill(Color.DARKSLATEBLUE);
		root.getChildren().addAll(createResumeButton(), createExitButton(), message);
		
		return new Scene(root,325,400);
	}

	public Scene gameScene() {

		//Create the BorderPane and return the Scene
		final BorderPane borderPane = new BorderPane();
		borderPane.setPadding(new Insets(7, 7, 7, 7));
		borderPane.setTop(createTopPane());
		borderPane.setCenter(createContent());
		borderPane.setLeft(createLeftPane());	
		return new Scene(borderPane,850,600);
	}

	public Parent createContent() {

		//Create the GridPane with the Tiles
		final GridPane gridPane = new GridPane();
		gridPane.setPadding(new Insets (7,7,7,7));

		gridPane.setHgap(25);
		gridPane.setVgap(25);		


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
			tile.setTranslateX(80 * (i % NUM_PER_ROW));
			tile.setTranslateY(80 * (i / NUM_PER_ROW));	
			gridPane.getChildren().add(tile);			
		}
		gridPane.getChildren().addAll(createResumeButton(),createExitButton());
		gridPane.setCursor(Cursor.OPEN_HAND);
		return gridPane;

	}

	private class Tile extends StackPane {

		private Text text = new Text();

		private Circle circle = new Circle(0, 0, 20);

		// Method to create a tile
		public Tile(int value) {

			circle.setStroke(Color.BLACK);
			circle.setFill(Color.DARKSLATEBLUE);

			text.setText(value+"");
			text.setFont(Font.font(30));
			text.setStyle("-fx-fill: white;");

			setAlignment(Pos.CENTER);
			getChildren().addAll(circle, text);

			text.setOnMouseClicked(this::handleMouseClick);
			circle.setOnMouseClicked(this::handleMouseClick);

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
					else {counter++;}
					selected = null;
					clickCount = 2;
					endGame();

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
		public void endGame() {
			if (counter == NUM_OF_PAIRS) {
				stage.setScene(endScene());
			}
		}
	}

	private Button createResumeButton() {

		Button resume = new Button("RESUME");
		resume.setTranslateX(15);
		resume.setTranslateY(325);
		resume.setStyle("    -fx-background-color: \r\n" + 
				"        #090a0c,\r\n" + 
				"        linear-gradient(#38424b 0%, #1f2429 20%, #191d22 100%),\r\n" + 
				"        linear-gradient(#20262b, #191d22),\r\n" + 
				"        radial-gradient(center 50% 0%, radius 100%, rgba(114,131,148,0.9), rgba(255,255,255,0));\r\n" + 
				"    -fx-background-radius: 5,4,3,5;\r\n" + 
				"    -fx-background-insets: 0,1,2,0;\r\n" + 
				"    -fx-text-fill: white;\r\n" + 
				"    -fx-effect: dropshadow( three-pass-box , rgba(0,0,0,0.6) , 5, 0.0 , 0 , 1 );\r\n" + 
				"    -fx-font-family: \"Arial\";\r\n" + 
				"    -fx-text-fill: linear-gradient(white, #d0d0d0);\r\n" + 
				"    -fx-font-size: 12px;\r\n" + 
				"    -fx-padding: 10 20 10 20;");

		resume.setTextFill(Color.AQUA);

		resume.setOnAction(e -> {
			counter =0;
			stage.setScene(gameScene());
			});
					
		return resume;

	}

	private Button createExitButton() {

		Button exit = new Button("   EXIT   ");

		exit.setTranslateX(230);
		exit.setTranslateY(325);
		exit.setStyle("    -fx-background-color: \r\n" + 
				"        #090a0c,\r\n" + 
				"        linear-gradient(#38424b 0%, #1f2429 20%, #191d22 100%),\r\n" + 
				"        linear-gradient(#20262b, #191d22),\r\n" + 
				"        radial-gradient(center 50% 0%, radius 100%, rgba(114,131,148,0.9), rgba(255,255,255,0));\r\n" + 
				"    -fx-background-radius: 5,4,3,5;\r\n" + 
				"    -fx-background-insets: 0,1,2,0;\r\n" + 
				"    -fx-text-fill: white;\r\n" + 
				"    -fx-effect: dropshadow( three-pass-box , rgba(0,0,0,0.6) , 5, 0.0 , 0 , 1 );\r\n" + 
				"    -fx-font-family: \"Arial\";\r\n" + 
				"    -fx-text-fill: linear-gradient(white, #d0d0d0);\r\n" + 
				"    -fx-font-size: 12px;\r\n" + 
				"    -fx-padding: 10 20 10 20;");
		exit.setTextFill(Color.AQUA);
		exit.setOnAction(event -> System.exit(0));
		return exit;

	}

	private VBox createLeftPane() {
		VBox leftBox = new VBox(10);
		Label l1 = new Label("								");
		leftBox.getChildren().add(l1);
		return leftBox;

	}

	private Pane createTopPane() {
		final VBox topBox = new VBox(25);
		for (int i =0; i<2; i++) {
			Label l1 = new Label("");
			topBox.getChildren().add(l1);
		}
		return topBox;
	}

	public void start(final Stage primaryStage) throws Exception {
		stage = primaryStage;
		primaryStage.setScene(startScene());	
		primaryStage.setTitle("Memory Game");
		primaryStage.show();

	}	

	
	public static void main(String[] args) {
		launch(args);
	}



}
