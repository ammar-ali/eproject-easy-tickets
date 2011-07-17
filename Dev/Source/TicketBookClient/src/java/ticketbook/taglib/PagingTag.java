package ticketbook.taglib;

import java.util.ArrayList;


import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.BodyTagSupport;

import ticketbook.util.JavascriptCode;

public class PagingTag extends BodyTagSupport{

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    boolean enableSubmit = false;
    String properties = "";
    String queryString = "";
    IPaging paging;
    String pathName = "";
    int index = 0;
    int totalRecord = 0;
    int numRecordDivide = 0;
    int numPageDivide = 0;
    String pageName = "";
    ArrayList params;
    String nameIndexGet = "pIndex";
    String style = "";
    String classCss = "";
    boolean enableIndexChoose = false;
    boolean enableFirstPage = false;
    boolean enableLastPage = false;
    String styleIndexChoose = "";
    String nameForm = "";
    String idForm = "";

    public void setIndex(int index) {
        this.index = index;
    }

    public void setIdForm(String idForm) {
        this.idForm = idForm;
    }

    public void setNameForm(String nameForm) {
        this.nameForm = nameForm;
    }

    public void setEnableSubmit(boolean enableSubmit) {
        this.enableSubmit = enableSubmit;
    }

    public void setEnableIndexChoose(boolean enableIndexChoose) {
        this.enableIndexChoose = enableIndexChoose;
    }

    public void setEnableFirstPage(boolean enableFirstPage) {
        this.enableFirstPage = enableFirstPage;
    }

    public void setEnableLastPage(boolean enableLastPage) {
        this.enableLastPage = enableLastPage;
    }

    public void setStyleIndexChoose(java.lang.String styleIndexChoose) {
        this.styleIndexChoose = styleIndexChoose;
    }

    public void setClassCss(java.lang.String classCss) {
        this.classCss = classCss;
    }

    public void setTotalRecord(int totalRecord) {

        this.totalRecord = totalRecord;
    }

    public void setStyle(String style) {
        this.style = style;
    }

    public void setNumRecordDivide(int numRecordDivide) {
        this.numRecordDivide = numRecordDivide;
    }

    public void setNumPageDivide(int numPageDivide) {
        this.numPageDivide = numPageDivide;
    }

    public void setPageName(java.lang.String pageName) {
        this.pageName = pageName;
    }

    public void setPaging(IPaging paging) {
        this.paging = paging;
    }

    public void setPathName(java.lang.String pathName) {
        this.pathName = pathName;
    }

    public int doAfterBody() throws JspException {
        return SKIP_BODY;
    }


    public int doStartTag() throws JspException {
        initProperties();
        initIPaging();
        return EVAL_BODY_AGAIN;
    }

    public void show() {
        try {

            ArrayList indexList = this.paging.divide();

            initQueryString();

            outFirstPageLink(indexList);

            outIndexNumList(indexList);

            outEndPageLink(indexList);

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private void initIPaging() {

        if (this.paging == null) {
            Paging pagingNumber = new Paging();
            if (this.index == 0) {
                this.index = 1;
            }
            pagingNumber.setIndex(this.index);
            pagingNumber.setNumPageDivide(this.numPageDivide);
            pagingNumber.setNumRecordDivide(this.numRecordDivide);
            pagingNumber.setTotalRecord(this.totalRecord);
            this.paging = pagingNumber;

        }
    }

    private void initProperties() {
        this.params = new ArrayList();
        if (!this.pageName.equals("")) {
            this.nameIndexGet = this.pageName;
        }

        this.queryString = "";
        this.properties = "";

        if (!this.style.equals("")) {
            this.properties = this.properties + " style=\"" + this.style + "\"";
        }

        if (!this.classCss.equals("")) {
            this.properties = this.properties + " class=\"" + this.classCss + "\"";
        }
    }

    public int doEndTag() throws JspException {
        // TODO Auto-generated method stub
        show();
        this.params = null;
        this.paging = null;
        return 0;
    }

    public void setPageContext(PageContext arg0) {
        // TODO Auto-generated method stub
        this.pageContext = arg0;
    }

    public ArrayList getParams() {
        return this.params;
    }

    public void outFirstPageLink(ArrayList indexList) {
        JspWriter out = pageContext.getOut();
        try {
            String link = this.pathName + "?" + this.nameIndexGet + "=" + paging.getIndexStart().getIndex() + queryString;
            if (this.enableFirstPage == true) {
                out.print("<a " + this.properties + " " + this.getEventClick(link) + ">" + this.paging.getIndexStart().getDisplay() + "</a> ");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void outEndPageLink(ArrayList indexList) {

        JspWriter out = pageContext.getOut();
        try {
            if (this.enableLastPage == true) {
                String link = this.pathName + "?" + this.nameIndexGet + "=" + paging.getIndexEnd().getIndex() + queryString;
                out.print("<a " + this.properties + " " + this.getEventClick(link) + " >" + paging.getIndexEnd().getDisplay()
                        + "</a> ");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void outIndexNumList(ArrayList indexList) {
        JspWriter out = pageContext.getOut();
        try {
            for (int i = 0; i < indexList.size(); i++) {
                ((IndexNum)indexList.get(i)).setDisplay(((IndexNum)indexList.get(i)).getIndex() + "");
                String link = this.pathName + "?" + this.nameIndexGet + "=" + ((IndexNum)indexList.get(i)).getIndex() + queryString;

                String eventClick = getEventClick(link);

                if (this.enableIndexChoose == true && this.index == ((IndexNum)indexList.get(i)).getIndex()) {
                    out.print("<a style=\"" + this.styleIndexChoose + "\" " + eventClick + ">" + ((IndexNum)indexList.get(i)).getDisplay() + "</a> ");
                } else {
                    out.print("<a " + this.properties + " " + eventClick + ">" + ((IndexNum)indexList.get(i)).getDisplay() + "</a> ");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String getEventClick(String link) {
        String mode = "";
        if (this.enableSubmit) {
            mode = " onclick=\""
                    + JavascriptCode.getChangeActionForm(this.idForm, link)
                    + JavascriptCode.getChangeMethodForm(this.idForm, "post")
                    + JavascriptCode.getSubmitFormByName(this.nameForm)
                    + " \" ";
        } else {
            mode = " href='" + link + "' ";
        }

        return mode;
    }

    private void initQueryString() {
        for (int i = 0; i < params.size(); i++) {
            this.queryString = "&" + ((Parameter)params.get(i)).getName() + "=" + ((Parameter)params.get(i)).getValue() + queryString;
        }

    }
}
