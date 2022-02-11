package web.java.dao.implement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import web.java.model.Image;
import web.java.utils.ConnectDB;

public class ImageDAO {
//    int id, String name, String data)
    public List<Image> findAll() {
	List<Image> allImages = new ArrayList<Image>();
	Connection con = new ConnectDB().getDBConnection();
	String query = "select * from image";
	PreparedStatement ps = null;
	ResultSet rs = null;
	if(con != null) {
	    try {
		ps = con.prepareStatement(query);
		rs = ps.executeQuery();
		while(rs.next()) {
		    allImages.add(new Image(rs.getInt(1), rs.getString(2), rs.getString(3)));
		}
		return allImages;
	    } catch (SQLException e) {
		e.printStackTrace();
	    }
	}
	return null;
    }
}
