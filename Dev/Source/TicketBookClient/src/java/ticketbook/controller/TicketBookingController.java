
package ticketbook.controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import ticketbook.util.StringUtil;
import ticketbook.util.TicketBookParameter;

/**
 *
 * @author ${user}
 */

public class TicketBookingController extends HandlerController {

   public static final String TICKETBOOKID_CONTROL_NAME="txtTicketBookID";

    public static final String TEMP_TICKETBOOK_CHECKBOX_CONTROL_NAME="ckbTicket";

    public static final String TEMP_LENGTH_TICKETBOOK_CHECKBOX_CONTROL_NAME="txtLengthCkbTicket";

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
                if(request.getParameter(HandlerController.ACTIONTYPE_NAME).equals(HandlerController.ACTIONTYPE_VALUE_UPDATE_BOOKING_STATUS)){
                    updateBookingStatus(request,response);
                }
                else{
                    if(handlerController!=null)
                        handlerController.processRequest(request, response);
                }
            }
        } finally { 
            out.close();
        }
    }

    public void updateBookingStatus(HttpServletRequest request,HttpServletResponse response){
        try {
            if(request.getParameter(TEMP_LENGTH_TICKETBOOK_CHECKBOX_CONTROL_NAME)!=null){
                if(StringUtil.validatePositiveNumber(request.getParameter(TEMP_LENGTH_TICKETBOOK_CHECKBOX_CONTROL_NAME))){
                    int total=Integer.parseInt(request.getParameter(TEMP_LENGTH_TICKETBOOK_CHECKBOX_CONTROL_NAME));
                    for(int i=0;i<total;i++){
                        Integer ticketBookingID=new Integer(request.getParameter(TICKETBOOKID_CONTROL_NAME+i));
                        String tempCheckStatus=request.getParameter(TEMP_TICKETBOOK_CHECKBOX_CONTROL_NAME+i);
                        if(tempCheckStatus!=null){
                            if(tempCheckStatus.equals("true")){
                                
                            }
                        }
                    }
                    response.sendRedirect(request.getContextPath()+"/Form/Admin/admin.jsp?name=booking&stt="+TicketBookParameter.getInstance().getNewStatusTicketBooking());
            
                }
                else{
                    
                }
            }
            else{

            }

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    // <editor-fold defaultstate="collapsed" desc="${servletEditorFold}">
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
