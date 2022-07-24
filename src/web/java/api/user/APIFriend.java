package web.java.api.user;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import web.java.dao.FriendShipDAO;
import web.java.dao.UserDAO;
import web.java.model.User;

/**
 * Servlet implementation class APIFriend
 */
@WebServlet("/api/admin/friend")
public class APIFriend extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public APIFriend() {
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
		
		List<User> users = new UserDAO().findAllFriendById(Integer.valueOf(request.getParameter("id")), 100 );
		
		String userJson = objectMapper.writeValueAsString(users);
		PrintWriter printWriter = response.getWriter();
		printWriter.write(userJson);
		printWriter.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setContentType("application/json;charset=UTF-8");
		
		new FriendShipDAO().addFriend(Integer.valueOf(request.getParameter("user1")), Integer.valueOf(request.getParameter("user2")), Integer.valueOf(request.getParameter("status")));
		
	}

}
