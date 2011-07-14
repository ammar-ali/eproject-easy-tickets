/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ticketbook.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.rmi.RemoteException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.CreateException;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.rmi.PortableRemoteObject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import ticketbook.ejb.cmp.FaqSessionBeanRemote;
import ticketbook.ejb.cmp.FaqSessionBeanRemoteHome;

/**
 *
 * @author QuocHai
 */
public class FAQsController extends HttpServlet {

    public static final String ANSWER = "txtAnswer";
    public static final String QUESTION = "txtQuestion";
    public static final String CREATE_DATE = "txtCreate_Date";
    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
           String act = request.getParameter("act");
           if(act.equals("insert")){
               String answer = request.getParameter(ANSWER);
               String question = request.getParameter(QUESTION);
               String create_date = request.getParameter(CREATE_DATE);
               FaqSessionBeanRemote remote = lookupFaqSessionBeanRemote();
               remote.insertFAQs(answer, question, create_date);
               RequestDispatcher rd = request.getRequestDispatcher("faq.jsp");
               rd.forward(request, response);
           }}catch(Exception ex){
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
