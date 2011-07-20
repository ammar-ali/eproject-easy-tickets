/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ticketbook.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.rmi.RemoteException;
import java.sql.Timestamp;
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
import ticketbook.ejb.cmp.FaqSessionBeanRemote;
import ticketbook.ejb.cmp.FaqSessionBeanRemoteHome;
import ticketbook.util.StringELF;

/**
 *
 * @author QuocHai
 */
public class FAQsController extends HandlerController {

    public static final String ANSWER_CONTROL_NAME = "txtAnswer";
    public static final String QUESTION_CONTROL_NAME = "txtQuestion";
    public static final String CREATE_DATE_CONTROL_NAME = "txtCreate_Date";
    public static final String ID_CONTROL_NAME = "txtId";


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
                if(request.getParameter(FormController.ACTIONTYPE_NAME).equals(HandlerController.ACTIONTYPE_VALUE_INSERT_FAQ)){
                    this.insertFAQs(request, response);
                }else if (request.getParameter(FormController.ACTIONTYPE_NAME).equals(HandlerController.ACTIONTYPE_VALUE_UPDATE_FAQ)){
                    this.updateFAQs(request, response);
                }else if(request.getParameter(FormController.ACTIONTYPE_NAME).equals(HandlerController.ACTIONTYPE_VALUE_DELETE_FAQ)){
                    this.deleteFAQs(request, response);
                }else if(handlerController!=null){
                    handlerController.processRequest(request, response);
                }
            }
        }catch(Exception ex){
               ex.printStackTrace();
        } finally { 
            out.close();
        }
    } 

    public void insertFAQs(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        if(request.getParameter(FormController.ACTIONTYPE_NAME).equals(HandlerController.ACTIONTYPE_VALUE_INSERT_FAQ)){
            FaqSessionBeanRemote remote = lookupFaqSessionBeanRemote();
            if(remote!=null){
               String answer = request.getParameter(ANSWER_CONTROL_NAME);
               String question = request.getParameter(QUESTION_CONTROL_NAME);
               String get_create_date = request.getParameter(CREATE_DATE_CONTROL_NAME);
               //Timestamp create_date = StringELF.convertStringToTimestamp(get_create_date, "mm-dd-yyyy");
               //remote.insertFAQs(answer, question, create_date);
               RequestDispatcher rd = request.getRequestDispatcher("faq.jsp");
               rd.forward(request, response);
            }
        }
    }

    public void updateFAQs(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        if(request.getAttribute(FormController.ACTIONTYPE_NAME).equals(HandlerController.ACTIONTYPE_VALUE_UPDATE_FAQ)){
            FaqSessionBeanRemote remote = lookupFaqSessionBeanRemote();
            String answer = request.getParameter(ANSWER_CONTROL_NAME);
            String question = request.getParameter(QUESTION_CONTROL_NAME);
            Integer id = Integer.getInteger(ID_CONTROL_NAME);
            remote.updateFAQs(id, answer, question);
            RequestDispatcher rd = request.getRequestDispatcher("faq.jsp");
            rd.forward(request, response);
        }
    }

    public void deleteFAQs(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, RemoveException{
        if(request.getParameter(FormController.ACTIONTYPE_NAME).equals(HandlerController.ACTIONTYPE_VALUE_DELETE_FAQ)){
            FaqSessionBeanRemote remote = lookupFaqSessionBeanRemote();
            Integer id = Integer.getInteger(ID_CONTROL_NAME);
            remote.remove();
            RequestDispatcher rd = request.getRequestDispatcher("faq.jsp");
            rd.forward(request, response);
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

    private FaqSessionBeanRemote lookupFaqSessionBeanRemote() {
        try {
            Context c = new InitialContext();
            Object remote = c.lookup("FaqSesLocalJNDI");
            FaqSessionBeanRemoteHome rv = (FaqSessionBeanRemoteHome) PortableRemoteObject.narrow(remote, FaqSessionBeanRemoteHome.class);
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
