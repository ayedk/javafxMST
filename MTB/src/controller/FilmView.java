package controller;

import java.util.ArrayList;

import javafx.animation.FadeTransition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.ScrollPane.ScrollBarPolicy;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Duration;
import model.Movie;

public class FilmView extends Scene{
	
	private BorderPane borderPane;
	private GridPane gridpane = new GridPane();
	private ScrollPane sp = new ScrollPane();
	
	private Button btnLogin =new Button("Login") ;
	private Button btnSignup =new Button("Signup") ;
	private Button btnHome =new Button("Home") ;
	TextField search = new TextField();
	
	public FilmView(Stage stage, BorderPane bPane) {
		super(bPane);
		this.borderPane = bPane;
		borderPane.setStyle(
				"-fx-background-image: url('images/cenema.png');"
				+ " -fx-background-repeat: stretch;"
				+ "-fx-background-size: cover;"
				+ " -fx-background-position: center center;"
				+ "-fx-effect: dropshadow(three-pass-box, black, 30, 0.5, 0, 0);");
		initButton();
		
		
		
		ArrayList<Movie> movieList = new ArrayList<Movie>();
		
		
		movieList.add(new Movie(0,"the-internet-wreck-it-ralph-2","Desc","12/12/2018 20:30","12/12/2018 23:20","Gr"));
		movieList.add(new Movie(1,"the-grinch","Desc","12/12/2018 20:30","12/12/2018 23:20","Gr"));
		movieList.add(new Movie(2,"bazaar","Desc","12/12/2018 20:30","12/12/2018 23:20","Gr"));
		movieList.add(new Movie(3,"thugsofhindostan","Desc","12/12/2018 20:30","12/12/2018 23:20","Gr"));
		movieList.add(new Movie(4,"the-girl-in-the-spider-s-web","Desc","12/12/2018 20:30","12/12/2018 23:20","Gr"));
		movieList.add(new Movie(5,"thecrimesofgrindelwald","Desc","12/12/2018 20:30","12/12/2018 23:20","Gr"));
		movieList.add(new Movie(6,"the-internet-wreck-it-ralph-2","Desc","12/12/2018 20:30","12/12/2018 23:20","Gr"));
		movieList.add(new Movie(7,"the-grinch","Desc","12/12/2018 20:30","12/12/2018 23:20","Gr"));
		movieList.add(new Movie(8,"bazaar","Desc","12/12/2018 20:30","12/12/2018 23:20","Gr"));
		movieList.add(new Movie(9,"thugsofhindostan","Desc","12/12/2018 20:30","12/12/2018 23:20","Gr"));
		movieList.add(new Movie(10,"the-girl-in-the-spider-s-web","Desc","12/12/2018 20:30","12/12/2018 23:20","Gr"));
		movieList.add(new Movie(11,"thecrimesofgrindelwald","Desc","12/12/2018 20:30","12/12/2018 23:20","Gr"));
		movieList.add(new Movie(12,"the-internet-wreck-it-ralph-2","Desc","12/12/2018 20:30","12/12/2018 23:20","Gr"));
		movieList.add(new Movie(13,"the-grinch","Desc","12/12/2018 20:30","12/12/2018 23:20","Gr"));
		movieList.add(new Movie(14,"bazaar","Desc","12/12/2018 20:30","12/12/2018 23:20","Gr"));
		movieList.add(new Movie(15,"the-internet-wreck-it-ralph-2","Desc","12/12/2018 20:30","12/12/2018 23:20","Gr"));
		movieList.add(new Movie(16,"the-grinch","Desc","12/12/2018 20:30","12/12/2018 23:20","Gr"));
		movieList.add(new Movie(17,"bazaar","Desc","12/12/2018 20:30","12/12/2018 23:20","Gr"));
		movieList.add(new Movie(0,"the-internet-wreck-it-ralph-2","Desc","12/12/2018 20:30","12/12/2018 23:20","Gr"));
		movieList.add(new Movie(1,"the-grinch","Desc","12/12/2018 20:30","12/12/2018 23:20","Gr"));
		movieList.add(new Movie(2,"bazaar","Desc","12/12/2018 20:30","12/12/2018 23:20","Gr"));
		movieList.add(new Movie(3,"thugsofhindostan","Desc","12/12/2018 20:30","12/12/2018 23:20","Gr"));
		movieList.add(new Movie(4,"the-girl-in-the-spider-s-web","Desc","12/12/2018 20:30","12/12/2018 23:20","Gr"));
		movieList.add(new Movie(0,"the-internet-wreck-it-ralph-2","Desc","12/12/2018 20:30","12/12/2018 23:20","Gr"));
		movieList.add(new Movie(1,"the-grinch","Desc","12/12/2018 20:30","12/12/2018 23:20","Gr"));
		movieList.add(new Movie(2,"bazaar","Desc","12/12/2018 20:30","12/12/2018 23:20","Gr"));
		movieList.add(new Movie(3,"thugsofhindostan","Desc","12/12/2018 20:30","12/12/2018 23:20","Gr"));
		movieList.add(new Movie(4,"the-girl-in-the-spider-s-web","Desc","12/12/2018 20:30","12/12/2018 23:20","Gr"));
		movieList.add(new Movie(5,"thecrimesofgrindelwald","Desc","12/12/2018 20:30","12/12/2018 23:20","Gr"));
		final EventHandler<ActionEvent> eventHandler = new EventHandler<ActionEvent>() {
			
			public void handle(ActionEvent event) {
				
				if (event.getSource() == btnHome) {
					FadeTransition ft = new FadeTransition(Duration.millis(1000), gridpane);
				    ft.setFromValue(1.0);
				    ft.setToValue(0.3);
				    ft.setCycleCount(2);
				    ft.setAutoReverse(true);
				     
				    ft.play();
				    gridpane.getChildren().clear();
				    addFilm(movieList);
				}
				if (event.getSource() == btnSignup) {
					GridPane gridpane1 = new GridPane();
					stage.setScene(new SignUpView(stage, gridpane1 ));
				}
				if (event.getSource() == btnLogin) {
					
					stage.setScene(new LoginView(stage, new GridPane()));
				}
			}
		};
		
		btnSignup.setOnAction(eventHandler);
		btnLogin.setOnAction(eventHandler);
		btnHome.setOnAction(eventHandler);  
		
		
		
		
		this.setOnKeyPressed(e -> {
		    if (e.getCode() == KeyCode.ENTER) {
		    	if(!search.getText().equals("")) {
		    		gridpane.getChildren().clear();
		    		
		    		int row = 0;
		    		int column = 0;
		    		String ch = search.getText();
		    		
		    		for (int k = 0; k < movieList.size();k++) {
		    			if(movieList.get(k).getMovieTitle().equals(ch)) {
		    				
		    				VBox hb = movieList.get(k).getMovie();
		    				hb.setStyle("-fx-padding: 5 5 5 5");
		    				gridpane.add(hb,column,row);
		    				
		    			}
		    		}
		    	}
		    }
		});
		
		gridpane.setAlignment(Pos.CENTER);
		sp.setContent(gridpane);
		sp.setStyle("-fx-pannable: true;");
	    sp.setVbarPolicy(ScrollBarPolicy.ALWAYS);
	    sp.setHbarPolicy(ScrollBarPolicy.NEVER);
	    sp.setMaxHeight(650);
	    sp.setMaxWidth(885);
		gridpane.setStyle("-fx-padding: 5 5 5 5");
		borderPane.setCenter(sp);
		
		addFilm(movieList);
		
		
		
		
		
		borderPane.setPrefSize(900, 650);
		
	}
	
	
	public void  addFilm(ArrayList<Movie> ml) {
		int row = 0;
		int column = 0;

		for (int g = 0; g < ml.size();g++) {
		
			VBox hb = ml.get(g).getMovie();
			hb.setStyle("-fx-padding: 5 5 5 5");
			gridpane.add(hb,column,row);
			column++;
			if (column == 5) {
				row++;
				column =0;
			}
		}
	}
	
