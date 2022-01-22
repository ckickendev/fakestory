package web.java.model;

public class TypeReact {
    private int type;
    private String name;
    private String icon;
    public TypeReact(int type, String name, String icon) {
	super();
	this.type = type;
	this.name = name;
	this.icon = icon;
    }
    public int getType() {
        return type;
    }
    public void setType(int type) {
        this.type = type;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getIcon() {
        return icon;
    }
    public void setIcon(String icon) {
        this.icon = icon;
    }
    @Override
    public String toString() {
	return "TypeReact [type=" + type + ", name=" + name + ", icon=" + icon + "]";
    }
    
    
}
