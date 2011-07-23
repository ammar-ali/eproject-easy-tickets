<%-- 
    Document   : footer
    Created on : Jul 12, 2011, 1:48:15 PM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList"%>
<%@page import="ticketbook.model.EventType"%>
<%@page import="ticketbook.util.TicketBookSession"%>
<%@page import="ticketbook.util.TicketBookConvert"%>
<%@page import="ticketbook.util.Constant"%>
<%@page import="ticketbook.util.TicketBookParameter"%>
<%@ taglib uri="/WEB-INF/TLD/elfticketbook" prefix="ticketbookELF" %>
<%@ taglib uri="/WEB-INF/TLD/elfeventtype" prefix="eventtypeELF" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<%@ taglib uri="/WEB-INF/TLD/taglib.tld" prefix="w" %>

<w:authorize_role pathTo="/WEB-INF/authorize.xml" request="${pageContext.request}" response="${pageContext.response}"></w:authorize_role>

<c:set var="ID_FALSE_INTEGER" value='<%=Constant.ID_FALSE_INTETER%>'></c:set>
<c:set var="TICKETBOOK_SESSION" value='<%=request.getSession()%>'></c:set>
<c:set var="ROLEID_USER_LOGIN_SESSION_NAME" value='<%=TicketBookSession.ROLEID_USER_LOGIN%>'></c:set>
<c:set var="CONTEXT_PATH" value='<%=request.getContextPath()%>'></c:set>

<c:set var="SYS_PARAM" value='${ticketbookELF:getSystemParameter()}'></c:set>
<c:set var="roleID" value='${ticketbookELF:castSessionIsNull(TICKETBOOK_SESSION,ROLEID_USER_LOGIN_SESSION_NAME,0)}'/>
<c:set var="ADMIN_ROLEID" value="${SYS_PARAM.adminRoleID}"></c:set>


<center>
	<div class="_div_header_1">
		<div class="_div_header_2">
			<div class="_div_header_3">
                            <c:if test="${roleID eq ADMIN_ROLEID}">
                                <a href="${CONTEXT_PATH}/Form/Admin/admin.jsp">A<font color="#62b7e5">dmin</font></a> |
                            </c:if>
                            <c:if test="${roleID eq ID_FALSE_INTEGER}">
                                <a href="${CONTEXT_PATH}/Form/login.jsp">L<font color="#62b7e5">ogin</font></a> | <a href="${CONTEXT_PATH}/Form/register.jsp">R<font color="#62b7e5">egister</font></a>
                            </c:if>
                            <c:if test="${roleID ne ID_FALSE_INTEGER}">
                                <a href="${CONTEXT_PATH}/Form/logout.jsp">L<font color="#62b7e5">ogout</font></a>
                            </c:if>
                
                        </div>
		</div>
	</div>
	<div class="_div_menu_1">
		<div class="_div_menu_2">
			<div class="_div_line_vertical_1"></div>
			<div class="_div_menu_3">
				<div class="_div_menu_3_left">
					<img src="${CONTEXT_PATH}/Images/template_11.png" alt="logo"/>
				</div>
				<div class="_div_menu_3_right">

                                        <a href="${CONTEXT_PATH}/Form/contact_us.jsp"><img src="${CONTEXT_PATH}/Images/template_04.gif" alt="Contact"/></a>
					<a href="${CONTEXT_PATH}/Form/about_us.jsp"><img src="${CONTEXT_PATH}/Images/template_06.gif" alt="AboutUs"/></a>
					<a href="${CONTEXT_PATH}/Form/faq.jsp"><img src="${CONTEXT_PATH}/Images/template_08.gif" alt="FAQ'S" /></a>
				
				</div>


			</div>
			<div class="_div_menu_4">
				<div class="_div_line_vertical_2"></div>
				<div class="_div_menu_5"><a href="${CONTEXT_PATH}/index.jsp">Home</a></div>
				
          <c:set var="EVENT_TYPES" value='${eventtypeELF:getInstanceValue()}'></c:set>
          <c:forEach items="${EVENT_TYPES}" var="obj">
              <div class="_div_menu_5"><a href="${CONTEXT_PATH}/Form/show_tickets.jsp?index=${eventtypeELF:getIndexEventTypesByID(obj.ID)}">${obj.name}</a></div>
          </c:forEach>
			</div>
		</div>
	</div>
	<div class="_div_content_1">
            <img width="796px" src="${CONTEXT_PATH}/Images/template_19.gif" alt="banner"/>
		<div class="_div_content_2">
			<div class="_div_line_vertical_3"></div>

			<div class="_div_content_3">
