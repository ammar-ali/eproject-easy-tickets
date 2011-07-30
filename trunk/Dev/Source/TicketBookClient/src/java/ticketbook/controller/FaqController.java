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
 * @author QuocHai
 */
public class FaqController extends HandlerController {

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
            if(request.getParameter(HandlerController.ACTIONTYPE_NAME)!=null){
                if(request.getParameter(HandlerController.ACTIONTYPE_NAME).equals(HandlerController.ACTIONTYPE_VALUE_INSERT_FAQ)){
                    //this.insertFAQs(request, response);
                }else if (request.getParameter(HandlerController.ACTIONTYPE_NAME).equals(HandlerController.ACTIONTYPE_VALUE_UPDATE_FAQ)){
                   // this.updateFAQs(request, response);
                }else if(request.getParameter(HandlerController.ACTIONTYPE_NAME).equals(HandlerController.ACTIONTYPE_VALUE_DELETE_FAQ)){
                    //this.deleteFAQs(request, response);
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
}