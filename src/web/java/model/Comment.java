package web.java.model;

import java.sql.Timestamp;

import com.fasterxml.jackson.annotation.JsonFormat;

public class Comment {
    private int id;
    private int userid;
    private String content;
    private int post_id;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Timestamp datetime;
    private int rep_id;

    public Comment(int id, int userid, String content, int post_id, Timestamp datetime, int rep_id) {
	super();
	this.id = id;
	this.userid = userid;
	this.content = content;
	this.post_id = post_id;
	this.datetime = datetime;
	this.rep_id = rep_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getPost_id() {
        return post_id;
    }

    public void setPost_id(int post_id) {
        this.post_id = post_id;
    }

    public Timestamp getDatetime() {
        return datetime;
    }

    public void setDatetime(Timestamp datetime) {
        this.datetime = datetime;
    }

    public int getRep_id() {
        return rep_id;
    }

    public void setRep_id(int rep_id) {
        this.rep_id = rep_id;
    }

    @Override
    public String toString() {
	return "Comment [id=" + id + ", userid=" + userid + ", content=" + content + ", post_id=" + post_id
		+ ", datetime=" + datetime + ", rep_id=" + rep_id + "]";
    }

    

}
