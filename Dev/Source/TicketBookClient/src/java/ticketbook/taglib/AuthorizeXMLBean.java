package ticketbook.taglib;

import java.util.ArrayList;

public class AuthorizeXMLBean {
	private String pageName;
	private ArrayList role;
	private String errorPage;
	private String alert;
	private String sessionRole;
	
	
	public AuthorizeXMLBean(){
		this.role=new ArrayList();
		this.pageName="";
		this.alert="";
		this.errorPage="";
		this.sessionRole="";
	}
	
	public String getPageName(){
		return this.pageName;
	}
	
	public void setPageName(String pageName){
		this.pageName=pageName;
	}
	
	public ArrayList getRoles(){
		return this.role;
	}
	
	public String getErrorPage(){
		return this.errorPage;
	}
	
	public String getAlert(){
		return this.alert;
	}
	
	public void setRoles(ArrayList roles){
		this.role=roles;
	}
	
	public void setErrorPage(String errorPage){
		this.errorPage=errorPage;
	}
	
	public void setAlert(String alert){
		this.alert=alert;
	}
	
	public String getSessionRole(){
		return this.sessionRole;
	}
	
	public void setSessionRole(String sessionName){
		this.sessionRole=sessionName;
	}
}

