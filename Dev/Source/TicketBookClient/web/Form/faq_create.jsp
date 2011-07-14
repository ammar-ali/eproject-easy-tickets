<%-- 
    Document   : faq_create
    Created on : Jul 14, 2011, 10:40:01 AM
    Author     : QuocHai
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<%@page import="javax.naming.*" %>
<%@page import="ticketbook.transfer.UserTransferData" %>
<%@page import="ticketbook.exception.ConfigException" %>
<%@page import="ticketbook.util.Config" %>
<%@page import="javax.rmi.PortableRemoteObject" %>
<%@page import="java.util.Enumeration" %>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>FAQ'S Create</title>
<link rel='stylesheet' href='<%=request.getContextPath()%>/Style/layout.css'/>
<link rel='stylesheet' href='<%=request.getContextPath()%>/Style/tag_def.css'/>
<link rel='stylesheet' href='<%=request.getContextPath()%>/Style/component.css'/>

</head>
<body>

<jsp:include page="../Block/block1.jsp"/>
<font class="_content_title">FAQ'S Create</font>
<form action="FAQsController?act=insert" method="post">
    <br>
    <table>
        <tr>
            <td>Question:</td>
            <td><input type="text" name="txtQuestion" value=""</td>
        </tr>
        <tr>
            <td>Answer:</td>
            <td><input type="text" name="txtAnswer" value=""</td>
        </tr>
        <tr>
            <td>Create Date:</td>
            <td><input type="text" name="txtCreate_Date" value=""</td>
        </tr>
        <tr>
            <td><input type="submit" value="Create"</td>
        </tr>
    </table>

</form>

<jsp:include page="../Block/block2.jsp"/>
</body>
</html>