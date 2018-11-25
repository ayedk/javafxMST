package model;

public class Booking {
	public int NoTicket = 1;
	static private int NoSeat = 3;
	public String MovieName ;
	
	void UpdateSeat() {
		NoSeat -=1;
	};
	void SetNoSeat(int s) {
		NoSeat = s;
	}
}
