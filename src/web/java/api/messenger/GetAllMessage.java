package web.java.api.messenger;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;

import web.java.dao.MessageDAO;
import web.java.dao.NotificationDAO;
import web.java.dao.PostDAO;
import web.java.dao.ReactDAO;
import web.java.dao.UserDAO;
import web.java.model.Message;
import web.java.model.Post;
import web.java.model.React;
import web.java.model.User;

/**
 * Servlet implementation class GetAllMessage
 */
@WebServlet("/api/admin/messagesbetween")
public class GetAllMessage extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public GetAllMessage() {
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
		Integer currentId = Integer.valueOf(request.getParameter("id"));
		Integer oppId = Integer.valueOf(request.getParameter("oppId"));
		List<Message> mess = new MessageDAO().getMessageBetweenTwoPeople(currentId, oppId);
		Collections.sort(mess);
		System.out.println("All last mess" + mess);
		String pagesJson = objectMapper.writeValueAsString(mess);
		
		PrintWriter printWriter = response.getWriter();
		printWriter.write(pagesJson);
		printWriter.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("application/json;charset=UTF-8");

//		ObjectMapper objectMapper = new ObjectMapper();
//		PrintWriter printWriter = response.getWriter();

		Message message = new Gson().fromJson(request.getReader(), Message.class);
		System.out.println(message);
		Date date = new Date();
		Timestamp timestamp = new Timestamp(date.getTime());
		message.setDateTime(timestamp);
		System.out.print("Mess json" + message);
		new MessageDAO().addMessage(message);
	}

}
