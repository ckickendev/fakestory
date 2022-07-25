package web.java.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import web.java.model.Notification;
import web.java.utils.ConnectDB;

public class NotificationDAO {
	public List<Notification> findAll() {
		List<Notification> all = new ArrayList<Notification>();
		Connection con = new ConnectDB().getDBConnection();
		String query = "select * from notification";
		PreparedStatement ps = null;
		ResultSet rs = null;
		if (con != null) {
			try {
				ps = con.prepareStatement(query);
				rs = ps.executeQuery();
				while (rs.next()) {
//   		 int id, int user, String title, String content, Timestamp datetime
					all.add(new Notification(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4),
							rs.getTimestamp(5), rs.getInt(6), rs.getInt(7)));
				}
				return all;
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}
	
	public List<Notification> findAllNotiByUserId(int id) {
		List<Notification> all = new ArrayList<Notification>();
		Connection con = new ConnectDB().getDBConnection();
		String query = "select * from notification where user_id = ?";
		PreparedStatement ps = null;
		ResultSet rs = null;
		if (con != null) {
			try {
				ps = con.prepareStatement(query);
				ps.setInt(1, id);
				rs = ps.executeQuery();
				while (rs.next()) {
					all.add(new Notification(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4),
							rs.getTimestamp(5), rs.getInt(6), rs.getInt(7)));
				}
				return all;
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}
	
	public void addNotification(int userId, String title, String content, int type, int userCurrentId) {
		Connection con = new ConnectDB().getDBConnection();
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
	
//	public Notification findFriendRequest() {
//		List<Notification> all = new ArrayList<Notification>();
//		Connection con = new ConnectDB().getDBConnection();
//		String query = "select * from notification";
//		PreparedStatement ps = null;
//		ResultSet rs = null;
//		if (con != null) {
//			try {
//				ps = con.prepareStatement(query);
//				rs = ps.executeQuery();
//				while (rs.next()) {
////   		 int id, int user, String title, String content, Timestamp datetime
//					all.add(new Notification(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4),
//							rs.getTimestamp(5), rs.getInt(6)));
//				}
//				return all;
//			} catch (SQLException e) {
//				e.printStackTrace();
//			}
//		}
//		return null;
//	}
}
