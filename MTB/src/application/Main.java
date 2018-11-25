package application;

import controller.FilmView;
import javafx.application.Application;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			primaryStage.setTitle("Ticket Management Systems");
			primaryStage.getIcons().add(new Image("images/icon.png"));
			
			BorderPane root = new BorderPane();
			root.setStyle("-fx-background-color: #e9ebee;");
			FilmView filmView = new FilmView(primaryStage, root);
			
			primaryStage.setScene(filmView);
			primaryStage.show();
		} 
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
