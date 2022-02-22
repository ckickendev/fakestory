package web.java.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;

import web.java.dao.UserDAO;
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
	super();
	// TODO Auto-generated constructor stub
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {
	request.setCharacterEncoding("UTF-8");
        response.setContentType("application/json;charset=UTF-8");
	String username = request.getParameter("username");
	String password = request.getParameter("password");
	User user = new UserDAO().login(username, password);
	ObjectMapper objectMapper = new ObjectMapper();
	String userJson = objectMapper.writeValueAsString(user);
        PrintWriter printWriter = response.getWriter();
        printWriter.write(userJson);
        printWriter.close();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {
	request.setCharacterEncoding("UTF-8");
        response.setContentType("application/json;charset=UTF-8");
	String username = request.getParameter("username");
	String password = request.getParameter("password");
	User user = new UserDAO().login(username, password);
	if(user == null) {
	    request.setAttribute("mess", "Username and password must not empty");
//	    request.getRequestDispatcher("Page/web/login.jsp").forward(request, response);
	}else {
	    if(new UserDAO().login(username, password) != null) {
		Cookie userId = new Cookie("loginId", String.valueOf(user.getId()));
		Cookie userName = new Cookie("loginName", user.getUsername());
		userId.setMaxAge(60*60*24);
		userName.setMaxAge(60*60*24);
		response.addCookie(userId);
		response.addCookie(userName);
		
		HttpSession session = request.getSession();
		session.setAttribute("userloginSession", user);
		System.out.println( ((User) session.getAttribute("loginSession")).getFullname());
//		response.sendRedirect("home");
	    }else {
		request.setAttribute("mess", "Wrong username and password, please check again");
//		request.getRequestDispatcher("Page/web/login.jsp").forward(request, response);
	    }
	}
	ObjectMapper objectMapper = new ObjectMapper();
	String userJson = objectMapper.writeValueAsString(user);
        PrintWriter printWriter = response.getWriter();
        printWriter.write(userJson);
        printWriter.close();
    }

}
