<%--
   Document   : index
    Created on : Jul 8, 2011, 3:16:48 PM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<%@page import="ticketbook.controller.UserController" %>
<%@page import="ticketbook.controller.FormController" %>
<%@page import="ticketbook.controller.HandlerController" %>
<%@page import="ticketbook.util.TicketBookConvert" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Register</title>
        <link rel='stylesheet' href='<%=request.getContextPath()%>/Style/layout.css'/>
        <link rel='stylesheet' href='<%=request.getContextPath()%>/Style/tag_def.css'/>
        <link rel='stylesheet' href='<%=request.getContextPath()%>/Style/component.css'/>

		<link rel="stylesheet" type="text/css" media="all" href="<%=request.getContextPath()%>/Style/calendar-blue.css"  />

                <script type="text/javascript" src="<%=request.getContextPath()%>/Script/jquery_min.js"></script>

		<script type="text/javascript" src="<%=request.getContextPath()%>/Script/jquery.dynDateTime.js"></script>
		<script type="text/javascript" src="<%=request.getContextPath()%>/Script/calendar-en.js"></script>

    </head>
    <body>

        <jsp:include page="../Block/block1.jsp"/>
        <font class="_content_title">Register</font>
         <c:set var="alertRegister" value='<%=request.getAttribute("alertRegister") %>'></c:set>
         <c:set var="alertRegisterBirth" value='<%=request.getAttribute("alertRegister_Birthday")%>'></c:set>
         <c:if test="${alertRegister ne null}">
                <font color='red'>${alertRegister}</font>
          </c:if>
           <c:if test="${alertRegisterBirth ne null}">
                <font color='red'>${alertRegisterBirth}</font>
          </c:if>
                 
        <br/>
        <form action="<%=request.getContextPath()%>/FormController" method="post" name="frmRegister">


            <input type="hidden" name="<%=FormController.ACTIONTYPE_NAME%>" id="actionType"/>

            <table cellspacing="4px" style="width:550px; float: left;margin-left:200px" >
                <tr>
                    <td style="text-align:left" width="150px" class="_title_form">Username</td>
                    <td width="150px"><input type="text" class="_textbox" id="txtUsername" name="<%=UserController.USERNAME_CONTROL_NAME%>" value="<%=TicketBookConvert.castParameterRequestIsNull(request, UserController.USERNAME_CONTROL_NAME,"")%>"/></td>
                    <td width="250px" class="_alert_error" id="txtAlertUsername"></td>
                </tr>
                <tr>
                    <td style="text-align:left"  class="_title_form">Password</td>
                    <td><input type="password" class="_textbox" id="txtPassword" name="<%=UserController.PASSWORD_CONTROL_NAME%>" value="<%=TicketBookConvert.castParameterRequestIsNull(request, UserController.PASSWORD_CONTROL_NAME,"")%>"/></td>
                    <td  class="_alert_error" id="txtAlertPassword"></td>
                </tr>
                <tr>
                    <td style="text-align:left"  class="_title_form">Re-Password</td>
                    <td ><input type="password" class="_textbox" id="txtRePassword"/></td>
                    <td class="_alert_error" id="txtAlertRePassword"></td>
                </tr>
                <tr>
                    <td style="text-align:left" class="_title_form">Fullname</td>
                    <td><input type="text" class="_textbox" id="txtFullname" name="<%=UserController.FULLNAME_CONTROL_NAME%>" value="<%=TicketBookConvert.castParameterRequestIsNull(request, UserController.FULLNAME_CONTROL_NAME,"")%>"/></td>
                    <td class="_alert_error" id="txtAlertFullname"></td>
                </tr>
                <tr>
                    <td  style="text-align:left" class="_title_form">Phone</td>
                    <td><input type="text" class="_textbox" id="txtPhone" name="<%=UserController.PHONE_CONTROL_NAME%>" value="<%=TicketBookConvert.castParameterRequestIsNull(request, UserController.PHONE_CONTROL_NAME,"")%>"/></td>
                    <td class="_alert_error" id="txtAlertPhone"></td>
                </tr>
                <tr>
                    <td style="text-align:left" class="_title_form">Address</td>
                    <td><input type="text" class="_textbox" id="txtAddress" name="<%=UserController.ADDRESS_CONTROL_NAME%>" value="<%=TicketBookConvert.castParameterRequestIsNull(request, UserController.ADDRESS_CONTROL_NAME,"")%>"/></td>
                    <td class="_alert_error" id="txtAlertAddress"></td>
                </tr>
                <tr>
                    <td style="text-align:left" class="_title_form">Email</td>
                    <td><input type="text" class="_textbox" id="txtEmail" name="<%=UserController.EMAIL_CONTROL_NAME%>" value="<%=TicketBookConvert.castParameterRequestIsNull(request, UserController.EMAIL_CONTROL_NAME,"")%>"/></td>
                    <td class="_alert_error" id="txtAlertEmail"></td>
                </tr>

                <tr>
                    <td style="text-align:left" class="_title_form">Birthday</td>
                    <td>
                        <input  type="text" readonly="readOnly" class="_textbox" id="txtBirthday" name="<%=UserController.BIRTHDAY_CONTROL_NAME%>" value="<%=TicketBookConvert.castParameterRequestIsNull(request, UserController.BIRTHDAY_CONTROL_NAME,"")%>"/>
                       
                    </td>
                    
                    <td class="_alert_error" id="txtAlertBirthday"></td>
                </tr>
                <tr>
                    <td style="text-align:left" class="_title_form">Person Card Number</td>
                    <td><input type="text" class="_textbox" id="txtPersonCardNumber" name="<%=UserController.PERSONCARDNUMBER_CONTROL_NAME%>" value="<%=TicketBookConvert.castParameterRequestIsNull(request, UserController.PERSONCARDNUMBER_CONTROL_NAME,"")%>"/></td>
                    <td class="_alert_error" id="txtAlertPersonCardNumber"></td>
                </tr>
                <tr><td colspan ="2" align="center"> <input type="button" value="Submit" onclick="register()"/></td><td></td></tr>
            </table>

        </form>
        <script type="text/javascript">

            
            function register(){
                if(validate()){
                    document.getElementById("actionType").value="<%=HandlerController.ACTIONTYPE_VALUE_REGISTER_MEMBER%>";
                    document.forms["frmRegister"].submit();
                }
            }
            function validate(){
                var stt=true;
                if(document.getElementById("txtUsername").value=="" || isAllSpace(document.getElementById("txtUsername").value)){
                    document.getElementById("txtAlertUsername").innerHTML="can't empty";
                    stt=false;
                }
                else document.getElementById("txtAlertUsername").innerHTML="";
                if(document.getElementById("txtPassword").value=="" || document.getElementById("txtPassword").value!=document.getElementById("txtRePassword").value || isAllSpace(document.getElementById("txtPassword").value) && !isAllSpace(document.getElementById("txtRePassword").value)){
                    document.getElementById("txtAlertPassword").innerHTML="invalid password";
                    stt=false;
                }
                else{
                    document.getElementById("txtAlertPassword").innerHTML="";
                    document.getElementById("txtAlertRePassword").innerHTML="";
                }
                if(document.getElementById("txtFullname").value=="" || isAllSpace(document.getElementById("txtFullname").value)){
                    document.getElementById("txtAlertFullname").innerHTML="can't empty";
                    stt=false;
                }
                else document.getElementById("txtAlertFullname").innerHTML="";
                if(document.getElementById("txtEmail").value=="" || isAllSpace(document.getElementById("txtEmail").value)){
                    document.getElementById("txtAlertEmail").innerHTML="can't empty";
                    stt=false;
                }
                else document.getElementById("txtAlertEmail").innerHTML="";
                if(document.getElementById("txtAddress").value=="" || isAllSpace(document.getElementById("txtAddress").value)){
                    document.getElementById("txtAlertAddress").innerHTML="can't empty";
                    stt=false;
                }
                else document.getElementById("txtAlertAddress").innerHTML="";
                if(document.getElementById("txtBirthday").value=="" || isAllSpace(document.getElementById("txtBirthday").value)){
                    document.getElementById("txtAlertBirthday").innerHTML="can't empty";
                    stt=false;
                }
                else document.getElementById("txtAlertBirthday").innerHTML="";
                if(document.getElementById("txtPersonCardNumber").value=="" || isAllSpace(document.getElementById("txtPersonCardNumber").value)|| !isNumber(document.getElementById("txtPersonCardNumber").value)){
                    document.getElementById("txtAlertPersonCardNumber").innerHTML="can't empty";
                    stt=false;
                }
                else document.getElementById("txtAlertPersonCardNumber").innerHTML="";
                if(document.getElementById("txtPhone").value!="" && !isNumber(document.getElementById("txtPhone").value)){
                    document.getElementById("txtAlertPhone").innerHTML="You just enter the number";
                    stt=false;
                }
                else document.getElementById("txtAlertPhone").innerHTML="";
                return stt;

            }

            function isNumber(str)
            {
                num="0123456789";
                for(i=0;i<str.length;i++)
                {
                    for(j=0;j<num.length;j++)
                    {
                        if(str.charAt(i)==num.charAt(j)){
                            j=num.length;
                        }
                    }
                    if(j!=num.length+1)
                        return false;
                }
                return true;
            }
            function isAllSpace(str)
            {
                i=0;
                while(i<str.length&&str.charAt(i)==' ')
                    i++;
                if(i==str.length)
                    return true;
                else
                    return false;
            }

            
        </script>
        			<script type="text/javascript">
					jQuery(document).ready(function() {
						jQuery("#txtBirthday").dynDateTime(); //defaults
					});
				</script>
        <jsp:include page="../Block/block2.jsp"/>
    </body>
</html>	