package web.java.model;

public class React {
    private int id;
    private int type;
    private int user;
    private int post;
    public React(int id, int type, int user, int post) {
	super();
	this.id = id;
	this.type = type;
	this.user = user;
	this.post = post;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public int getType() {
        return type;
    }
    public void setType(int type) {
        this.type = type;
    }
    public int getUser() {
        return user;
    }
    public void setUser(int user) {
        this.user = user;
    }
    public int getPost() {
        return post;
    }
    public void setPost(int post) {
        this.post = post;
    }
    @Override
    public String toString() {
	return "React [id=" + id + ", type=" + type + ", user=" + user + ", post=" + post + "]";
    }
    
    
}
