package web.java.api;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import web.java.dao.GroupDAO;
import web.java.model.Group;

/**
 * Servlet implementation class APIGroup
 */
@WebServlet("/api/admin/group")
public class APIGroup extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public APIGroup() {
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
	Group group = new GroupDAO().findGroupById(Integer.valueOf(request.getParameter("id")));
	String groupJson = objectMapper.writeValueAsString(group);
	PrintWriter printWriter = response.getWriter();
	printWriter.write(groupJson);
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
