package model;

import controller.BookPageView;
import controller.FilmDetailView;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Movie {
	static private Stage stage = new Stage();
	private VBox vBox;
	private Image image;
	public int iD;
	public String MovieTitle;
	public String Genre;
	public String BeginDate;
	public String FinalDate;
	public String Description;
	
	private Button reserveButton;
	public Movie(int id, String name, String Desc, String BDate, String FDate, String Gr) {
		this.vBox = new VBox(10);
		this.iD = id;
		this.MovieTitle = name;
		this.Description = Desc;
		this.BeginDate = BDate;
		this.FinalDate = FDate;
		this.Genre = Gr;
		
		reserveButton = new Button("Book");
		reserveButton.setStyle("-fx-background-color: white; -fx-text-fill: red;");

		reserveButton.setOnMouseEntered(e -> reserveButton.setStyle("-fx-background-color: red; -fx-text-fill: white;"));
		reserveButton.setOnMouseExited(e -> reserveButton.setStyle("-fx-background-color: white; -fx-text-fill: red;"));
		image = new Image("imagesFilm/"+ MovieTitle +".png");
		ImageView imageView = new ImageView(image);

		imageView.setFitHeight(160);
		imageView.setFitWidth(160);
		
		reserveButton.setOnAction(new EventHandler<ActionEvent>(){
			public void handle(ActionEvent e){
				Movie m = new Movie(iD,MovieTitle,Description ,BeginDate ,FinalDate, Genre );
				Booking bk = new Booking();
				BookPageView BookPageView = new BookPageView(stage, new GridPane(), bk, m);
				stage.setScene(BookPageView);
				stage.show();
			}
		});
		
		imageView.setOnMouseClicked(new EventHandler<MouseEvent>(){
			
			public void handle(MouseEvent e){
				Movie mv = new Movie(iD,MovieTitle,Description ,BeginDate ,FinalDate, Genre );
				FilmDetailView FilmDetailView = new FilmDetailView(stage, new BorderPane(),mv);
				stage.setScene(FilmDetailView);
				stage.show();
				
			}
		});
		
		imageView.setOnMouseEntered((MouseEvent t) -> {});

		imageView.setOnMouseExited((MouseEvent t) -> {});
		
		vBox.setAlignment(Pos.CENTER);
		vBox.getChildren().add(imageView);
		vBox.getChildren().add(reserveButton);
		
	}
	
	public VBox getMovie(){
		return vBox;
	}
	public String getMovieTitle(){
		return MovieTitle;
	}
}
