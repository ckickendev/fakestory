package web.java.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import web.java.model.Comment;
import web.java.model.Post;
import web.java.utils.ConnectDB;

public class PostDAO {
	public List<Post> findAll() {
		List<Post> all = new ArrayList<Post>();
		Connection con = new ConnectDB().getDBConnection();
		String query = "select * from post";
		PreparedStatement ps = null;
		ResultSet rs = null;
		if (con != null) {
			try {
				ps = con.prepareStatement(query);
				rs = ps.executeQuery();
				while (rs.next()) {
//   		 int id, String content, String image, int user, Timestamp time, int react
					all.add(new Post(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getTimestamp(5),
							rs.getInt(6), rs.getInt(7)));
				}
				return all;
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	public Post findPostById(int id) {
		Post post = null;
		Connection con = new ConnectDB().getDBConnection();
		String query = "select * from post where post_id = ?";
		PreparedStatement ps = null;
		ResultSet rs = null;
		if (con != null) {
			try {
				ps = con.prepareStatement(query);
				ps.setInt(1, id);
				rs = ps.executeQuery();
				while (rs.next()) {
					post = new Post(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getTimestamp(5),
							rs.getInt(6), rs.getInt(7));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return post;
	}

	public void addPost(String content, String image, int user_id, Timestamp date_time, int number_react) {
		Connection con = new ConnectDB().getDBConnection();
		String query = "insert into post(content, image, user_id, date_time, number_react) values (?,?,?,?,?) ";
		PreparedStatement ps = null;
		if (con != null) {
			try {
				ps = con.prepareStatement(query);
				ps.setString(1, content);
				ps.setString(2, image);
				ps.setInt(3, user_id);
				ps.setTimestamp(4, date_time);
				ps.setInt(5, number_react);
				ps.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void addPostToGroup(int postId, int groupId) {
		Connection con = new ConnectDB().getDBConnection();
		String query = "insert into post_in_group(post_id, group_id) values (?,?) ";
		PreparedStatement ps = null;
		if (con != null) {
			try {
				ps = con.prepareStatement(query);
				ps.setInt(1, postId);
				ps.setInt(2, groupId);
				ps.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public List<Post> findAllPostByUserId(int id) {
		Connection con = new ConnectDB().getDBConnection();
		String query = "select * from post where user_id = ?";
		List<Post> posts = new ArrayList<Post>();
		PreparedStatement ps = null;
		ResultSet rs = null;
		if (con != null) {
			try {
				ps = con.prepareStatement(query);
				ps.setInt(1, id);
				rs = ps.executeQuery();
				while (rs.next()) {
					posts.add(new Post(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getTimestamp(5),
							rs.getInt(6), rs.getInt(7)));
				}

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return posts;
	}

	public List<Post> findAllPostInGroup(int id) {
		List<Post> all = new ArrayList<Post>();
		Connection con = new ConnectDB().getDBConnection();
		String query = "select * from post where post_id in (select post_id from post_in_group where group_id = ?)";
		PreparedStatement ps = null;
		ResultSet rs = null;
		if (con != null) {
			try {
				ps = con.prepareStatement(query);
				ps.setInt(1, id);
				rs = ps.executeQuery();
				while (rs.next()) {
					all.add(new Post(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getTimestamp(5),
							rs.getInt(6), rs.getInt(7)));
				}
				return all;
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return all;

	}

	public void modifyPost(int post_id, String content, String image, int user_id, Timestamp time, int react) {
		Connection con = new ConnectDB().getDBConnection();
		String query = "update post set content = ?, image = ?, user_id = ?, date_time=?, number_react = ? where id = ?";
		PreparedStatement ps = null;
		if (con != null) {
			try {
				ps = con.prepareStatement(query);
				ps.setString(1, content);
				ps.setString(2, image);
				ps.setInt(3, user_id);
				ps.setTimestamp(4, time);
				ps.setInt(5, react);
				ps.setInt(6, post_id);
				ps.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public void deletePost(int post_id) {
		Connection con = new ConnectDB().getDBConnection();
		String query = "update post set status = -1 where post_id = ?";
		PreparedStatement ps = null;
		if (con != null) {
			try {
				ps = con.prepareStatement(query);
				ps.setInt(1, post_id);
				ps.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void editPost(Post post) {
		Connection con = new ConnectDB().getDBConnection();
		String query = "update post set content = ? where post_id = ?";
		PreparedStatement ps = null;
		if (con != null) {
			try {
				ps = con.prepareStatement(query);
				ps.setString(1, post.getContent());
				ps.setInt(2, post.getId());
				ps.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public Post findLastPost() {
		Connection con = new ConnectDB().getDBConnection();
		String query = "SELECT * FROM post order by date_time desc limit 1";
		PreparedStatement ps = null;
		ResultSet rs = null;
		Post post = null;
		if (con != null) {
			try {
				ps = con.prepareStatement(query);
				rs = ps.executeQuery();
				while (rs.next()) {
					post = new Post(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getTimestamp(5),
							rs.getInt(6), rs.getInt(7));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return post;
	}
	
	public Post findLastPostByUser(int id) {
		Connection con = new ConnectDB().getDBConnection();
		String query = "SELECT * FROM post where user_id = ? order by date_time desc limit 1";
		PreparedStatement ps = null;
		ResultSet rs = null;
		Post post = null;
		if (con != null) {
			try {
				ps = con.prepareStatement(query);
				ps.setInt(1, id);
				rs = ps.executeQuery();
				while (rs.next()) {
					post = new Post(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getTimestamp(5),
							rs.getInt(6), rs.getInt(7));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return post;
	}
	
	public Comment findLastCommentInPost(int id) {
		Connection con = new ConnectDB().getDBConnection();
		String query = "select * from comment where post_id = ? order by date_comment desc limit 1";
		PreparedStatement ps = null;
		ResultSet rs = null;
		Comment comment = null;
		if (con != null) {
			try {
				ps = con.prepareStatement(query);
				ps.setInt(1, id);
				rs = ps.executeQuery();
				while (rs.next()) {
					comment = new Comment(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getInt(4), rs.getTimestamp(5),
							rs.getInt(6));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return comment;
	}

}
