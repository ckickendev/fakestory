package web.java.service.implement;

import java.util.List;

import web.java.dao.implement.UserDAO;
import web.java.model.User;
import web.java.service.IUserService;

public class UserService implements IUserService {
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
