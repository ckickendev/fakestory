package web.java.model;

import java.sql.Timestamp;

import com.fasterxml.jackson.annotation.JsonFormat;

public class HistoryAction {
    private int id;
    private String title;
    private int user;
    private int forward;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Timestamp dateTime;
    
    
    public HistoryAction(int id, String title, int user, int forward, Timestamp dateTime) {
	super();
	this.id = id;
	this.title = title;
	this.user = user;
	this.forward = forward;
	this.dateTime = dateTime;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public int getUser() {
        return user;
    }
    public void setUser(int user) {
        this.user = user;
    }
    public int getForward() {
        return forward;
    }
    public void setForward(int forward) {
        this.forward = forward;
    }
    public Timestamp getDateTime() {
        return dateTime;
    }
    public void setDateTime(Timestamp dateTime) {
        this.dateTime = dateTime;
    }
    @Override
    public String toString() {
	return "HistoryAction [id=" + id + ", title=" + title + ", user=" + user + ", forward=" + forward
		+ ", dateTime=" + dateTime + "]";
    }
    
    
}
