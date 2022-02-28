package web.java.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import web.java.model.React;
import web.java.utils.ConnectDB;

public class ReactDAO {
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
    
    public int getReactInPost(int id) {
	int react = 0;
	Connection con = new ConnectDB().getDBConnection();
	String query = "select * from post where post_id = ?";
	PreparedStatement ps = null;
	ResultSet rs = null;
	if(con != null) {
	    try {
		ps = con.prepareStatement(query);
		ps.setInt(1, id);
		rs = ps.executeQuery();
		while(rs.next()) {
		    
		    react = rs.getInt(6);
		}
		
	    } catch (SQLException e) {
		e.printStackTrace();
	    }
	}
	return react;
    }
    
    public void react(int user, int post, int type) {
	Connection con = new ConnectDB().getDBConnection();
	String query = "select * from react where post_id = ? and user_react = ? ";
	PreparedStatement ps = null;
	ResultSet rs = null;
	if(con != null) {
	    try {
		ps = con.prepareStatement(query);
		ps.setInt(1, post);
		ps.setInt(2, user);
		rs = ps.executeQuery();
		if(rs.next()) {
		    if(rs.getInt(2) != type) {
			updateReact(user, post, type);
		    }
		}else {
		    addReact(user, post, type);
		}
	    } catch (SQLException e) {
		e.printStackTrace();
	    }
	}
    }
    
    public void addReact(int user, int post, int type) {
	Connection con = new ConnectDB().getDBConnection();
	String query = "insert into react(react_type, user_react, post_id) values (? , ?, ?)";
	PreparedStatement ps = null;
	if(con != null) {
	    try {
		ps = con.prepareStatement(query);
		ps.setInt(1, user);
		ps.setInt(2, post);
		ps.setInt(3, type);
		ps.execute();
	    } catch (SQLException e) {
		e.printStackTrace();
	    }
	}
    }
    
    public void updateReact(int user, int post, int type) {
	Connection con = new ConnectDB().getDBConnection();
	String query = "update react set react_type = ?, user_react = ?, post_id =? ";
	PreparedStatement ps = null;
	if(con != null) {
	    try {
		ps = con.prepareStatement(query);
		ps.setInt(1, type);
		ps.setInt(2, user);
		ps.setInt(3, post);
		ps.execute();
	    } catch (SQLException e) {
		e.printStackTrace();
	    }
	}
    }
    

}
