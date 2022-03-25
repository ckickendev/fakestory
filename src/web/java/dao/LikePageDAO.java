package web.java.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import web.java.model.LikePage;
import web.java.utils.ConnectDB;

public class LikePageDAO {
	public List<LikePage> findAll() {
		List<LikePage> allLikePages = new ArrayList<LikePage>();
		Connection con = new ConnectDB().getDBConnection();
		String query = "select * from like_page";
		PreparedStatement ps = null;
		ResultSet rs = null;
		if (con != null) {
			try {
				ps = con.prepareStatement(query);
				rs = ps.executeQuery();
				while (rs.next()) {
//		    int id, int pageId, Timestamp dateLike
					allLikePages.add(new LikePage(rs.getInt(1), rs.getInt(2), rs.getTimestamp(3), rs.getInt(4)));
				}
				return allLikePages;
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	public LikePage findLikePageInPage(int userid, int pageid) {
		LikePage LikePage = null;
		Connection con = new ConnectDB().getDBConnection();
		String query = "select * from like_page where user_id = ? and page_id = ?";
		PreparedStatement ps = null;
		ResultSet rs = null;
		if (con != null) {
			try {
				ps = con.prepareStatement(query);
				ps.setInt(1, userid);
				ps.setInt(2, pageid);
				rs = ps.executeQuery();
				while (rs.next()) {
//    		    int id, int pageId, Timestamp dateLike
					LikePage = new LikePage(rs.getInt(1), rs.getInt(2), rs.getTimestamp(3), rs.getInt(4));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return LikePage;
	}
}
