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

    
    public static final String ACTIONTYPE_NAME="actionType";

    public static final String ACTIONTYPE_VALUE_LOGIN = "login";
    public static final String ACTIONTYPE_VALUE_REGISTER_MEMBER="register_member";
    public static final String ACTIONTYPE_VALUE_BOOKING="booking";
    public static final String ACTIONTYPE_VALUE_INSERT_FAQ = "insert_faq";
    public static final String ACTIONTYPE_VALUE_DELETE_FAQ = "delete_faq";
    public static final String ACTIONTYPE_VALUE_UPDATE_FAQ = "update_faq";
    public static final String ACTIONTYPE_VALUE_CREATE_CONTACT_MESSAGE = "create_message";
    public static final String ACTIONTYPE_VALUE_ANSWER_CONTACT_MESSAGE = "answer_message";
    public static final String ACTIONTYPE_VALUE_DELETE_CONTACT_MESSAGE = "delete_message";
    public static final String ACTIONTYPE_VALUE_UPDATE_BOOKING_STATUS = "update_booking_status";
    public static final String ACTIONTYPE_VALUE_CREATE_EVENT="create_event";
}
