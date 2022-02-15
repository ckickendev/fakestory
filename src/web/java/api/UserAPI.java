package web.java.api;

import java.io.IOException;
import java.io.PrintWriter;

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


@WebServlet(urlPatterns = {"/api/admin/users"})
public class UserAPI extends HttpServlet  {
    private static final long serialVersionUID = 7742280602776321071L;
    
    @JacksonInject
    private UserService userService;
    
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // TODO Auto-generated method stub
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("application/json;charset=UTF-8");
        ObjectMapper objectMapper = new ObjectMapper();
        User user = new UserDAO().findUserByID(1);
        String userJson = objectMapper.writeValueAsString(user);
        PrintWriter printWriter = resp.getWriter();
        printWriter.write(userJson);
        printWriter.close();
    }
    
    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // TODO Auto-generated method stub
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("application/json");
        User user = HttpUtil.of(req.getReader()).toModel(User.class);
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
