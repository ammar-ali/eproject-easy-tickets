<%-- 
    Document   : error
    Created on : Jul 18, 2011, 10:07:22 AM
    Author     : Admin
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
        <title>Error!</title>
    </head>
    <body>
        <jsp:include page="../Block/block1.jsp"/>
        <h1>Sorry ! You can't view this page</h1>
        <h2>You must be registered and login to view</h2>
        <jsp:include page="../Block/block2.jsp"/>
    </body>
</html>
