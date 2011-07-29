<%--
   Document   : index
    Created on : Jul 8, 2011, 3:16:48 PM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="ticketbook.transfer.FaqTransferData" %>
<%@page import="java.util.ArrayList" %>
<%@page import="ticketbook.model.Faq" %>
<%@page import="ticketbook.ejb.bmp.FaqRemote" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
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
    <c:set var="faqlist" value= '<%=Faq.getAll(1, 10)%>' ></c:set>
<jsp:include page="../Block/block1.jsp"/>
  <form action="FAQsController" method="post">
<font class="_content_title">FAQ'S</font>
<center>
    <table border="1">
            <tr>
                <th>No.</th>
                <th>Question</th>
            </tr>
            <c:forEach items="${faqlist}" var="obj">
                <tr>
                    <td>
                        ${obj.question}
                    </td>
                    <td>
                        ${obj.answer}
                    </td>
                </tr>
           </c:forEach>        
    </table>
</center>
          </form>
<jsp:include page="../Block/block2.jsp"/>
</body>
</html>	