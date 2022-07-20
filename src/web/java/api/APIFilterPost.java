package web.java.api;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collection;
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
 * Servlet implementation class APIFilterPost
 */
@WebServlet("/api/filter/postuser")
public class APIFilterPost extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public APIFilterPost() {
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
		
		int offset = Integer.valueOf(request.getParameter("offset"));
		
		ObjectMapper objectMapper = new ObjectMapper();
		PostDAO postDAO = new PostDAO();
		List<Post> postOfUser = postDAO.findAllPostByUserId(Integer.valueOf(request.getParameter("id")));
		
		int[] listFriendsId = new UserDAO().findFriendId(Integer.valueOf(request.getParameter("id")), 10);
		
		List<Post> postOfFriends = new ArrayList<Post>();
		for(int x: listFriendsId) {	
			System.out.println("FriendId" + x);
			List<Post> postFriendClone = postDAO.findAllPostByUserId(x);
			for(Post a: postFriendClone) {
				postOfFriends.add(a);
			}
		}
		
		List<Post> posts = new ArrayList<Post>();
		for(Post a: postOfUser) {
			System.out.print(a);
			posts.add(a);
		}
		for(Post b: postOfFriends) {
			System.out.print(b);
			posts.add(b);
		}
		Collections.shuffle(posts);
		
		List<Post> newPost = posts.subList(10*(offset-1), 10*offset);
		System.out.println(newPost);
		
		String postJson = objectMapper.writeValueAsString(newPost);
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
