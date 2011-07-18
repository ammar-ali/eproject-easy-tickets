<%--
   Document   : index
    Created on : Jul 8, 2011, 3:16:48 PM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">


<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Register</title>
        <link rel='stylesheet' href='<%=request.getContextPath()%>/Style/layout.css'/>
        <link rel='stylesheet' href='<%=request.getContextPath()%>/Style/tag_def.css'/>
        <link rel='stylesheet' href='<%=request.getContextPath()%>/Style/component.css'/>

        <link rel="stylesheet" href="<%=request.getContextPath()%>/Style/general.css" />
        <link rel="stylesheet" href="<%=request.getContextPath()%>/Style/aqua.css" />
        
        <script type="text/javascript" src="<%=request.getContextPath()%>/Script/General.js"></script>
        <script type="text/javascript" src="<%=request.getContextPath()%>/Script/jquery-1.3.2.min.js"></script>
        <script type="text/javascript" src="<%=request.getContextPath()%>/Script/zapatec.js"></script>
        <script type="text/javascript" src="<%=request.getContextPath()%>/Script/calendar.js"></script>
        <script type="text/javascript" src="<%=request.getContextPath()%>/Script/Calendar-en.js"></script>
        <script src="<%=request.getContextPath()%>/Script/jquery.js" type="text/javascript"></script>
        <script src="<%=request.getContextPath()%>/Script/interface.js" type="text/javascript"></script>

    </head>
    <body>

        <jsp:include page="../Block/block1.jsp"/>
        <font class="_content_title">Register</font>
        <br/>
        <form action="post">
            <table cellspacing="4px" style="width:550px; float: left;margin-left:200px" >
                <tr>
                    <td style="text-align:left" width="150px" class="_title_form">Username</td>
                    <td width="150px"><input type="text" class="_textbox" id="txtUsername"/></td>
                    <td width="250px" class="_alert_error" id="txtAlertUsername"></td>
                </tr>
                <tr>
                    <td style="text-align:left"  class="_title_form">Password</td>
                    <td><input type="password" class="_textbox" id="txtPassword"/></td>
                    <td  class="_alert_error" id="txtAlertPassword"></td>
                </tr>
                <tr>
                    <td style="text-align:left"  class="_title_form">Re-Password</td>
                    <td ><input type="password" class="_textbox" id="txtRePassword"/></td>
                    <td class="_alert_error" id="txtAlertRePassword"></td>
                </tr>
                <tr>
                    <td style="text-align:left" class="_title_form">Fullname</td>
                    <td><input type="text" class="_textbox" id="txtFullname"/></td>
                    <td class="_alert_error" id="txtAlertFullname"></td>
                </tr>
                <tr>
                    <td  style="text-align:left" class="_title_form">Phone</td>
                    <td><input type="text" class="_textbox" id="txtPhone"/></td>
                    <td class="_alert_error" id="txtAlertPhone"></td>
                </tr>
                <tr>
                    <td style="text-align:left" class="_title_form">Address</td>
                    <td><input type="text" class="_textbox" id="txtAddress"/></td>
                    <td class="_alert_error" id="txtAlertAddress"></td>
                </tr>
                <tr>
                    <td style="text-align:left" class="_title_form">Email</td>
                    <td><input type="text" class="_textbox" id="txtEmail"/></td>
                    <td class="_alert_error" id="txtAlertEmail"></td>
                </tr>

                <tr>
                    <td style="text-align:left" class="_title_form">Birthday</td>
                    <td>
                        <input type="text" class="_textbox" id="txtBirthday" name="txtBirthday" />
                        
                    </td>
                    
                    <td class="_alert_error" id="txtAlertBirthday"></td>
                </tr>
                <tr>
                    <td style="text-align:left" class="_title_form">Person Card Number</td>
                    <td><input type="text" class="_textbox" id="txtPersonCarNumber"/></td>
                    <td class="_alert_error" id="txtAlertPersonCardNumber"></td>
                </tr>
                <tr><td colspan ="2" align="center"> <input type="button" value="Submit" onclick="register()"/></td><td></td></tr>
            </table>

        </form>
        <script type="text/javascript">
/*
            
            function register(){
                if(validate()){
            
                }
            }
            function validate(){
                var stt=true;
                if(document.getElementById("txtUsername").value==""){
                    document.getElementById("txtAlertUsername").innerHTML="can't empty";
                    stt=false;
                }
                else document.getElementById("txtAlertUsername").innerHTML="";
                if(document.getElementById("txtPassword").value=="" || document.getElementById("txtPassword").value!=document.getElementById("txtRePassword").value){
                    document.getElementById("txtAlertPassword").innerHTML="invalid password";
                    stt=false;
                }
                else{
                    document.getElementById("txtAlertPassword").innerHTML="";
                    document.getElementById("txtAlertRePassword").innerHTML="";
                }
                if(document.getElementById("txtFullname").value==""){
                    document.getElementById("txtAlertFullname").innerHTML="can't empty";
                    stt=false;
                }
                else document.getElementById("txtAlertFullname").innerHTML="";
                if(document.getElementById("txtEmail").value==""){
                    document.getElementById("txtAlertEmail").innerHTML="can't empty";
                    stt=false;
                }
                else document.getElementById("txtAlertEmail").innerHTML="";
                if(document.getElementById("txtAddress").value==""){
                    document.getElementById("txtAlertAddress").innerHTML="can't empty";
                    stt=false;
                }
                else document.getElementById("txtAlertAddress").innerHTML="";
                if(document.getElementById("txtBirthday").value==""){
                    document.getElementById("txtAlertBirthday").innerHTML="can't empty";
                    stt=false;
                }
                else document.getElementById("txtAlertBirthday").innerHTML="";
                if(document.getElementById("txtPersonCarNumber").value==""){
                    document.getElementById("txtAlertPersonCardNumber").innerHTML="can't empty";
                }
                else document.getElementById("txtAlertPersonCardNumber").innerHTML="";

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

            */
        </script>
        <script type="text/javascript">
            //<![CDATA[
              Zapatec.Calendar.setup({
                    firstDay          : 1,
                    weekNumbers       : false,
                    range             : [2010.01, 2020.12],
                    electric          : false,
                    inputField        : "txtBirthday",
                    button            : "Calendar",
                    ifFormat          : "%d-%m-%Y"
              });
            //]]>

        </script>
        <jsp:include page="../Block/block2.jsp"/>
    </body>
</html>	