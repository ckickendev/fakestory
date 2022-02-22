package web.java.api;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import web.java.dao.PageDAO;
import web.java.model.Page;

/**
 * Servlet implementation class PageAPI
 */
@WebServlet("/api/admin/page")
public class PageAPI extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public PageAPI() {
	super();
	// TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {
	request.setCharacterEncoding("UTF-8");
	response.setContentType("application/json;charset=UTF-8");
	ObjectMapper objectMapper = new ObjectMapper();
	Page page = new PageDAO().findPageById(Integer.valueOf(request.getParameter("id")) );
	String pageJson = objectMapper.writeValueAsString(page);
	PrintWriter printWriter = response.getWriter();
	printWriter.write(pageJson);
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
