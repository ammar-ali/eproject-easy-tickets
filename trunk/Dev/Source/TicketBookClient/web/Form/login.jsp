<%--
   Document   : index
    Created on : Jul 8, 2011, 3:16:48 PM
    Author     : Admin
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
<title>Login</title>
<link rel='stylesheet' href='<%=request.getContextPath()%>/Style/layout.css'/>
<link rel='stylesheet' href='<%=request.getContextPath()%>/Style/tag_def.css'/>
<link rel='stylesheet' href='<%=request.getContextPath()%>/Style/component.css'/>

</head>
<body>

<jsp:include page="../Block/block1.jsp"/>
<font class="_content_title">Login</font>


<jsp:include page="../Block/block2.jsp"/>
</body>
</html>	