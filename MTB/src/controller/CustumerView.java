package controller;

import java.io.File;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import model.User;

public class CustumerView extends Scene{
	
	private BorderPane BorderPane;
	
	private String path;
	
	final FileChooser fileChooser = new FileChooser();
    
	
	final private Label Text = new Label("Custumuer View"); 
	
	final private Button btnLogout = new Button("Logout");
	final private Button btnFilmView = new Button("Film View");
	final private Button btnBookingView = new Button("Booking History");
	
	public CustumerView(Stage stage, BorderPane borderpane, User user) {
		super(borderpane);
		this.BorderPane = borderpane;
		BorderPane.setStyle(
				"-fx-background-image: url('images/cenema.png');"
				+ " -fx-background-repeat: stretch;"
				+ "-fx-background-size: cover;"
				+ " -fx-background-position: center center;"
				+ "-fx-effect: dropshadow(three-pass-box, black, 30, 0.5, 0, 0);");
		navbar();
		
		sidebarleft(user);
		
		sidebarright();
		
		EventHandler<ActionEvent> eventHandler = new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
					
				if(event.getSource() == btnFilmView) {
					stage.setScene(new FilmView(stage, new BorderPane(),user));
				}
				if (event.getSource() == btnLogout) {
					
					stage.setScene(new FilmView(stage, new BorderPane(),null));
				}
				if(event.getSource() == btnBookingView) {
					stage.setScene(new BookingView(stage, new BorderPane(), user));
				}
			}
		};
		btnBookingView.setOnAction(eventHandler);
		btnLogout.setOnAction(eventHandler);
		btnFilmView.setOnAction(eventHandler);
		
		BorderPane.setPrefSize(900, 650);
	}
	
	
	public void navbar() {
		Region region = new Region();
		Region region1 = new Region();
		HBox hbox = new HBox(Text, region, region1, btnLogout);
        HBox.setHgrow(region, Priority.ALWAYS);
        HBox.setHgrow(region1, Priority.ALWAYS);
		hbox.setStyle("-fx-background-color: black;");
		
		
		Text.setTextFill(Color.WHITE);
		Text.setStyle("-fx-background-color: black;");
		Text.setOnMouseEntered(e -> Text.setStyle("-fx-background-color: #252626;"));
		Text.setOnMouseExited(e -> Text.setStyle("-fx-background-color: black;"));
		Text.setFont(new Font("Verdana", 27));
		
		
		btnLogout.setTextFill(Color.WHITE);
		btnLogout.setStyle("-fx-background-color: black;");
		btnLogout.setOnMouseExited(e -> btnLogout.setStyle("-fx-background-color: black;"));
		btnLogout.setOnMouseEntered(e -> btnLogout.setStyle("-fx-background-color: #252626;"));
		btnLogout.setFont(new Font("Verdana", 18));
		
		BorderPane.setTop(hbox);
	}
	
	public void sidebarleft(User user){
		Region region = new Region();
		Region region1 = new Region();
		Image image = new Image("images/user.png");
		ImageView iv = new ImageView(image);
		iv.setFitHeight(100);
		iv.setFitWidth(100);
		
		Button button = new Button("Select some Pictures");
		
		
		
		Label lb = new Label("Name: "); 
		Label lb1 = new Label("UserName: ");
		Label lb2 = new Label(user.getName());
		Label lb3 = new Label(user.getUserName());
		
		GridPane gp = new GridPane();
		gp.setAlignment(Pos.CENTER);
		gp.add(lb, 0, 0);
		gp.add(lb1, 0, 1);
		gp.add(lb2, 1, 0);
		gp.add(lb3, 1, 1);
		
		VBox vb = new VBox(iv, button, gp,region, region1);
		VBox.setVgrow(region, Priority.ALWAYS);
        VBox.setVgrow(region1, Priority.ALWAYS);
		vb.setStyle(" -fx-padding: 30 60 30 60; -fx-border-color: black;-fx-border-width: 0 1 3 0 ;");
		vb.setSpacing(10);
		
		configuringFileChooser(fileChooser);
		
		button.setOnAction(new EventHandler<ActionEvent>() {
			 
	          @Override
	          public void handle(ActionEvent event) {
	        	  Stage primaryStage = new Stage();
	              File selectedFile = fileChooser.showOpenDialog(primaryStage);
	              if (selectedFile != null) {
	            	  path = selectedFile.toURI().toString();
	            	  Image image = new Image(path);
	            	  ImageView iv2 = new ImageView(image);
	            	  iv2.setFitHeight(100);
	          		  iv2.setFitWidth(100);
	            	  vb.getChildren().set(0, iv2);
	              }
	          }
	      });
		
		
		
		BorderPane.setLeft(vb);
	}
	
	public void sidebarright(){
		Region region = new Region();
		Region region1 = new Region();
	
		btnFilmView.setMinWidth(420);
		btnFilmView.setMinHeight(50);
		btnFilmView.setStyle("-fx-background-color: #9e6758;-fx-text-fill: #51ffe2;");
		btnFilmView.setFont(new Font("Verdana", 18));
		
		btnBookingView.setMinWidth(420);
		btnBookingView.setMinHeight(50);
		btnBookingView.setStyle("-fx-background-color: #9e6758; -fx-text-fill: #51ffe2;");
		btnBookingView.setFont(new Font("Verdana", 18));
		
		VBox vb = new VBox(region, region1, btnFilmView,btnBookingView);
		VBox.setVgrow(region, Priority.ALWAYS);
        VBox.setVgrow(region1, Priority.ALWAYS);
		vb.setSpacing(10);
		vb.setStyle("-fx-padding: 0 0 10 0; -fx-border-color: black;-fx-border-width: 0 1 3 0 ;");
		
		vb.setAlignment(Pos.CENTER);
		
		BorderPane.setCenter(vb);
	}
	
	private void configuringFileChooser(FileChooser fileChooser) {
	      // Set title for FileChooser
	      fileChooser.setTitle("Select Pictures");
	 
	      // Set Initial Directory
	      fileChooser.setInitialDirectory(new File("C:\\Users\\Klila Ayed\\Downloads"));
	 
	      // Add Extension Filters
	      fileChooser.getExtensionFilters().addAll(//
	              new FileChooser.ExtensionFilter("All Files", "*.*"), //
	              new FileChooser.ExtensionFilter("JPG", "*.jpg"), //
	              new FileChooser.ExtensionFilter("PNG", "*.png"));
	  }
	
}
