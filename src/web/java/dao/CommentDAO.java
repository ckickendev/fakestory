package web.java.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import web.java.model.Comment;
import web.java.utils.ConnectDB;

public class CommentDAO {
	public List<Comment> findAll() {
		List<Comment> all = new ArrayList<Comment>();
		Connection con = new ConnectDB().getDBConnection();
		String query = "select * from comment where status = 1";
		PreparedStatement ps = null;
		ResultSet rs = null;
		if (con != null) {
			try {
				ps = con.prepareStatement(query);
				rs = ps.executeQuery();
				while (rs.next()) {
					all.add(new Comment(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getInt(4), rs.getTimestamp(5),
							rs.getInt(6)));
				}
				return all;
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	public List<Comment> findAllCommentByPostId(int id) {
		List<Comment> all = new ArrayList<Comment>();
		Connection con = new ConnectDB().getDBConnection();
		String query = "select * from comment where post_id = ? and status = 1 order by date_comment asc ";
		PreparedStatement ps = null;
		ResultSet rs = null;
		if (con != null) {
			try {
				ps = con.prepareStatement(query);
				ps.setInt(1, id);
				rs = ps.executeQuery();
				while (rs.next()) {
					all.add(new Comment(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getInt(4), rs.getTimestamp(5),
							rs.getInt(6)));
				}
				return all;
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	public void addComment(Comment comment) {
		System.out.print("alo");
		Connection con = new ConnectDB().getDBConnection();
		String query = "insert into comment(user_rep_id, content, post_id, date_comment, reply_comment_id , status) values (? , ?, ?, ?, ?, 1)";
		PreparedStatement ps = null;
		if (con != null) {
			try {
				ps = con.prepareStatement(query);
				ps.setInt(1, comment.getUserid());
				ps.setString(2, comment.getContent());
				ps.setInt(3, comment.getPost_id());
				ps.setTimestamp(4, comment.getDatetime());
				ps.setInt(5, comment.getRep_id());
				System.out.print(ps);
				ps.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void deleteComment(int comment_id) {
		Connection con = new ConnectDB().getDBConnection();
		String query = "update comment set status = -1 where comment_id = ?";
		PreparedStatement ps = null;
		if (con != null) {
			try {
				ps = con.prepareStatement(query);
				ps.setInt(1, comment_id);
				ps.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
