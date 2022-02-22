package web.java.model;

import java.sql.Timestamp;

import com.fasterxml.jackson.annotation.JsonFormat;

public class Message {
    private int userFrom;
    private int userTo;
    private String content;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Timestamp dateTime;
    public Message(int userFrom, int userTo, String content, Timestamp dateTime) {
	super();
	this.userFrom = userFrom;
	this.userTo = userTo;
	this.content = content;
	this.dateTime = dateTime;
    }
    public int getUserFrom() {
        return userFrom;
    }
    public void setUserFrom(int userFrom) {
        this.userFrom = userFrom;
    }
    public int getUserTo() {
        return userTo;
    }
    public void setUserTo(int userTo) {
        this.userTo = userTo;
    }
    public String getContent() {
        return content;
    }
    public void setContent(String content) {
        this.content = content;
    }
    public Timestamp getDateTime() {
        return dateTime;
    }
    public void setDateTime(Timestamp dateTime) {
        this.dateTime = dateTime;
    }
    @Override
    public String toString() {
	return "Message [userFrom=" + userFrom + ", userTo=" + userTo + ", content=" + content + ", dateTime="
		+ dateTime + "]";
    }
    
    
    
}
