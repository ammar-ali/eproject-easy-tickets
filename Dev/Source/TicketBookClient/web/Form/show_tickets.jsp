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
<%@page import="ticketbook.util.TicketBookSession"%>
<%@page import="ticketbook.model.Ticket"%>
<%@page import="java.util.ArrayList"%>
<%@page import="ticketbook.ejb.bmp.EventTypeRemote"%>
<%@page import="ticketbook.util.TicketBookParameter"%>
<%@page import="ticketbook.controller.FormBackController"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<%@ page import="ticketbook.util.Constant"%>
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
    <body onload="loadFocus();">
<c:set var="ROLEID_SESSION" value='<%=TicketBookConvert.castSessionIsNull(request.getSession(),TicketBookSession.ROLEID_USER_LOGIN,new Integer(0))%>'/>
<c:set var="ID_FALSE_INTEGER" value='<%=Constant.ID_FALSE_INTETER%>'/>
<c:set var="SYSTEM_PARAM" value='<%=new TicketBookParameter()%>'/>

<jsp:include page="../Block/block1.jsp"/>

<c:if test="${ stringELF:validatePositiveNumber(param.index) eq 1}">
    <c:set var="lengthEventType" value='<%=EventType.getInstanceValue().size()%>'></c:set>
    <c:set var="eventType" value='<%=((EventTypeRemote)EventType.getInstanceValue().get(Integer.parseInt(request.getParameter("index"))))%>'></c:set>
    <c:if test="${param.index<lengthEventType}">
        <font class="_content_title">${eventType.name} Events</font>

        <c:set var="eventTypeID" value='${eventType.ID}'></c:set>
        <c:set var="tickets" value='${ticketbookELF:getTicketsByEventTypeID(eventTypeID,1,20)}'></c:set>
        <% int count=1; %>
        <c:forEach var="obj" items="${tickets}">
            <div class="_block_event_item">
                <c:set var="index_row" value='<%=count%>'></c:set>
                <div class="_block_event_item_image">
                    
                        <c:if test="${obj.image ne '' and obj.image ne null}">
                            <img src="<%=request.getContextPath()%>${SYSTEM_PARAM.pathImageEvent}/${obj.image}" alt="image${obj.ID}"/>
                        </c:if>
                        <c:if test="${obj.image eq null or obj.image eq ''}">
                            <img src="<%=request.getContextPath()%>/Images/error_image.jpg" width="150px" alt="image${obj.ID}"/>
                        </c:if>
                   
                </div>
                <div class="_block_event_item_detail">
                    
                    <table width="480px">
                        <tr>
                        <td colspan="2"><font style="font-size:14px;font-weight:bold;color:#176c9c">${obj.title}</font></td>
                        </tr>
                        <tr>
                        <td style="font-weight:bold">Price</td><td>:</td><td style="width:360px"> ${ticketbookELF:filterTicketBookMoney(obj.price)} USD</td>
                        </tr>
                        <tr>
                        <td style="font-weight:bold">Release Date</td><td>:</td><td style="width:360px">${ticketbookELF:filterTicketBookDate(obj.viewDate)}</td>
                        </tr>
                        <tr>
                        <td style="font-weight:bold">Time</td><td>:</td><td style="width:360px">${obj.viewTime}</td>
                        </tr>
                        <tr>
                            <td style="font-weight:bold">Address</td><td>:</td><td style="width:360px">${obj.cityName} City, ${obj.venueName} Theatre ,${obj.venueAddress} Street</td>
                        </tr>
                        <tr>
                            <td colspan="3">

                                <c:if test="${ROLEID_SESSION eq ID_FALSE_INTEGER}">
                                    
                                    <a onclick="submitFormBack('/Form/login.jsp')" style="cursor:pointer" >[You must be registered and logged in to book the ticket.]</a>
                                </c:if>

                                <c:if test="${ROLEID_SESSION ne ID_FALSE_INTEGER}">
                                  
                                    <input onclick="submitFormBack('/Form/Booking/ticket_book.jsp')" type="button" onclick="submitFormBack()"  value="Book"/>
                                </c:if>

                            </td>
                        </tr>
                    </table>

                    
                    <c:if test="${index_row ne param.view or (index_row eq param.view and param.stt eq 'close')}">
                        <div style="float:right"><a href="<%=request.getContextPath()%>/Form/show_tickets.jsp?index=${param.index}&view=<%=count%>&stt=more">More...</a></div>
                    </c:if>
                </div>

                <c:if test="${index_row eq param.view and param.stt eq 'more'}">
 
                    <div style="width:600px;padding-left:60px;padding-right:20px">
                        <div><b>Artist</b>: ${obj.artist}</div>
                        <div style="font-weight:bold">Introduction:</div>
                        <div style="padding-left:20px;padding-right:20px">${obj.content}</div>
                        <c:if test="${obj.promotion ne '' and obj.promotion ne null}">
                            <div style="color:green;"><b>Promotion</b>: <font>${obj.promotion}</font></div>
                        </c:if>
                        <c:if test="${obj.discount ne '' and obj.discount ne null and obj.discount ne 0}">
                            <div style="color:green;padding-left:20px;padding-right:20px"><b>Discount</b>: <font>${obj.discount}</font></div>
                        </c:if>
                       
                        <div style="float:right"><a  href="<%=request.getContextPath()%>/Form/show_tickets.jsp?index=${param.index}&view=<%=count%>&stt=close">Close</a></div>
                        
                    </div>
               </c:if>
                         <c:if test="${index_row eq param.view}">
                            <input type="text" readonly="readOnly" style="border:none;background-color:inherit" id="txtFocus"/>
                        </c:if>
            </div>
                <% count++; %>
        </c:forEach>

        <script type="text/javascript">
            function loadFocus(){
                var obj=document.getElementById("txtFocus");
                if(obj!=null){
                    obj.focus();
                    obj.style.visibility="hidden";
                }
            }

            function submitFormBack(pathTo){
                document.getElementById("txtPathBack").value=window.location;
                document.getElementById("txtPathTo").value=pathTo;
                document.forms["frmFormBack"].submit();
            }
        </script>

        <form name="frmFormBack" action="<%=request.getContextPath()%>/FormBackController" method="post">
            <input type="hidden" value="" name="<%=FormBackController.PATH_BACK_CONTROL_NAME%>" id="txtPathBack"/>
            <input type="hidden" id="txtPathTo" value="" name="<%=FormBackController.PATH_TO_CONTROL_NAME%>"/>
        </form>
    </c:if>
</c:if>
<jsp:include page="../Block/block2.jsp"/>
    </body>
</html>
