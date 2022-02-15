package web.java.service.implement;

import java.util.List;

import web.java.dao.RoleGroupDAO;
import web.java.model.RoleGroup;

public class RoleGroupService {
    private RoleGroupDAO roleGroupDAO;
    
    public RoleGroupService() {
	roleGroupDAO = new RoleGroupDAO();
    }
    
    public List<RoleGroup> findAll(){
	return roleGroupDAO.findAll();
    }
}
