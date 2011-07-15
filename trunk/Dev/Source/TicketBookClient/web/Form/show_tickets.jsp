<%-- 
    Document   : show_tickets
    Created on : Jul 14, 2011, 7:58:08 PM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="/WEB-INF/TLD/elfstring" prefix="stringELF" %>
<%@ taglib uri="/WEB-INF/TLD/elfticketbook" prefix="ticketbookELF" %>
<%@page import="ticketbook.model.EventType"%>
<%@page import="ticketbook.transfer.EventTypeTransferData"%>
<%@page import="ticketbook.util.TicketBookConvert"%>
<%@page import="ticketbook.model.Ticket"%>
<%@page import="java.util.ArrayList"%>
<%@page import="ticketbook.ejb.bmp.EventTypeRemote"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Events</title>
        <link rel='stylesheet' href='<%=request.getContextPath()%>/Style/layout.css'/>
        <link rel='stylesheet' href='<%=request.getContextPath()%>/Style/tag_def.css'/>
        <link rel='stylesheet' href='<%=request.getContextPath()%>/Style/component.css'/>
    </head>
    <body>

<jsp:include page="../Block/block1.jsp"/>
<font class="_content_title">Events</font>

<c:if test="${ stringELF:validatePositiveNumber(param.index) eq 1}">
    <c:set var="lengthEventType" value='<%=EventType.getInstanceValue().size()%>'></c:set>
    <c:if test="${param.index<lengthEventType}">
        <c:set var="eventTypeID" value='<%=((EventTypeRemote)EventType.getInstanceValue().get(Integer.parseInt(request.getParameter("index")))).getID()%>'></c:set>
        <c:set var="tickets" value='${ticketbookELF:getTicketsByEventTypeID(eventTypeID,1,20)}'></c:set>
        <c:forEach var="obj" items="${tickets}">
            ${obj.ID} <br/>
        </c:forEach>
    </c:if>
</c:if>
<jsp:include page="../Block/block2.jsp"/>
    </body>
</html>
