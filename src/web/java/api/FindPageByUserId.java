package web.java.api;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import web.java.dao.GroupDAO;
import web.java.dao.PageDAO;
import web.java.model.Group;
import web.java.model.Page;

/**
 * Servlet implementation class FindPageByUserId
 */
@WebServlet("/FindPageByUserId")
public class FindPageByUserId extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FindPageByUserId() {
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
		
		String userId = request.getParameter("id");
		
		List<Page> pages = new PageDAO().findPageByUserId(Integer.valueOf(userId));
		
		String groupJson = objectMapper.writeValueAsString(pages);
		
		PrintWriter printWriter = response.getWriter();
		
		printWriter.write(groupJson);
		
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
