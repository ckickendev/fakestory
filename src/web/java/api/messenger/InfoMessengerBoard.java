package web.java.api.messenger;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import web.java.dao.GroupDAO;
import web.java.dao.MessageDAO;
import web.java.model.Group;
import web.java.model.Message;

/**
 * Servlet implementation class InfoMessengerBoard
 */
@WebServlet("/api/messenger/allmess")
public class InfoMessengerBoard extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InfoMessengerBoard() {
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
		
		Integer currentId = Integer.valueOf(request.getParameter("id"));
		
		List<Message> mess = new ArrayList<Message>();
		Set<Integer> setMessage = new MessageDAO().getListUserChatById(currentId);
		MessageDAO messagesDAO = new MessageDAO();
		for(Integer x: setMessage) {
			mess.add(messagesDAO.getLastMessageBetweenTwoPeople(currentId, x));
		}
		System.out.println("All last mess" + mess);
		String pagesJson = objectMapper.writeValueAsString(mess);

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
