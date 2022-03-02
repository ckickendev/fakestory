package web.java.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import web.java.model.Friendship;
import web.java.utils.ConnectDB;

public class FriendShipDAO {
	public List<Friendship> findAll() {
		List<Friendship> allFS = new ArrayList<Friendship>();
		Connection con = new ConnectDB().getDBConnection();
		String query = "select * from friendShip";
		PreparedStatement ps = null;
		ResultSet rs = null;
		if (con != null) {
			try {
				ps = con.prepareStatement(query);
				rs = ps.executeQuery();
				while (rs.next()) {
//		    Friendship(int id, int user_1, int user_2, int status)
					allFS.add(new Friendship(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getInt(4)));
				}
				return allFS;
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}
	
	public void addFriend(int user1, int user2, int status) {
		
		Connection con = new ConnectDB().getDBConnection();
		String query = "insert into friend_status(user_id_1, user_id_2, status) values (?, ?, ?)";
		PreparedStatement ps = null;
		if (con != null) {
			try {
				ps = con.prepareStatement(query);
				ps.setInt(1, user1);
				ps.setInt(2, user2);
				ps.setInt(3, status);
				ps.execute();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}
