package web.java.service.implement;

import java.util.List;

import web.java.dao.GroupDAO;
import web.java.model.Group;

public class GroupService {
    private GroupDAO groupDAO;
    
    public GroupService() {
	groupDAO = new GroupDAO();
    }
    
    public List<Group> findAll(){
	return groupDAO.findAll();
    }
}
