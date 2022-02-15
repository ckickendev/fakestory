package web.java.service.implement;

import java.util.List;

import web.java.dao.ImageDAO;
import web.java.model.Image;

public class ImageService {
    private ImageDAO imageDAO;
    
    public ImageService() {
	imageDAO = new ImageDAO();
    };
    
    public List<Image> findAll(){
	return imageDAO.findAll();
    }
}
