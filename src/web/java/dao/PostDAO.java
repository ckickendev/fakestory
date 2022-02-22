package web.java.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
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
    
    public Post findPostById(int id) {
	Post post = null;
	Connection con = new ConnectDB().getDBConnection();
	String query = "select * from post where post_id = ?";
	PreparedStatement ps = null;
	ResultSet rs = null;
	if (con != null) {
	    try {
		ps = con.prepareStatement(query);
		ps.setInt(1, id);
		rs = ps.executeQuery();
		while (rs.next()) {
		    post = new Post(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getTimestamp(5),
			    rs.getInt(6));
		}
	    } catch (SQLException e) {
		e.printStackTrace();
	    }
	}
	return post;
    }

    public void addPost(String content, String image, int user_id, Timestamp date_time, int number_react) {
	Connection con = new ConnectDB().getDBConnection();
	String query = "insert into post(content, image, user_id, date_time, number_react) values (?,?,?,?,?) ";
	PreparedStatement ps = null;
	if (con != null) {
	    try {
		ps = con.prepareStatement(query);
		ps.setString(1, content);
		ps.setString(2, image);
		ps.setInt(3, user_id);
		ps.setTimestamp(4, date_time);
		ps.setInt(5, number_react);
		System.out.print(ps);
		ps.executeUpdate();
	    } catch (SQLException e) {
		e.printStackTrace();
	    }
	}
    }
    
    public void deletePost(int post_id) {
	Connection con = new ConnectDB().getDBConnection();
	String query = "delete * from post where post_id = ?";
	PreparedStatement ps = null;
	if (con != null) {
	    try {
		ps = con.prepareStatement(query);
		ps.setInt(1, post_id);
		ps.executeUpdate();
	    } catch (SQLException e) {
		e.printStackTrace();
	    }
	}
    }
}
