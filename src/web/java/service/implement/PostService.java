package web.java.service.implement;

import java.util.List;

import web.java.dao.PostDAO;
import web.java.model.Post;

public class PostService {
    private PostDAO postDAO;
    
    public PostService() {
	postDAO = new PostDAO();
    }
    
    public List<Post> findAll(){
	return postDAO.findAll();
    }
}
