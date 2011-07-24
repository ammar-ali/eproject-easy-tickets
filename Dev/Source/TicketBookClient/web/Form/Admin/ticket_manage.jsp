<%--
   Document   : index
    Created on : Jul 8, 2011, 3:16:48 PM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="/WEB-INF/TLD/taglib.tld" prefix="w" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<%@ taglib uri="/WEB-INF/TLD/elfcity" prefix="cityELF" %>
<%@ taglib uri="/WEB-INF/TLD/elfvenue" prefix="venueELF" %>

<c:set var="CONTEXT_PATH" value="<%=request.getContextPath()%>"></c:set>
<c:set var="lstCity" value='${cityELF:getInstanceValue()}'></c:set>
<c:set var="lstVenue" value='${venueELF:getAllVenue()}'></c:set>
<w:authorize_role pathTo="/WEB-INF/authorize.xml" request="${pageContext.request}" response="${pageContext.response}"></w:authorize_role>
<form action="${CONTEXT_PATH}AdminController" method="post">
   Choose <select>
        <option value="event">Event</option>
        <option value="ticket">Ticket</option>
    </select>
    <table cellpadding="10px">
        <tr>
            <td  class="_title_form" align="left">Title</td>
            <td  align="left"><input type="text" id="txtTitle"/></td>
        </tr>
        <tr>
            <td class="_title_form" align="left">Artist</td>
            <td align="left"><input type="text" id="txtArtist"/></td>
        </tr>
        <tr>
            <td class="_title_form" align="left">Content</td>
            <td align="left"><textarea id="txtContent" rows="6" cols="20"></textarea></td>
        </tr>
        <tr>
            <td class="_title_form" align="left">Image</td>
            <td align="left"><input type="file" id="txtImage"/></td>
        </tr>
        <tr>
            <td class="_title_form" align="left">City</td>
            <td align="left"><select>
                    <c:forEach var="objCity" items='${lstCity}'>

                        <option value="${objCity.ID}">${objCity.name}</option>
                   
                    </c:forEach>
                </select></td>
        </tr>
        <tr>
            <td class="_title_form" align="left">Venue</td>
            <td align="left"><select>
                     <c:forEach var="objVenue" items='${lstVenue}'>

                        <option value="${objVenue.ID}">${objVenue.name} | ${objVenue.address}</option>

                    </c:forEach>
                </select></td>
        </tr>
        <tr>
            <td colspan="2"><input type="button" value="Submit"/></td>
        </tr>
    </table>
</form>
   <script type="text/javaScript">
      
   </script>