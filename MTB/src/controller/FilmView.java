package controller;

import java.sql.SQLException;
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
import model.MovieDAO;
import model.User;

public class FilmView extends Scene{
	
	private BorderPane borderPane;
	private GridPane gridpane = new GridPane();
	private ScrollPane sp = new ScrollPane();
	
	private Button btnLogin =new Button("Login") ;
	private Button btnSignup =new Button("Signup") ;
	private Button btnHome =new Button("Home") ;
	private Button btnProfile =new Button("Profile") ;
	TextField search = new TextField();
	
	public FilmView(Stage stage, BorderPane bPane, User user) {
		super(bPane);
		this.borderPane = bPane;
		borderPane.setStyle(
				"-fx-background-image: url('images/cenema.png');"
				+ " -fx-background-repeat: stretch;"
				+ "-fx-background-size: cover;"
				+ " -fx-background-position: center center;"
				+ "-fx-effect: dropshadow(three-pass-box, black, 30, 0.5, 0, 0);");
		Image image = new Image("images/search.png");
		ImageView iv = new ImageView(image);
		iv.setFitHeight(25);
		iv.setFitWidth(25);
		Region region = new Region();
		if(user == null) {
			HBox hbox = new HBox(btnHome, iv, search, region, btnLogin, btnSignup);
			HBox.setHgrow(region, Priority.ALWAYS);
			hbox.setStyle("-fx-background-color: #4267b2; -fx-padding: 3 3 3 30;");
			hbox.setSpacing(10);
			borderPane.setTop(hbox);
		}else
		{
			HBox hbox = new HBox(btnHome, iv, search, region,btnProfile);
			HBox.setHgrow(region, Priority.ALWAYS);
			hbox.setStyle("-fx-background-color: #4267b2; -fx-padding: 3 3 3 30;");
			hbox.setSpacing(10);
			borderPane.setTop(hbox);
		}
		search.setStyle("-fx-border-radius: 1;"
				+ " -fx-background-color: #ffffff; -fx-border-width: 2;"
				+ " -fx-border-color: grey; -fx-min-width: 400;");
		search.setPromptText("Search Film");
		
		btnProfile.setTextFill(Color.WHITE);
		btnProfile.setStyle("-fx-background-color: #4267b2;");
		btnProfile.setOnMouseEntered(e -> btnProfile.setStyle("-fx-background-color: #3b5ca0;"));
		btnProfile.setOnMouseExited(e -> btnProfile.setStyle("-fx-background-color: #4267b2;"));
		
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
		gridpane.setAlignment(Pos.CENTER);
		sp.setContent(gridpane);
		sp.setStyle("-fx-pannable: true;");
	    sp.setVbarPolicy(ScrollBarPolicy.ALWAYS);
	    sp.setHbarPolicy(ScrollBarPolicy.NEVER);
	    sp.setMaxHeight(650);
	    sp.setMaxWidth(885);
		gridpane.setStyle("-fx-padding: 5 5 5 5");
		borderPane.setCenter(sp);
		borderPane.setPrefSize(900, 650);

		ArrayList<Movie> movieList = new ArrayList<Movie>();
		
		try{
			movieList = MovieDAO.getAllMovie();
			addFilm(movieList, user);
			handleEvent(stage,movieList, user);
		}catch(ClassNotFoundException e) {
            System.out.println("Problem occurred at executeQuery operation : " + e);
		}catch(SQLException e) {
            System.out.println("Problem occurred at executeQuery operation : " + e);	
		}
		
		
		
	}
	
	
	public void  addFilm(ArrayList<Movie> ml, User user) {
		int row = 0;
		int column = 0;
		for (int j=0;j<6;j++) {
			for (int g = 0; g < ml.size();g++) {
				
				MovieView mv = new MovieView(ml.get(g),user);
				VBox hb = mv.getMovie();
				hb.setStyle("-fx-padding: 5 5 5 5");
				gridpane.add(hb,column,row);
				column++;
				if (column == 5) {
					row++;
					column =0;
				}
			}
		}
		
	}
	
	public void handleEvent(Stage stage, ArrayList<Movie> movieList, User user) {
		this.setOnKeyPressed(e -> {
		    if (e.getCode() == KeyCode.ENTER) {
		    	if(!search.getText().equals("")) {
		    		gridpane.getChildren().clear();
		    		
		    		int row = 0;
		    		int column = 0;
		    		String ch = search.getText();
		    		
		    		for (int k = 0; k < movieList.size();k++) {
		    			if(movieList.get(k).getMovieTitle().equals(ch)) {
		    				MovieView mv = new MovieView(movieList.get(k), user);
		    				VBox hb = mv.getMovie();
		    				hb.setStyle("-fx-padding: 5 5 5 5");
		    				gridpane.add(hb,column,row);
		    				
		    			}
		    		}
		    	}
		    }
		});
		
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
				    addFilm(movieList, user);
				}
				if (event.getSource() == btnSignup) {
					GridPane gridpane1 = new GridPane();
					stage.setScene(new SignUpView(stage, gridpane1 ));
				}
				if (event.getSource() == btnLogin) {
					
					stage.setScene(new LoginView(stage, new GridPane()));
				}
				if (event.getSource() == btnProfile) {
					stage.setScene(new CustumerView(stage, new BorderPane(),user));
				}
			}
		};
		
		btnSignup.setOnAction(eventHandler);
		btnLogin.setOnAction(eventHandler);
		btnHome.setOnAction(eventHandler);
		btnProfile.setOnAction(eventHandler);
	}
		

}
