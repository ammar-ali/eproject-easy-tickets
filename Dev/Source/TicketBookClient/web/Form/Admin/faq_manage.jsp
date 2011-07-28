<%-- 
    Document   : faq_create
    Created on : Jul 14, 2011, 10:40:01 AM
    Author     : QuocHai
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<%@page import="javax.naming.*" %>
<%@page import="ticketbook.transfer.UserTransferData" %>
<%@page import="ticketbook.exception.ConfigException" %>
<%@page import="ticketbook.util.Config" %>
<%@page import="javax.rmi.PortableRemoteObject" %>
<%@page import="java.util.Enumeration" %>
<%@page import="ticketbook.transfer.FaqTransferData" %>
<%@page import="java.util.Vector" %>
<%@page import="ticketbook.model.FAQ" %>

<font class="_content_title">Create new FAQs</font>
<form action=""
    <table border="1">
            <tr>
                <td><input type="text" name="txtAnswer"/></td>
            </tr>
            <tr>
                <td><input type="text" name="txtQuestion"/></td>
            </tr>
            <tr>
                <td><input type="submit" value="Submit"/></td>
            </tr>
    </table>
</form>