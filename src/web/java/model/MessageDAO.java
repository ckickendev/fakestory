package web.java.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import web.java.utils.ConnectDB;

public class MessageDAO {
    public List<Message> findAll() {
   	List<Message> all = new ArrayList<Message>();
   	Connection con = new ConnectDB().getDBConnection();
   	String query = "select * from message";
   	PreparedStatement ps = null;
   	ResultSet rs = null;
   	if(con != null) {
   	    try {
   		ps = con.prepareStatement(query);
   		rs = ps.executeQuery();
   		while(rs.next()) {
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
}
