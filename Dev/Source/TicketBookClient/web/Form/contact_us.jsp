<%--
   Document   : index
    Created on : Jul 8, 2011, 3:16:48 PM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<%@ taglib uri="/WEB-INF/TLD/elfticketbook" prefix="ticketbookELF" %>
<%@page import="ticketbook.controller.ContactController" %>
<%@page import="ticketbook.controller.HandlerController" %>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Contact Us</title>
        <c:set var="CONTEXT_PATH" value='<%=request.getContextPath()%>'></c:set>
        <link rel='stylesheet' href='${CONTEXT_PATH}/Style/layout.css'/>
        <link rel='stylesheet' href='${CONTEXT_PATH}/Style/tag_def.css'/>
        <link rel='stylesheet' href='${CONTEXT_PATH}/Style/component.css'/>
        <script type="text/javascript" src="${CONTEXT_PATH}/Script/ticketbookfunction.js"></script>
    </head>
    <body>
        <form action="${CONTEXT_PATH}/FormController" name="frmContact" method="post">
            <input type="hidden" id="actionType" name="<%= HandlerController.ACTIONTYPE_NAME%>"/>
            <jsp:include page="../Block/block1.jsp"/>
            <font class="_content_title">Contact us</font>
            <c:set var="MESSAGE" value="${ticketbookELF:castAttributeRequestIsNull(pageContext.request,'message','')}"></c:set>
            <c:set var="TITLE_CONTROL_NAME" value='<%=ContactController.TITLE_CONTACT_CONTROL_NAME%>'></c:set>
            <c:set var="CONTENT_CONTROL_NAME" value='<%= ContactController.CONTENT_CONTACT_CONTROL_NAME%>'></c:set>
            <c:set var="EMAIL_CONTROL_NAME" value='<%= ContactController.EMAIL_CONTACT_CONTROL_NAME%>'></c:set>
            <c:if test="${MESSAGE eq 1}">
                <c:set var="alertContact" value= "<div class='_div_alert_msg'>You have already sent a contact.</div>"></c:set>
            </c:if>
            <c:if test="${MESSAGE eq 0}">
                <c:set var="alertContact" value="<div class='_div_alert'>Error occured! This contact wasn't sent.</div>"></c:set>

                <c:set var="txtTitle" value="${ticketbookELF:castParameterRequestIsNull(pageContext.request,TITLE_CONTROL_NAME,'')}"></c:set>
                <c:set var="txtContent" value="${ticketbookELF:castParameterRequestIsNull(pageContext.request,CONTENT_CONTROL_NAME,'')}"></c:set>
                <c:set var="txtEmail" value="${ticketbookELF:castParameterRequestIsNull(pageContext.request,EMAIL_CONTROL_NAME,'')}"></c:set>
            </c:if>
${alertContact}
            <center>
                <table width="700px" cellpadding="10px">
                    <tr>
                        <td class="_title_form" width="150px" >Title</td>
                        <td width="300px"><input type="text" value="${txtTitle}" name="${TITLE_CONTROL_NAME}" maxlength="200" style="width: 300px" id="txtTitle" /></td>
                        <td id="alertTitle" class="_alert_error" width="200px"></td>
                    </tr>
                    <tr>
                        <td class="_title_form" valign="top" >Content</td>
                        <td><textarea id="txtContent" cols="35" name="${CONTENT_CONTROL_NAME}" rows="8">${txtContent}</textarea></td>
                        <td id="alertContent" class="_alert_error"></td>
                    </tr>
                    <tr>
                        <td class="_title_form">Email</td>
                        <td><input type="text" maxlength="200" value="${txtEmail}" name="${EMAIL_CONTROL_NAME}" id="txtEmail" style="width: 300px"/></td>
                        <td id="alertEmail" class="_alert_error"></td>
                    </tr>
                    <tr align="center">
                        <td align="center"></td><td align="left"><input type="button" value="Submit" onclick="submitForm()"/> <input type="reset" value="Reset"/></td>
                    </tr>
                </table>
            </center>
        </form>
        <jsp:include page="../Block/block2.jsp"/>
        <script type="text/javascript">
            function validate(){
                var status = true;
                var objTitle = document.getElementById("txtTitle");
                var objContent = document.getElementById("txtContent");
                var objEmail = document.getElementById("txtEmail");
                if(Validate.isAllSpace(objTitle.value)||objTitle.value==""){
                    document.getElementById("alertTitle").innerHTML="can't empty!!!";
                    status = false;
                }else{
                    document.getElementById("alertTitle").innerHTML="";
                }
                if(Validate.isAllSpace(objContent.value)||objContent.value==""){
                    document.getElementById("alertContent").innerHTML="can't empty!!!";
                    status = false;
                }else{
                    document.getElementById("alertContent").innerHTML="";
                }
                if(Validate.isAllSpace(objEmail.value)||objEmail.value==""){
                    document.getElementById("alertEmail").innerHTML="can't empty!!!";
                    status = false;
                }else{
                    document.getElementById("alertEmail").innerHTML="";
                }
                return status;
            }
            function submitForm(){
                if(validate()){
                    document.getElementById("actionType").value = "<%= HandlerController.ACTIONTYPE_VALUE_CREATE_CONTACT_MESSAGE%>" ;
                    document.forms["frmContact"].submit();
                }
            }
        </script>
    </body>
</html>	