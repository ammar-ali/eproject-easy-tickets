<%--
    Document   : show_tickets
    Created on : Jul 14, 2011, 7:58:08 PM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="/WEB-INF/TLD/elfstring" prefix="stringELF" %>
<%@ taglib uri="/WEB-INF/TLD/elfticketbook" prefix="ticketbookELF" %>

<%@page import="ticketbook.model.Ticket"%>
<%@page import="java.util.ArrayList"%>
<%@page import="ticketbook.model.PaymentType"%>
<%@page import="ticketbook.controller.BookingController"%>
<%@page import="ticketbook.controller.TicketController"%>
<%@page import="ticketbook.controller.HandlerController"%>
<%@page import="ticketbook.util.TicketBookConvert"%>
<%@ taglib uri="/WEB-INF/TLD/elfticketbook" prefix="ticketbookELF" %>
<%@ taglib uri="/WEB-INF/TLD/elfpayment" prefix="paymentELF" %>
<%@ taglib uri="/WEB-INF/TLD/elfticket" prefix="ticketELF" %>
<%@ taglib uri="/WEB-INF/TLD/elfstring" prefix="stringELF" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<c:set var="CONTEXT_PATH" value='<%=request.getContextPath()%>'></c:set>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Booking</title>
        <link rel='stylesheet' href='${CONTEXT_PATH}/Style/layout.css'/>
        <link rel='stylesheet' href='${CONTEXT_PATH}/Style/tag_def.css'/>
        <link rel='stylesheet' href='${CONTEXT_PATH}/Style/component.css'/>
        <script type="text/javascript" src="${CONTEXT_PATH}/Script/ticketbookfunction.js"></script>

    </head>

<jsp:include page="../../Block/block1.jsp"/>

<c:if test="${param.ticketID ne null and param.ticketID ne 0}">

    <form action="${CONTEXT_PATH}/BookingController" method="post" name="frmBooking">
    <c:set var="objTicket" value="${ticketELF:getTicketByID(param.ticketID)}"></c:set>
    <c:set var="paymentTypes" value='${paymentELF:getInstanceValue()}'></c:set>
    <c:set var="TICKET_TOTAL_CONTROL_NAME" value='<%=TicketController.TICKET_TOTAL_CONTROL_NAME%>'></c:set>
    <c:set var="CARD_NUMBER_CONTROL_NAME" value='<%=TicketController.CARD_NUMBER_CONTROL_NAME%>'></c:set>
    <c:set var="PAYMENTTYPE_CONTROL_NAME" value='<%=TicketController.PAYMENTTYPE_CONTROL_NAME%>'></c:set>
  <c:set var="TICKETID_CONTROL_NAME" value='<%=TicketController.TICKETID_CONTROL_NAME%>'></c:set>
  <c:set var="TICKET_PRICE_CONTROL_NAME" value='<%=TicketController.TICKET_PRICE_CONTROL_NAME%>'></c:set>
  <c:set var="ACTIONTYPE_NAME" value='<%=HandlerController.ACTIONTYPE_NAME%>'></c:set>
  <c:set var="TICKET_DISCOUNT_CONTROL_NAME" value='<%=TicketController.TICKET_DISCOUNT_CONTROL_NAME%>'></c:set>

    <input type="hidden" name="${TICKETID_CONTROL_NAME}" value="${param.ticketID}" id="txtTicketID">
    <input type="hidden" name="${ACTIONTYPE_NAME}" id="actionType" value=""/>
            
    <font class="_content_title">Booking</font>
    <br/>
    <div class="_div_alert">
        <c:set var="alert" value="${ticketbookELF:castAttributeRequestIsNull(request,'error_ticket','')}"></c:set>
        <c:if test="${alert eq '1'}">
            Sorry ! Ticket is not available, please choose other tickets
        </c:if>
    </div>
    <table width="600px" cellpadding="10px" style="margin-left: 200px">
        <tr>
            <td class="_title_form" width="100px">Ticket Total</td>
            <td width="100px"><input style="width:100px" id="txtTicketTotal" type="text" value="${ticketbookELF:castParameterRequestIsNull(pageContext.request,TICKET_TOTAL_CONTROL_NAME,'1')}" name="${TICKET_TOTAL_CONTROL_NAME}" /></td>
            <td width="200px"><input onclick="checkPrice()" type="button" value="Check price"</td>
        </tr>
        <tr>
            <td colspan="2" align="right" class="_alert_error" id="alertTicketTotal"></td>
        </tr>
        <tr>
            <td colspan="2" style="font-size: 14px;color:#176c9c;font-weight: bold;border-style: inset;border-top: black;border-left: black;border-right: black;border-width: 1px">Payment Detail</td>
        </tr>
        <tr>
            <td class="_title_form">Price</td>
            <td>
                <c:set var="price"   value="${ticketbookELF:filterTicketBookMoney(objTicket.price)}"></c:set>
                 ${price} USD
                 <input type="hidden" value="${price}" id="txtPrice" name="${TICKET_PRICE_CONTROL_NAME}"/>
            </td>
            <td></td>
        </tr>
        <tr>
            <td class="_title_form">Discount</td>
            <td> <c:set var="discount"   value="${objTicket.discount}"></c:set>
                <c:if test="${discount ne '' and discount ne null }">
                    <c:set var="discount" value="${ticketbookELF:filterTicketBookMoney(objTicket.discount)}"></c:set>
                    ${discount} 
                    <input type="hidden" value="${discount}" id="txtDiscount" name="${TICKET_DISCOUNT_CONTROL_NAME}"/>
                </c:if>
                <c:if test="${discount eq '' or discount eq null }">
                    0
                    <c:set var="discount" value="${0}"></c:set>
                    <input type="hidden" value="0" id="txtDiscount"/>
                </c:if>
            USD</td>
            <td></td>
        </tr>
        <tr>
            <td class="_title_form">Price Total</td>
            <td><font id="ftPriceTotal">${stringELF:parseInt(price)-stringELF:parseInt(discount)} USD</font></td>
            <td></td>
        </tr>
        <tr>
            <td class="_title_form">Payment Type</td>
            <td><select name="<%=TicketController.PAYMENTTYPE_CONTROL_NAME%>">
                    <c:set var="selPaymentTypeChoose" value="${ticketbookELF:castParameterRequestIsNull(pageContext.request,PAYMENTTYPE_CONTROL_NAME,'')}"></c:set>
                    <c:forEach items="${paymentTypes}" var="objPaymentType">
                        <c:set var="selected" value=""></c:set>
                        <c:if test="${selPaymentTypeChoose eq objPaymentType.ID}">
                            <c:set var="selected" value="selected"></c:set>
                        </c:if>
                        <option value="${objPaymentType.ID}" ${selected}>${objPaymentType.name}</option>
                    </c:forEach>
                </select></td>
            <td></td>
        </tr>
        <tr>
            <td class="_title_form">Card Number</td>
            <td><input style="width:100px" type="text" id="txtCardNumber" value="${ticketbookELF:castParameterRequestIsNull(pageContext.request,CARD_NUMBER_CONTROL_NAME,'')}" name="${CARD_NUMBER_CONTROL_NAME}"></td>
            <td></td>
        </tr>
        <tr>
            <td  colspan="2" class="_alert_error" align="right" id="alertCardNumber"></td>
        </tr>
        <tr>
            <td colspan="2" style="border-style: inset;border-top: black;border-left: black;border-right: black;border-width: 1px"></td>
        <tr>
            <td colspan="2" align="right"><input type="button" value="Submit" onclick="submitBooking()"/></td>
        </tr>
        
    </table>

    </form>
