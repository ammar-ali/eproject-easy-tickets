package ticketbook.taglib;

public class Parameter {
	private static final long serialVersionUID = 1L;
	private String name;
	private String value;
	
	public Parameter(){
		this.name="";
		this.value="";
	}
	
	public void setValue(String value){
		this.value=value;
	}
	
	public String getValue(){
		return this.value;
	}
	
	public void setName(String name){
		this.name=name;
	}
	
	public String getName(){
		return this.name;
	}
}
