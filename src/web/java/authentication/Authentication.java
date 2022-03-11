package web.java.authentication;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import web.java.model.User;
import web.java.utils.ConnectDB;

public class Authentication {
	public void Login(String username, String password) {
		User user = null;
		Connection con = new ConnectDB().getDBConnection();
		String query = "select * from user where user_id = ?";
		PreparedStatement ps = null;
		ResultSet rs = null;
		if (con != null) {
			try {
				ps = con.prepareStatement(query);
				rs = ps.executeQuery();
				while (rs.next()) {
					user = new User(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(11),
							rs.getString(12),rs.getInt(6), rs.getString(7), rs.getInt(8), rs.getString(9),rs.getString(13), rs.getInt(14), rs.getTimestamp(10), rs.getTimestamp(14));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
