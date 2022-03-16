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

import org.apache.catalina.util.URLEncoder;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;

import web.java.dao.PostDAO;
import web.java.model.Post;

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
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("application/json;charset=UTF-8");

		ObjectMapper objectMapper = new ObjectMapper();
		PrintWriter printWriter = response.getWriter();

		Post postJson = new Gson().fromJson(request.getReader(), Post.class);
		
		String content = postJson.getContent();
		ByteBuffer buffer = StandardCharsets.UTF_8.encode(content); 
		String utf8EncodedString = StandardCharsets.UTF_8.decode(buffer).toString();

		System.out.print("utf8EncodedString"+ utf8EncodedString);
		
		String image = postJson.getImage();
		String user_id = String.valueOf(postJson.getUser());
		Date date = new Date();
		Timestamp timestamp = new Timestamp(date.getTime());
		System.out.print("content" + content);
//		new PostDAO().addPost(content, image, Integer.valueOf(user_id), timestamp, 0);

		String newPost = objectMapper.writeValueAsString(new PostDAO().findLastPost());
		printWriter.write(newPost);
		printWriter.close();

	}

	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int id = Integer.parseInt(req.getParameter("postDelete"));
		new PostDAO().deletePost(id);
	}

	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String post_id = req.getParameter("post_id");
		String content = req.getParameter("content");
		String image = req.getParameter("image");
		String user_id = req.getParameter("user_id");
		Date date = new Date();
		Timestamp timestamp = new Timestamp(date.getTime());
		int number_react = Integer.valueOf(req.getParameter("number_react"));

		new PostDAO().modifyPost(Integer.valueOf(post_id), content, image, Integer.valueOf(user_id), timestamp,
				number_react);
	}

}
