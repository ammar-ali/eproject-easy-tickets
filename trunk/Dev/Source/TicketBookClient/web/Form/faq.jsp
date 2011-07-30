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
<%@ taglib uri="/WEB-INF/TLD/elfticketbook" prefix="ticketbookELF" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<%@ taglib uri="/WEB-INF/TLD/taglib.tld" prefix="w" %>
<%@ taglib uri="/WEB-INF/TLD/elffaq" prefix="faqELF" %>
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
    <c:set var="SYSTEM_PARAM" value='${ticketbookELF:getSystemParameter()}'/>
    <c:set var="TOTAL_RECORD_SHOW" value="${SYSTEM_PARAM.recordNumberNeedShow}"></c:set>
    <c:set var="TOTAL_PAGE_SHOW" value="${SYSTEM_PARAM.pageNumberNeedShow}"></c:set>
    <c:set var="totalRecord" value='<%= Faq.countFindAll() %>'></c:set>

    <c:set var="faqlist" value= '${faqELF:getAll(param.pindex,TOTAL_RECORD_SHOW)}' ></c:set>
<jsp:include page="../Block/block1.jsp"/>

  <form action="FaqController" method="post">
<font class="_content_title">FAQ'S</font>
<c:if test="${totalRecord gt TOTAL_RECORD_SHOW}">
                <w:paging pathName="faq.jsp"
                          enableFirstPage="true"
                enableLastPage="true"
                enableIndexChoose="true"
                styleIndexChoose="color:blue"
                index="${param.pindex}"
                totalRecord="${totalRecord}"
                numPageDivide="${TOTAL_PAGE_SHOW}"
                numRecordDivide="${TOTAL_RECORD_SHOW}"
                style="cursor:pointer"
                pageName="pindex">
                </w:paging>
            </c:if>
<br/>

<table border="1" cellpadding="4px"  style="width:640px;">
            <tr>
                <th align="center">Question</th>
                <th align="center">Function</th>
            </tr>
            <c:set var="count" value="1"></c:set>
            <c:forEach items="${faqlist}" var="obj">
                <tr>
                    <td align="left">
                        ${obj.question}
                    </td>
                    <td align="center">
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