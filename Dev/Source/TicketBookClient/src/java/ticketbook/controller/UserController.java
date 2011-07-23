/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ticketbook.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.rmi.RemoteException;
import javax.ejb.FinderException;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ticketbook.ejb.bmp.UserRemote;

import ticketbook.model.Date;
import ticketbook.model.User;
import ticketbook.transfer.UserTransferData;
import ticketbook.util.Constant;
import ticketbook.util.TicketBookContextPath;

import ticketbook.util.TicketBookParameter;
import ticketbook.util.TicketBookSession;

/**
 *
 * @author Admin
 */
public class UserController extends HandlerController {

    public static final String USERNAME_CONTROL_NAME = "txtUsername";
    public static final String PASSWORD_CONTROL_NAME = "txtPassword";
    public static final String FULLNAME_CONTROL_NAME = "txtFullName";
    public static final String PHONE_CONTROL_NAME = "txtPhone";
    public static final String ADDRESS_CONTROL_NAME = "txtAddress";
    public static final String EMAIL_CONTROL_NAME = "txtEmail";
    public static final String BIRTHDAY_CONTROL_NAME = "txtBirthday";
    public static final String PERSONCARDNUMBER_CONTROL_NAME = "txtPersonCardNumber";

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    public void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, RemoteException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            if (request.getParameter(HandlerController.ACTIONTYPE_NAME) != null) {
                if (request.getParameter(HandlerController.ACTIONTYPE_NAME).equals(HandlerController.ACTIONTYPE_VALUE_LOGIN)) {
                    this.processLogin(request, response);
                } else if (request.getParameter(HandlerController.ACTIONTYPE_NAME).equals(HandlerController.ACTIONTYPE_VALUE_REGISTER_MEMBER)) {
                    try {
                        this.registerMember(request, response);
                    } catch (FinderException ex) {
                        ex.printStackTrace();
                    }
                } else {
                    if (this.handlerController != null) {
                        this.handlerController.processRequest(request, response);
                    }
                }
            }
        } finally {
            out.close();
        }
    }

    public void processLogin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getParameter(HandlerController.ACTIONTYPE_NAME).equals(HandlerController.ACTIONTYPE_VALUE_LOGIN)) {
            UserRemote userRemote = isAccount(request, response);
            if (userRemote != null && !userRemote.getRoleID().equals(Constant.ID_FALSE_INTETER)) {
                request.getSession().setAttribute(TicketBookSession.USER_LOGIN, userRemote);
                request.getSession().setAttribute(TicketBookSession.ROLEID_USER_LOGIN, userRemote.getRoleID());
                if (request.getSession().getAttribute(FormBackController.CONTEXTPATH_ATTRIBUTE_NAME) != null) {
                    ((TicketBookContextPath) request.getSession().getAttribute(FormBackController.CONTEXTPATH_ATTRIBUTE_NAME)).response(response);
                } else {
                    if (userRemote.getRoleID().intValue() == TicketBookParameter.getInstance().getAdminRoleID()) {
                        response.sendRedirect(request.getContextPath() + "/Form/Admin/admin.jsp?name=booking&stt=0");
                    } else {
                        response.sendRedirect(request.getContextPath() + "/index.jsp");
                    }
                }
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

    public void registerMember(HttpServletRequest request, HttpServletResponse response) throws RemoteException, FinderException {
        UserTransferData data = new UserTransferData();
        String username = "";
        if (request.getParameter(USERNAME_CONTROL_NAME) != null) {
            username = request.getParameter(USERNAME_CONTROL_NAME);
        }

        UserRemote user = User.getByUsername(username);

        if (user.getRoleID().equals(Constant.ID_FALSE_INTETER) && !username.equals("")) {
            data.setRoleID(new Integer(TicketBookParameter.getInstance().getCustomerRoleID()));
            data.setUsername(request.getParameter(USERNAME_CONTROL_NAME));
            String birthday = "";
            if (request.getParameter(BIRTHDAY_CONTROL_NAME) != null) {

                birthday = request.getParameter(BIRTHDAY_CONTROL_NAME);
            }
            if (Date.diffDate(birthday, Date.getDateCurrent()) >= 0) {
                data.setBirthDate(request.getParameter(BIRTHDAY_CONTROL_NAME));
                if (request.getParameter(PASSWORD_CONTROL_NAME) != null) {
                    data.setPassword(request.getParameter(PASSWORD_CONTROL_NAME));
                }
                if (request.getParameter(FULLNAME_CONTROL_NAME) != null) {
                    data.setFullname(request.getParameter(FULLNAME_CONTROL_NAME));
                }
                if (request.getParameter(PHONE_CONTROL_NAME) != null) {
                    data.setPhone(request.getParameter(PHONE_CONTROL_NAME));
                }
                if (request.getParameter(PERSONCARDNUMBER_CONTROL_NAME) != null) {
                    data.setPersonCardNumber(request.getParameter(PERSONCARDNUMBER_CONTROL_NAME));
                }
                if (request.getParameter(ADDRESS_CONTROL_NAME) != null) {
                    data.setAddress(request.getParameter(ADDRESS_CONTROL_NAME));
                }

                if (request.getParameter(EMAIL_CONTROL_NAME) != null) {
                    data.setEmail(request.getParameter(EMAIL_CONTROL_NAME));
                }

                try {
                    User.create(data);
                    response.sendRedirect(request.getContextPath() + "/Form/login.jsp?register=yes");
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            } else {
                request.setAttribute("alertRegister_Birthday", "Invalid birthday");
                try {
                    request.getRequestDispatcher("/Form/register.jsp").forward(request, response);
                } catch (ServletException ex) {
                    ex.printStackTrace();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        } else {
            request.setAttribute("alertRegister", "Username already exists");
            try {
                request.getRequestDispatcher("/Form/register.jsp").forward(request, response);
            } catch (ServletException ex) {
                ex.printStackTrace();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
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
