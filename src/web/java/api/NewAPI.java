package web.java.api;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.annotation.JacksonInject;

import web.java.dao.IReactDAO;
import web.java.model.React;
import web.java.model.User;
import web.java.service.implement.UserService;
import web.java.utils.HttpUtil;


@WebServlet(urlPatterns = {"/api/admin/news"})
public class NewAPI extends HttpServlet  {
    private static final long serialVersionUID = 7742280602776321071L;
    
    @JacksonInject
//    private ReactService reactService;
    
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // TODO Auto-generated method stub
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("application/json");
        System.out.println(new UserService().findAll());
        HttpUtil.of(req.getReader());
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // TODO Auto-generated method stub
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("application/json");
        User user = HttpUtil.of(req.getReader()).toModel(User.class);
        System.out.print(user);
        
    }
    
    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // TODO Auto-generated method stub
        super.doPut(req, resp);
    }
    
    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // TODO Auto-generated method stub
        super.doDelete(req, resp);
    }
}
