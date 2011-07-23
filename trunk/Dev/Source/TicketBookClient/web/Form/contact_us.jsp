<%--
   Document   : index
    Created on : Jul 8, 2011, 3:16:48 PM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Contact Us</title>
<link rel='stylesheet' href='<%=request.getContextPath()%>/Style/layout.css'/>
<link rel='stylesheet' href='<%=request.getContextPath()%>/Style/tag_def.css'/>
<link rel='stylesheet' href='<%=request.getContextPath()%>/Style/component.css'/>

</head>
<body>

<jsp:include page="../Block/block1.jsp"/>
<font class="_content_title">Contact us</font>
<center>
    <table>
        <tr>
            <td>Title</td>
            <td><input type="text" name="txtContact_Title" maxlength="200" /></td>
        </tr>
        <tr>
            <td>Content</td>
            <td><input type="text" maxlength="200" name="txtContact_Content"/></td>
        </tr>
        <tr>
            <td>Email</td>
            <td><input type="text" maxlength="200" name="txtContact_Email"/></td>
        </tr>
        <tr align="center">
            <td><input type="button" value="Submit" onclick=""/></td>
        </tr>
    </table>
</center>
<jsp:include page="../Block/block2.jsp"/>
</body>
</html>	