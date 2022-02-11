package web.java.service.implement;

import java.util.List;

import web.java.dao.IReactDAO;
import web.java.dao.implement.ReactDAO;
import web.java.model.React;
import web.java.service.IReactService;

public class ReactService implements IReactService {
    
    private IReactDAO iReactDao;
    
    public ReactService() {
	iReactDao = new ReactDAO();
    }
    @Override
    public List<React> findAll() {
        return iReactDao.findAll();
    }
    
    
}
