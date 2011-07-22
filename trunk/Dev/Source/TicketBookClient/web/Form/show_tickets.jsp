<%-- 
    Document   : show_tickets
    Created on : Jul 14, 2011, 7:58:08 PM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="/WEB-INF/TLD/elfstring" prefix="stringELF" %>
<%@ taglib uri="/WEB-INF/TLD/elfticketbook" prefix="ticketbookELF" %>
<%@ taglib uri="/WEB-INF/TLD/elfticket" prefix="ticketELF" %>
<%@ taglib uri="/WEB-INF/TLD/elfcity" prefix="cityELF" %>
<%@ taglib uri="/WEB-INF/TLD/elfeventtype" prefix="eventtypeELF" %>
<%@ taglib uri="/WEB-INF/TLD/taglib.tld" prefix="w" %>
<%@page import="ticketbook.model.EventType"%>
<%@page import="ticketbook.transfer.EventTypeTransferData"%>
<%@page import="ticketbook.util.TicketBookConvert"%>
<%@page import="ticketbook.util.TicketBookSession"%>
<%@page import="ticketbook.model.Ticket"%>
<%@page import="java.util.ArrayList"%>
<%@page import="ticketbook.ejb.bmp.EventTypeRemote"%>
<%@page import="ticketbook.util.TicketBookParameter"%>
<%@page import="ticketbook.controller.FormBackController"%>
<%@page import="ticketbook.ejb.bmp.TicketRemote"%>
<%@page import="ticketbook.model.City"%>
<%@page import="ticketbook.ejb.bmp.CityRemote"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<%@ page import="ticketbook.util.Constant"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <c:set var="CONTEXT_PATH" value='<%=request.getContextPath()%>'></c:set>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Events</title>
        <link rel='stylesheet' href='${CONTEXT_PATH}/Style/layout.css'/>
        <link rel='stylesheet' href='${CONTEXT_PATH}/Style/tag_def.css'/>
        <link rel='stylesheet' href='${CONTEXT_PATH}/Style/component.css'/>
    </head>
    <body onload="loadFocus();">


<jsp:include page="../Block/block1.jsp"/>

<c:set var="TICKETBOOK_SESSION" value='<%=request.getSession()%>'></c:set>
<c:set var="ROLEID_USER_LOGIN_SESSION_NAME" value='<%=TicketBookSession.ROLEID_USER_LOGIN%>'></c:set>
<c:set var="ID_FALSE_INTEGER" value='<%=Constant.ID_FALSE_INTETER%>'/>
<c:set var="eventTypes" value='${eventtypeELF:getInstanceValue()}'></c:set>

<c:set var="SYSTEM_PARAM" value='${ticketbookELF:getSystemParameter()}'/>
<c:set var="ROLEID_SESSION" value='${ticketbookELF:castSessionIsNull(TICKETBOOK_SESSION,ROLEID_USER_LOGIN_SESSION_NAME,0)}'/>

<c:set var="lstCity" value='${cityELF:getInstanceValue()}'></c:set>
<c:set var="lengthCityItem" value='${stringELF:getSizeOfArrayList(lstCity)}'></c:set>

<c:set var="indexCity" value="-1"></c:set>
<c:set var="cityID" value="0"></c:set>


<c:if test="${param.indexCity ne ''}">
    <c:if test="${ stringELF:validatePositiveNumber(param.indexCity) eq 1 and lengthCityItem ge param.indexCity and param.indexCity ge 0}">
        <c:set var="indexCity" value='${stringELF:parseInt(param.indexCity)}'></c:set>
        <c:set var="cityID" value="${cityELF:getIDByIndex(indexCity)}"></c:set>
    </c:if>
</c:if>

<div style="width:640px;text-align: right">
    Choose City: <select id="selCity" onchange="changeCity()">
    <c:set var="countCity" value="0" ></c:set>
    <option value="-1">--All--</option>
    <c:forEach var="objCity" items='${lstCity}'>
        <c:set var="countCity" value='${countCity}'></c:set>
         <c:set var="selected" value=''></c:set>
        <c:if test="${param.indexCity eq countCity}">
            <c:set var="selected" value='selected'></c:set>
        </c:if>
        
        <option value="${countCity}" ${selected}>${objCity.name}</option>
         <c:set var="countCity" value='${countCity+1}'></c:set>
    </c:forEach>
</select>
</div>

