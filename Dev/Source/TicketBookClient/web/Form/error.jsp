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
        <div style="border-style:inset;border-width: 1px;width:500px">
            <h2 style="background-color:#176c9c;padding-left:10px;padding-right:10px;border-style:inset;border-width: 1px;;color:white;width:480px">Sorry ! You can't view this page </h2>
            <h3 style="padding-left:10px;padding-right:10px">Reason:</h3>
            <ul>
                <li><h3>You must be registered and login to view.</h3></li>
                <li><h3>This page is repairing.</h3></li>
                <li><h3>Your role don't access this page</h3></li>
            </ul>
            <h3 style="padding-left:10px;width:480px;text-align: right;padding-right:10px">You can contact with admin to know detail.</h3>
        </div>
        <jsp:include page="../Block/block2.jsp"/>
    </body>
</html>
