package web.java.service.implement;

import java.util.List;

import web.java.dao.TypeReactDAO;
import web.java.model.TypeReact;

public class TypeReactService {
    private TypeReactDAO typeReactDAO;
    
    public TypeReactService() {
	typeReactDAO = new TypeReactDAO();
    }
    
    public List<TypeReact> findAll(){
	return typeReactDAO.findAll();
    }
}
