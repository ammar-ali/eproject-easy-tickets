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
<%@ taglib uri="/WEB-INF/TLD/taglib.tld" prefix="w" %>

<%@page import="ticketbook.model.TicketBooking"%>
<c:set var="bookings" value='<%=TicketBooking.getAll(1,10)%>'></c:set>
  
<table width="640px" cellpadding="10px">
    <tr align="center" style="font-weight: bold"><td></td><td>Card Number</td><td>Event</td><td>Ticket Total</td><td>Price Total</td><td>Status</td></tr>
    <c:forEach var="objBooking" items="${bookings}">
        <tr>
            <td><input type="checkbox"/></td>
            <td>${objBooking.cardNumber}</td>
            <td><c:set var="ticket" value="${ticketbookELF:getTicketByID(objBooking.ticketID)}"></c:set>
                
                <c:set var="eventName" value="${ticketbookELF:getEventTypeNameByID(ticket.eventTypeID)}"></c:set>
                ${eventName}
            </td>
            <td>${objBooking.ticketTotal}</td>
            <td>${ticketbookELF:filterTicketBookMoney(objBooking.priceTotal)} USD</td>
            <td>
                <c:choose>
                    <c:when test="${objBooking.acceptStatus eq '1'}">Finish</c:when>
                    <c:when test="${objBooking.acceptStatus eq '0'}">
                        <font color="red">Waiting</font>
                    </c:when>
                </c:choose>
            </td>
        </tr>
    </c:forEach>
</table>