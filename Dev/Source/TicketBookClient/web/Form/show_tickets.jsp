<%-- 
    Document   : show_tickets
    Created on : Jul 14, 2011, 7:58:08 PM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="/WEB-INF/TLD/elfstring" prefix="stringELF" %>
<%@ taglib uri="/WEB-INF/TLD/elfticketbook" prefix="ticketbookELF" %>
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
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Events</title>
        <link rel='stylesheet' href='<%=request.getContextPath()%>/Style/layout.css'/>
        <link rel='stylesheet' href='<%=request.getContextPath()%>/Style/tag_def.css'/>
        <link rel='stylesheet' href='<%=request.getContextPath()%>/Style/component.css'/>
    </head>
    <body onload="loadFocus();">
<c:set var="ROLEID_SESSION" value='<%=TicketBookConvert.castSessionIsNull(request.getSession(),TicketBookSession.ROLEID_USER_LOGIN,new Integer(0))%>'/>
<c:set var="ID_FALSE_INTEGER" value='<%=Constant.ID_FALSE_INTETER%>'/>
<% TicketBookParameter systemParam=new TicketBookParameter();%>
<c:set var="SYSTEM_PARAM" value='<%=systemParam%>'/>

<jsp:include page="../Block/block1.jsp"/>
<%
    int indexCity=-1;
    Integer cityID=new Integer(0);
    ArrayList lstCity=City.getInstanceValue();
    
%>
<c:set var="lengthCityItem" value='<%=lstCity.size()%>'></c:set>
<c:if test="${param.indexCity ne ''}">
<c:if test="${ stringELF:validatePositiveNumber(param.indexCity) eq 1 and lengthCityItem ge param.indexCity and param.indexCity ge 0}">
    <% indexCity=Integer.parseInt(request.getParameter("indexCity"));%>
    <%cityID=((CityRemote)lstCity.get(indexCity)).getID();%>
</c:if>
</c:if>
<div style="width:640px;text-align: right">
    Choose City: <select id="selCity" onchange="changeCity()">
    <% int countCity=0; %>
    <option value="-1">--All--</option>
    <c:forEach var="objCity" items='<%=lstCity%>'>
        <c:set var="countCity" value='<%=countCity%>'></c:set>
         <c:set var="selected" value=''></c:set>
        <c:if test="${param.indexCity eq countCity}">
            <c:set var="selected" value='selected'></c:set>
        </c:if>
        
        <option value="<%=countCity%>" ${selected}>${objCity.name}</option>
        <% countCity++;%>
    </c:forEach>
</select>
</div>

<c:if test="${ stringELF:validatePositiveNumber(param.index) eq 1}">
    <c:set var="lengthEventType" value='<%=EventType.getInstanceValue().size()%>'></c:set>

    <c:if test="${param.index<lengthEventType}">
        <% EventTypeRemote eventType=((EventTypeRemote)EventType.getInstanceValue().get(Integer.parseInt(request.getParameter("index"))));%>
        <% Integer eventTypeID= eventType.getID();%>
        <font class="_content_title"><%=eventType.getName()%> Events</font>
        <c:set var="TOTAL_RECORD_SHOW" value='${SYSTEM_PARAM.recordNumberNeedShow}'></c:set>
        <c:set var="TOTAL_PAGE_SHOW" value='${SYSTEM_PARAM.pageNumberNeedShow}'></c:set>
        <% Integer indexPage=new Integer(0);%>
     
        <c:if test="${param.pindex ne '' and  stringELF:validatePositiveNumber(param.pindex) eq 1}">
           <% indexPage=new Integer(Integer.parseInt(TicketBookConvert.castParameterRequestIsNull(request, "pindex","0")));%>
        </c:if>
        <c:set var="indexPage" value='<%=indexPage%>'></c:set>
        <% ArrayList tickets=Ticket.getTicketsByEventTypeID(eventTypeID,cityID,indexPage,new Integer(systemParam.getRecordNumberNeedShow())); %>
        <c:set var="tickets" value='<%=tickets%>'></c:set>
        <c:set var="sizeTicketFind" value='<%=tickets.size()%>'></c:set>
        <% Integer totalRecord=new Integer(0);%>
        <c:if test="${sizeTicketFind gt 0}">
            <% totalRecord=((TicketRemote)tickets.get(0)).countByEventTypeID(eventTypeID,cityID);%>
        </c:if>
        <c:set var="totalRecord" value="<%=totalRecord%>"></c:set>

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
                                        <input onclick="location.href='<%=request.getContextPath()%>/Form/show_tickets.jsp?sttView=Old&index=${param.index}&pindex=${param.pindex}&indexCity=${param.indexCity}&stt=more&view=<%=count%>';" value="Book" type="button"/>
                                        <c:if test="${param.sttView eq 'Old'}">
                                            <font color="red">Ticket is not available, you can view reference</font>
                                        </c:if>
                                    </c:if>
                               </c:if>

                            </td>
                        </tr>
                    </table>

                    
                    <c:if test="${index_row ne param.view or (index_row eq param.view and param.stt eq 'close')}">
                        <div style="float:right"><a href="<%=request.getContextPath()%>/Form/show_tickets.jsp?index=${param.index}&view=<%=count%>&stt=more&pindex=${param.pindex}&indexCity=${param.indexCity}">More...</a></div>
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
                        <c:if test="${ROLEID_SESSION ne ID_FALSE_INTEGER and param.sttView eq 'Old' and obj.viewStatus ne 'New'}">
                            <div style="font-weight:bold;color:red">Reference:</div>
                            <div style="border-style: inset;border-width: 1px">
                                    <c:set var="referenceTickets" value="${ticketbookELF:getAvailableReferenceTicketByTitle(obj.title)}"></c:set>
                                    <c:forEach items="${referenceTickets}" var="objReferenceTicket">
                                        <c:if test="${obj.ID ne objReferenceTicket.ID and obj.eventTypeID eq objReferenceTicket.eventTypeID}">
                                           <div style="padding-left:20px;padding-right:20px">

                                               <c:if test="${objReferenceTicket.viewStatus eq 'New'}">
                                                   <a onclick="submitFormBack('/Form/Booking/ticket_book.jsp')" style="cursor:pointer" >${objReferenceTicket.cityName} City, ${objReferenceTicket.venueName} Theatre ,${objReferenceTicket.venueAddress} Street </a> <font color="red" style="font-style: italic">${objReferenceTicket.viewStatus}</font>
                                               </c:if>
                                               <c:if test="${objReferenceTicket.viewStatus ne 'New'}">
                                                   <a>${objReferenceTicket.cityName} City, ${objReferenceTicket.venueName} Theatre ,${objReferenceTicket.venueAddress} Street </a> <font color="red" style="font-style: italic">Release</font>
                                               </c:if>
                                           </div>
                                       </c:if>
                                    </c:forEach>
                            </div>
                        </c:if>
                        <div style="float:right"><a  href="<%=request.getContextPath()%>/Form/show_tickets.jsp?index=${param.index}&view=<%=count%>&stt=close&pindex=${param.pindex}&indexCity=${param.indexCity}">Close</a></div>
                        
                    </div>
               </c:if>
                         <c:if test="${index_row eq param.view}">
                            <input type="text" readonly="readOnly" style="border:none;background-color:inherit" id="txtFocus"/>
                        </c:if>
            </div>
                <% count++; %>
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
                location.href=("<%=request.getContextPath()%>"+"/Form/show_tickets.jsp?index=<%=request.getParameter("index")%>&indexCity="+valueCity);
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
