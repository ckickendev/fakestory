package web.java.utils;

import java.util.List;

import web.java.dao.UserDAO;
import web.java.model.User;

public class Test {
	public static void main(String[] args) {
		List<User> users = new UserDAO().findAllFriendByIdUnlimited(Integer.valueOf(1));
		System.out.println(users);
	}
}
