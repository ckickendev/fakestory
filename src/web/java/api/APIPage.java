package web.java.api;

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

import web.java.dao.PageDAO;
import web.java.model.Page;

/**
 * Servlet implementation class PageAPI
 */
@WebServlet("/api/admin/page")
public class APIPage extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public APIPage() {
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
		Page page = new PageDAO().findPageById(Integer.valueOf(request.getParameter("id")));
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
		request.setCharacterEncoding("UTF-8");
		response.setContentType("application/json;charset=UTF-8");
		
		Date date = new Date();
		Timestamp time = new Timestamp(date.getTime());

		new PageDAO().addPage(request.getParameter("name"), request.getParameter("des"), time);
	}
	
	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("application/json;charset=UTF-8");
		new PageDAO().deletePage(req.getParameter("id"));
	}

}
