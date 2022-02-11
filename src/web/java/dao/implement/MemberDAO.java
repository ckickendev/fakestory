package web.java.dao.implement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import web.java.model.Member;
import web.java.utils.ConnectDB;

public class MemberDAO {
    public List<Member> findAll() {
	List<Member> all = new ArrayList<Member>();
	Connection con = new ConnectDB().getDBConnection();
	String query = "select * from member";
	PreparedStatement ps = null;
	ResultSet rs = null;
	if(con != null) {
	    try {
		ps = con.prepareStatement(query);
		rs = ps.executeQuery();
		while(rs.next()) {
//		    int user_id, int group_id, int role
		    all.add(new Member(rs.getInt(1), rs.getInt(2), rs.getInt(3)));
		}
		return all;
	    } catch (SQLException e) {
		e.printStackTrace();
	    }
	}
	return null;
    }
}
