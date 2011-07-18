<%--
   Document   : index
    Created on : Jul 8, 2011, 3:16:48 PM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="ticketbook.util.TicketBookConvert"%>
<%@page import="ticketbook.controller.UserController"%>
<%@page import="ticketbook.controller.FormController"%>
<%@page import="ticketbook.controller.HandlerController"%>

<%@page import="ticketbook.controller.FormBackController"%>

<%@page import="ticketbook.util.TicketBookContextPath"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login</title>
<link rel='stylesheet' href='<%=request.getContextPath()%>/Style/layout.css'/>
<link rel='stylesheet' href='<%=request.getContextPath()%>/Style/tag_def.css'/>
<link rel='stylesheet' href='<%=request.getContextPath()%>/Style/component.css'/>
<script type="text/javascript">
    function clickBtnSubmit(){
        if(validateLogin()){
		document.getElementById("actionType").value="<%=HandlerController.ACTIONTYPE_VALUE_LOGIN%>";
		document.forms["frmLogin"].submit();
        }
    }

    function validateLogin(){
   
        var stt=true;
        if(document.getElementById("txtUsername").value==""){
            document.getElementById("alertUsername").innerHTML=" can't empty";
            stt=false;
        }
        else document.getElementById("alertUsername").innerHTML="";
        if(document.getElementById("txtPassword").value==""){
            document.getElementById("alertPassword").innerHTML=" can't empty";
            stt=false;
        }
        else document.getElementById("alertPassword").innerHTML="";

        return stt;
    }
</script>
</head>
<body>

<jsp:include page="../Block/block1.jsp"/>
<font class="_content_title">Login</font>


<form method="post" action="<%=request.getContextPath()%>/UserController" name="frmLogin">

    <c:set var="alertLogin" value='<%=TicketBookConvert.castAttributeRequestIsNull(request,"alert_login","")%>'></c:set>
    <c:set var="txtUsername" value='<%=TicketBookConvert.castParameterRequestIsNull(request,UserController.USERNAME_CONTROL_NAME,"")%>'></c:set>
    <c:set var="txtPassword" value='<%=TicketBookConvert.castParameterRequestIsNull(request,UserController.PASSWORD_CONTROL_NAME,"")%>'></c:set>
   
    <br/>

    <!--ALERT LOGIN ERROR-->
        <div class="_div_alert">${alertLogin}</div>
    <!--------------------->

    <br/>
    <input type="hidden" name="<%=FormController.ACTIONTYPE_NAME%>" id="actionType"/>
    <table cellpadding="5px" width="430px" style="margin-left: 230px;float:left">
        <tr>
            <td class="_title_form" width="50px">Username</td>
            <td width="180px"><input class="_textbox" type="text" name="<%=UserController.USERNAME_CONTROL_NAME%>" id="txtUsername" value="${txtUsername}"/></td>
            <td width="180px" class="_alert_error" id="alertUsername"></td>
        </tr>
        <tr>
            <td class="_title_form" width="50px">Password</td>
            <td width="180px"><input class="_textbox" type="password" name="<%=UserController.PASSWORD_CONTROL_NAME%>" id="txtPassword" value="${txtPassword}"/></td>
            <td width="180px" class="_alert_error" id="alertPassword"></td>
        </tr>
        <tr>
            <td colspan="2" align="center"><input type="button" value="Submit" onclick="clickBtnSubmit()"/></td
            <td></td>
        </tr>
    </table>
</form>

<jsp:include page="../Block/block2.jsp"/>
</body>
</html>	