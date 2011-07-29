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
<table border="1" cellspacing="4px" style="width:640px; float: left;margin-left:100px">
            <tr>
                <th>Question</th>
                <th>Function</th>
            </tr>
            <c:set var="count" value="1"></c:set>
            <c:forEach items="${faqlist}" var="obj">
                <tr>
                    <td>
                        ${obj.question}
                    </td>
                    <td>
                        <a href="<%= request.getContextPath()%>/Form/faq.jsp?index=${count}">View</a>
                    </td>
                </tr>
                <c:if test="${param.index eq count}">
                    <tr>
                        <td colspan="2">
                            ${obj.answer}
                        </td>
                    </tr>
                </c:if>
                <c:set var="count" value="${count+1}"></c:set>
           </c:forEach>        
    </table>
          </form>
<jsp:include page="../Block/block2.jsp"/>
</body>
</html>	