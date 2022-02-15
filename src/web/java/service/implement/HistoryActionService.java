package web.java.service.implement;

import java.util.List;

import web.java.dao.HisActionDAO;
import web.java.model.HistoryAction;

public class HistoryActionService {
    private HisActionDAO hisActionDAO;
    
    public HistoryActionService() {
	hisActionDAO = new HisActionDAO();
    }
    
    public List<HistoryAction> findAll(){
	return hisActionDAO.findAll();
    }
}
