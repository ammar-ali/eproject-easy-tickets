<%--  
   Document   : index
    Created on : Jul 8, 2011, 3:16:48 PM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<%@ taglib uri="/WEB-INF/TLD/elfticketbook" prefix="ticketbookELF" %>
<%@page import="java.util.ArrayList"%>
<%@page import="ticketbook.model.EventType"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>EasyTickets-Home</title>
<link rel='stylesheet' href='<%=request.getContextPath()%>/Style/layout.css'/>
<link rel='stylesheet' href='<%=request.getContextPath()%>/Style/tag_def.css'/>
<link rel='stylesheet' href='<%=request.getContextPath()%>/Style/component.css'/>

</head>
<body>
    
<jsp:include page="Block/block1.jsp"/>
<c:set var="SYS_PARAM" value='<%=new ticketbook.util.TicketBookParameter()%>'></c:set>
<c:set var="eventTypes" value='<%=EventType.getInstanceValue()%>'></c:set>
<% int indexEventTypes=0; %>
 <% int indexItemEvent=1; %>

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


<font class="_content_title"> TOP </font>
<% indexEventTypes=0; %>
<br/>
<table  border="1" cellpadding="3px" cellspacing="0"  width="720px" style="border-style: solid;">
<c:forEach items="${eventTypes}" var="objEventType">
       
        <c:set var="indexEventTypes" value='<%=indexEventTypes%>'></c:set>
        
            <tr>
                <td align="center" width="250px" style="color:white;font-size:14px;background-color:#176c9c;border-right: 1px">${objEventType.name}</td>

            </tr>
            <c:set var="events" value='${ticketbookELF:getTopTicketsByEventTypeID(objEventType.ID,SYS_PARAM.topIndexShow)}'></c:set>
                <c:forEach items="${events}" var="objEvent">
                    <tr>
                        <c:set var="status" value="${objEvent.viewStatus}"></c:set>
                        <td align="center" width="250px"><font style='font-size: 14px;font-weight:bold'>${objEvent.title}</font> </td>
                        <td width="360px"  style="border-left:none;border-right:none;padding-left:10px">${objEvent.cityName} City, ${objEvent.venueName} Theatre ,${objEvent.venueAddress} Street</td>
                        <td width="40px"  style="border-left:none;border-right:none" align="center"><c:if test="${status ne 'Old'}"><font color="red" style="font-style: italic">${status}</font></c:if></td>
                        <td width="40px" style="border-left:none;" align="center"><a href="<%=request.getContextPath()%>/Form/show_tickets.jsp?index=<%=indexEventTypes%>&view=<%=indexItemEvent%>&stt=more">Detail</a></td>
                    </tr>
                    <% indexItemEvent++; %>
                </c:forEach>
            <tr>

                <td colspan="4">
                    <div style="text-align: right;"><a href="<%=request.getContextPath()%>/Form/show_tickets.jsp?index=<%=indexEventTypes%>">More..</a></div>
                </td>
            </tr>
        
        <% indexEventTypes++;%>
 </c:forEach>
</table>

<jsp:include page="Block/block2.jsp"/>
</body>
</html>	