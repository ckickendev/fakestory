package web.java.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import web.java.model.PostGroup;
import web.java.utils.ConnectDB;

public class PostGroupDAO {
    public List<PostGroup> findAll() {
	List<PostGroup> all = new ArrayList<PostGroup>();
	Connection con = new ConnectDB().getDBConnection();
	String query = "select * from post_in_group";
	PreparedStatement ps = null;
	ResultSet rs = null;
	if (con != null) {
	    try {
		ps = con.prepareStatement(query);
		rs = ps.executeQuery();
		while (rs.next()) {
//   		 int id, String content, String image, int user, Timestamp time, int react
		    all.add(new PostGroup(rs.getInt(1), rs.getInt(2)));
		}
		return all;
	    } catch (SQLException e) {
		e.printStackTrace();
	    }
	}
	return null;
    }
}
