package web.java.service.implement;

import java.util.List;

import web.java.dao.MessageDAO;
import web.java.model.Message;

public class MessageService {
    private MessageDAO messageDAO;
    
    public MessageService() {
	messageDAO = new MessageDAO();
    }
    
    public List<Message> findAll(){
	return messageDAO.findAll();
    }
} 
