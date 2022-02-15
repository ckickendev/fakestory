package web.java.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import web.java.model.Post;
import web.java.utils.ConnectDB;

public class PostDAO {
    public List<Post> findAll() {
	List<Post> all = new ArrayList<Post>();
	Connection con = new ConnectDB().getDBConnection();
	String query = "select * from post";
	PreparedStatement ps = null;
	ResultSet rs = null;
	if (con != null) {
	    try {
		ps = con.prepareStatement(query);
		rs = ps.executeQuery();
		while (rs.next()) {
//   		 int id, String content, String image, int user, Timestamp time, int react
		    all.add(new Post(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getTimestamp(5),
			    rs.getInt(6)));
		}
		return all;
	    } catch (SQLException e) {
		e.printStackTrace();
	    }
	}
	return null;
    }
}
