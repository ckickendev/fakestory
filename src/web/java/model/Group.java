package web.java.model;

import java.sql.Timestamp;

import com.fasterxml.jackson.annotation.JsonFormat;

public class Group {
    private int id;
    private String name;
    private String des;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Timestamp dateCreate;
    private int totalMember;
    
    
    public Group(int id, String name, String des, Timestamp dateCreate, int totalMember) {
	super();
	this.id = id;
	this.name = name;
	this.des = des;
	this.dateCreate = dateCreate;
	this.totalMember = totalMember;
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
    public String getDes() {
        return des;
    }
    public void setDes(String des) {
        this.des = des;
    }
    public Timestamp getDateCreate() {
        return dateCreate;
    }
    public void setDateCreate(Timestamp dateCreate) {
        this.dateCreate = dateCreate;
    }
    public int getTotalMember() {
        return totalMember;
    }
    public void setTotalMember(int totalMember) {
        this.totalMember = totalMember;
    }
    @Override
    public String toString() {
	return "Group [id=" + id + ", name=" + name + ", des=" + des + ", dateCreate=" + dateCreate + ", totalMember="
		+ totalMember + "]";
    }
    
    
}
