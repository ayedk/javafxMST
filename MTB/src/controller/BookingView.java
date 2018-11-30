package controller;

import java.sql.SQLException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import model.Reservation;
import model.ReservationDAO;
import model.User;

public class BookingView extends Scene{
	private BorderPane borderPane = new BorderPane();
	private User User;
	
	private TableView<Reservation> table = new TableView<Reservation>();
	final private Label Text = new Label("Booking List"); 
	Button btnBack = new Button("Back");
	public BookingView(Stage stage, BorderPane borderpane, User user) {
		super(borderpane);
		this.borderPane = borderpane;
		this.User = user;
		
		navbar();
		
		EventHandler<ActionEvent> eventHandler = new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
					
				if(event.getSource() == btnBack) {
					stage.setScene(new CustumerView(stage, new BorderPane(), User));
				}
			}
		};
		btnBack.setOnAction(eventHandler);
		
		table.setEditable(true);
		
		TableColumn<Reservation, String> id = new TableColumn<Reservation, String>("id");
        id.setMinWidth(100);
        id.setCellValueFactory(
                new PropertyValueFactory<Reservation, String>("id"));
        
        TableColumn<Reservation, String> userid = new TableColumn<Reservation, String>("userid");
        userid.setMinWidth(100);
        userid.setCellValueFactory(
                new PropertyValueFactory<Reservation, String>("userid"));
        
        TableColumn<Reservation, String> ShowDate = new TableColumn<Reservation, String>("ShowDate");
        ShowDate.setMinWidth(100);
        ShowDate.setCellValueFactory(
                new PropertyValueFactory<Reservation, String>("ShowDate"));
        
        TableColumn<Reservation, String> ShowTime = new TableColumn<Reservation, String>("ShowTime");
        ShowTime.setMinWidth(100);
        ShowTime.setCellValueFactory(
                new PropertyValueFactory<Reservation, String>("ShowTime"));
        
        TableColumn<Reservation, String> NbSeat = new TableColumn<Reservation, String>("NbSeat");
        NbSeat.setMinWidth(100);
        NbSeat.setCellValueFactory(
                new PropertyValueFactory<Reservation, String>("NbSeat"));
        
        TableColumn<Reservation, String> MovieTitle = new TableColumn<Reservation, String>("MovieTitle");
        MovieTitle.setMinWidth(100);
        MovieTitle.setCellValueFactory(
                new PropertyValueFactory<Reservation, String>("MovieTitle"));
		
		
		
	      
	      try {
	    	  ObservableList<Reservation> data = FXCollections.observableList(ReservationDAO.getReservationList(user));
	    	  table.setItems(data);
	    	  table.getColumns().addAll(id,userid,MovieTitle,ShowDate,ShowTime,NbSeat);
	      }catch(ClassNotFoundException e) {
	            System.out.println("Problem occurred at executeQuery operation : " + e);
		  }catch(SQLException e) {
	            System.out.println("Problem occurred at executeQuery operation : " + e);	
		  }
	      borderPane.setPadding(new Insets(5));
	      borderPane.setCenter(table);
	      borderPane.setPrefSize(900, 650);
	}
	public void navbar() {
		Region region = new Region();
		Region region1 = new Region();
		HBox hbox = new HBox(Text, region, region1, btnBack);
        HBox.setHgrow(region, Priority.ALWAYS);
        HBox.setHgrow(region1, Priority.ALWAYS);
		hbox.setStyle("-fx-background-color: black;");
		
		
		Text.setTextFill(Color.WHITE);
		Text.setStyle("-fx-background-color: black;");
		Text.setOnMouseEntered(e -> Text.setStyle("-fx-background-color: #252626;"));
		Text.setOnMouseExited(e -> Text.setStyle("-fx-background-color: black;"));
		Text.setFont(new Font("Verdana", 27));
		
		
		btnBack.setTextFill(Color.WHITE);
		btnBack.setStyle("-fx-background-color: black;");
		btnBack.setOnMouseExited(e -> btnBack.setStyle("-fx-background-color: black;"));
		btnBack.setOnMouseEntered(e -> btnBack.setStyle("-fx-background-color: #252626;"));
		btnBack.setFont(new Font("Verdana", 18));
		
		borderPane.setTop(hbox);
		
	}
}
