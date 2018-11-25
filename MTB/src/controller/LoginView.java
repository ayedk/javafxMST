package controller;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class LoginView extends Scene{
	
	private GridPane gridPane;

	private Text topTitle = new Text("Ticket Reservation System"); 
	private Text bottomTitle = new Text("Login");

	private Label usernameLabel = new Label("User Name");
	private Label passwordLabel = new Label("Password");

	final private TextField usernameField = new TextField();
	final private PasswordField passwordField = new PasswordField();

	final private Button loginButton = new Button("Login");
	final private Button backButton = new Button("Back");
	
	public LoginView(final Stage stage, final GridPane gridpane) {
		super(gridpane);
		this.gridPane = gridpane;
		
		gridPane.setAlignment(Pos.CENTER);
		gridPane.setHgap(15); 
		gridPane.setVgap(10); 
		gridPane.setPadding(new Insets(25,25,25,25));
		
		
		topTitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 30));
		bottomTitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
		
		EventHandler<ActionEvent> eventHandler = new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				
				if ((event.getSource() == loginButton)) {
					if(usernameField.getText().equals("admin")&&passwordField.getText().equals("admin")) {
						stage.setScene(new CustumerView(stage, new BorderPane()));
					}
						
						
					
				}
				if (event.getSource() == backButton) {
					System.out.println("Back");
					stage.setScene(new FilmView(stage, new BorderPane()));
				}
			}
		};

		backButton.setOnAction(eventHandler);
		loginButton.setOnAction(eventHandler);
		
		gridPane.add(topTitle,0,0,3,1);
		gridPane.add(bottomTitle,0,1,2,1);

		gridPane.add(usernameLabel,0,2);
		gridPane.add(passwordLabel,0,3);
		gridPane.add(usernameField,1,2);
		gridPane.add(passwordField,1,3);
		gridPane.add(loginButton,1,4);
		gridPane.add(backButton, 2, 4);
		
		gridPane.setVisible(true);
		
		
		gridPane.setPrefSize(900, 650);
		
	}
}
