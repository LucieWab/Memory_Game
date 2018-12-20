import java.io.File;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class Scene1 extends Application {

	protected Scene startScene()
	{
		 String uriString = new File("theme.mp3").toURI().toString();
		    MediaPlayer player = new MediaPlayer( new Media(uriString));
		    player.play();
		    player.setAutoPlay(true);
		    
		Pane root = new Pane();
		Label nameGame = new Label("****THE MEMORY'S GAME****");
		
		Label instruction = new Label("\r\n" + 
				"    The objective is to collect every pairs of cards.\r\n" + "\r\n" +
				"    Shuffle the cards and lay them, face down, in rows.\r\n" + "\r\n" +
				"    Turn over any two cards (one at a time) and keep them if the cards match. \r\n" + "\r\n" +
				"    If you successfully match a pair they get to keep the cards\r\n" + "\r\n" +
				"    When you turn over two cards that do not match, those cards are turned face down again (in the same position).\r\n" + "\r\n" +
				"    The trick is to remember which cards are where.\r\n" + "\r\n" +
				"    You win when you find every pairs of cards.\r\n" + "\r\n" +
				"    GOOD LUCK");
		
		
		Button button1 = new Button("START THE GAME");
		/*button1.setOnAction(new EventHandler<ActionEvent>()
		
				{
					@Override
					public void handle(ActionEvent event)
					{
						// TODO Auto-generated method stub
						stage.setScene(game());
					}
				});*/
		
		root.getChildren().addAll(button1, nameGame, instruction);
		button1.setPadding(new Insets(7, 7, 7, 7));
		
		nameGame.setLayoutX(150);
		
		instruction.setLayoutX(10);
		instruction.setLayoutY(20);
		
		
		button1.setLayoutX(300);
		button1.setLayoutY(450);
		
		nameGame.setFont(Font.font ("Century Schoolbook", 30));
		instruction.setFont(Font.font ("Century Schoolbook", 20));
		button1.setFont(Font.font ("Century Schoolbook", 20));

		nameGame.setTextFill(Color.SIENNA);
		instruction.setTextFill(Color.CHOCOLATE);
		button1.setTextFill(Color.CHOCOLATE);
		
		Scene scene = new Scene(root, 800, 500, Color.AQUA);
		scene.setCursor(Cursor.OPEN_HAND);
		
		
		return scene;
	}


	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		primaryStage.setScene(startScene());
		primaryStage.setTitle(null);
		primaryStage.show();
		
	}

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);
	}
}
