package web.java.service.implement;

import java.util.List;

import web.java.dao.TagPostDAO;
import web.java.model.TagPost;

public class TagPostService {
    private TagPostDAO tagPost;
    
    public TagPostService() {
	tagPost = new TagPostDAO();
    }
    
    public List<TagPost> findAll(){
	return tagPost.findAll();
    }
}
