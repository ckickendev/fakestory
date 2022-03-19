package web.java.api;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;

import web.java.dao.PostDAO;
import web.java.dao.ReactDAO;
import web.java.model.React;

/**
 * Servlet implementation class APIReact
 */
@WebServlet("/api/admin/react")
public class APIReact extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public APIReact() {
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
		int react = new ReactDAO().getReactInPost(Integer.valueOf(request.getParameter("id")));
		String userJson = objectMapper.writeValueAsString(react);
		PrintWriter printWriter = response.getWriter();
		printWriter.write(userJson);
		printWriter.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setContentType("application/json;charset=UTF-8");
		
		ObjectMapper objectMapper = new ObjectMapper();
		PrintWriter printWriter = response.getWriter();

		React reactJson = new Gson().fromJson(request.getReader(), React.class);
		System.out.print("react json" + reactJson);
		new ReactDAO().react(reactJson.getUser(), reactJson.getPost(), reactJson.getType());
//		();
		String newPost = objectMapper.writeValueAsString(new PostDAO().findPostById(reactJson.getPost()));
		printWriter.write(newPost);
	}

	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPut(req, resp);
	}

}
