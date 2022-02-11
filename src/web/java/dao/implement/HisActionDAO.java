package web.java.dao.implement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import web.java.model.HistoryAction;
import web.java.utils.ConnectDB;

public class HisActionDAO {
    public List<HistoryAction> findAll() {
	List<HistoryAction> allHAs = new ArrayList<HistoryAction>();
	Connection con = new ConnectDB().getDBConnection();
	String query = "select * from history_action";
	PreparedStatement ps = null;
	ResultSet rs = null;
	if (con != null) {
	    try {
		ps = con.prepareStatement(query);
		rs = ps.executeQuery();
		while (rs.next()) {
		    allHAs.add(new HistoryAction(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getInt(4),
			    rs.getTimestamp(5)));
		}
		return allHAs;
	    } catch (SQLException e) {
		e.printStackTrace();
	    }
	}
	return null;
    }
}
