package web.java.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import web.java.model.Role;
import web.java.utils.ConnectDB;

public class RoleDAO {
    public List<Role> findAll() {
	List<Role> all = new ArrayList<Role>();
	Connection con = new ConnectDB().getDBConnection();
	String query = "select * from role";
	PreparedStatement ps = null;
	ResultSet rs = null;
	if(con != null) {
	    try {
		ps = con.prepareStatement(query);
		rs = ps.executeQuery();
		while(rs.next()) {
		    all.add(new Role(rs.getInt(1), rs.getString(2), rs.getString(3)));
		}
		return all;
	    } catch (SQLException e) {
		e.printStackTrace();
	    }
	}
	return null;
    }
}
