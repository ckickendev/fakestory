package web.java.model;

public class Member {
    private int user_id;
    private int group_id;
    private int role;
    public Member(int user_id, int group_id, int role) {
	super();
	this.user_id = user_id;
	this.group_id = group_id;
	this.role = role;
    }
    public int getUser_id() {
        return user_id;
    }
    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }
    public int getGroup_id() {
        return group_id;
    }
    public void setGroup_id(int group_id) {
        this.group_id = group_id;
    }
    public int getRole() {
        return role;
    }
    public void setRole(int role) {
        this.role = role;
    }
    @Override
    public String toString() {
	return "Member [user_id=" + user_id + ", group_id=" + group_id + ", role=" + role + "]";
    }
    
    
}
