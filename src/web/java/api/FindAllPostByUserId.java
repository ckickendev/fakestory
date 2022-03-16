package web.java.api;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import web.java.dao.PostDAO;
import web.java.dao.UserDAO;
import web.java.model.Post;

/**
 * Servlet implementation class FindAllPostByUserId
 */
@WebServlet("/api/post/user")
public class FindAllPostByUserId extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public FindAllPostByUserId() {
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
		PostDAO postDAO = new PostDAO();
		List<Post> postOfUser = postDAO.findAllPostByUserId(Integer.valueOf(request.getParameter("id")));

		
		Collections.sort(postOfUser);
		String postJson = objectMapper.writeValueAsString(postOfUser);
		PrintWriter printWriter = response.getWriter();
		printWriter.write(postJson);
		printWriter.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
