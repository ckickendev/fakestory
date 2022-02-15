package web.java.service.implement;

import java.util.List;

import web.java.dao.LikePageDAO;
import web.java.model.LikePage;

public class LikePageService {
    private LikePageDAO likePageDAO;
    
    public LikePageService() {
	likePageDAO = new LikePageDAO();
    }
    
    public List<LikePage> findAll(){
	return likePageDAO.findAll();
    }
}
