/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ticketbook.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Admin
 */
public abstract class HandlerController extends HttpServlet {

    protected HandlerController handlerController;

    public void setHandlerController(HandlerController handlerController){
        this.handlerController=handlerController;
    }
    
    public abstract void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;

    public static final String ACTIONTYPE_VALUE_LOGIN = "login";
    public static final String ACTIONTYPE_VALUE_REGISTER_MEMBER="register_member";
}
