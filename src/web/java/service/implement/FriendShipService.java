package web.java.service.implement;

import java.util.List;

import web.java.dao.FriendShipDAO;
import web.java.model.Friendship;

public class FriendShipService {
    private FriendShipDAO friendShipDAO;
    
    public FriendShipService() {
	friendShipDAO = new FriendShipDAO();
    }
    
    public List<Friendship> findAll(){
	return friendShipDAO.findAll();
    }
}
