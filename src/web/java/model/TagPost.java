package web.java.model;

public class TagPost {
    private int postId;
    private int userId;
    public TagPost(int postId, int userId) {
	super();
	this.postId = postId;
	this.userId = userId;
    }
    public int getPostId() {
        return postId;
    }
    public void setPostId(int postId) {
        this.postId = postId;
    }
    public int getUserId() {
        return userId;
    }
    public void setUserId(int userId) {
        this.userId = userId;
    }
    @Override
    public String toString() {
	return "TagPost [postId=" + postId + ", userId=" + userId + "]";
    }
    
    
}