	public void initButton() {
		Image image = new Image("images/search.png");
		ImageView iv = new ImageView(image);
		iv.setFitHeight(25);
		iv.setFitWidth(25);
		Region region = new Region();
		
		HBox hbox = new HBox(btnHome, iv, search, region, btnLogin, btnSignup);
        HBox.setHgrow(region, Priority.ALWAYS);
		hbox.setStyle("-fx-background-color: #4267b2; -fx-padding: 3 3 3 30;");
		hbox.setSpacing(10);
		
		
		
		search.setStyle("-fx-border-radius: 1;"
				+ " -fx-background-color: #ffffff; -fx-border-width: 2;"
				+ " -fx-border-color: grey; -fx-min-width: 400;");
		search.setPromptText("Search Film");
		
		btnHome.setTextFill(Color.WHITE);
		btnHome.setStyle("-fx-background-color: #4267b2;");
		btnHome.setOnMouseEntered(e -> btnHome.setStyle("-fx-background-color: #3b5ca0;"));
		btnHome.setOnMouseExited(e -> btnHome.setStyle("-fx-background-color: #4267b2;"));
		
		btnLogin.setTextFill(Color.WHITE);
		btnLogin.setStyle("-fx-background-color: #4267b2;");
		btnLogin.setOnMouseExited(e -> btnLogin.setStyle("-fx-background-color: #4267b2;"));
		btnLogin.setOnMouseEntered(e -> btnLogin.setStyle("-fx-background-color: #3b5ca0;"));
		
		btnSignup.setTextFill(Color.WHITE);
		btnSignup.setStyle("-fx-background-color: #4267b2;");
		btnSignup.setOnMouseEntered(e -> btnSignup.setStyle("-fx-background-color: #3b5ca0;"));
		btnSignup.setOnMouseExited(e -> btnSignup.setStyle("-fx-background-color: #4267b2;"));
		
		borderPane.setTop(hbox);
	}
}
