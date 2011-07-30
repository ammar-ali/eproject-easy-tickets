<%-- 
    Document   : create_event
    Created on : Jul 26, 2011, 1:14:49 PM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib uri="/WEB-INF/TLD/taglib.tld" prefix="w" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<%@ taglib uri="/WEB-INF/TLD/elfcity" prefix="cityELF" %>
<%@ taglib uri="/WEB-INF/TLD/elfvenue" prefix="venueELF" %>
<%@ taglib uri="/WEB-INF/TLD/elfeventtype" prefix="eventtypeELF" %>
<%@page import="ticketbook.controller.EventController" %>
<%@page import="ticketbook.controller.HandlerController" %>
<%@page import="ticketbook.util.TicketBookConvert" %>
<c:set var="CONTEXT_PATH" value="<%=request.getContextPath()%>"></c:set>
<c:set var="lstCity" value='${cityELF:getInstanceValue()}'></c:set>
<c:set var="lstVenue" value='${venueELF:getAllVenue()}'></c:set>
<c:set var="lstEventType" value='${eventtypeELF:getInstanceValue()}'></c:set>
<script type="text/javascript" src="${CONTEXT_PATH}/Script/ticketbookfunction.js"></script>

<w:authorize_role pathTo="/WEB-INF/authorize.xml" request="${pageContext.request}" response="${pageContext.response}"></w:authorize_role>
<div style="width:640px;text-align: left">
    Choose <select>
        <option value="event">Event</option>
        <option value="ticket">Ticket</option>
    </select>
</div>
<form action="${CONTEXT_PATH}/AdminController" method="post" name="frmCreateEvent">
    <input type="hidden" name="<%=HandlerController.ACTIONTYPE_NAME%>" id="actionType"/>

    <table cellpadding="10px">
        <tr>
            <td  class="_title_form" align="left">Title</td>
            <td  align="left"><input type="text" id="txtTitle" name="<%=EventController.TITLE_CONTROL_NAME%>" value="<%=TicketBookConvert.castParameterRequestIsNull(request, EventController.TITLE_CONTROL_NAME, "")%>"/></td>
            <td class="_alert_error" id="txtAlertTitle"></td>
        </tr>
        <tr>
            <td class="_title_form" align="left">Artist</td>
            <td align="left"><input type="text" id="txtArtist" name="<%=EventController.ARTIST_CONTROL_NAME%>" value="<%=TicketBookConvert.castParameterRequestIsNull(request, EventController.ARTIST_CONTROL_NAME, "")%>"/></td>
            <td class="_alert_error" id="txtAlertArtist"></td>
        </tr>
        <tr>
            <td class="_title_form" align="left">Content</td>
            <td align="left"><textarea id="txtContent" rows="6" cols="20" name="<%=EventController.CONTENT_CONTROL_NAME%>"><%=TicketBookConvert.castParameterRequestIsNull(request, EventController.CONTENT_CONTROL_NAME, "")%></textarea></td>
            <td class="_alert_error" id="txtAlertContent"></td>
        </tr>
        <tr>
            <td class="_title_form" align="left">Image</td>
            <td align="left"><input type="file" id="txtImage" name="<%=EventController.IMAGE_CONTROL_NAME%>" value="<%=TicketBookConvert.castParameterRequestIsNull(request, EventController.IMAGE_CONTROL_NAME, "")%>"/></td>
            <td class="_alert_error" id="txtAlertImage"></td>
        </tr>
        <tr>
            <td class="_title_form" align="left">Event Type</td>
            <td align="left"><select name="<%=EventController.EVENTTYPE_CONTROL_NAME%>">
                    <c:forEach var="objEventType" items='${lstEventType}'>

                        <option value="${objEventType.ID}">${objEventType.name}</option>

                    </c:forEach>
                </select>
            </td>
        </tr>
        <tr>
            <td class="_title_form" align="left">City</td>
            <td align="left"><select name="<%=EventController.CITY_CONTROL_NAME%>">
                    <c:forEach var="objCity" items='${lstCity}'>

                        <option value="${objCity.ID}">${objCity.name}</option>

                    </c:forEach>
                </select></td>
        </tr>
        <tr>
            <td class="_title_form" align="left">Venue</td>
            <td align="left"><select name="<%=EventController.VENUE_CONTROL_NAME%>">
                    <c:forEach var="objVenue" items='${lstVenue}'>

                        <option value="${objVenue.ID}">${objVenue.name} | ${objVenue.address}</option>

                    </c:forEach>
                </select></td>
        </tr>
        <tr>
            <td colspan="2"><input type="button" value="Submit" onclick="createEvent()"/></td>
        </tr>
    </table>
</form>
<script type="text/javaScript">
       function createEvent(){
           if(validate()){
               document.getElementById("actionType").value="<%=HandlerController.ACTIONTYPE_VALUE_CREATE_EVENT%>";
               document.forms["frmCreateEvent"].submit();
           }
       }
       function validate(){
           var stt=true;
           var title=document.getElementById("txtTitle");
           var content=document.getElementById("txtContent");
           if(title.value==""||Validate.isAllSpace(title.value)){
               document.getElementById("txtAlertTitle").innerHTML="can't empty";
               stt=false;
           }else document.getElementById("txtAlertTitle").innerHTML="";

           if(content.value==""||Validate.isAllSpace(content.value)){
               document.getElementById("txtAlertContent").innerHTML="can't empty";
               stt=false;
           }else document.getElementById("txtAlertContent").innerHTML="";


           return stt;
       }
</script>