package web.java.service.implement;

import java.util.List;

import web.java.dao.CommentDAO;
import web.java.model.Comment;

public class CommentService {
private CommentDAO commentDAO ;
    
    public CommentService() {
	commentDAO = new CommentDAO();
    }
    
    public List<Comment> findAll() {
        return commentDAO.findAll();
    }
}
