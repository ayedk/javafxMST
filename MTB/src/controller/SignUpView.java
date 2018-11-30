package controller;


import java.sql.SQLException;
import java.util.ArrayList;

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
import model.User;
import model.UserDAO;


public class SignUpView extends Scene{
	private GridPane gridPane;
	
	private Label error = new Label("Username exit");
	
	private Text topTitle = new Text("Register"); 
	private Text bottomTitle = new Text("Create a new user!");
	private Label usernameLabel = new Label("Username");
	private Label nameLabel = new Label("Name");
	private Label passwordLabel = new Label("Password");
	private Label passwordAgainLabel = new Label("Write password again");
	final private TextField usernameField = new TextField();
	final private TextField nameField = new TextField();
	final private PasswordField passwordField = new PasswordField(); 
	final private PasswordField passwordAgainField = new PasswordField();
	final private Button registerButton = new Button("Register");
	final private Button backButton = new Button("Back");
	
	public SignUpView(final Stage stage, final GridPane gridpane) {
		super(gridpane);
		this.gridPane = gridpane;
		
		topTitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 30));
		bottomTitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
		
		EventHandler<ActionEvent> eventHandler = new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
					
				if (event.getSource() == registerButton) {
					try{
						if(verif(usernameField,nameField,passwordField,passwordAgainField)) {
							User user = new User(0,usernameField.getText(),nameField.getText(),passwordField.getText());
							UserDAO.insertUser(user);
						    stage.setScene(new CustumerView(stage, new BorderPane(), user));
						 }
					}catch(ClassNotFoundException e) {
				            System.out.println("Problem occurred at executeQuery operation : " + e);
					}catch(SQLException e) {
				            System.out.println("Problem occurred at executeQuery operation : " + e);	
					}
				}
				if (event.getSource() == backButton) {
					System.out.println("Back");
					stage.setScene(new FilmView(stage, new BorderPane(), null));
				}
			}
		};
		
		backButton.setOnAction(eventHandler);
		registerButton.setOnAction(eventHandler);
		
		error.setVisible(false);
		
		gridPane.setVgap(10); 
		gridPane.setHgap(10); 
		gridPane.setPadding(new Insets(20,20,20,20)); 
		gridPane.setAlignment(Pos.CENTER); 
		
		
		gridPane.add(topTitle, 0, 0, 3, 1);
		gridPane.add(bottomTitle, 0, 1, 2, 1);

		gridPane.add(nameLabel, 0, 2);
		gridPane.add(nameField, 1, 2);
		gridPane.add(usernameLabel, 0, 3); 
		gridPane.add(usernameField, 1, 3);
		gridPane.add(passwordLabel, 0, 4);
		gridPane.add(passwordField, 1, 4);
		gridPane.add(passwordAgainLabel, 0, 5);
		gridPane.add(passwordAgainField, 1, 5);
		gridPane.add(registerButton, 0, 6);
		gridPane.add(backButton, 1, 6);
		gridPane.add(error, 2, 3);
		
		gridPane.setPrefSize(900, 650);		
			
	}
	
	public boolean verif(TextField n,TextField un,PasswordField p,PasswordField pa) {
		if(!( (n.getText().isEmpty())||(un.getText().isEmpty())||(p.getText().isEmpty())||(pa.getText().isEmpty()) )) {
			try {
			if( (p.getText().length()>=8)&&(pa.getText().equals(p.getText()))&&(checkUser(n)) ) {
				return true;
			}
			return false;
			}catch(ClassNotFoundException e) {
	            return false;
			}catch(SQLException e) {
	            return false;
			}
		}
		else return false;
	};
	
	
	public boolean checkUser(TextField usernameFiled) throws ClassNotFoundException, SQLException{
		ArrayList<User> userList = new ArrayList<User>();
		userList = UserDAO.getAllUser();
		for(int i=0;i<userList.size();i++) {
			if(userList.get(i).getUserName().equals(usernameFiled.getText())) {
					error.setVisible(true);
					return false;
			}
		}
		error.setVisible(false);
		return true;
	}
}
