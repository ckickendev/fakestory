package web.java.controller;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import web.java.dao.NotificationDAO;
import web.java.dao.PostDAO;
import web.java.dao.UserDAO;
import web.java.model.Notification;
import web.java.model.Post;
import web.java.model.User;


/**
 * Servlet implementation class AddPost
 */
@WebServlet("/AddPost")
public class AddPost extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddPost() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("application/json;charset=UTF-8");
		String content = request.getParameter("content");
		String image = request.getParameter("image");
		String user_id = request.getParameter("user_id");
		Date date = new Date();
		Timestamp timestamp = new Timestamp(date.getTime());
		System.out.print(content +"==="+  image +"==="+ Integer.valueOf(user_id) +"==="+timestamp);
		PostDAO postDAO = new PostDAO();
		NotificationDAO notificationDAO = new NotificationDAO();
		postDAO.addPost(content, image,Integer.valueOf(user_id) , timestamp, 0);
		Post LastPost = postDAO.findLastPostByUser(Integer.valueOf(user_id));
		List<User> users = new UserDAO().findAllFriendByIdUnlimited(Integer.valueOf(user_id));
		System.out.println(users);
		for(User user : users) {
			notificationDAO.addNotification(user.getId(), "Đã đăng một bài viết mới", String.valueOf(LastPost.getId()), 1, Integer.parseInt(user_id));
		}
		response.sendRedirect("http://localhost:3000/");
	}

}
