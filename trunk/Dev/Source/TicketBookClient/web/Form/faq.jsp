<%--
   Document   : index
    Created on : Jul 8, 2011, 3:16:48 PM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="ticketbook.transfer.FaqTransferData" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>FAQ'S</title>
<link rel='stylesheet' href='<%=request.getContextPath()%>/Style/layout.css'/>
<link rel='stylesheet' href='<%=request.getContextPath()%>/Style/tag_def.css'/>
<link rel='stylesheet' href='<%=request.getContextPath()%>/Style/component.css'/>

</head>
<body>

<jsp:include page="../Block/block1.jsp"/>
<font class="_content_title">FAQ'S</font>
    <table border="1">
            <tr>
                <th>No.</th>
                <th>Question</th>
                <th>Answer</th>
            </tr>
            <% FaqTransferData[] faq = (FaqTransferData[])request.getAttribute("");
                for(int i = 0; i<faq.length; i++){
            %>
            <form action="FAQsController" method="post">
                <tr>
                    <td><%=i+1%></td>
                    <td>
                        <%= faq[i].getQuestion()%><input type="text" name="txtQuestion" value="<%=faq[i].getQuestion()%>"
                    </td>
                    <td>
                        <input type="text" name="txtAnswer" value="<%= faq[i].getAnswer()%>"
                    </td>
                </tr>
            </form>
            <%
                }
            %>
    </table>
<a href="faq_create.jsp">Create FAQs</a>
<jsp:include page="../Block/block2.jsp"/>
</body>
</html>	