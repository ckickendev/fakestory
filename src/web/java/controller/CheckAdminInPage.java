package web.java.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import web.java.dao.GroupDAO;
import web.java.dao.LikePageDAO;
import web.java.model.Group;
import web.java.model.LikePage;

/**
 * Servlet implementation class CheckAdminInPage
 */
@WebServlet("/api/rolepage/page")
public class CheckAdminInPage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CheckAdminInPage() {
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

		LikePage likepage = new LikePageDAO().findLikePageInPage(Integer.valueOf(request.getParameter("userId")), Integer.valueOf(request.getParameter("pageId")));

		String pagesJson = objectMapper.writeValueAsString(likepage);

		PrintWriter printWriter = response.getWriter();
		printWriter.write(pagesJson);
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
