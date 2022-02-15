package web.java.service.implement;

import java.util.List;

import web.java.dao.PageDAO;
import web.java.model.Page;

public class PageService {
    private PageDAO pageDAO;
    
    public PageService() {
	pageDAO = new PageDAO();
    }
    
    public List<Page> findAll(){
	return pageDAO.findAll();
    }
}
