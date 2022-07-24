package web.java.api.profile;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import web.java.dao.NotificationDAO;
import web.java.model.Notification;

/**
 * Servlet implementation class GetAllNotificationUser
 */
@WebServlet("/api/admin/notification")
public class GetAllNotificationUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetAllNotificationUser() {
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

		List<Notification> notis = new NotificationDAO().findAllNotiByUserId(Integer.valueOf(request.getParameter("id")));
		String postJson;
		if (notis.size() == 0) {
			postJson = objectMapper.writeValueAsString(null);
		} else {
			Collections.sort(notis);
			postJson = objectMapper.writeValueAsString(notis);
		}
		PrintWriter printWriter = response.getWriter();
		printWriter.write(postJson);
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
