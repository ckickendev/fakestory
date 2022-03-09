package web.java.model;

public class MessageAPI {
	private String name;
	private String content;
	
	public MessageAPI(String name, String content) {
		this.name = name;
		this.content = content;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	@Override
	public String toString() {
		return "MessageAPI [name=" + name + ", content=" + content + "]";
	}
	
	
	
	
	
}
