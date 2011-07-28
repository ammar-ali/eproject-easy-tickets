<%--
   Document   : index
    Created on : Jul 8, 2011, 3:16:48 PM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="ticketbook.transfer.FaqTransferData" %>
<%@page import="java.util.Vector" %>
<%@page import="ticketbook.model.FAQ" %>
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
  <form action="FAQsController" method="post">
<font class="_content_title">FAQ'S</font>
<center>
    <table border="1">
            <tr>
                <th>No.</th>
                <th>Question</th>
                <th>Answer</th>
            </tr>
            
          <% Vector lstFAQ = FAQ.getAll();%>
          <% for(int i=0;i<lstFAQ.size();i++){
            %>
                <tr>
                    <td>
                        <%=((FaqTransferData)lstFAQ.get(i)).getID() %>
                    </td>
                    <td>
                        <%=((FaqTransferData)lstFAQ.get(i)).getQuestion()%>
                    </td>
                    <td>
                        <%=((FaqTransferData)lstFAQ.get(i)).getAnswer()%>
                    </td>
                </tr>
            <%
                }
            %>
    </table>
</center>
          </form>
<jsp:include page="../Block/block2.jsp"/>
</body>
</html>	