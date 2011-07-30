/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ticketbook.controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
                   // this.createContact(request, response);
                }else if (request.getParameter(FormController.ACTIONTYPE_NAME).equals(HandlerController.ACTIONTYPE_VALUE_ANSWER_CONTACT_MESSAGE)){
                    //this.answerContact(request, response);
                }else if(request.getParameter(FormController.ACTIONTYPE_NAME).equals(HandlerController.ACTIONTYPE_VALUE_DELETE_CONTACT_MESSAGE)){
                    //this.deleteContact(request, response);
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
   
}
