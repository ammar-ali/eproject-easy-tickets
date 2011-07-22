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
<%@ taglib uri="/WEB-INF/TLD/elfticket" prefix="ticketELF" %>
<%@ taglib uri="/WEB-INF/TLD/elfeventtype" prefix="eventtypeELF" %>
<%@ taglib uri="/WEB-INF/TLD/elfbooking" prefix="bookingELF" %>
<%@ taglib uri="/WEB-INF/TLD/taglib.tld" prefix="w" %>
<%@page import="ticketbook.util.TicketBookParameter"%>
<%@page import="ticketbook.model.TicketBooking"%>


<c:set var="SYS_PARAM" value="${ticketbookELF:getSystemParameter()}"></c:set>
<c:set var="CONTEXT_PATH" value='<%=request.getContextPath()%>'></c:set>
<c:set var="bookings" value='${bookingELF:getAllBookingByStatus(param.stt,1,10)}'></c:set>

Delivery Status: <select onchange="changeStatusDelivery(this.value)" id="selStatusDelivery">
    <option value="${SYS_PARAM.newStatusTicketBooking}" <c:if test="${param.stt eq SYS_PARAM.newStatusTicketBooking}">selected</c:if>>New</option>
    <option value="${SYS_PARAM.acceptStatusTicketBooking}" <c:if test="${param.stt eq SYS_PARAM.acceptStatusTicketBooking}">selected</c:if>>Finish</option>
</select>
<table width="640px" cellpadding="10px">
    <tr align="center" style="font-weight: bold"><td></td><td>Card Number</td><td>Event</td><td>Ticket Total</td><td>Price Total</td></tr>
    <c:forEach var="objBooking" items="${bookings}">
        <tr>
            <td><input type="checkbox"/></td>
            <td>${objBooking.cardNumber}</td>
            <td><c:set var="ticket" value="${ticketELF:getTicketByID(objBooking.ticketID)}"></c:set>
                
                <c:set var="eventName" value="${eventtypeELF:getEventTypeNameByID(ticket.eventTypeID)}"></c:set>
                ${eventName}
            </td>
            <td>${objBooking.ticketTotal}</td>
            <td>${ticketbookELF:filterTicketBookMoney(objBooking.priceTotal)} USD</td>
         
        </tr>
    </c:forEach>
</table>

<script type="text/javascript">
    
    function changeStatusDelivery(args){
        location.href="<%=request.getContextPath()%>/Form/Admin/admin.jsp?name=booking&stt="+args;
    }

</script>