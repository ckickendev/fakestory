package web.java.model;

import java.sql.Timestamp;

import com.fasterxml.jackson.annotation.JsonFormat;

public class LikePage {
    private int id;
    private int pageId;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Timestamp dateLike;
    public LikePage(int id, int pageId, Timestamp dateLike) {
	super();
	this.id = id;
	this.pageId = pageId;
	this.dateLike = dateLike;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public int getPageId() {
        return pageId;
    }
    public void setPageId(int pageId) {
        this.pageId = pageId;
    }
    public Timestamp getDateLike() {
        return dateLike;
    }
    public void setDateLike(Timestamp dateLike) {
        this.dateLike = dateLike;
    }
    @Override
    public String toString() {
	return "LikePage [id=" + id + ", pageId=" + pageId + ", dateLike=" + dateLike + "]";
    }
    
    
}
