package web.java.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import web.java.model.TagPost;
import web.java.utils.ConnectDB;

public class TagPostDAO {
    public List<TagPost> findAll() {
	List<TagPost> all = new ArrayList<TagPost>();
	Connection con = new ConnectDB().getDBConnection();
	String query = "select * from tag_post";
	PreparedStatement ps = null;
	ResultSet rs = null;
	if(con != null) {
	    try {
		ps = con.prepareStatement(query);
		rs = ps.executeQuery();
		while(rs.next()) {
		    all.add(new TagPost(rs.getInt(1), rs.getInt(2)));
		}
		return all;
	    } catch (SQLException e) {
		e.printStackTrace();
	    }
	}
	return null;
    }
}
