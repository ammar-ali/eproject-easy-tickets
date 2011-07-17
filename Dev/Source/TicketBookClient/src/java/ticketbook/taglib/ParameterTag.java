package ticketbook.taglib;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.BodyTagSupport;
import ticketbook.util.ClassPathUtil;

public class ParameterTag extends BodyTagSupport  {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String name;
	private String value;
	
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
	
	public int doAfterBody() throws JspException{		
		this.value=getBodyContent().getString();
		Parameter param=new Parameter();
		param.setName(this.name);
		param.setValue(this.value);
		if(this.getParent().getClass().getName().equals(ClassPathUtil.TICKETBOOK_TAGLIB_PAGINGTAG)){
			PagingTag pagingTag=(PagingTag)findAncestorWithClass(this,PagingTag.class);		
			pagingTag.getParams().add(param);
		}

		return SKIP_BODY;
	}
	
	public int doStartTag() throws JspException {
		// TODO Auto-generated method stub
		return EVAL_BODY_AGAIN;
	}

	
	
}
