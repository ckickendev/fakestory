package web.java.api;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

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
	doGet(request, response);
    }
    
    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // TODO Auto-generated method stub
	int id = Integer.parseInt(req.getParameter("postDelete"));
        new PostDAO().deletePost(id);
    }

}
