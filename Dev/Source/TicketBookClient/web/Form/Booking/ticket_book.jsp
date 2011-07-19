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
<%@ taglib uri="/WEB-INF/TLD/elfticketbook" prefix="ticketbookELF" %>
<%@ taglib uri="/WEB-INF/TLD/elfstring" prefix="stringELF" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Booking</title>
        <link rel='stylesheet' href='<%=request.getContextPath()%>/Style/layout.css'/>
        <link rel='stylesheet' href='<%=request.getContextPath()%>/Style/tag_def.css'/>
        <link rel='stylesheet' href='<%=request.getContextPath()%>/Style/component.css'/>
        <script type="text/javascript" src="<%=request.getContextPath()%>/Script/ticketbookfunction.js"></script>

    </head>

<jsp:include page="../../Block/block1.jsp"/>
<c:if test="${param.ticketID ne null and param.ticketID ne 0}">
    <form action="" method="post">
    <c:set var="objTicket" value="${ticketbookELF:getTicketByID(param.ticketID)}"></c:set>
    <c:set var="paymentTypes" value='<%=PaymentType.getInstanceValue()%>'></c:set>

    <font class="_content_title">Booking</font>
    <br/>
    <table width="600px" cellpadding="10px" style="margin-left: 150px">
        <tr>
            <td class="_title_form" width="100px">Ticket Total</td>
            <td width="100px"><input style="width:100px" id="txtTicketTotal" type="text" value="1"></td>
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
                 <input type="hidden" value="${price}" id="txtPrice"/>
            </td>
            <td></td>
        </tr>
        <tr>
            <td class="_title_form">Discount</td>
            <td> <c:set var="discount"   value="${objTicket.discount}"></c:set>
                <c:if test="${discount ne '' and discount ne null }">
                    <c:set var="discount" value="${ticketbookELF:filterTicketBookMoney(objTicket.discount)}"></c:set>
                    <input type="hidden" value="${discount}" id="txtDiscount"/>
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
            <td><select>
                    <c:forEach items="${paymentTypes}" var="objPaymentType">
                        <option value="${objPaymentType.ID}">${objPaymentType.name}</option>
                    </c:forEach>
                </select></td>
            <td></td>
        </tr>
        <tr>
            <td class="_title_form">Card Number</td>
            <td><input style="width:100px" type="text" id="txtCardNumber"></td>
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
