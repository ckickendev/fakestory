package web.java.model;

public class SingleID {
	private String id;

	public SingleID(String id) {
		super();
		this.id = id;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "SingleID [id=" + id + "]";
	}
	
	
	
}
