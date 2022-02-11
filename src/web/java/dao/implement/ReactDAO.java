package web.java.dao.implement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import web.java.dao.IReactDAO;
import web.java.model.React;
import web.java.utils.ConnectDB;

public class ReactDAO implements IReactDAO {
    @Override
    public List<React> findAll() {
	List<React> allReact = new ArrayList<React>();
	Connection con = new ConnectDB().getDBConnection();
	String query = "select * from react";
	PreparedStatement ps = null;
	ResultSet rs = null;
	if(con != null) {
	    try {
		ps = con.prepareStatement(query);
		rs = ps.executeQuery();
		while(rs.next()) {
		    allReact.add(new React(rs.getInt(0), rs.getInt(0), rs.getInt(0), rs.getInt(0)));
		}
		return allReact;
	    } catch (SQLException e) {
		e.printStackTrace();
	    }
	}
	return null;
    }
    

}
