package ticketbook.taglib;

public class IndexNum {
	
	private int index;
	private String display;
	
	public IndexNum(){
		this.index=0;
		this.display="";
	}
	
	public void setIndex(int index){
		this.index=index;
	}
	
	public int getIndex(){
		return this.index;
	}
	
	public String getDisplay(){
		return this.display;
	}
	
	public void setDisplay(String display){
		this.display=display;
	}
}
