package controller;

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
import model.Movie;
import model.User;

public class MovieView {
	private static Stage stage = new Stage();
	private Movie mv;
	private VBox vBox;
	private Image image;
	private Button reserveButton;
	
	public MovieView(Movie Mv, User user) {
		this.mv = Mv;
		this.vBox = new VBox(10);
		stage.getIcons().add(new Image("images/icon.png"));
		
		reserveButton = new Button("Book");
		reserveButton.setStyle("-fx-background-color: white; -fx-text-fill: red;");
		reserveButton.setOnMouseEntered(e -> reserveButton.setStyle("-fx-background-color: red; -fx-text-fill: white;"));
		reserveButton.setOnMouseExited(e -> reserveButton.setStyle("-fx-background-color: white; -fx-text-fill: red;"));
		
		image = new Image("imagesFilm/"+ mv.getMovieTitle() +".png");
		ImageView imageView = new ImageView(image);
		imageView.setFitHeight(160);
		imageView.setFitWidth(160);
		
		vBox.setAlignment(Pos.CENTER);
		vBox.getChildren().add(imageView);
		vBox.getChildren().add(reserveButton);
		
		handleEvent(imageView,user);
	}
	public VBox getMovie(){
		return vBox;
	}
	public void handleEvent(ImageView imageView, User user){
		reserveButton.setOnAction(new EventHandler<ActionEvent>(){
			public void handle(ActionEvent e){
				if(user != null) {
					Movie m = new Movie(mv.getiD(),mv.getMovieTitle(),mv.getDescription() ,mv.getShowDate() ,mv.getShowTime(), mv.getGenre(), mv.getPlaceAvailable() );
					BookPageView BookPageView = new BookPageView(stage, new GridPane(), m, user);
					stage.setScene(BookPageView);
					stage.show();
				}
				
			}
		});
		imageView.setOnMouseClicked(new EventHandler<MouseEvent>(){
			public void handle(MouseEvent e){
				Movie m = new Movie(mv.getiD(),mv.getMovieTitle(),mv.getDescription() ,mv.getShowDate() ,mv.getShowTime(), mv.getGenre(), mv.getPlaceAvailable()  );
				FilmDetailView FilmDetailView = new FilmDetailView(stage, new BorderPane(),m);
				stage.setScene(FilmDetailView);
				stage.show();
			}
		});
		imageView.setOnMouseEntered((MouseEvent t) -> {});
		imageView.setOnMouseExited((MouseEvent t) -> {});
	}
}
