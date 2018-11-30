package model;


public class Reservation {
	private int id;
	private String MovieTitle;
	private String ShowDate;
	private String ShowTime;
	private int NbSeat;
	private int userid;
	public Reservation(int id, String mt, String sd, String st, int nb, int usid) {
		this.id = id;
		this.MovieTitle = mt; 
		this.ShowDate = sd;
		this.ShowTime = st;
		this.NbSeat = nb;
		this.userid = usid;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getMovieTitle() {
		return MovieTitle;
	}
	public void setMovieTitle(String movieTitle) {
		MovieTitle = movieTitle;
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
	public int getNbSeat() {
		return NbSeat;
	}
	public void setNbSeat(int nbSeat) {
		NbSeat = nbSeat;
	}
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
}
