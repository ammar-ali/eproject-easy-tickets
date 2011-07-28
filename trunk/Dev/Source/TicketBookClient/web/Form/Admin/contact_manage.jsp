<%-- 
    Document   : contact_manage
    Created on : Jul 21, 2011, 4:41:52 PM
    Author     : Admin
--%>
<%@page import="java.util.Vector" %>
<%@page import="ticketbook.transfer.ContactTransferData" %>
<%@page import="ticketbook.model.Contact" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<c:set var="CONTEXT_PATH" value='<%=request.getContextPath()%>'></c:set>
<form action="${CONTEXT_PATH}/ContactController" method="post" name="frmContact">
    <input type="hidden" value="" name="${ACTIONTYPE_NAME}" id="actionType">
<font class="_content_title">Contacts</font>
    <table>
            <tr>
                <th>No.</th>
                <th>Title</th>
                <th>Content</th>
                <th>Email</th>
                <th>Create Date</th>
                <th>Creator</th>
            </tr>

          <% Vector lstContact = Contact.getAll();%>
          <% for(int i=0;i<lstContact.size();i++){
            %>
                <tr>
                    <td>
                        <%=((ContactTransferData)lstContact.get(i)).getID() %>
                    </td>
                    <td>
                        <%=((ContactTransferData)lstContact.get(i)).getTitle() %>
                    </td>
                    <td>
                        <%=((ContactTransferData)lstContact.get(i)).getContent() %>
                    </td>
                    <td>
                        <%= ((ContactTransferData)lstContact.get(i)).getEmail() %>
                    </td>
                    <td>
                        <%= ((ContactTransferData)lstContact.get(i)).getCreate_date() %>
                    </td>
                     <td>
                        <%= ((ContactTransferData)lstContact.get(i)).getUsername() %>
                    </td>
                    <td>
                        <input type="button" onclick="" name="" value="Update"/>
                    </td>
                     <td>
                        <input type="button" onclick="click_delete()" name="" value="Delete"/>
                    </td>
                </tr>
            <%
                }
            %>
            <tr align="center">
                <td><input type="button" onclick="" name="" value="Create" id="create"/>
                </td>
            </tr>
    </table>
          </form>
    <script type="text/javascript">
        function submitUpdateContact(){
            document.getElementById(id).value="${ACTIONTYPE_VALUE}";
        }

        function createContact(){
            if(document.getElementById(id).value=="create"){
                window.location
            }
        }
        function click_delete(){
            var a = confirm("Are you sure to delete this contact?? ");
        }

    </script>
