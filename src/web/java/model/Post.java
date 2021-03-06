package web.java.model;

import java.sql.Timestamp;

import com.fasterxml.jackson.annotation.JsonFormat;

public class Post implements Comparable<Post> {
	private int id;
	private String content;
	private String image;
	private int user;
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Timestamp time;
	private int react;
	private int status;

	public Post(int id, String content, String image, int user, Timestamp time, int react, int status) {
		super();
		this.id = id;
		this.content = content;
		this.image = image;
		this.user = user;
		this.time = time;
		this.react = react;
		this.status = status;
	}

	public Post(int id, String content, String image, int user, int react) {
		super();
		this.id = id;
		this.content = content;
		this.image = image;
		this.user = user;
		this.react = react;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public int getUser() {
		return user;
	}

	public void setUser(int user) {
		this.user = user;
	}

	public Timestamp getTime() {
		return time;
	}

	public void setTime(Timestamp time) {
		this.time = time;
	}

	public int getReact() {
		return react;
	}

	public void setReact(int react) {
		this.react = react;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Post [id=" + id + ", content=" + content + ", image=" + image + ", user=" + user + ", time=" + time
				+ ", react=" + react + "]";
	}

	public int compareTo(Post post) {
		// sort student's name by ASC
		return post.getTime().compareTo(this.getTime());
	}

}
