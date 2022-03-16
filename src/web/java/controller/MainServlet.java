package web.java.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import web.java.dao.GroupDAO;
import web.java.dao.UserDAO;
import web.java.model.Group;
import web.java.model.User;

/**
 * Servlet implementation class MainServlet
 */
@WebServlet("/api/MainServlet")
public class MainServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public MainServlet() {
	super();
	// TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {
	// TODO Auto-generated method stub
	request.setCharacterEncoding("UTF-8");
	response.setContentType("application/json;charset=UTF-8");
	
	ObjectMapper objectMapper = new ObjectMapper();
	
	List<User> users = new UserDAO().findAllFriendById(1,100);
	
	List<Group> groups = new GroupDAO().findAllGroupByUserId(1);
	
	String postJson = objectMapper.writeValueAsString(users);
	String groupJson = objectMapper.writeValueAsString(groups);
	
	PrintWriter printWriter = response.getWriter();
	printWriter.write(postJson);
	printWriter.write(groupJson);
	printWriter.close();
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {
	doGet(request, response);
    }

}
