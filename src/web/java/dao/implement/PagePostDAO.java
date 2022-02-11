package web.java.dao.implement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import web.java.model.PagePost;
import web.java.utils.ConnectDB;

public class PagePostDAO {
    public List<PagePost> findAll() {
   	List<PagePost> all = new ArrayList<PagePost>();
   	Connection con = new ConnectDB().getDBConnection();
   	String query = "select * from page_post";
   	PreparedStatement ps = null;
   	ResultSet rs = null;
   	if(con != null) {
   	    try {
   		ps = con.prepareStatement(query);
   		rs = ps.executeQuery();
   		while(rs.next()) {
//   		 int id, String name, String description, Timestamp dateCreate, int liked
   		    all.add(new PagePost(rs.getInt(1), rs.getInt(2)));
   		}
   		return all;
   	    } catch (SQLException e) {
   		e.printStackTrace();
   	    }
   	}
   	return null;
       }
}
