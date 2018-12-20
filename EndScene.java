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
import java.io.File;

public class EndScene extends Application {
	
	protected Scene endScene()
	{
		//musique
		 String uriString = new File("tortuga.mp3").toURI().toString();
				    MediaPlayer player = new MediaPlayer( new Media(uriString));
				    player.setAutoPlay(true);
				    
				    
		Pane root = new Pane();
		Label message = new Label("CONGRATULATION !");
		
		Button resume = new Button("Resume");
		/*resume.setOnAction(new EventHandler<ActionEvent>()
		
				{
					@Override
					public void handle(ActionEvent event)
					{
						// TODO Auto-generated method stub
						stage.setScene(game());
					}
				});*/
		Button exit = new Button("exit");
		exit.setOnAction(new EventHandler<ActionEvent>()
		
				{
					@Override
					public void handle(ActionEvent event)
					{
						// TODO Auto-generated method stub
						System.exit(0);
						
					}
				});
		
		
		root.getChildren().addAll(resume, exit, message);
		
		resume.setPadding(new Insets(7, 7, 7, 7));
		
		exit.setPadding(new Insets(7,7,7,7));
		
		message.setLayoutX(240);
		message.setLayoutY(200);
		
		
		resume.setLayoutX(200);
		resume.setLayoutY(450);
		
		exit.setLayoutX(500);
		exit.setLayoutY(450);
		
		message.setFont(Font.font ("Century Schoolbook", 30));
		resume.setFont(Font.font ("Century Schoolbook", 20));
		exit.setFont(Font.font("Century Schoolbook", 20));

		message.setTextFill(Color.SIENNA);
		resume.setTextFill(Color.CHOCOLATE);
		exit.setTextFill(Color.CHOCOLATE);
		
		Scene scene = new Scene(root, 800, 500, Color.AQUA);
		scene.setCursor(Cursor.OPEN_HAND);
		
		
		return scene;
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		primaryStage.setScene(endScene());
		primaryStage.setTitle(null);
		primaryStage.show();
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);
	}

}
