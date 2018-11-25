package controller;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import model.Booking;
import model.Movie;

public class BookPageView extends Scene{
private GridPane gridPane;
	
	
	private Label usernameLabel = new Label("Username");
	private Label nameLabel = new Label("Name");
	final private TextField usernameField = new TextField();
	final private TextField nameField = new TextField();
	final private Button bookButton = new Button("Book");
	
	public BookPageView(final Stage stage, final GridPane gridpane, Booking bk, Movie m) {
		super(gridpane);
		this.gridPane = gridpane;
		
		
		Text topTitle = new Text("Booking Page"); 
		
		topTitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 30));
		
		EventHandler<ActionEvent> eventHandler = new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
					
				if (event.getSource() == bookButton) {
					
				}
			}
		};
		
		bookButton.setOnAction(eventHandler);
		
		
		gridPane.setVgap(10); 
		gridPane.setHgap(10); 
		gridPane.setPadding(new Insets(20,20,20,20)); 
		gridPane.setAlignment(Pos.CENTER); 
		
		
		gridPane.add(topTitle, 0, 0, 3, 1);

		gridPane.add(nameLabel, 0, 2);
		gridPane.add(nameField, 1, 2);
		gridPane.add(usernameLabel, 0, 3); 
		gridPane.add(usernameField, 1, 3);
		gridPane.add(bookButton, 0, 6);
		
		
		gridPane.setPrefSize(500, 550);		
			
	}
}