<c:if test="${ stringELF:validatePositiveNumber(param.index) eq 1}">
    
    <c:set var="lengthEventType" value='${stringELF:getSizeOfArrayList(eventTypes)}'></c:set>

    <c:if test="${param.index<lengthEventType}">
        
        <c:set var="eventType" value="${eventtypeELF:getEventTypeRemoteByIndex(param.index)}"></c:set>
        <c:set var="eventTypeID" value="${eventType.ID}"></c:set>

        <font class="_content_title">${eventType.name} Events</font>
        <c:set var="TOTAL_RECORD_SHOW" value='${SYSTEM_PARAM.recordNumberNeedShow}'></c:set>
        <c:set var="TOTAL_PAGE_SHOW" value='${SYSTEM_PARAM.pageNumberNeedShow}'></c:set>
        
        <c:set var="indexPage" value="0"></c:set>
        <c:if test="${param.pindex ne '' and  stringELF:validatePositiveNumber(param.pindex) eq 1}">
            <c:set var="indexPage" value="${stringELF:parseInt(ticketbookELF:castParameterRequestIsNull(pageContext.request,'pindex','0'))}"></c:set>
        </c:if>
        <c:set var="indexPage" value='${indexPage}'></c:set>

        <c:set var="tickets" value='${ticketELF:getTicketsByEventTypeID(eventTypeID,cityID,indexPage,TOTAL_RECORD_SHOW)}'></c:set>
        <c:set var="sizeTicketFind" value='${stringELF:getSizeOfArrayList(tickets)}'></c:set>
        <c:set var="totalRecord" value="0"></c:set>

        <c:if test="${sizeTicketFind gt 0}">
            <c:set var="totalRecord" value="${ticketELF:countByEventTypeID(tickets,eventTypeID,cityID)}"></c:set>
        </c:if>
           <div style="width:inherit;text-align:right">
            <c:if test="${totalRecord gt TOTAL_RECORD_SHOW}">
                <w:paging pathName="show_tickets.jsp"
                          enableFirstPage="true"
                enableLastPage="true"
                enableIndexChoose="true"
                styleIndexChoose="color:blue"
                index="${indexPage}"
                totalRecord="${totalRecord}"
                numPageDivide="${TOTAL_PAGE_SHOW}"
                numRecordDivide="${TOTAL_RECORD_SHOW}"
                style="cursor:pointer"
                pageName="pindex">
                    <w:parameter name="index">${param.index}</w:parameter>
                    <w:parameter name="indexCity">${param.indexCity}</w:parameter>
                </w:paging>
            </c:if>
        </div>

 
        <c:set var="count" value="1"></c:set>
        <c:forEach var="obj" items="${tickets}">
            <div class="_block_event_item">
                <c:set var="index_row" value='${count}'></c:set>
                <div class="_block_event_item_image">
                    
                        <c:if test="${obj.image ne '' and obj.image ne null}">
                            <img src="${CONTEXT_PATH}${SYSTEM_PARAM.pathImageEvent}/${obj.image}" alt="image${obj.ID}"/>
                        </c:if>
                        <c:if test="${obj.image eq null or obj.image eq ''}">
                            <img src="${CONTEXT_PATH}/Images/error_image.jpg" width="150px" alt="image${obj.ID}"/>
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
                            <td></td>
                            <td colspan="2">

                                <c:if test="${ROLEID_SESSION eq ID_FALSE_INTEGER}">
                                    <a onclick="submitFormBack('/Form/login.jsp')" style="cursor:pointer" >[You must be registered and logged in to book the ticket.]</a>
                                </c:if>

                                <c:if test="${ROLEID_SESSION ne ID_FALSE_INTEGER}">
                                    <c:if test="${obj.viewStatus eq 'New'}">
                                        <input onclick="submitFormBack('/Form/Booking/ticket_book.jsp?ticketID=${obj.ID}')" type="button"  value="Book"/>
                                    </c:if>
                                    <c:if test="${obj.viewStatus ne 'New'}">
                                        <input onclick="location.href='${CONTEXT_PATH}/Form/show_tickets.jsp?sttView=Old&index=${param.index}&pindex=${param.pindex}&indexCity=${param.indexCity}&stt=more&view=${count}';" value="Book" type="button"/>
                                        <c:if test="${param.sttView eq 'Old'}">
                                            <font color="red">Ticket is not available, you can view reference</font>
                                        </c:if>
                                    </c:if>
                               </c:if>

                            </td>
                        </tr>
                    </table>

                    
                    <c:if test="${index_row ne param.view or (index_row eq param.view and param.stt eq 'close')}">
                        <div style="float:right"><a href="${CONTEXT_PATH}/Form/show_tickets.jsp?index=${param.index}&view=${count}&stt=more&pindex=${param.pindex}&indexCity=${param.indexCity}">More...</a></div>
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
                        <c:if test="${obj.discount ne '' and obj.discount ne '0' and obj.discount != null}">
                            <div style="color:green;"><b>Discount</b>: <font>${ticketbookELF:filterTicketBookMoney(obj.discount)} USD</font></div>
                        </c:if>
                        <c:if test="${ROLEID_SESSION ne ID_FALSE_INTEGER and param.sttView eq 'Old' and obj.viewStatus ne 'New'}">
                            <div style="font-weight:bold;color:red">Reference:</div>
                            <c:set var="TEMP_ROW_REFERENCE" value="0"></c:set>
                            <table style="border-style: inset;border-width: 1px;width:500px">
                                <tr style="font-weight:bold"><td width="200px">Time</td><td width="300px">Information</td></tr>
                                <c:set var="referenceTickets" value="${ticketELF:getAvailableReferenceTicketByEventID(obj.eventID)}"></c:set>
                                    <c:forEach items="${referenceTickets}" var="objReferenceTicket">
                                        
                                        <c:if test="${obj.ID ne objReferenceTicket.ID and obj.eventTypeID eq objReferenceTicket.eventTypeID}">
                                            <tr>
                                            <td style="padding-left:20px;padding-right:20px;border-width:1px;border-bottom: black;border-style: inset">
                                               <c:if test="${objReferenceTicket.viewStatus eq 'New'}">
                                                   <a onclick="submitFormBack('/Form/Booking/ticket_book.jsp?ticketID=${objReferenceTicket.ID}')" style="cursor:pointer" >Time: ${ticketbookELF:filterTicketBookDate(objReferenceTicket.viewDate)} ${objReferenceTicket.viewTime}</a> <font color="red" style="font-style: italic">${objReferenceTicket.viewStatus}</font>
                                               </c:if>
                                               <c:if test="${objReferenceTicket.viewStatus ne 'New'}">
                                                   <a>Time: ${ticketbookELF:filterTicketBookDate(objReferenceTicket.viewDate)} ${objReferenceTicket.viewTime} </a> <font color="red" style="font-style: italic"></font>
                                               </c:if>
                                           </td>
                                           <td style="border-width:1px;border-bottom: black;border-style: inset">
                                                <c:if test="${objReferenceTicket.promotion ne '' and objReferenceTicket.promotion ne null}">
                                                     <font style="color:green;"> <b style="color:green;">Promotion</b>: ${objReferenceTicket.promotion}</font><br/>
                                                </c:if>
                                                     
                                                <c:if test="${objReferenceTicket.discount ne '' and objReferenceTicket.discount ne '0' and objReferenceTicket.discount != null}">
                                                    <font style="color:green;"> <b style="color:green;">Discount</b>: ${ticketbookELF:filterTicketBookMoney(objReferenceTicket.discount)} USD</font>
                                                </c:if>
                                           </td>
                                           </tr>
                                           <c:set var="TEMP_ROW_REFERENCE" value="1"></c:set>
                                       </c:if>
                                    
                                    </c:forEach>
                                           <c:if test="${TEMP_ROW_REFERENCE eq 0}"><td colspan="2" align="center" style="color:red"> No data, please choose other sections </td></c:if>
                            </table>
                        </c:if>
                        <div style="float:right"><a  href="${CONTEXT_PATH}/Form/show_tickets.jsp?index=${param.index}&view=${count}&stt=close&pindex=${param.pindex}&indexCity=${param.indexCity}">Close</a></div>
                        
                    </div>
               </c:if>
                         <c:if test="${index_row eq param.view}">
                            <input type="text" readonly="readOnly" style="border:none;background-color:inherit" id="txtFocus"/>
                        </c:if>
            </div>
               <c:set var="count" value="${count+1}"></c:set>
        </c:forEach>


        <div style="width:inherit;text-align:right">
            <c:if test="${totalRecord gt TOTAL_RECORD_SHOW}">
                <w:paging pathName="show_tickets.jsp"
                          enableFirstPage="true"
                enableLastPage="true"
                enableIndexChoose="true"
                styleIndexChoose="color:blue"
                index="${indexPage}"
                totalRecord="${totalRecord}"
                numPageDivide="${TOTAL_PAGE_SHOW}"
                numRecordDivide="${TOTAL_RECORD_SHOW}"
                style="cursor:pointer"
                pageName="pindex">
                    <w:parameter name="index">${param.index}</w:parameter>
                    <w:parameter name="indexCity">${param.indexCity}</w:parameter>
                </w:paging>
            </c:if>
        </div>

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

            function changeCity(){
                var valueCity=document.getElementById("selCity").value;
                location.href=("${CONTEXT_PATH}"+"/Form/show_tickets.jsp?index=<%=request.getParameter("index")%>&indexCity="+valueCity);
            }

        </script>
        
        <form name="frmFormBack" action="${CONTEXT_PATH}/FormBackController" method="post">
            <input type="hidden" value="" name="<%=FormBackController.PATH_BACK_CONTROL_NAME%>" id="txtPathBack"/>
            <input type="hidden" id="txtPathTo" value="" name="<%=FormBackController.PATH_TO_CONTROL_NAME%>"/>
        </form>
    </c:if>
</c:if>
        
<jsp:include page="../Block/block2.jsp"/>
    </body>
</html>
