package web.java.service.implement;

import java.util.List;

import web.java.dao.NotificationDAO;
import web.java.model.Notification;

public class NotificationService {
    private NotificationDAO notificationDAO;
    
    public NotificationService() {
	notificationDAO = new NotificationDAO();
    }
    
    public List<Notification> findAll(){
	return notificationDAO.findAll();
    }
}
