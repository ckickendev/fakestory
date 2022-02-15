package web.java.service.implement;

import java.util.List;

import web.java.dao.ReactDAO;
import web.java.model.React;

public class ReactService {
    private ReactDAO reactDAO ;
    
    public ReactService() {
	reactDAO = new ReactDAO();
    }
    
    public List<React> findAll() {
        return reactDAO.findAll();
    }
    
    
}
