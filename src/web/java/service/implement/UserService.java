package web.java.service.implement;

import java.util.List;

import web.java.dao.UserDAO;
import web.java.model.User;

public class UserService {
    private UserDAO userDAO;
    
    public UserService() {
	userDAO = new UserDAO();
    }
    
    public List<User> findAll() {
        return userDAO.findAll();
    }
    
    public User findUserByID(int id) {
	return userDAO.findUserByID(id);
    }
}
