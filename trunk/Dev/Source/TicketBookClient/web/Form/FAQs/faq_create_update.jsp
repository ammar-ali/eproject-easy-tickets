<%-- 
    Document   : faq_create_update
    Created on : Jul 28, 2011, 3:25:03 PM
    Author     : QuocHai
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<link rel='stylesheet' href='<%=request.getContextPath()%>/Style/layout.css'/>
<link rel='stylesheet' href='<%=request.getContextPath()%>/Style/tag_def.css'/>
<link rel='stylesheet' href='<%=request.getContextPath()%>/Style/component.css'/>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>FAQs Management</title>
    </head>
    <body>
        <jsp:include page="../../Block/block1.jsp"/>
        <font class="_content_title">Create FAQs</font>
        <center>
            <table>
                <form action="FaqController" method="post">
                    <tr>
                        <td>Question:</td>
                        <td><input type="text" value="" name="txtQuestion"/><br/></td>
                    </tr>
                    <tr>
                        <td>Answer:</td>
                        <td><input type="text" value="" name="txtAnswer"/><br/></td>
                    </tr>
                    <tr>
                        <td><input type="submit" value="Create"/></td>
                        <td><input type="button" value="Cancel" onclick="history.back()"</td>
                    </tr>
                </form>
            </table>
        </center>
        <jsp:include page="../../Block/block2.jsp"/>
    </body>
</html>
