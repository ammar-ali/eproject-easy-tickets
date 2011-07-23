<%-- 
    Document   : top
    Created on : Jul 23, 2011, 10:45:06 AM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<%@ taglib uri="/WEB-INF/TLD/elfticketbook" prefix="ticketbookELF" %>
<%@ taglib uri="/WEB-INF/TLD/elfeventtype" prefix="eventtypeELF" %>
<%@ taglib uri="/WEB-INF/TLD/elfticket" prefix="ticketELF" %>
<%@ taglib uri="/WEB-INF/TLD/taglib.tld" prefix="w" %>

<%@page import="java.util.ArrayList"%>
<%@page import="ticketbook.model.EventType"%>
<%@page import="ticketbook.util.TicketBookParameter"%>
<w:authorize_role pathTo="/WEB-INF/authorize.xml" request="${pageContext.request}" response="${pageContext.response}"></w:authorize_role>

<c:set var="CONTEXT_PATH" value='<%=request.getContextPath()%>'></c:set>
<c:set var="SYS_PARAM" value='${ticketbookELF:getSystemParameter()}'></c:set>
<c:set var="EVENT_TYPES" value='${eventtypeELF:getInstanceValue()}'></c:set>
<c:set var="indexEventTypes" value="0"></c:set>
<c:set var="indexItemEvent" value="1"></c:set>
 

<font class="_content_title"> TOP </font>

<br/>
<table  border="1" cellpadding="3px" cellspacing="0"  width="720px" style="border-style: solid;">

<c:forEach items="${EVENT_TYPES}" var="objEventType">

        <c:set var="indexItemEvent" value="1"></c:set>

        <c:set var="indexEventTypes" value='${indexEventTypes}'></c:set>

            <tr>
                <td align="center" width="250px" style="color:white;font-size:14px;background-color:#176c9c;border-right: 1px">${objEventType.name}</td>

            </tr>
            <c:set var="events" value='${ticketELF:getTopTicketsByEventTypeID(objEventType.ID,SYS_PARAM.topIndexShow)}'></c:set>
                <c:forEach items="${events}" var="objEvent">
                    <tr>
                        <c:set var="status" value="${objEvent.viewStatus}"></c:set>
                        <td align="center" width="250px"><font style='font-size: 14px;font-weight:bold'>${objEvent.title}</font> </td>
                        <td width="360px"  style="border-left:none;border-right:none;padding-left:10px">${objEvent.cityName} City, ${objEvent.venueName} Theatre ,${objEvent.venueAddress} Street</td>
                        <td width="40px"  style="border-left:none;border-right:none" align="center"><c:if test="${status ne 'Old'}"><font color="red" style="font-style: italic">${status}</font></c:if></td>
                        <td width="40px" style="border-left:none;" align="center"><a href="${CONTEXT_PATH}/Form/show_tickets.jsp?index=${indexEventTypes}&view=${indexItemEvent}&stt=more">Detail</a></td>
                    </tr>
                    <c:set var="indexItemEvent" value="${indexItemEvent+1}"></c:set>
                </c:forEach>
            <tr>

                <td colspan="4">
                    <div style="text-align: right;"><a href="${CONTEXT_PATH}/Form/show_tickets.jsp?index=${indexEventTypes}">More..</a></div>
                </td>
            </tr>

    <c:set var="indexEventTypes" value="${indexEventTypes+1}"></c:set>
 </c:forEach>
</table>

