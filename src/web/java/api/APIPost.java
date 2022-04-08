package web.java.api;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.sql.Timestamp;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;

import web.java.dao.PostDAO;
import web.java.model.Post;
import web.java.model.SingleID;

/**
 * Servlet implementation class PostAPI
 */
@WebServlet("/api/admin/post")
public class APIPost extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public APIPost() {
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
		Post post = new PostDAO().findPostById(Integer.valueOf(request.getParameter("id")));
		String postJson = objectMapper.writeValueAsString(post);
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
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("application/json;charset=UTF-8");

		ObjectMapper objectMapper = new ObjectMapper();
		PrintWriter printWriter = response.getWriter();

		Post postJson = new Gson().fromJson(request.getReader(), Post.class);
		
		
		String image = postJson.getImage();
		String user_id = String.valueOf(postJson.getUser());
		Date date = new Date();
		Timestamp timestamp = new Timestamp(date.getTime());

		String newPost = objectMapper.writeValueAsString(new PostDAO().findLastPost());
		printWriter.write(newPost);
		printWriter.close();

	}

	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("application/json;charset=UTF-8");

		ObjectMapper objectMapper = new ObjectMapper();
		PrintWriter printWriter = resp.getWriter();

		SingleID singleId = new Gson().fromJson(req.getReader(), SingleID.class);
		new PostDAO().deletePost(Integer.valueOf(singleId.getId()));
		printWriter.close();
	}

	@Override
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("application/json;charset=UTF-8");

		ObjectMapper objectMapper = new ObjectMapper();
		PrintWriter printWriter = response.getWriter();

		Post postJson = new Gson().fromJson(request.getReader(), Post.class);
		new PostDAO().editPost(postJson);
		
		
		String newPost = objectMapper.writeValueAsString(new PostDAO().findLastPost());
		printWriter.write(newPost);
		printWriter.close();
	}

}
