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

<form action="FAQsController" method="post">
<font class="_content_title">FAQ'S</font>
    <table>
            <tr>
                <th>No.</th>
                <th>Question</th>
                <th>Answer</th>
                <th>Create Date</th>
                <th>User</th>
                <th colspan="2">Function</th>
            </tr>

          <% Vector lstFAQ = FAQ.getAll();%>
          <% for(int i=0;i<lstFAQ.size();i++){
          System.out.println(lstFAQ.size());
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
                    <td>
                        <%=((FaqTransferData)lstFAQ.get(i)).getCreate_date()%>
                    </td>
                    <td>
                        <%=((FaqTransferData)lstFAQ.get(i)).getUsername()%>
                    </td>
                    <td>
                        <input type="button" name="" value="Update" onclick="" />
                    </td>
                    <td>
                        <input type="button" name="" value="Delete" onclick="click_delete()" />
                    </td>
                </tr>
            <%
                }
            %>
            <tr>
                <td>
                    <input type="button" name="" value="Create" onclick="" />
               </td>
            </tr>
    </table>
          </form>
            <script type="text/javascript">
            function click_delete(){
            var a = confirm("Are you sure to delete this FAQ?? ");
            }
            </script>