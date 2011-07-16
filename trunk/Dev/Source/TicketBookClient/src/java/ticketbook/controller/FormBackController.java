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
import ticketbook.util.TicketBookContextPath;
import ticketbook.util.TicketBookSession;

/**
 *
 * @author Admin
 */
public class FormBackController extends HttpServlet {
   
    public static String PATH_TO_CONTROL_NAME="pathTo";
    public static String PATH_BACK_CONTROL_NAME="pathBack";
    public static String CONTEXTPATH_ATTRIBUTE_NAME="ticket_book_context_path";

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
            String pathTo="";
            String pathBack="";
            if(request.getParameter(PATH_TO_CONTROL_NAME)!=null){
                pathTo=request.getParameter(PATH_TO_CONTROL_NAME);
            }

            if(request.getParameter(PATH_BACK_CONTROL_NAME)!=null){
                pathBack=request.getParameter(PATH_BACK_CONTROL_NAME);
            }
            try{
                if(!pathTo.equals("")&&!pathBack.equals("")){
                    TicketBookContextPath contextPath=new TicketBookContextPath();
                    contextPath.setPath(pathTo, pathBack);
                    contextPath.request();
                    request.getSession().setAttribute(TicketBookSession.CONTEXTPATH_ATTRIBUTE_NAME,contextPath);
                    contextPath.forward(request,response);
                }
                else
                    response.sendError(404);
            }catch(Exception ex){
                ex.printStackTrace();
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
