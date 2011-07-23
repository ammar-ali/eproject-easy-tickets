<%--
   Document   : index
    Created on : Jul 8, 2011, 3:16:48 PM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<c:set var="REQUEST_CONTEXTPATH" value='<%=request.getContextPath()%>'></c:set>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
        <link rel='stylesheet' href='${REQUEST_CONTEXTPATH}/Style/layout.css'/>
        <link rel='stylesheet' href='${REQUEST_CONTEXTPATH}/Style/tag_def.css'/>
        <link rel='stylesheet' href='${REQUEST_CONTEXTPATH}/Style/component.css'/>


    </head>
    <body>

        <jsp:include page="../Block/block1.jsp"/>
            <jsp:include page="login_form.jsp"></jsp:include>
        <jsp:include page="../Block/block2.jsp"/>
    </body>
</html>	