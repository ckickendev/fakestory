package web.java.dao;

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

    public List<Group> findAllGroupByUserId(int id) {
	List<Group> allGroups = new ArrayList<Group>();
	Connection con = new ConnectDB().getDBConnection();
	String query = "select * from group_fb where group_id in (select group_id as grid from member where user_id = ? ) ; ";
	PreparedStatement ps = null;
	ResultSet rs = null;
	if (con != null) {
	    try {
		ps = con.prepareStatement(query);
		ps.setInt(1, id);
		rs = ps.executeQuery();
		while (rs.next()) {
		    allGroups.add(new Group(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getTimestamp(4),
			    rs.getInt(5)));
		}
		return allGroups;
	    } catch (SQLException e) {
		e.printStackTrace();
	    }
	}
	return null;
    }

    public Group findGroupById(int id) {
	Group group = null;
	Connection con = new ConnectDB().getDBConnection();
	String query = "select * from group_fb where group_id = ? ";
	PreparedStatement ps = null;
	ResultSet rs = null;
	if (con != null) {
	    try {
		ps = con.prepareStatement(query);
		ps.setInt(1, id);
		rs = ps.executeQuery();
		while (rs.next()) {
		    group = new Group(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getTimestamp(4), rs.getInt(5));
		}
	    } catch (SQLException e) {
		e.printStackTrace();
	    }
	}
	return group;
    }
}