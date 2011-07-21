/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ticketbook.controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import ticketbook.util.TicketBookSession;

/**
 *
 * @author Admin
 */
public class BookingController extends HttpServlet {
       public static final String ACTIONTYPE_NAME="actionType";

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
            boolean stt=false;
            if(request.getSession()!=null){
               HttpSession sessionRoleID=request.getSession();
               Object attributeRoleID=sessionRoleID.getAttribute(TicketBookSession.ROLEID_USER_LOGIN);
               if(attributeRoleID!=null){
                   if(((Integer)attributeRoleID).intValue()!=0){
                       TicketController ticketController=new TicketController();
                       ticketController.processRequest(request, response);

                       stt=true;
                   }
               }
            }
            if(!stt){
                response.sendRedirect(request.getContextPath()+"/Form/error.jsp?stt=0");
            }
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
