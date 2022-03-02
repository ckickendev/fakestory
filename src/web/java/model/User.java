package web.java.model;

import java.sql.Timestamp;

import com.fasterxml.jackson.annotation.JsonFormat;

public class User {
    private int id;
    private String username;
    private String password;
    private String fullname;
    private String phone;
    private String avatar;
    private int role_id;
    private String description;
    private int numberFriends;
    private String country;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Timestamp dateCreate;
    public User() {
        super();
    }

    
    public User(int id, String username, String password, String fullname, String phone, String avatar, int role_id,
			String description, int numberFriends, String country, Timestamp dateCreate) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.fullname = fullname;
		this.phone = phone;
		this.avatar = avatar;
		this.role_id = role_id;
		this.description = description;
		this.numberFriends = numberFriends;
		this.country = country;
		this.dateCreate = dateCreate;
	}


	public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getFullname() {
        return fullname;
    }
    public void setFullname(String fullname) {
        this.fullname = fullname;
    }
    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
    public int getRole_id() {
        return role_id;
    }
    public void setRole_id(int role_id) {
        this.role_id = role_id;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public int getNumberFriends() {
        return numberFriends;
    }
    public void setNumberFriends(int numberFriends) {
        this.numberFriends = numberFriends;
    }
    public String getCountry() {
        return country;
    }
    public void setCountry(String country) {
        this.country = country;
    }
    public Timestamp getDateCreate() {
        return dateCreate;
    }
    public void setDateCreate(Timestamp dateCreate) {
        this.dateCreate = dateCreate;
    }
    
    public String getAvatar() {
		return avatar;
	}


	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}


	@Override
    public String toString() {
	return "User [id=" + id + ", username=" + username + ", password=" + password + ", fullname=" + fullname
		+ ", phone=" + phone + ", role_id=" + role_id + ", description=" + description + ", numberFriends="
		+ numberFriends + ", country=" + country + ", dateCreate=" + dateCreate + "]";
    }
    
    
    
}
