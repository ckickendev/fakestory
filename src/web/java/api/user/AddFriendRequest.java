package web.java.api.user;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collections;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import web.java.dao.CommentDAO;
import web.java.dao.FriendShipDAO;
import web.java.model.Comment;

/**
 * Servlet implementation class AddFriendRequest
 */
@WebServlet("/addFriendRequest")
public class AddFriendRequest extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddFriendRequest() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setContentType("application/json;charset=UTF-8");
		
		ObjectMapper objectMapper = new ObjectMapper();
		int userId = Integer.valueOf(request.getParameter("userId"));
		int userCurrentId = Integer.valueOf(request.getParameter("userCurrentId"));
		int type= Integer.valueOf(request.getParameter("type"));
		new FriendShipDAO().sendFriendRequest(userId, userCurrentId, type);
		
		String commentJson = objectMapper.writeValueAsString("success");
		PrintWriter printWriter = response.getWriter();
		printWriter.write(commentJson);
		printWriter.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
