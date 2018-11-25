package controller;

import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import model.Movie;

public class FilmDetailView extends Scene{
	
	private BorderPane bp = new BorderPane();
	private Label lb1;
	private Label lb2 = new Label("Genre :");
	private Label lb3 = new Label("BeginDate :");
	private Label lb4 = new Label("FinalDate :");
	private Label lb5 = new Label("Description :");
	
	private Text t1;
	private Text t2;
	private Text t3;
	private Text t4;
	
	public FilmDetailView(Stage stage, BorderPane bpane, Movie mv) {
		super(bpane);
		this.bp = bpane;
		HBox hb = new HBox();
		String string = "imagesFilm/"+ mv.MovieTitle + ".png";
		
		Image image = new Image(string);
		BackgroundSize backgroundSize = new BackgroundSize(500, 150, false, false, false, false);
		BackgroundImage backgroundImage = new BackgroundImage(image, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, backgroundSize);
		Background background = new Background(backgroundImage);
		hb.setBackground(background);
		hb.setPrefSize(500, 150);
		bp.setTop(hb);
		
		GridPane gridpane = new GridPane();
		gridpane.setStyle("-fx-padding:50 0 0 30");
		gridpane.setHgap(25); 
		gridpane.setVgap(50);
		
		lb1 = new Label(mv.MovieTitle);
		lb1.setStyle("-fx-text-fill:red; -fx-font: normal bold 20px 'serif' ");
		gridpane.add(lb1, 2, 0);
		gridpane.add(lb2, 1, 1);
		gridpane.add(lb5, 1, 2);
		gridpane.add(lb3, 1, 3);
		gridpane.add(lb4, 1, 4);
		
		
		t1 = new Text(mv.Genre);
		t2 = new Text(mv.Description);
		t3 = new Text(mv.BeginDate);
		t4 = new Text(mv.FinalDate);
		
		gridpane.add(t1, 2, 1);
		gridpane.add(t2, 2, 2);
		gridpane.add(t3, 2, 3);
		gridpane.add(t4, 2, 4);
		
		
		bpane.setCenter(gridpane);
		
		bp.setPrefSize(500, 550);
	}
}
