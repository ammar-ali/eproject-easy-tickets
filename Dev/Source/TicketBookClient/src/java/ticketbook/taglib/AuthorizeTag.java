package ticketbook.taglib;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.TagSupport;




public class AuthorizeTag extends TagSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	javax.servlet.http.HttpServletResponse response;
	javax.servlet.http.HttpServletRequest request;
	java.lang.String pathTo;
	
	public void setResponse(javax.servlet.http.HttpServletResponse response){
		this.response=response;
	}
	
	public void setRequest(javax.servlet.http.HttpServletRequest request){
		this.request=request;
	}
	
	public void setPathTo(java.lang.String pathTo){
		this.pathTo=pathTo;
	}
	
	public int doEndTag() throws JspException {		
		return 0;
	}


	public int doStartTag() throws JspException {
		// TODO Auto-generated method stub
		try {
			AuthorizeController.check(this.request,this.response, this.pathTo);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return SKIP_BODY;
	}

	

	public void release() {
		// TODO Auto-generated method stub
		
	}


	public void setPageContext(PageContext arg0) {
		// TODO Auto-generated method stub
		
	}

}
