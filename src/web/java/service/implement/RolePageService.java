package web.java.service.implement;

import java.util.List;

import web.java.dao.RolePageDAO;
import web.java.model.RolePage;

public class RolePageService {
    private RolePageDAO rolePageDAO;
    
    public RolePageService() {
	rolePageDAO = new RolePageDAO();
    }
    
    public List<RolePage> findAll(){
	return rolePageDAO.findAll();
    }
}
