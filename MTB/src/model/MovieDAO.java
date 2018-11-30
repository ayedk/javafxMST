package model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import util.DBUtil;

public class MovieDAO {
	public static ArrayList<Movie> getAllMovie() throws SQLException, ClassNotFoundException {
        ArrayList<Movie> MovieList= new ArrayList<Movie>();
        
        ResultSet rs = DBUtil.dbExecuteQuery("SELECT * FROM MOVIE");
        while (rs.next()) {
        		int id = rs.getShort(1);
        		String MovieTitle = rs.getString(2);
        		String desc = rs.getString(3);
        		String bd = rs.getString(4);
        		String fd = rs.getString(5);
        		String g = rs.getString(6);
        		int pv = rs.getInt(7);
        		Movie mv = new Movie(id,MovieTitle,desc,bd,fd,g,pv);
        		MovieList.add(mv);
        }

        return MovieList;
    }
	
	public static void updateMovie(Movie Movie, int nb) throws SQLException, ClassNotFoundException {
		System.out.println("\n updateMovie \n");
		
		DBUtil.dbExecuteUpdate("UPDATE MOVIE SET AVAILABLAPLACE = " + nb +" WHERE ID = "+Movie.getiD());
	}
	
}
