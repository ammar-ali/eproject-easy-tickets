package ticketbook.taglib;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



public class AuthorizeController{


	public static void check(HttpServletRequest request, HttpServletResponse response,String path) throws ServletException, IOException {
			// TODO Auto-generated method stub
		
		String URI=request.getRequestURI();
		String contextPath=request.getContextPath();
		try{
			ArrayList authorizeListModel=new ArrayList();
			authorizeListModel = XMLBundle.getAuthorizeRole(request.getRealPath(path));
	  		for(int i=0;i<authorizeListModel.size();i++){
	  			AuthorizeXMLBean authorize=(AuthorizeXMLBean)authorizeListModel.get(i);
	  			
			  		if(URI.equals(contextPath+authorize.getPageName())){
			  			ArrayList rolesXML=authorize.getRoles();
			  			String role="";
			  			if(request.getSession().getAttribute(authorize.getSessionRole())!=null){
			  				role=request.getSession().getAttribute(authorize.getSessionRole()).toString();	
	  					}
	  					
			  			int j;
			  			for(j=0;j<rolesXML.size();j++){
			  				if(rolesXML.get(j).equals(role)){
			  					j=rolesXML.size();
			  				}
			  			}
			  			if(j!=rolesXML.size()+1){
			  				i=authorizeListModel.size();
			  				response.getWriter().print("<script>location.href='"+authorize.getErrorPage()+"';</script>");
			  			}
			  		}
		  		
	  		}
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}

	
}
