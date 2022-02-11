package web.java.dao.implement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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
   	if(con != null) {
   	    try {
   		ps = con.prepareStatement(query);
   		rs = ps.executeQuery();
   		while(rs.next()) {
//   		 int id, int user, String title, String content, Timestamp datetime
   		    all.add(new Notification(rs.getInt(1), rs.getInt(2), rs.getString(3),rs.getString(4), rs.getTimestamp(5)));
   		}
   		return all;
   	    } catch (SQLException e) {
   		e.printStackTrace();
   	    }
   	}
   	return null;
       }
}
