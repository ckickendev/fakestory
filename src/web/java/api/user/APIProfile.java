package web.java.api.user;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class APIProfile
 */
@WebServlet("/api/admin/profile")
public class APIProfile extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public APIProfile() {
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
//	request.setCharacterEncoding("UTF-8");
//	response.setContentType("application/json;charset=UTF-8");
//	ObjectMapper objectMapper = new ObjectMapper();
//	List<User> friends = new UserDAO().findAllFriendById(Integer.valueOf(request.getParameter("id")));
//	List<Post> posts = new PostDAO().findAllPostByUserId(Integer.valueOf(request.getParameter("id")));
//	User user = new UserDAO().findUserByID(Integer.valueOf(request.getParameter("id")));
//	String postJson = objectMapper.writeValueAsString(friends);
//	
//	PrintWriter printWriter = response.getWriter();
//	printWriter.write(postJson);
//	printWriter.close();
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
