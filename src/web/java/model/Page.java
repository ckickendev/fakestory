package web.java.model;

import java.sql.Timestamp;

import com.fasterxml.jackson.annotation.JsonFormat;

public class Page {
    private int id;
    private String name;
    private String description;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Timestamp dateCreate;
    private int liked;
    public Page(int id, String name, String description, Timestamp dateCreate, int liked) {
	super();
	this.id = id;
	this.name = name;
	this.description = description;
	this.dateCreate = dateCreate;
	this.liked = liked;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public Timestamp getDateCreate() {
        return dateCreate;
    }
    public void setDateCreate(Timestamp dateCreate) {
        this.dateCreate = dateCreate;
    }
    public int getLiked() {
        return liked;
    }
    public void setLiked(int liked) {
        this.liked = liked;
    }
    @Override
    public String toString() {
	return "Page [id=" + id + ", name=" + name + ", description=" + description + ", dateCreate=" + dateCreate
		+ ", liked=" + liked + "]";
    }
    
    
    
}
