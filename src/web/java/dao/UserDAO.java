package web.java.dao;

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
	User user = null;
	Connection con = new ConnectDB().getDBConnection();
	String query = "select * from user where user_id = ?";
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

    public void addUser(User user) {
	Connection con = new ConnectDB().getDBConnection();
	String query = "insert into user(email, password, fullname, phone, role_id, description, number_friends, country, date_create ) values (?,?,?,?,?,?,?,?,?) ";
	PreparedStatement ps = null;
	if (con != null) {
	    try {
		ps = con.prepareStatement(query);
		ps.setString(1, user.getUsername());
		ps.setString(2, user.getPassword());
		ps.setString(3, user.getFullname());
		ps.setString(4, user.getPhone());
		ps.setInt(5, user.getRole_id());
		ps.setString(6, user.getDescription());
		ps.setInt(7, user.getNumberFriends());
		ps.setString(8, user.getCountry());
		ps.setTimestamp(9, user.getDateCreate());
		ps.executeUpdate();
	    } catch (SQLException e) {
		e.printStackTrace();
	    }
	}
    }

    public void deleteUserById(int id) {
	Connection con = new ConnectDB().getDBConnection();
	String query = "delete from user where user_id = ?";
	PreparedStatement ps = null;
//	ResultSet rs = null;
	if (con != null) {
	    try {
		ps = con.prepareStatement(query);
		ps.setInt(1, id);
		ps.execute();
	    } catch (SQLException e) {
		e.printStackTrace();
	    }
	}
    }

    public void modifyUser(User user, int id) {
	Connection con = new ConnectDB().getDBConnection();
	String query = "update user set email = ?, password = ?, fullname = ?, phone = ?, role_id = ?, description = ?, number_friends = ? , country = ?, date_create = ? where user_id = ?";
	PreparedStatement ps = null;
//	ResultSet rs = null;
	if (con != null) {
	    try {
		ps = con.prepareStatement(query);
		ps.setString(1, user.getUsername());
		ps.setString(2, user.getPassword());
		ps.setString(3, user.getFullname());
		ps.setString(4, user.getPhone());
		ps.setInt(5, user.getRole_id());
		ps.setString(6, user.getDescription());
		ps.setInt(7, user.getNumberFriends());
		ps.setString(8, user.getCountry());
		ps.setTimestamp(9, user.getDateCreate());
		ps.setInt(10, id);
		ps.executeUpdate();
	    } catch (SQLException e) {
		e.printStackTrace();
	    }
	}
    }
}
