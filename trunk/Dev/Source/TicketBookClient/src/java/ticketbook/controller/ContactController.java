/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ticketbook.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.rmi.RemoteException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.CreateException;
import javax.ejb.RemoveException;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.rmi.PortableRemoteObject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import ticketbook.ejb.cmp.ContactSessionBeanRemote;
import ticketbook.ejb.cmp.ContactSessionBeanRemoteHome;
import ticketbook.util.StringELF;
import ticketbook.util.TicketBookLookUpJNDI;

/**
 *
 * @author Admin
 */
public class ContactController extends HandlerController {

    public static final String TITLE_CONTACT_CONTROL_NAME = "txtContact_Title";
    public static final String CONTENT_CONTACT_CONTROL_NAME = "txtContact_Content";
    public static final String ANSWER_CONTACT_CONTROL_NAME = "txtContact_Answer";
    public static final String EMAIL_CONTACT_CONTROL_NAME = "txtContact_Email";
    public static final String CREATE_DATE_CONTACT_CONTROL_NAME = "txtContact_Create_Date";
    public static final String USERNAME_CONTACT_CONTROL_NAME = "txtUsername";
    public static final String ID_CONTACT_CONTROL_NAME = "txtId";
    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    public void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            if(request.getParameter(FormController.ACTIONTYPE_NAME)!=null){
                 if(request.getParameter(FormController.ACTIONTYPE_NAME).equals(HandlerController.ACTIONTYPE_VALUE_CREATE_CONTACT_MESSAGE)){
                    this.createContact(request, response);
                }else if (request.getParameter(FormController.ACTIONTYPE_NAME).equals(HandlerController.ACTIONTYPE_VALUE_ANSWER_CONTACT_MESSAGE)){
                    this.answerContact(request, response);
                }else if(request.getParameter(FormController.ACTIONTYPE_NAME).equals(HandlerController.ACTIONTYPE_VALUE_DELETE_CONTACT_MESSAGE)){
                    this.deleteContact(request, response);
                }else if(this.handlerController!=null){
                    this.handlerController.processRequest(request, response);
                }
            }
        }catch(Exception ex){
            ex.printStackTrace();
        } finally { 
            out.close();
        }
    } 

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /** 
     * Handles the HTTP <code>GET</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        processRequest(request, response);
    } 

    /** 
     * Handles the HTTP <code>POST</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        processRequest(request, response);
    }

    /** 
     * Returns a short description of the servlet.
     * @return a String containing servlet description
     */
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
    public void loadAllContact(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        try {
            ContactSessionBeanRemote remote = TicketBookLookUpJNDI.getContactSessionBeanRemoteHome().create();
            ArrayList contact = (ArrayList) remote.ejbFindAllContact();
            RequestDispatcher rd = request.getRequestDispatcher("contact_manage.jsp");
            rd.forward(request, response);
        } catch (CreateException ex) {
            ex.printStackTrace();
        } catch (RemoteException ex) {
            ex.printStackTrace();
        }
    }

    public void createContact(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        if(request.getParameter(FormController.ACTIONTYPE_NAME).equals(HandlerController.ACTIONTYPE_VALUE_CREATE_CONTACT_MESSAGE)){
            ContactSessionBeanRemote remote = lookupContactSessionBeanRemote();
            if(remote!=null){
                String title = request.getParameter(TITLE_CONTACT_CONTROL_NAME);
                String content = request.getParameter(CONTENT_CONTACT_CONTROL_NAME);
                String email = request.getParameter(EMAIL_CONTACT_CONTROL_NAME);
                String get_create_date = request.getParameter(CREATE_DATE_CONTACT_CONTROL_NAME);
                Timestamp create_date = StringELF.convertStringToTimestamp(title, "mm-dd-yyyy");
                String username = request.getSession().getAttribute(USERNAME_CONTACT_CONTROL_NAME).toString();
//                remote.createContact(title, content, email, create_date, username);
                RequestDispatcher rd = request.getRequestDispatcher("contact.jsp");
                rd.forward(request, response);
            }
        }
    }

    public void answerContact(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        if(request.getParameter(FormController.ACTIONTYPE_NAME).equals(HandlerController.ACTIONTYPE_VALUE_ANSWER_CONTACT_MESSAGE)){
            ContactSessionBeanRemote remote = lookupContactSessionBeanRemote();
            Integer id = Integer.getInteger(ID_CONTACT_CONTROL_NAME);
            String title = request.getParameter(TITLE_CONTACT_CONTROL_NAME);
            String content = request.getParameter(CONTENT_CONTACT_CONTROL_NAME);
            String email = request.getParameter(EMAIL_CONTACT_CONTROL_NAME);
            String username = request.getParameter(USERNAME_CONTACT_CONTROL_NAME);
            remote.answerContact(id, title, content, title, email, username);
            RequestDispatcher rd = request.getRequestDispatcher("contact.jsp");
            rd.forward(request, response);
        }
    }

    public void deleteContact(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, RemoveException{
        if(request.getParameter(FormController.ACTIONTYPE_NAME).equals(HandlerController.ACTIONTYPE_VALUE_DELETE_CONTACT_MESSAGE)){
            ContactSessionBeanRemote remote = lookupContactSessionBeanRemote();
            Integer id = Integer.getInteger(ID_CONTACT_CONTROL_NAME);
            remote.remove();
            RequestDispatcher rd = request.getRequestDispatcher("contact.jsp");
            rd.forward(request, response);
        }
    }

    private ContactSessionBeanRemote lookupContactSessionBeanRemote() {
        try {
            Context c = new InitialContext();
            Object remote = c.lookup("ContactSesLocalJNDI");
            ContactSessionBeanRemoteHome rv = (ContactSessionBeanRemoteHome) PortableRemoteObject.narrow(remote, ContactSessionBeanRemoteHome.class);
            return rv.create();
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        } catch (CreateException ce) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ce);
            throw new RuntimeException(ce);
        } catch (RemoteException re) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", re);
            throw new RuntimeException(re);
        }
    }

}
