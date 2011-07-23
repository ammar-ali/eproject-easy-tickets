<%--  
   Document   : index
    Created on : Jul 8, 2011, 3:16:48 PM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<%@page import="ticketbook.util.TicketBookSession"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<%@ taglib uri="/WEB-INF/TLD/elfticketbook" prefix="ticketbookELF" %>
<%@page import="ticketbook.util.Constant"%>
<html>
<head>
<c:set var="CONTEXT_PATH" value='<%=request.getContextPath()%>'></c:set>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>EasyTickets-Home</title>
<link rel='stylesheet' href='${CONTEXT_PATH}/Style/layout.css'/>
<link rel='stylesheet' href='${CONTEXT_PATH}/Style/tag_def.css'/>
<link rel='stylesheet' href='${CONTEXT_PATH}/Style/component.css'/>

</head>
<body>
    
<jsp:include page="Block/block1.jsp"/>
<c:set var="TICKETBOOK_SESSION" value='<%=request.getSession()%>'></c:set>
<c:set var="ROLEID_USER_LOGIN_SESSION_NAME" value='<%=TicketBookSession.ROLEID_USER_LOGIN%>'></c:set>
<c:set var="roleID" value='${ticketbookELF:castSessionIsNull(TICKETBOOK_SESSION,ROLEID_USER_LOGIN_SESSION_NAME,0)}'/>
<c:set var="ID_FALSE_INTEGER" value='<%=Constant.ID_FALSE_INTETER%>'></c:set>

 <font class="_content_title"> Online Booking & Payment </font>
<div>
    <ul>
        <li>You must be registered member to book the ticket.</li>
        <li>Online booking can be done only 15 days in advance.</li>
        <li>This requires possession of a bank‘s credit or debit card with the customer</li>
        <li>No cancellation of tickets once they are booked, at any cost.</li>
    </ul>
</div>
<br/>
<c:choose>
    <c:when test="${roleID ne ID_FALSE_INTEGER}">
        <jsp:include page="Form/top_ticket_form.jsp"></jsp:include>
    </c:when>
    <c:otherwise>
        <jsp:include page="Form/login_form.jsp"></jsp:include>
    </c:otherwise>
</c:choose>
<jsp:include page="Block/block2.jsp"/>
</body>
</html>	