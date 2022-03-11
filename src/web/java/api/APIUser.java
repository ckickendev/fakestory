package web.java.api;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.annotation.JacksonInject;
import com.fasterxml.jackson.databind.ObjectMapper;

import web.java.dao.UserDAO;
import web.java.model.User;
import web.java.service.implement.UserService;
import web.java.utils.HttpUtil;

@WebServlet(urlPatterns = { "/api/admin/user" })
public class APIUser extends HttpServlet {
	private static final long serialVersionUID = 7742280602776321071L;

	@JacksonInject
	private UserService userService;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setContentType("application/json;charset=UTF-8");
		ObjectMapper objectMapper = new ObjectMapper();
		User user = new UserDAO().findUserByID(Integer.valueOf(request.getParameter("id")));
		String userJson = objectMapper.writeValueAsString(user);
		PrintWriter printWriter = response.getWriter();
		System.out.print(userJson);
		printWriter.write(userJson);
		printWriter.close();
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("application/json");
		String avatar = Integer.valueOf(req.getParameter("sex")) == 1 ? "https://firebasestorage.googleapis.com/v0/b/fakestory-9fb8d.appspot.com/o/file%2FdefaultAvatar.png?alt=media&token=8042470b-2bd9-4f51-825f-d62bb94f6e7b" : "https://firebasestorage.googleapis.com/v0/b/fakestory-9fb8d.appspot.com/o/file%2FdefaulAvatarFemale.png?alt=media&token=0fc589be-e8b1-42db-a16b-0b4a9333513b";
		User user = new User(0, req.getParameter("username"), req.getParameter("password"),
				req.getParameter("fullname"), req.getParameter("phone"), avatar,
				req.getParameter("background"), Integer.valueOf(req.getParameter("role_id")),
				req.getParameter("description"), 0, req.getParameter("country"), req.getParameter("live"),
				Integer.valueOf(req.getParameter("sex")), null, null);
		Date date = new Date();
		System.out.print(date);
		Timestamp time = new Timestamp(date.getTime());
		user.setDateCreate(time);

		System.out.print(req.getParameter("birthday"));

		String birthday = req.getParameter("birthday");
		try {
			Date date1 = new SimpleDateFormat("yyyy-MM-dd").parse(birthday);
			Timestamp birthdayTime = new Timestamp(date1.getTime());
			user.setBirthday(birthdayTime);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		new UserDAO().addUser(user);
	}

	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

//	int id = Integer.parseInt(req.getParameter("idDelete"));
		req.setCharacterEncoding("UTF-8");
		User user = HttpUtil.of(req.getReader()).toModel(User.class);
		System.out.print(user);
		new UserDAO().modifyUser(user, user.getId());
	}

	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("userDelete"));
		new UserDAO().deleteUserById(id);
	}
}
