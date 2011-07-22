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
<%@page import="ticketbook.controller.BookingController"%>
<%@page import="ticketbook.controller.HandlerController"%>
<%@page import="ticketbook.controller.TicketBookingController"%>

<c:set var="SYS_PARAM" value="${ticketbookELF:getSystemParameter()}"></c:set>
<c:set var="TOTAL_RECORD_SHOW" value='${SYS_PARAM.recordNumberNeedShow}'></c:set>
<c:set var="TOTAL_PAGE_SHOW" value='${SYS_PARAM.pageNumberNeedShow}'></c:set>
<c:set var="CONTEXT_PATH" value='<%=request.getContextPath()%>'></c:set>
<c:set var="ACTIONTYPE_NAME" value='<%=HandlerController.ACTIONTYPE_NAME%>'></c:set>
<c:set var="ACTIONTYPE_VALUE" value='<%=HandlerController.ACTIONTYPE_VALUE_UPDATE_BOOKING_STATUS%>'></c:set>
<c:set var="TICKETBOOKID_CONTROL_NAME" value='<%=TicketBookingController.TICKETBOOKID_CONTROL_NAME%>'></c:set>
<c:set var="TEMP_TICKETBOOK_CHECKBOX_CONTROL_NAME" value='<%=TicketBookingController.TEMP_TICKETBOOK_CHECKBOX_CONTROL_NAME%>'></c:set>
<c:set var="TEMP_LENGTH_TICKETBOOK_CHECKBOX_CONTROL_NAME" value='<%=TicketBookingController.TEMP_LENGTH_TICKETBOOK_CHECKBOX_CONTROL_NAME%>'></c:set>
<c:set var="bookings" value='${bookingELF:getAllBookingByStatus(param.stt,param.pindex,TOTAL_RECORD_SHOW)}'></c:set>
<form action="${CONTEXT_PATH}/AdminController" method="post" name="frmBooking">
    <input type="hidden" value="" name="${ACTIONTYPE_NAME}" id="actionType">

    Delivery Status: <select onchange="changeStatusDelivery(this.value)" id="selStatusDelivery">
        <option value="${SYS_PARAM.newStatusTicketBooking}" <c:if test="${param.stt eq SYS_PARAM.newStatusTicketBooking}">selected</c:if>>New</option>
        <option value="${SYS_PARAM.acceptStatusTicketBooking}" <c:if test="${param.stt eq SYS_PARAM.acceptStatusTicketBooking}">selected</c:if>>Finish</option>
    </select>
    <table width="640px" cellpadding="10px">
        <tr align="center" style="font-weight: bold">
            <td><input type="checkbox" onclick="checkAll_ckbTicket(this.checked)"/></td><td>Card Number</td><td>Event</td><td>Ticket Total</td><td>Price Total</td>
        </tr>
        <c:set var="count" value="0"></c:set>
        <c:forEach var="objBooking" items="${bookings}">
            <tr align="center">
                <td><input type="checkbox" name="${TEMP_TICKETBOOK_CHECKBOX_CONTROL_NAME}${count}" <c:if test="${objBooking.acceptStatus eq SYS_PARAM.acceptStatusTicketBooking}">checked disabled='disabled'</c:if> id="ckbTicket_${count}"/>
                    <input type="hidden"  id="txtTicket_${count}" value="${objBooking.ID}" name="${TICKETBOOKID_CONTROL_NAME}${count}"/>
                </td>
                <td>${objBooking.cardNumber}</td>
                <td>
                    <c:set var="ticket" value="${ticketELF:getTicketByID(objBooking.ticketID)}"></c:set>
                    <c:set var="eventName" value="${eventtypeELF:getEventTypeNameByID(ticket.eventTypeID)}"></c:set>
                    ${eventName}
                </td>
                <td>${objBooking.ticketTotal}</td>
                <td>${ticketbookELF:filterTicketBookMoney(objBooking.priceTotal)} USD</td>
            </tr>
            <c:set var="count" value="${count+1}"></c:set>
        </c:forEach>
        <tr>
            <td colspan="5" align="center">
                <input type="hidden" value="${count}" name="${TEMP_LENGTH_TICKETBOOK_CHECKBOX_CONTROL_NAME}"/>
                <input type="button" <c:if test="${SYS_PARAM.acceptStatusTicketBooking eq param.stt}">disabled='disabled'</c:if> value="Submit" onclick="submitUpdateStatus()"/></td>
        </tr>
    </table>
</form>
<script type="text/javascript">

    function submitUpdateStatus(){
        document.getElementById("actionType").value="${ACTIONTYPE_VALUE}";
        document.forms["frmBooking"].submit();
    }

    function changeStatusDelivery(args){
        location.href="${CONTEXT_PATH}/Form/Admin/admin.jsp?name=booking&stt="+args;
    }

    function checkAll_ckbTicket(stt)
    {
        for(i=0;i<${count};i++){
            var objCheck=document.getElementById("ckbTicket_"+i);
            objCheck.checked=stt;
            objCheck.value=stt;
        }
    }


</script>