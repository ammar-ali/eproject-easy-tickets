<%-- 
    Document   : contact_manage
    Created on : Jul 21, 2011, 4:41:52 PM
    Author     : Admin
--%>
<%@page import="java.util.ArrayList" %>
<%@page import="ticketbook.transfer.ContactTransferData" %>
<%@page import="ticketbook.model.Contact" %>
<%@page import="ticketbook.ejb.bmp.ContactRemote" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="/WEB-INF/TLD/elfticketbook" prefix="ticketbookELF" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<%@ taglib uri="/WEB-INF/TLD/taglib.tld" prefix="w" %>
<%@ taglib uri="/WEB-INF/TLD/elffaq" prefix="faqELF" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
   <c:set var="SYSTEM_PARAM" value='${ticketbookELF:getSystemParameter()}'/>
    <c:set var="TOTAL_RECORD_SHOW" value="${SYSTEM_PARAM.recordNumberNeedShow}"></c:set>
    <c:set var="TOTAL_PAGE_SHOW" value="${SYSTEM_PARAM.pageNumberNeedShow}"></c:set>
    <c:set var="totalRecord" value='<%= Contact.countFindAll() %>'></c:set>

    <c:set var="contactlist" value= '${faqELF:getAll(param.pindex,TOTAL_RECORD_SHOW)}' ></c:set>
    <form action="ContactController" method="post">
<font class="_content_title">Contact</font>
<c:if test="${totalRecord gt TOTAL_RECORD_SHOW}">
                <w:paging pathName="contact_manage.jsp"
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
                <th align="center">Title</th>
                <th align="center">Content</th>
                <th align="center">Answer</th>
                <th align="center">Email</th>
                <th align="center">Create Date</th>
                <th align="center">Username</th>
            </tr>
            <c:set var="count" value="1"></c:set>
            <c:forEach items="${contactlist}" var="obj">
                <tr>
                    <td align="left">
                        ${obj.title}
                    </td>
                    <td>
                        ${obj.content}
                    </td>
                    <td>
                        ${obj.email}
                    </td>
                    <td>
                        ${obj.create_date}
                    </td>
                    <td>
                        ${obj.username}
                    </td>
                    <td align="center">
                        <a href="<%= request.getContextPath()%>/Form/Admin/contact_manage.jsp?index=${count}">Answer</a>
                    </td>
                </tr>
                <c:if test="${param.index eq count}">
                    <tr>
                        <td colspan="6">
                            ${obj.answer}
                        </td>
                    </tr>
                </c:if>
                <c:set var="count" value="${count+1}"></c:set>
           </c:forEach>
    </table>
          </form>