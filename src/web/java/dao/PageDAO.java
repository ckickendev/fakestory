package web.java.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import web.java.model.Page;
import web.java.utils.ConnectDB;

public class PageDAO {
	public List<Page> findAll() {
		List<Page> all = new ArrayList<Page>();
		Connection con = new ConnectDB().getDBConnection();
		String query = "select * from page";
		PreparedStatement ps = null;
		ResultSet rs = null;
		if (con != null) {
			try {
				ps = con.prepareStatement(query);
				rs = ps.executeQuery();
				while (rs.next()) {
//   		 int id, String name, String description, Timestamp dateCreate, int liked
					all.add(new Page(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getTimestamp(4), rs.getInt(5), rs.getString(6), rs.getString(7)));
				}
				return all;
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	public Page findPageById(int id) {
		Page page = null;
		Connection con = new ConnectDB().getDBConnection();
		String query = "select * from page where page_id = ?";
		PreparedStatement ps = null;
		ResultSet rs = null;
		if (con != null) {
			try {
				ps = con.prepareStatement(query);
				ps.setInt(1, id);
				rs = ps.executeQuery();
				while (rs.next()) {
					page = new Page(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getTimestamp(4), rs.getInt(5), rs.getString(6), rs.getString(7));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return page;
	}
	
	public List<Page> findPageByUserId(int id) {
		List<Page> pages = new ArrayList<Page>();
	
		Connection con = new ConnectDB().getDBConnection();
		String query = "select * from page where page_id in (select page_id from like_page where user_id = ?)";
		PreparedStatement ps = null;
		ResultSet rs = null;
		if (con != null) {
			try {
				ps = con.prepareStatement(query);
				ps.setInt(1, id);
				rs = ps.executeQuery();
				while (rs.next()) {
					pages.add(new Page(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getTimestamp(4), rs.getInt(5), rs.getString(6), rs.getString(7)));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return pages;
	}
	
	public void addPage(String name, String des, Timestamp time) {
		Connection con = new ConnectDB().getDBConnection();
		String query = "insert into page(page_name, page_description, date_create, total_like) values (?, ?, ?, 0)";
		PreparedStatement ps = null;
		if (con != null) {
			try {
				ps = con.prepareStatement(query);
				ps.setString(1, name);
				ps.setString(2, des);
				ps.setTimestamp(3, time);
				ps.execute();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void deletePage(String id) {
		Connection con = new ConnectDB().getDBConnection();
		String query = "delete from page where id = ?";
		PreparedStatement ps = null;
		if (con != null) {
			try {
				ps = con.prepareStatement(query);
				ps.setString(1, id);
				ps.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
