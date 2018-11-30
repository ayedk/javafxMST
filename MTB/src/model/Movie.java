package model;


public class Movie {
	private int iD;
	private String MovieTitle;
	private String Genre;
	private String ShowDate;
	private String ShowTime;
	private String Description;
	private int PlaceAvailable;
	public Movie(int id, String name, String Desc, String SDate, String STime, String Gr, int pv) {
		this.iD = id;
		this.MovieTitle = name;
		this.Description = Desc;
		this.ShowDate = SDate;
		this.ShowTime = STime;
		this.Genre = Gr;
		this.PlaceAvailable = pv;
	}
	public String getMovieTitle(){
		return MovieTitle;
	}
	public int getiD() {
		return iD;
	}
	public void setiD(int iD) {
		this.iD = iD;
	}
	public String getGenre() {
		return Genre;
	}
	public void setGenre(String genre) {
		Genre = genre;
	}
	public String getShowDate() {
		return ShowDate;
	}
	public void setShowDate(String showDate) {
		ShowDate = showDate;
	}
	public String getShowTime() {
		return ShowTime;
	}
	public void setShowTime(String showTime) {
		ShowTime = showTime;
	}
	public String getDescription() {
		return Description;
	}
	public void setDescription(String description) {
		Description = description;
	}
	public void setMovieTitle(String movieTitle) {
		MovieTitle = movieTitle;
	}
	public int getPlaceAvailable() {
		return PlaceAvailable;
	}
	public void setPlaceAvailable(int placeAvailable) {
		PlaceAvailable = placeAvailable;
	}
}
