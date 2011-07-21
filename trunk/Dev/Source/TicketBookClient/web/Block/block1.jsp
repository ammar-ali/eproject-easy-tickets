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
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<%@ taglib uri="/WEB-INF/TLD/taglib.tld" prefix="w" %>

<c:set var="SYS_PARAM" value='<%=new TicketBookParameter()%>'></c:set>
<c:set var="roleID" value='<%=TicketBookConvert.castSessionIsNull(request.getSession(),TicketBookSession.ROLEID_USER_LOGIN,new Integer(0))%>'/>
<c:set var="ADMIN_ROLEID" value="${SYS_PARAM.adminRoleID}"></c:set>
<c:set var="ID_FALSE_INTEGER" value='<%=Constant.ID_FALSE_INTETER%>'/>
<w:authorize_role pathTo="/WEB-INF/authorize.xml" request="${pageContext.request}" response="${pageContext.response}"></w:authorize_role>
<center>
	<div class="_div_header_1">
		<div class="_div_header_2">
			<div class="_div_header_3">
                            <c:if test="${roleID eq ADMIN_ROLEID}">
                                <a href="<%=request.getContextPath()%>/Form/Admin/admin.jsp">A<font color="#62b7e5">dmin</font></a> |
                            </c:if>
                            <c:if test="${roleID eq ID_FALSE_INTEGER}">
                                <a href="<%=request.getContextPath()%>/Form/login.jsp">L<font color="#62b7e5">ogin</font></a> | <a href="<%=request.getContextPath()%>/Form/register.jsp">R<font color="#62b7e5">egister</font></a>
                            </c:if>
                            <c:if test="${roleID ne ID_FALSE_INTEGER}">
                                <a href="<%=request.getContextPath()%>/Form/logout.jsp">L<font color="#62b7e5">ogout</font></a>
                            </c:if>
                
                        </div>
		</div>
	</div>
	<div class="_div_menu_1">
		<div class="_div_menu_2">
			<div class="_div_line_vertical_1"></div>
			<div class="_div_menu_3">
				<div class="_div_menu_3_left">
					<img src="<%=request.getContextPath()%>/Images/template_11.png" alt="logo"/>
				</div>
				<div class="_div_menu_3_right">

                                        <a href="<%=request.getContextPath()%>/Form/contact_us.jsp"><img src="<%=request.getContextPath()%>/Images/template_04.gif" alt="Contact"/></a>
					<a href="<%=request.getContextPath()%>/Form/about_us.jsp"><img src="<%=request.getContextPath()%>/Images/template_06.gif" alt="AboutUs"/></a>
					<a href="<%=request.getContextPath()%>/Form/faq.jsp"><img src="<%=request.getContextPath()%>/Images/template_08.gif" alt="FAQ'S" /></a>
				
				</div>


			</div>
			<div class="_div_menu_4">
				<div class="_div_line_vertical_2"></div>
				<div class="_div_menu_5"><a href="<%=request.getContextPath()%>/index.jsp">Home</a></div>
				
          <c:set var="event_types" value='<%=EventType.getInstanceValue()%>'></c:set>
          <c:forEach items="${event_types}" var="obj">
              <div class="_div_menu_5"><a href="<%=request.getContextPath()%>/Form/show_tickets.jsp?index=${ticketbookELF:getIndexEventTypesByID(obj.ID)}">${obj.name}</a></div>
          </c:forEach>
			</div>
		</div>
	</div>
	<div class="_div_content_1">
            <img width="796px" src="<%=request.getContextPath()%>/Images/template_19.gif" alt="banner"/>
		<div class="_div_content_2">
			<div class="_div_line_vertical_3"></div>

			<div class="_div_content_3">
