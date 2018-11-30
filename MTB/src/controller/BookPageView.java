package controller;

import java.sql.SQLException;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import model.Movie;
import model.MovieDAO;
import model.Reservation;
import model.ReservationDAO;
import model.User;

public class BookPageView extends Scene{
	private GridPane gridPane;
	private Label Label1 = new Label("Film Title");
	private Label Label4 = new Label("Seat Number");
	private Label Label2 = new Label("Show Date");
	private Label Label3 = new Label("Show Time");
	
	final private TextField Field1 ;
	final private TextField Field3 ;
	final private TextField Field4 ;
	final private TextField Field2 = new TextField();
	final private Button bookButton = new Button("Book");
	public BookPageView(final Stage stage, final GridPane gridpane, Movie m, User user) {
		super(gridpane);
		this.gridPane = gridpane;
		Text topTitle = new Text("Booking Page");
		topTitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 30));
		gridPane.setVgap(10); 
		gridPane.setHgap(10); 
		gridPane.setPadding(new Insets(20,20,20,20)); 
		gridPane.setAlignment(Pos.CENTER);
		
		Field1 = new TextField(m.getMovieTitle());
		Field3 = new TextField(m.getShowDate());
		Field4 = new TextField(m.getShowTime());
		
		
		gridPane.add(topTitle, 0, 0, 3, 1);
		gridPane.add(Label1, 0, 2);
		gridPane.add(Field1, 1, 2);
		gridPane.add(Label2, 0, 3);
		gridPane.add(Field3, 1, 3);
		gridPane.add(Label3, 0, 4);
		gridPane.add(Field4, 1, 4);
		gridPane.add(Label4, 0, 5); 
		gridPane.add(Field2, 1, 5);
		gridPane.add(bookButton, 0, 6);
		gridPane.setPrefSize(500, 550);
		
		handleEvent(stage,m,user,Field2);
	}
	public void handleEvent(Stage stage,Movie m, User user, TextField Field2) {
		EventHandler<ActionEvent> eventHandler = new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				if (event.getSource() == bookButton) {
					if(!Field2.getText().isEmpty()&&(m.getPlaceAvailable()-Integer.parseInt(Field2.getText())) > 0) {
						try{
							Reservation res = new Reservation(0,m.getMovieTitle(),m.getShowDate(),m.getShowTime(),Integer.parseInt(Field2.getText()),user.getId());
							MovieDAO.updateMovie(m, m.getPlaceAvailable() - res.getNbSeat());
							ReservationDAO.insertReservation(res, user);
							stage.setScene(new CustumerView(stage, new BorderPane(), user));
						}catch(ClassNotFoundException e) {
					            System.out.println("Problem occurred at executeQuery operation : " + e);
						}catch(SQLException e) {
					            System.out.println("Problem occurred at executeQuery operation : " + e);	
						}
						stage.close();
					}
				}
			}
		};
		bookButton.setOnAction(eventHandler);
	}
}
