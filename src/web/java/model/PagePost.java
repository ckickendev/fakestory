package web.java.model;

public class PagePost {
    private int postId;
    private int pageId;
    public PagePost(int postId, int pageId) {
	super();
	this.postId = postId;
	this.pageId = pageId;
    }
    public int getPostId() {
        return postId;
    }
    public void setPostId(int postId) {
        this.postId = postId;
    }
    public int getPageId() {
        return pageId;
    }
    public void setPageId(int pageId) {
        this.pageId = pageId;
    }
    @Override
    public String toString() {
	return "PagePost [postId=" + postId + ", pageId=" + pageId + "]";
    }
    
    
}
