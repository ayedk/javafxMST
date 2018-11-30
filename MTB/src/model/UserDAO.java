package model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import util.DBUtil;

public class UserDAO {
	public static ArrayList<User> getAllUser() throws SQLException, ClassNotFoundException {
        ArrayList<User> userList= new ArrayList<User>();
        
        ResultSet rs = DBUtil.dbExecuteQuery("SELECT * FROM CUSTOMER");
        
        while (rs.next()) {
        	System.out.println(rs.getString(2));
            int id = rs.getShort(1);
            String username = rs.getString(2);
            String name = rs.getString(3);
            String password = rs.getString(4);
            User us = new User(id,username,name,password);
            userList.add(us);
        }

        return userList;
    }
	
	public static void insertUser(User user) throws SQLException, ClassNotFoundException {
		DBUtil.dbExecuteUpdate(
				"BEGIN\n" +
                "INSERT INTO customer\n" +
                "(id, username, name, password)\n" +
                "VALUES\n" +
                "(SEQ_CUSTOMER.nextval, '"+user.getUserName()+"', '"+user.getName()+"','"+user.getPassword()+"');\n" +
                "END;");
	}
}
