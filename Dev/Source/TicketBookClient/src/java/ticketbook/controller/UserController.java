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
import ticketbook.ejb.bmp.UserRemote;
import ticketbook.model.User;
import ticketbook.util.TicketBookSession;

/**
 *
 * @author Admin
 */
public class UserController extends HttpServlet {
    public static final String ACTIONTYPE_NAME="actionType";
    public static final String ACTIONTYPE_VALUE_LOGIN="login";
    public static final String USERNAME_CONTROL_NAME="txtUsername";
    public static final String PASSWORD_CONTROL_NAME="txtUsername";
    
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
            if(request.getParameter(ACTIONTYPE_NAME)!=null){
                if(request.getParameter(ACTIONTYPE_NAME).equals(ACTIONTYPE_VALUE_LOGIN)){
                    UserRemote userRemote=isAccount(request, response);
                    if(userRemote!=null&&userRemote.getRoleID().intValue()!=0){
                        request.getSession().setAttribute(TicketBookSession.USER_LOGIN,userRemote);
                        request.getSession().setAttribute(TicketBookSession.ROLEID_USER_LOGIN,userRemote.getRoleID());
                        response.sendRedirect(request.getContextPath()+"/index.jsp");
                    }else {
                        request.setAttribute("alert_login","Invalid Account");
                        request.getRequestDispatcher("/Form/login.jsp").forward(request, response);
                    }
                }
            }
        } finally { 
            out.close();
        }
    }

    public UserRemote isAccount(HttpServletRequest request, HttpServletResponse response){
        UserRemote remote=null;
        try {
            String username="";
            String password="";
            if(request.getParameter(UserController.USERNAME_CONTROL_NAME)!=null){
                username=request.getParameter(UserController.USERNAME_CONTROL_NAME);
            }
            if(request.getParameter(UserController.PASSWORD_CONTROL_NAME)!=null){
                password=request.getParameter(UserController.PASSWORD_CONTROL_NAME);
            }
            remote = User.getByUsernameAndpassword(username, password);
                
        }
        catch (Exception ex) {
             ex.printStackTrace();
        }

        return remote;
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
