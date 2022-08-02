package web.java.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import web.java.model.Message;
import web.java.utils.ConnectDB;

public class MessageDAO {
	public List<Message> findAll() {
		List<Message> all = new ArrayList<Message>();
		Connection con = new ConnectDB().getDBConnection();
		String query = "select * from message";
		PreparedStatement ps = null;
		ResultSet rs = null;
		if (con != null) {
			try {
				ps = con.prepareStatement(query);
				rs = ps.executeQuery();
				while (rs.next()) {
//   		 int userFrom, int userTo, String content, Timestamp dateTime
					all.add(new Message(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getTimestamp(4)));
				}
				return all;
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	public Set<Integer> getListUserChatById(int id) {
		Set<Integer> hash_Set = new HashSet<Integer>();
		Connection con = new ConnectDB().getDBConnection();
		String query = "SELECT * FROM fakebook.message where user_id = ? group by user_to ";
		PreparedStatement ps = null;
		ResultSet rs = null;
		if (con != null) {
			try {
				ps = con.prepareStatement(query);
				ps.setInt(1, id);
				rs = ps.executeQuery();
				while (rs.next()) {
					hash_Set.add(rs.getInt(3));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		query = "SELECT * FROM fakebook.message where user_to = ? group by user_id";
		if (con != null) {
			try {
				ps = con.prepareStatement(query);
				ps.setInt(1, id);
				rs = ps.executeQuery();
				while (rs.next()) {
					hash_Set.add(rs.getInt(2));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return hash_Set;
	}

	public List<Message> getMessageBetweenTwoPeople(int user_id, int user_to) {

		List<Message> all = new ArrayList<Message>();
		Connection con = new ConnectDB().getDBConnection();
		String query = "SELECT * FROM fakebook.message where (user_id = ? and user_to = ?) or (user_id = ? and user_to = ?) ;";
		PreparedStatement ps = null;
		ResultSet rs = null;
		if (con != null) {
			try {
				ps = con.prepareStatement(query);
				ps.setInt(1, user_id);
				ps.setInt(2, user_to);
				ps.setInt(3, user_to);
				ps.setInt(4, user_id);
				rs = ps.executeQuery();
				while (rs.next()) {
					all.add(new Message(rs.getInt(2), rs.getInt(3), rs.getString(4), rs.getTimestamp(5)));
				}
				return all;
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}
	
	public Message getLastMessageBetweenTwoPeople(int user_id, int user_to) {

		Message lmessage = null;
		Connection con = new ConnectDB().getDBConnection();
		String query = "SELECT * FROM fakebook.message where (user_id = ? and user_to = ?) or (user_id = ? and user_to = ?) order by date_time desc limit 1 ;";
		PreparedStatement ps = null;
		ResultSet rs = null;
		if (con != null) {
			try {
				ps = con.prepareStatement(query);
				ps.setInt(1, user_id);
				ps.setInt(2, user_to);
				ps.setInt(3, user_to);
				ps.setInt(4, user_id);
				rs = ps.executeQuery();
				while (rs.next()) {
					lmessage = new Message(rs.getInt(2), rs.getInt(3), rs.getString(4), rs.getTimestamp(5));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return lmessage;
	}
	
	public void addMessage (Message message) {
		Connection con = new ConnectDB().getDBConnection();
		String query = "insert into message(user_id, user_to, content, date_time, type) values (?, ?, ?, ?, 1)";
		PreparedStatement ps = null;
		if (con != null) {
			try {
				ps = con.prepareStatement(query);
				ps.setInt(1, message.getUserFrom());
				ps.setInt(2, message.getUserTo());
				ps.setString(3, message.getContent());
				ps.setTimestamp(4, message.getDateTime());
				ps.execute();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
