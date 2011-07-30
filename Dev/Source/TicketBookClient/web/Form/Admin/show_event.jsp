<%-- 
    Document   : admin
    Created on : 
    Author     : 
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<%@ taglib uri="/WEB-INF/TLD/elfevent" prefix="eventELF" %>
<%@ taglib uri="/WEB-INF/TLD/elfstring" prefix="stringELF" %>
<%@ taglib uri="/WEB-INF/TLD/elfticketbook" prefix="ticketbookELF" %>
<%@ taglib uri="/WEB-INF/TLD/taglib.tld" prefix="w" %>

<c:set var="SYSTEM_PARAM" value='${ticketbookELF:getSystemParameter()}'/>
    <c:set var="TOTAL_RECORD_SHOW" value='${SYSTEM_PARAM.recordNumberNeedShow}'></c:set>
    <c:set var="TOTAL_PAGE_SHOW" value='${SYSTEM_PARAM.pageNumberNeedShow}'></c:set>
    <c:set var="indexPage" value="0"></c:set>
    <c:set var="totalRecord" value='${eventELF:getCountAllEvent()}'></c:set>

    <c:choose>
        <c:when test="${stringELF:validatePositiveNumber(param.index) eq 1}">
            <c:set var="lstEvent" value='${eventELF:getAllEvent(param.index,TOTAL_RECORD_SHOW)}'></c:set>
        </c:when>
        <c:otherwise>
            <c:set var="lstEvent" value='${eventELF:getAllEvent(0,TOTAL_RECORD_SHOW)}'></c:set>
        </c:otherwise>
    </c:choose>

        <c:if test="${param.pindex ne '' and  stringELF:validatePositiveNumber(param.pindex) eq 1}">
            <c:set var="indexPage" value="${stringELF:parseInt(ticketbookELF:castParameterRequestIsNull(pageContext.request,'pindex','0'))}"></c:set>
        </c:if>
        <c:set var="indexPage" value='${indexPage}'></c:set>
        <div style="text-align: right">
            <c:if test="${totalRecord gt TOTAL_RECORD_SHOW}">
                <w:paging pathName="admin.jsp"
                enableFirstPage="true"
                enableLastPage="true"
                enableIndexChoose="true"
                styleIndexChoose="color:blue"
                index="${indexPage}"
                totalRecord="${totalRecord}"
                numPageDivide="${TOTAL_PAGE_SHOW}"
                numRecordDivide="${TOTAL_RECORD_SHOW}"
                style="cursor:pointer"
                pageName="index">
                    <w:parameter name="name">${param.name}</w:parameter>
                    <w:parameter name="function">${param.function}</w:parameter>
                </w:paging>
            </c:if>
        </div>
<table width="640px" cellpadding="10px">
        <tr style="font-weight:bold">
            <td>Title</td>
            <td>City</td>
            <td>Address</td>
            <td>Type</td>
        </tr>
        <c:forEach items="${lstEvent}" var="event">
        <tr>
            <td>${event.title}</td>
            <td>${event.cityName}</td>
            <td>${event.venueName} | ${event.venueAddress}</td>
            <td>${event.eventTypeName}</td>
        </tr>

</c:forEach>
    </table>


