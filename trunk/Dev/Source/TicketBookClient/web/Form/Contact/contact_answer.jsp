<%-- 
    Document   : contact_create
    Created on : Jul 28, 2011, 3:24:32 PM
    Author     : QuocHai
--%>
<%@page import="java.util.Vector" %>
<%@page import="ticketbook.transfer.ContactTransferData" %>
<%@page import="ticketbook.model.Contact" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<link rel='stylesheet' href='<%=request.getContextPath()%>/Style/layout.css'/>
<link rel='stylesheet' href='<%=request.getContextPath()%>/Style/tag_def.css'/>
<link rel='stylesheet' href='<%=request.getContextPath()%>/Style/component.css'/>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Contact Management</title>
    </head>
    <body>
        <jsp:include page="../../Block/block1.jsp"/>
        <font class="_content_title">Answer Contact</font>
        <center>
            <form action="ContactController?act" method="post">
                <table>
                <% Vector lstContact = Contact.getAll();%>
                  <% for(int i=0;i<lstContact.size();i++){
                  %>
                  <tr>
                      <td>Title:</td>
                      <td><input type="hidden" name="txtTitle" value="<% ((ContactTransferData)lstContact.get(i)).getTitle(); %>"/></td>
                  </tr>
                  <tr>
                      <td>Content:</td>
                      <td><input type="hidden" name="txtContent" value="<% ((ContactTransferData)lstContact.get(i)).getContent(); %>"/></td>
                  </tr>
                  <tr>
                      <td>Email:</td>
                      <td><input type="hidden" name="txtEmail" value="<% ((ContactTransferData)lstContact.get(i)).getEmail(); %>"/></td>
                  </tr>
                  <tr>
                      <td>Answer:</td>
                      <td><input type="text" name="txtAnswer" value=""/></td>
                  </tr>
                  <tr>
                      <td><input type="submit" value="Create"/></td>
                      <td><input type="button" value="Cancel" onclick="history.back()"/></td>
                  </tr>
                 <%
                }
                %>
                </table>
            </form>
        </center>
            <jsp:include page="../../Block/block2.jsp"/>
    </body>
</html>
