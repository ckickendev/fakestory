package web.java.service.implement;

import java.util.List;

import web.java.dao.PostGroupDAO;
import web.java.model.PostGroup;

public class PostGroupService {
    private PostGroupDAO postGroupDAO;
    
    public PostGroupService() {
	postGroupDAO = new PostGroupDAO();
    }
    
    public List<PostGroup> findAll(){
	return postGroupDAO.findAll();
    }
}
