<%-- 
    Document   : footer
    Created on : Jul 12, 2011, 1:48:15 PM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList"%>
<%@page import="ticketbook.model.EventType"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<center>
	<div class="_div_header_1">
		<div class="_div_header_2">
			<div class="_div_header_3">
                            <a href="<%=request.getContextPath()%>/Form/login.jsp">L<font color="#62b7e5">ogin</font></a> | <a href="<%=request.getContextPath()%>/Form/register.jsp">R<font color="#62b7e5">egister</font></a>
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
				
          <c:set var="event_types" value='<%=EventType.values()%>'></c:set>
          <c:forEach items="${event_types}" var="obj">
                <div class="_div_menu_5"><a href="<%=request.getContextPath()%>/Form/show_tickets.jsp?id=${obj.ID}">${obj.name}</a></div>
          </c:forEach>
			</div>
		</div>
	</div>
	<div class="_div_content_1">
		<img src="<%=request.getContextPath()%>/Images/template_19.gif" alt="banner"/>

		<div class="_div_content_2">
			<div class="_div_line_vertical_3"></div>

			<div class="_div_content_3">
