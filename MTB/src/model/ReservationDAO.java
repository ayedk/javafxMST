package model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import util.DBUtil;

public class ReservationDAO {
	public static ArrayList<Reservation> getReservationList(User user) throws SQLException, ClassNotFoundException {
        ArrayList<Reservation> ReservationList= new ArrayList<Reservation>();
        
        ResultSet rs2 = DBUtil.dbExecuteQuery("SELECT * FROM RESERVATION WHERE USERID = "+user.getId());
        while(rs2.next()) {
            int id = rs2.getShort(1);
            String mt = rs2.getString(2);
            String sd = rs2.getString(3);
            String st = rs2.getString(4);
            int nb = rs2.getShort(5);
            int usid = rs2.getShort(6);
            Reservation res = new Reservation( id, mt, sd, st, nb, usid);
            ReservationList.add(res);
        }

        return ReservationList;
    }
	
	public static void insertReservation(Reservation Reservation, User user) throws SQLException, ClassNotFoundException {
		System.out.println("\n insertReservation \n");
		DBUtil.dbExecuteUpdate(
				"BEGIN \n"
				+ "INSERT INTO RESERVATION \n"
				+ "(id, MovieTitle, ShowDate, ShowTime, NbSeat, userid) \n"
				+ "VALUES (RESERVATION_SEQ.nextval,'"+Reservation.getMovieTitle()+"','"+Reservation.getShowDate()+"','"+Reservation.getShowTime()+"',"+Reservation.getNbSeat()+","+user.getId()+");\n"
						+ "END;");
	}
}
