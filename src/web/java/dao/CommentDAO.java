package web.java.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import web.java.model.Comment;
import web.java.utils.ConnectDB;

public class CommentDAO {
    public List<Comment> findAll() {
	List<Comment> all = new ArrayList<Comment>();
	Connection con = new ConnectDB().getDBConnection();
	String query = "select * from comment";
	PreparedStatement ps = null;
	ResultSet rs = null;
	if(con != null) {
	    try {
		ps = con.prepareStatement(query);
		rs = ps.executeQuery();
		while(rs.next()) {
		    all.add(new Comment(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getInt(4), rs.getTimestamp(5), rs.getInt(6)));
		}
		return all;
	    } catch (SQLException e) {
		e.printStackTrace();
	    }
	}
	return null;
    }
    
    
}