</c:if>
    <script type="text/javascript">
        
        function checkPrice(){
            var tickettotal=document.getElementById("txtTicketTotal");
            if(tickettotal.value != ""){
                if(Validate.isNumber(tickettotal.value)){
                   if(tickettotal.value != "0"){
                       document.getElementById("alertTicketTotal").innerHTML="";
                       var price=parseInt(document.getElementById("txtPrice").value,"10");
                       var discount=parseInt(document.getElementById("txtDiscount").value,"10");
                       var ticketnumber=parseInt(tickettotal.value,"10");
                       var result=(price-discount)*ticketnumber;
                       document.getElementById("ftPriceTotal").innerHTML=result+"USD";
            
                       return true;
                   }
                   else document.getElementById("alertTicketTotal").innerHTML="You have entered ticket number";
                }
                else{
                    document.getElementById("alertTicketTotal").innerHTML="You have entered ticket number";
                }
            }
            else{
                document.getElementById("alertTicketTotal").innerHTML="You have entered ticket number";
                document.getElementById("txtTicketTotal").value="1";
                document.getElementById("ftPriceTotal").innerHTML=document.getElementById("txtPrice").value+" USD";
            }
            return false;
        }

        function submitBooking(){
            var stt=true;
            stt=checkPrice();
            if(stt){
                var cardNumber=document.getElementById("txtCardNumber").value;
                if(Validate.isNumber(cardNumber)&&cardNumber!=""){
                    document.getElementById("alertCardNumber").innerHTML="";
                    document.getElementById("actionType").value="<%=HandlerController.ACTIONTYPE_VALUE_BOOKING%>";
                    document.forms["frmBooking"].submit();
                }
                else{
                    document.getElementById("alertCardNumber").innerHTML="Card number must to be number";
                }
            }
        }
        
    </script>
<jsp:include page="../../Block/block2.jsp"/>
    </body>
</html>
