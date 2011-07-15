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

import ticketbook.ejb.bmp.UserRemote;
import ticketbook.model.User;
import ticketbook.util.Constant;
import ticketbook.util.TicketBookSession;

/**
 *
 * @author Admin
 */
public class UserController extends HandlerController {


    public static final String USERNAME_CONTROL_NAME = "txtUsername";
    public static final String PASSWORD_CONTROL_NAME = "txtPassword";

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
            if (request.getParameter(FormController.ACTIONTYPE_NAME) != null) {
                if (request.getParameter(FormController.ACTIONTYPE_NAME).equals(HandlerController.ACTIONTYPE_VALUE_LOGIN)) {
                    this.processLogin(request, response);
                }
                else{
                    if(this.handlerController!=null)
                        this.handlerController.processRequest(request, response);
                }
            }
        } finally {
            out.close();
        }
    }

    public void processLogin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getParameter(FormController.ACTIONTYPE_NAME).equals(HandlerController.ACTIONTYPE_VALUE_LOGIN)) {
            UserRemote userRemote = isAccount(request, response);
            if (userRemote != null && userRemote.getRoleID() != Constant.ID_FALSE_INTETER) {
                request.getSession().setAttribute(TicketBookSession.USER_LOGIN, userRemote);
                request.getSession().setAttribute(TicketBookSession.ROLEID_USER_LOGIN, userRemote.getRoleID());
                response.sendRedirect(request.getContextPath() + "/index.jsp");
            } else {
                request.setAttribute("alert_login", "Invalid Account");
                request.getRequestDispatcher("/Form/login.jsp").forward(request, response);
            }
        }
    }

    private UserRemote isAccount(HttpServletRequest request, HttpServletResponse response) {
        UserRemote remote = null;
        try {
            String username = "";
            String password = "";
            if (request.getParameter(UserController.USERNAME_CONTROL_NAME) != null) {
                username = request.getParameter(UserController.USERNAME_CONTROL_NAME);
            }
            if (request.getParameter(UserController.PASSWORD_CONTROL_NAME) != null) {
                password = request.getParameter(UserController.PASSWORD_CONTROL_NAME);
            }
            
            remote = User.getByUsernameAndPassword(username, password);

        } catch (Exception ex) {
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
