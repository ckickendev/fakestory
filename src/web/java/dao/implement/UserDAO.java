package web.java.dao.implement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import web.java.model.User;
import web.java.utils.ConnectDB;

public class UserDAO {
    public List<User> findAll() {
	List<User> allUsers = new ArrayList<User>();
	Connection con = new ConnectDB().getDBConnection();
	String query = "select * from user";
	PreparedStatement ps = null;
	ResultSet rs = null;
	if (con != null) {
	    try {
		ps = con.prepareStatement(query);
		rs = ps.executeQuery();
		while (rs.next()) {
//		    int id, String username, String password, String fullname, String phone, int role_id,
//		    String description, int numberFriends, String country, Timestamp dateCreate)
		    allUsers.add(
			    new User(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
				    rs.getInt(6), rs.getString(7), rs.getInt(8), rs.getString(9), rs.getTimestamp(10)));
		}
		return allUsers;
	    } catch (SQLException e) {
		e.printStackTrace();
	    }
	}
	return null;
    }

    public User findUserByID(int id) {
	User user = null ;
	Connection con = new ConnectDB().getDBConnection();
	String query = "select * from user where id = ?";
	PreparedStatement ps = null;
	ResultSet rs = null;
	if (con != null) {
	    try {
		ps = con.prepareStatement(query);
		ps.setInt(1, id);
		rs = ps.executeQuery();
		while (rs.next()) {
		    user = new User(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
			    rs.getInt(6), rs.getString(7), rs.getInt(8), rs.getString(9), rs.getTimestamp(10));
		}
	    } catch (SQLException e) {
		e.printStackTrace();
	    }
	}
	return user;
    }
}
