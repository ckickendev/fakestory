package web.java.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import web.java.model.Page;
import web.java.utils.ConnectDB;

public class PageDAO {
    public List<Page> findAll() {
   	List<Page> all = new ArrayList<Page>();
   	Connection con = new ConnectDB().getDBConnection();
   	String query = "select * from page";
   	PreparedStatement ps = null;
   	ResultSet rs = null;
   	if(con != null) {
   	    try {
   		ps = con.prepareStatement(query);
   		rs = ps.executeQuery();
   		while(rs.next()) {
//   		 int id, String name, String description, Timestamp dateCreate, int liked
   		    all.add(new Page(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getTimestamp(4), rs.getInt(5)));
   		}
   		return all;
   	    } catch (SQLException e) {
   		e.printStackTrace();
   	    }
   	}
   	return null;
       }
}
