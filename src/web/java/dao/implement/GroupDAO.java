package web.java.dao.implement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import web.java.model.Group;
import web.java.utils.ConnectDB;

public class GroupDAO {
    public List<Group> findAll() {
    List<Group> allGroups = new ArrayList<Group>();
	Connection con = new ConnectDB().getDBConnection();
	String query = "select * from group";
	PreparedStatement ps = null;
	ResultSet rs = null;
	if (con != null) {
	    try {
		ps = con.prepareStatement(query);
		rs = ps.executeQuery();
		while (rs.next()) {
		    allGroups.add(
//			    (int id, String name, String des, Timestamp dateCreate, int totalMember)
			    new Group(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getTimestamp(4),
				    rs.getInt(5)));
		}
		return allGroups;
	    } catch (SQLException e) {
		e.printStackTrace();
	    }
	}
	return null;
    }
}
