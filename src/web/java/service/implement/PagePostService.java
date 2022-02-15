package web.java.service.implement;

import java.util.List;

import web.java.dao.PagePostDAO;
import web.java.model.PagePost;

public class PagePostService {
    private PagePostDAO pagePostDAO;
    
    public PagePostService() {
	pagePostDAO = new PagePostDAO();
    }
    
    public List<PagePost> findAll(){
	return pagePostDAO.findAll();
    }
}
