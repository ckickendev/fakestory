package web.java.model;

import java.sql.Timestamp;

import com.fasterxml.jackson.annotation.JsonFormat;

public class Notification {
    private int id;
    private int user;
    private String title;
    private String content;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Timestamp datetime;
    public Notification(int id, int user, String title, String content, Timestamp datetime) {
	super();
	this.id = id;
	this.user = user;
	this.title = title;
	this.content = content;
	this.datetime = datetime;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public int getUser() {
        return user;
    }
    public void setUser(int user) {
        this.user = user;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getContent() {
        return content;
    }
    public void setContent(String content) {
        this.content = content;
    }
    public Timestamp getDatetime() {
        return datetime;
    }
    public void setDatetime(Timestamp datetime) {
        this.datetime = datetime;
    }
    @Override
    public String toString() {
	return "Notification [id=" + id + ", user=" + user + ", title=" + title + ", content=" + content + ", datetime="
		+ datetime + "]";
    }
    
    
}
