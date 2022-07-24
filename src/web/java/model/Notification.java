package web.java.model;

import java.sql.Timestamp;

import com.fasterxml.jackson.annotation.JsonFormat;

public class Notification implements Comparable<Notification> {
	private int id;
	private int user;
	private String title;
	private String content;
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Timestamp datetime;
	private int status;
	private int forward_id;

	public Notification(int id, int user, String title, String content, Timestamp datetime, int status, int forward_id) {
		super();
		this.id = id;
		this.user = user;
		this.title = title;
		this.content = content;
		this.datetime = datetime;
		this.status = status;
		this.forward_id = forward_id;
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
	

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public int getForward_id() {
		return forward_id;
	}

	public void setForward_id(int forward_id) {
		this.forward_id = forward_id;
	}
	
	public int compareTo(Notification notification) {
		// sort student's name by ASC
		return notification.getDatetime().compareTo(this.getDatetime());
	}

	@Override
	public String toString() {
		return "Notification [id=" + id + ", user=" + user + ", title=" + title + ", content=" + content + ", datetime="
				+ datetime + ", status=" + status + ", forward_id=" + forward_id + "]";
	}
	
	

	

	
}
