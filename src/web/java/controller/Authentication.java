package web.java.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;

import web.java.dao.UserDAO;
import web.java.model.MessageAPI;
import web.java.model.User;

/**
 * Servlet implementation class Authentication
 */
@WebServlet("/api/login")
public class Authentication extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Authentication() {
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("application/json;charset=UTF-8");

		ObjectMapper objectMapper = new ObjectMapper();
		PrintWriter printWriter = response.getWriter();

//		 handle request	
		String username = "docute123";
		String password = "docute222";

		// Login
		User user = new UserDAO().login(username, password);
		
		List<MessageAPI> messs = new ArrayList<MessageAPI>();
		if (username.isEmpty() == true || password.isEmpty() == true) {
			MessageAPI apimess = new MessageAPI("mess", "Username and password must not empty");
			String message = objectMapper.writeValueAsString(apimess);
			System.out.print("Mess 1; " + message);
			printWriter.write(message);
			printWriter.close();
		} else {
			if (user != null) {
				String userJsonLogin = objectMapper.writeValueAsString(user);
				printWriter.write(userJsonLogin);
				printWriter.close();
			} else {
				MessageAPI apimess = new MessageAPI("message", "Wrong username and password, please fill again");
				messs.add(apimess);
				String message = objectMapper.writeValueAsString(messs);
				System.out.print("Mess 3; " + message);
				printWriter.write(message);
				printWriter.close();

			}
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("application/json;charset=UTF-8");

		ObjectMapper objectMapper = new ObjectMapper();
		PrintWriter printWriter = response.getWriter();

//		List<User> users = new UserDAO().findAll();
//		String usersJson = objectMapper.writeValueAsString(users);
//		printWriter.write(usersJson);
//		printWriter.close();
		
//		User user = new UserDAO().findUserByID(1);
//		String usersJson = objectMapper.writeValueAsString(user);
//		System.out.print(usersJson);
//		printWriter.write(usersJson);
//		printWriter.close();

//		 handle request
		User userJson = new Gson().fromJson(request.getReader(), User.class);
		String username = userJson.getUsername();
		String password = userJson.getPassword();

		// Login
		User user = new UserDAO().login(username, password);
		System.out.print(user);
		List<MessageAPI> messs = new ArrayList<MessageAPI>();
		if (username.isEmpty() == true || password.isEmpty() == true) {
			MessageAPI apimess = new MessageAPI("mess", "Username and password must not empty");
			String message = objectMapper.writeValueAsString(apimess);
			System.out.print("Mess 1; " + message);
			printWriter.write(message);
			printWriter.close();
		} else {
			if (user != null) {
				// cookie and session
//				System.out.print("add cookie");
//				Cookie userId = new Cookie("loginId", String.valueOf(user.getId()));
//				Cookie userName = new Cookie("loginName", user.getUsername());
//				userId.setMaxAge(60 * 60 * 24);
//				userName.setMaxAge(60 * 60 * 24);
//				response.addCookie(userId);
//				response.addCookie(userName);
//				HttpSession session = request.getSession();
//				session.setAttribute("userloginSession", user);
				// end cookie and session
				
				String userJsonLogin = objectMapper.writeValueAsString(user);
				printWriter.write(userJsonLogin);
				printWriter.close();
			} else {
				MessageAPI apimess = new MessageAPI("message", "Wrong username and password, please fill again");
				messs.add(apimess);
				String message = objectMapper.writeValueAsString(apimess);
				System.out.print("Mess 3; " + message);
				printWriter.write(message);
				printWriter.close();

			}
		}
	}

}
