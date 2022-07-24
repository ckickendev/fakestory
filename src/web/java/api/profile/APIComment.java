package web.java.api.profile;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;

import web.java.dao.CommentDAO;
import web.java.dao.PostDAO;
import web.java.model.Comment;
import web.java.model.Post;
import web.java.model.SingleID;

/**
 * Servlet implementation class APIComment
 */
@WebServlet("/api/admin/comment")
public class APIComment extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public APIComment() {
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

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setContentType("application/json;charset=UTF-8");

		ObjectMapper objectMapper = new ObjectMapper();
		PrintWriter printWriter = response.getWriter();
		
		Comment commentJson = new Gson().fromJson(request.getReader(), Comment.class);
		Date date = new Date();
		Timestamp timestamp = new Timestamp(date.getTime());
		commentJson.setDatetime(timestamp);
		System.out.print(commentJson);
		
		CommentDAO commentDAO = new CommentDAO();
		commentDAO.addComment(commentJson);

		String newComment = objectMapper.writeValueAsString(new PostDAO().findLastCommentInPost(commentJson.getPost_id()));
//		System.out.print("New comment: "+ newComment);
		printWriter.write(newComment);
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
		new CommentDAO().deleteComment(Integer.valueOf(singleId.getId()));
		printWriter.close();
	}

}
