<%--
    Document   : error
    Created on : Jul 18, 2011, 10:07:22 AM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<link rel='stylesheet' href='<%=request.getContextPath()%>/Style/layout.css'/>
<link rel='stylesheet' href='<%=request.getContextPath()%>/Style/tag_def.css'/>
<link rel='stylesheet' href='<%=request.getContextPath()%>/Style/component.css'/>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Admin</title>
    </head>
    <body>
        <jsp:include page="../../Block/block1.jsp"/>
        <div class="_content_title">Admin</div>
        <br/>
        <table width="720px" cellpadding="10px;" border="1">
            <tr align="center" style="font-size: 16px;font-weight: bold;background-color:#176c9c">
                <td <c:if test="${param.name eq 'ticket'}">style="background-color:black"</c:if>>
                    <a style="color:white" href="<%=request.getContextPath()%>/Form/Admin/admin.jsp?name=ticket">Ticket</a></td>
                <td <c:if test="${param.name eq 'booking'}">style="background-color:black"</c:if>>
                    <a style="color:white" href="<%=request.getContextPath()%>/Form/Admin/admin.jsp?name=booking">Booking</a></td>
                <td <c:if test="${param.name eq 'FAQ'}">style="background-color:black"</c:if>>
                    <a style="color:white" href="<%=request.getContextPath()%>/Form/Admin/admin.jsp?name=FAQ">FAQ</a></td>
                <td <c:if test="${param.name eq 'contact'}">style="background-color:black"</c:if>>
                    <a style="color:white" href="<%=request.getContextPath()%>/Form/Admin/admin.jsp?name=contact">Contact</a></td>
            </tr>
                <tr>
                <td colspan="4">
                    <c:choose>
                        <c:when test="${param.name eq 'FAQ'}">
                            <jsp:include page="faq_create.jsp"></jsp:include>
                        </c:when>
                        <c:when test="${param.name eq 'ticket'}">
                            <jsp:include page="ticket_manage.jsp"></jsp:include>
                        </c:when>
                        <c:when test="${param.name eq 'contact'}">
                            <jsp:include page="contact_manage.jsp"></jsp:include>
                        </c:when>
                        <c:when test="${param.name eq 'booking'}">
                            <jsp:include page="booking_manage.jsp"></jsp:include>
                        </c:when>

                    </c:choose>
                    
                </td>
            </tr>
        </table>
        <jsp:include page="../../Block/block2.jsp"/>
    </body>
</html>
