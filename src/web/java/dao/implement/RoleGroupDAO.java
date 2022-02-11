package web.java.dao.implement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import web.java.model.RoleGroup;
import web.java.utils.ConnectDB;

public class RoleGroupDAO {
    public List<RoleGroup> findAll() {
	List<RoleGroup> all = new ArrayList<RoleGroup>();
	Connection con = new ConnectDB().getDBConnection();
	String query = "select * from role_group";
	PreparedStatement ps = null;
	ResultSet rs = null;
	if(con != null) {
	    try {
		ps = con.prepareStatement(query);
		rs = ps.executeQuery();
		while(rs.next()) {
		    all.add(new RoleGroup(rs.getInt(1), rs.getString(2), rs.getString(3)));
		}
		return all;
	    } catch (SQLException e) {
		e.printStackTrace();
	    }
	}
	return null;
    }
}
