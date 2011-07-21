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
import ticketbook.model.Ticket;
import ticketbook.ejb.bmp.TicketRemote;
import ticketbook.ejb.bmp.UserRemote;
import ticketbook.model.TicketBooking;
import ticketbook.transfer.TicketBookingTransferData;
import ticketbook.util.Constant;
import ticketbook.util.StringUtil;
import ticketbook.util.TicketBookContextPath;
import ticketbook.util.TicketBookConvert;
import ticketbook.util.TicketBookSession;

/**
 *
 * @author Admin
 */
public class TicketController extends HandlerController {
    public static final String TICKET_TOTAL_CONTROL_NAME="txtTicketTotal";
    public static final String TICKET__PRICE_CONTROL_NAME="txtPrice";
    public static final String TICKET_DISCOUNT_CONTROL_NAME="txtDiscount";
    public static final String TICKETID_CONTROL_NAME="txtTicketID";
    public static final String CARD_NUMBER_CONTROL_NAME="txtCardNumber";
    public static final String PAYMENTTYPE_CONTROL_NAME="selPaymentType";

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
            if(request.getParameter(AdminController.ACTIONTYPE_NAME)!=null){
                if(request.getParameter(AdminController.ACTIONTYPE_NAME).equals(HandlerController.ACTIONTYPE_VALUE_BOOKING)){
                    booking(request, response);
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

    public void booking(HttpServletRequest request,HttpServletResponse response){
        try{
        boolean sttResponse=false;
        String ticketID=TicketBookConvert.castParameterRequestIsNull(request,TICKETID_CONTROL_NAME,"0");
           if(!ticketID.equals("")&&StringUtil.validatePositiveNumber(ticketID)){
                TicketRemote ticketRemote=Ticket.getTicketByID(new Integer(ticketID));
                if(ticketRemote.getViewStatus().equals("New")&&ticketRemote.getTicketTotal().intValue()!=0){
                    String price=TicketBookConvert.castParameterRequestIsNull(request,TICKET__PRICE_CONTROL_NAME, "");
                    String discount=TicketBookConvert.castParameterRequestIsNull(request,TICKET_DISCOUNT_CONTROL_NAME,"");
                    String cardNumber=TicketBookConvert.castParameterRequestIsNull(request,CARD_NUMBER_CONTROL_NAME,"");
                    String ticketTotal=TicketBookConvert.castParameterRequestIsNull(request,TICKET_TOTAL_CONTROL_NAME,"0");
                    String paymentType=TicketBookConvert.castParameterRequestIsNull(request,PAYMENTTYPE_CONTROL_NAME,"");
                    UserRemote userRemote=(UserRemote)TicketBookConvert.castSessionIsNull(request.getSession(),TicketBookSession.USER_LOGIN,null);
                    String username="";
                    if(userRemote!=null){
                        username=userRemote.getUsername();
                    }

                    TicketBookingTransferData ticketBooking=new TicketBookingTransferData();
                    ticketBooking.setTicketID(new Integer(ticketID));
                    ticketBooking.setUsername(username);
                    ticketBooking.setTicketTotal(new Integer(ticketTotal));
                    int priceTotal=(Integer.parseInt(price)-Integer.parseInt(discount))*Integer.parseInt(ticketTotal);
                    int discountTotal=Integer.parseInt(discount)*Integer.parseInt(ticketTotal);
                    ticketBooking.setPriceTotal(""+priceTotal);
                    ticketBooking.setDiscount(""+discountTotal);
                    ticketBooking.setCardNumber(cardNumber);
                    ticketBooking.setPaymentTypeID(new Integer(paymentType));
                    TicketBooking.insert(ticketBooking);
                    if(ticketBooking.getID()!=Constant.ID_FALSE_INTETER){
                        sttResponse=true;
                        if (request.getSession().getAttribute(FormBackController.CONTEXTPATH_ATTRIBUTE_NAME) != null) {
                            ((TicketBookContextPath) request.getSession().getAttribute(FormBackController.CONTEXTPATH_ATTRIBUTE_NAME)).response(response);
                        } else {
                            response.sendRedirect(request.getContextPath() + "/index.jsp");
                        }
                    }

                }

                if(!sttResponse){
                    request.setAttribute("error_ticket","1");
                    request.getRequestDispatcher("/Form/Booking/ticket_book.jsp?ticketID="+ticketID).forward(request, response);
                }
            }
        }
        catch(Exception ex){ex.printStackTrace();}
        finally{}
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
