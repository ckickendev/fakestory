package web.java.model;

public class Friendship {
    private int id;
    private int user_1;
    private int user_2;
    private int status;
    
    
    public Friendship(int id, int user_1, int user_2, int status) {
	super();
	this.id = id;
	this.user_1 = user_1;
	this.user_2 = user_2;
	this.status = status;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public int getUser_1() {
        return user_1;
    }
    public void setUser_1(int user_1) {
        this.user_1 = user_1;
    }
    public int getUser_2() {
        return user_2;
    }
    public void setUser_2(int user_2) {
        this.user_2 = user_2;
    }
    public int getStatus() {
        return status;
    }
    public void setStatus(int status) {
        this.status = status;
    }
    @Override
    public String toString() {
	return "Friendship [id=" + id + ", user_1=" + user_1 + ", user_2=" + user_2 + ", status=" + status + "]";
    }
    
    
}
