package web.java.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import web.java.model.User;
import web.java.utils.ConnectDB;
import web.java.utils.GeneralFunction;

public class UserDAO {
	public List<User> findAll() {
		List<User> allUsers = new ArrayList<User>();
		Connection con = new ConnectDB().getDBConnection();
		String query = "select * from user";
		PreparedStatement ps = null;
		ResultSet rs = null;
		if (con != null) {
			try {
				ps = con.prepareStatement(query);
				rs = ps.executeQuery();
				while (rs.next()) {
					allUsers.add(new User(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),
							rs.getString(5), rs.getString(11), rs.getString(12), rs.getInt(6), rs.getString(7),
							rs.getInt(8), rs.getString(9), rs.getString(13), rs.getInt(15), rs.getTimestamp(10),
							rs.getTimestamp(14)));
				}
				return allUsers;
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	public User findUserByID(int id) {
		User user = null;
		Connection con = new ConnectDB().getDBConnection();
		String query = "select * from user where user_id = ?";
		PreparedStatement ps = null;
		ResultSet rs = null;
		if (con != null) {
			try {
				ps = con.prepareStatement(query);
				ps.setInt(1, id);
				rs = ps.executeQuery();
				while (rs.next()) {
					user = new User(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
							rs.getString(11), rs.getString(12), rs.getInt(6), rs.getString(7), rs.getInt(8),
							rs.getString(9), rs.getString(13), rs.getInt(15), rs.getTimestamp(10), rs.getTimestamp(14));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return user;
	}

	public List<User> findUserByGroupId(int id) {

		List<User> users = new ArrayList<User>();
		Connection con = new ConnectDB().getDBConnection();
		String query = "select * from user where user_id in (select user_id from member where group_id = ?)";
		PreparedStatement ps = null;
		ResultSet rs = null;
		if (con != null) {
			try {
				ps = con.prepareStatement(query);
				ps.setInt(1, id);
				rs = ps.executeQuery();
				while (rs.next()) {
					User user = new User(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),
							rs.getString(5), rs.getString(11), rs.getString(12), rs.getInt(6), rs.getString(7),
							rs.getInt(8), rs.getString(9), rs.getString(13), rs.getInt(15), rs.getTimestamp(10),
							rs.getTimestamp(14));
					users.add(user);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return users;
	}

	public List<User> findUserByPage(int id) {

		List<User> users = new ArrayList<User>();
		Connection con = new ConnectDB().getDBConnection();
		String query = "select * from user where user_id in (select user_id from like_page where page_id = ?)";
		PreparedStatement ps = null;
		ResultSet rs = null;
		if (con != null) {
			try {
				ps = con.prepareStatement(query);
				ps.setInt(1, id);
				rs = ps.executeQuery();
				while (rs.next()) {
					User user = new User(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),
							rs.getString(5), rs.getString(11), rs.getString(12), rs.getInt(6), rs.getString(7),
							rs.getInt(8), rs.getString(9), rs.getString(13), rs.getInt(15), rs.getTimestamp(10),
							rs.getTimestamp(14));
					users.add(user);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return users;
	}

	public void addUser(User user) {
		Connection con = new ConnectDB().getDBConnection();
		String query = "insert into user(email, password, fullname, phone, role_id, description, number_friends, country, date_create, avatar, background, live, birthday,sex ) values (?,?,?,?,?,?,?,?,?,?,?,?,?, ?) ";
		PreparedStatement ps = null;
		if (con != null) {
			try {
				ps = con.prepareStatement(query);
				ps.setString(1, user.getUsername());
				ps.setString(2, GeneralFunction.getEncodedString(user.getPassword()));
				ps.setString(3, user.getFullname());
				ps.setString(4, user.getPhone());
				ps.setInt(5, user.getRole_id());
				ps.setString(6, user.getDescription());
				ps.setInt(7, user.getNumberFriends());
				ps.setString(8, user.getCountry());
				ps.setTimestamp(9, user.getDateCreate());
				ps.setString(10, user.getAvatar());
				ps.setString(11, user.getBackground());
				ps.setString(12, user.getLive());
				ps.setTimestamp(13, user.getBirthday());
				ps.setInt(14, user.getSex());
				ps.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public void deleteUserById(int id) {
		Connection con = new ConnectDB().getDBConnection();
		String query = "delete from user where user_id = ?";
		PreparedStatement ps = null;
//	ResultSet rs = null;
		if (con != null) {
			try {
				ps = con.prepareStatement(query);
				ps.setInt(1, id);
				ps.execute();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public void modifyUser(User user, int id) {
		Connection con = new ConnectDB().getDBConnection();
		String query = "update user set email = ?, password = ?, fullname = ?, phone = ?, role_id = ?, description = ?, number_friends = ? , country = ?, date_create = ? where user_id = ?";
		PreparedStatement ps = null;
//	ResultSet rs = null;
		if (con != null) {
			try {
				ps = con.prepareStatement(query);
				ps.setString(1, user.getUsername());
				ps.setString(2, GeneralFunction.getEncodedString(user.getPassword()));
				ps.setString(3, user.getFullname());
				ps.setString(4, user.getPhone());
				ps.setInt(5, user.getRole_id());
				ps.setString(6, user.getDescription());
				ps.setInt(7, user.getNumberFriends());
				ps.setString(8, user.getCountry());
				ps.setTimestamp(9, user.getDateCreate());
				ps.setInt(10, id);
				ps.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public User login(String username, String password) {
		User user = null;
		Connection con = new ConnectDB().getDBConnection();
		String passwordEn = GeneralFunction.getEncodedString(password);

		String query = "select * from user where email = ? and password = ?";
		PreparedStatement ps = null;
		ResultSet rs = null;
		if (con != null) {
			try {
				ps = con.prepareStatement(query);
				ps.setString(1, username);
				ps.setString(2, passwordEn);
				rs = ps.executeQuery();
				if (rs.next()) {
					user = new User(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
							rs.getString(11), rs.getString(12), rs.getInt(6), rs.getString(7), rs.getInt(8),
							rs.getString(9), rs.getString(13), rs.getInt(15), rs.getTimestamp(10), rs.getTimestamp(14));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return user;
	}

	public String[] findAllImageByUserId(int id) {
		String[] photos = new String[9];
		int index = 0;
		Connection con = new ConnectDB().getDBConnection();

		String query = "select image as img from post where user_id = ? order by date_time desc";
		PreparedStatement ps = null;
		ResultSet rs = null;
		if (con != null) {
			try {
				ps = con.prepareStatement(query);
				ps.setInt(1, id);
				rs = ps.executeQuery();
				while (rs.next()) {
					if (rs.getString(1).isEmpty()) {
						continue;
					}
					photos[index] = rs.getString(1);
					index++;
					if (index == 9) {
						break;
					}
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return photos;
	}

	public int[] findFriendId(int id, int number) {
		int[] idArray = new int[20];
		int index = 0;
		Connection con = new ConnectDB().getDBConnection();
		String query = "select user_id_2 as user_id from friend_status where user_id_1 = ? and status = 1 ";
		PreparedStatement ps = null;
		ResultSet rs = null;
		if (con != null) {
			try {
				ps = con.prepareStatement(query);
				ps.setInt(1, id);
				rs = ps.executeQuery();
				while (rs.next()) {
					idArray[index] = rs.getInt(1);
					index++;
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		query = "select user_id_1 as user_id from friend_status where user_id_2 = ? and status = 1 ";
		ps = null;
		rs = null;
		if (con != null) {
			try {
				ps = con.prepareStatement(query);
				ps.setInt(1, id);
				rs = ps.executeQuery();
				while (rs.next()) {
					idArray[index] = rs.getInt(1);
					index++;
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		int sizeId = index;
		int size = number > sizeId ? sizeId : number;
		int[] cloneArr = new int[size];
		for (int i = 0; i < size; i++) {
			cloneArr[i] = idArray[i];
		}
		return cloneArr;
	}

	public List<User> findAllFriendById(int id, int number) {
		List<User> users = new ArrayList<User>();
		Connection con = new ConnectDB().getDBConnection();
		String query = "select * from user where user_id in (select user_id_2 as user_id from friend_status where user_id_1 = ? and status = 1 )";
		PreparedStatement ps = null;
		ResultSet rs = null;
		if (con != null) {
			try {
				ps = con.prepareStatement(query);
				ps.setInt(1, id);
				rs = ps.executeQuery();
				while (rs.next()) {
					users.add(new User(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
							rs.getString(11), rs.getString(12), rs.getInt(6), rs.getString(7), rs.getInt(8),
							rs.getString(9), rs.getString(13), rs.getInt(15), rs.getTimestamp(10),
							rs.getTimestamp(14)));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		query = "select * from user where user_id in (select user_id_1 as user_id from friend_status where user_id_2 = ? and status = 1 )";
		ps = null;
		rs = null;
		if (con != null) {
			try {
				ps = con.prepareStatement(query);
				ps.setInt(1, id);
				rs = ps.executeQuery();
				while (rs.next()) {
					users.add(new User(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
							rs.getString(11), rs.getString(12), rs.getInt(6), rs.getString(7), rs.getInt(8),
							rs.getString(9), rs.getString(13), rs.getInt(15), rs.getTimestamp(10),
							rs.getTimestamp(14)));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		int size = number > users.size() ? users.size() : number;
		List<User> userClone = new ArrayList<User>(size);
		for (int i = 0; i < size; i++) {
			userClone.add(users.get(i));
		}
		return userClone;
	}

	public void changeAvatar(String userId, String image) {
		Connection con = new ConnectDB().getDBConnection();
		String query = "update user set avatar = ? where user_id = ?";
		PreparedStatement ps = null;
		if (con != null) {
			try {
				ps = con.prepareStatement(query);
				ps.setString(1, image);
				ps.setString(2, userId);
				ps.executeUpdate();
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public int checkRelationship(int userId, int userCurrentId) {
		int relationship = 2;
		Connection con = new ConnectDB().getDBConnection();
		String query = "select * from friend_status where user_id_1 = ? and user_id_2 = ? or user_id_1 = ? and user_id_2 = ? ";
		PreparedStatement ps = null;
		ResultSet rs = null;
		if (con != null) {
			try {
				ps = con.prepareStatement(query);
				ps.setInt(1, userId);
				ps.setInt(2, userCurrentId);
				ps.setInt(3, userCurrentId);
				ps.setInt(4, userId);
				rs = ps.executeQuery();
				while (rs.next()) {
					relationship = rs.getInt(4);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return relationship;
	} 
	
	public int checkRecieveOrRequest(int userId, int userCurrentId) {
		Connection con = new ConnectDB().getDBConnection();
		String query = "select * from friend_status where user_id_1 = ? and user_id_2 = ?";
		PreparedStatement ps = null;
		ResultSet rs = null;
		if (con != null) {
			try {
				ps = con.prepareStatement(query);
				ps.setInt(1, userId);
				ps.setInt(2, userCurrentId);
				rs = ps.executeQuery();
				while (rs.next()) {
					return 1;
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return 0;
	}

}
