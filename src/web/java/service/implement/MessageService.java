package web.java.service.implement;

import java.util.List;

import web.java.model.Message;
import web.java.model.MessageDAO;

public class MessageService {
    private MessageDAO messageDAO;
    
    public MessageService() {
	messageDAO = new MessageDAO();
    }
    
    public List<Message> findAll(){
	return messageDAO.findAll();
    }
} 
