package web.java.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import web.java.model.Friendship;
import web.java.model.Notification;
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

	public void sendFriendRequest(int userId, int userCurrentId, int type) {
//		System.out.println("type" + type);
		Connection con = new ConnectDB().getDBConnection();
		if (type == 2) {
			cancelFriendRequest(userId, userCurrentId);
			return;
		}
		if (type == -1) {
			unfriend(userId, userCurrentId);
			return;
		}
		if(type == 5) {
			acceptFriendRequest(userId, userCurrentId);
			addNotification(userId, "Đã chấp nhận lời mời kết bạn", "", 3, userCurrentId);
			return;
		}
		String query = "insert into friend_status(user_id_1, user_id_2, status) values (?, ?, 3)";
		addNotification(userId, "Đã gửi cho bạn lời mời kết bạn", "", 3, userCurrentId);
		PreparedStatement ps = null;
		if (con != null) {
			try {
				ps = con.prepareStatement(query);
				ps.setInt(1, userCurrentId);
				ps.setInt(2, userId);
				ps.execute();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public void cancelFriendRequest(int userId, int userCurrentId) {
		Connection con = new ConnectDB().getDBConnection();
		String query = "delete from friend_status where user_id_1 = ? and user_id_2 = ? and status = 3";
		PreparedStatement ps = null;
		if (con != null) {
			try {
				ps = con.prepareStatement(query);
				ps.setInt(1, userCurrentId);
				ps.setInt(2, userId);
				ps.execute();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void acceptFriendRequest(int userId, int userCurrentId) {
		Connection con = new ConnectDB().getDBConnection();
		String query = "update friend_status set status = 1 where user_id_1 = ? and user_id_2 = ?";
		PreparedStatement ps = null;
		if (con != null) {
			try {
				ps = con.prepareStatement(query);
				ps.setInt(1, userId);
				ps.setInt(2, userCurrentId);
				ps.execute();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public void unfriend(int userId, int userCurrentId) {
		Connection con = new ConnectDB().getDBConnection();
		String query = "delete from friend_status where (user_id_1 = ? and user_id_2 = ? and status = 1) or (user_id_1 = ? and user_id_2 = ? and status = 1)";
		PreparedStatement ps = null;
		if (con != null) {
			try {
				ps = con.prepareStatement(query);
				ps.setInt(1, userId);
				ps.setInt(2, userCurrentId);
				ps.setInt(3, userCurrentId);
				ps.setInt(4, userId);
				System.out.println(ps);
				ps.execute();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public void addNotification(int userId, String title, String content, int type, int userCurrentId) {
		Connection con = new ConnectDB().getDBConnection();
		if(findFriendRequestNotification(userId, 1, userCurrentId) != null) {
			return;
		}
		Date date = new Date();
		Timestamp timestamp = new Timestamp(date.getTime());
		String query = "insert into notification(user_id, title, date_time, status, forward_id) values (?, ?, ?, ?, ?)";
		PreparedStatement ps = null;
		if (con != null) {
			try {
				ps = con.prepareStatement(query);
				ps.setInt(1, userId);
				ps.setString(2, title);
				ps.setTimestamp(3, timestamp);
				ps.setInt(4, type);
				ps.setInt(5, userCurrentId);
				System.out.println(ps);
				ps.execute();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public Notification findFriendRequestNotification(int user_id, int status, int forward_id) {
		Connection con = new ConnectDB().getDBConnection();
		String query = "select * from notification where user_id = ? and status= ? and forward_id = ?";
		PreparedStatement ps = null;
		ResultSet rs = null;
		if (con != null) {
			try {
				ps = con.prepareStatement(query);
				ps.setInt(1, user_id);
				ps.setInt(2, status);
				ps.setInt(3, forward_id);
				rs = ps.executeQuery();
				while (rs.next()) {
					return new Notification(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4),
							rs.getTimestamp(5), rs.getInt(6), rs.getInt(7));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

}
