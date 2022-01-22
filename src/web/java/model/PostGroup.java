package web.java.model;

public class PostGroup {
    private int postId;
    private int groupId;
    public PostGroup(int postId, int groupId) {
	super();
	this.postId = postId;
	this.groupId = groupId;
    }
    public int getPostId() {
        return postId;
    }
    public void setPostId(int postId) {
        this.postId = postId;
    }
    public int getGroupId() {
        return groupId;
    }
    public void setGroupId(int groupId) {
        this.groupId = groupId;
    }
    @Override
    public String toString() {
	return "PostGroup [postId=" + postId + ", groupId=" + groupId + "]";
    }
    
    
    
}
