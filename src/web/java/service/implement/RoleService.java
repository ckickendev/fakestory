package web.java.service.implement;

import java.util.List;


import web.java.dao.RoleDAO;
import web.java.model.Role;

public class RoleService {
    private RoleDAO roleDAO;
    
    public RoleService() {
	roleDAO = new RoleDAO();
    }
    
    public List<Role> findAll(){
	return roleDAO.findAll();
    }
}
