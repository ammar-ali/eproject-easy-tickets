<%--
   Document   : index
    Created on : Jul 8, 2011, 3:16:48 PM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<%@ taglib uri="/WEB-INF/TLD/elfticket" prefix="ticketELF" %>
<%@ taglib uri="/WEB-INF/TLD/elfstring" prefix="stringELF" %>
<%@ taglib uri="/WEB-INF/TLD/elfticketbook" prefix="ticketbookELF" %>
<%@ taglib uri="/WEB-INF/TLD/taglib.tld" prefix="w" %>
<%@taglib  uri="/WEB-INF/TLD/elfeventtype" prefix="eventtypeELF"%>
<%@taglib  uri="/WEB-INF/TLD/elfevent" prefix="eventELF"%>

<c:set var="SYSTEM_PARAM" value='${ticketbookELF:getSystemParameter()}'/>
    <c:set var="TOTAL_RECORD_SHOW" value='${SYSTEM_PARAM.recordNumberNeedShow}'></c:set>
    <c:set var="TOTAL_PAGE_SHOW" value='${SYSTEM_PARAM.pageNumberNeedShow}'></c:set>
    <c:set var="indexPage" value="0"></c:set>
    <c:set var="eventTypes" value='${eventtypeELF:getInstanceValue()}'></c:set>
    <c:set var="tickets" value="${ticketELF:getTicketsByEventTypeID(1,0,indexPage,TOTAL_RECORD_SHOW)}"></c:set>
    <c:set var="totalRecord" value="${ticketELF:countByEventTypeID(tickets,1,0)}"></c:set>



        <c:if test="${param.pindex ne '' and  stringELF:validatePositiveNumber(param.pindex) eq 1}">
            <c:set var="indexPage" value="${stringELF:parseInt(ticketbookELF:castParameterRequestIsNull(pageContext.request,'pindex','0'))}"></c:set>
        </c:if>
        <c:set var="indexPage" value='${indexPage}'></c:set>

        <select>
            <c:forEach var="event" items="${eventTypes}">
                <option value="${event.ID}">${event.name}</option>
            </c:forEach>
        </select>


<table width="640px" cellpadding="10px">
        <tr style="font-weight:bold">
            <td>Title</td>
            <td>City</td>
            <td>Address</td>

        </tr>
        <c:forEach items="${tickets}" var="ticket">
        <tr>
            <td>${ticket.title}</td>
            <td>${ticket.cityName}</td>
            <td>${ticket.venueName} | ${ticket.venueAddress}</td>

        </tr>

</c:forEach>
    </table>

