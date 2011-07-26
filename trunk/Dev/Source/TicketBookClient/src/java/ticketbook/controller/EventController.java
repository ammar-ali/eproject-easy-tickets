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
import ticketbook.model.Event;
import ticketbook.transfer.EventTransferData;

/**
 *
 * @author Admin
 */
public class EventController extends HandlerController {
   
    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    public static final String TITLE_CONTROL_NAME="txtTitle";
    public static final String CONTENT_CONTROL_NAME="txtContent";
    public static final String ARTIST_CONTROL_NAME="txtArtist";
    public static final String IMAGE_CONTROL_NAME="txtImage";
    public static final String CITY_CONTROL_NAME="selCity";
    public static final String VENUE_CONTROL_NAME="selVenue";
    public static final String EVENTTYPE_CONTROL_NAME="selEventType";

    public  void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            if (request.getParameter(HandlerController.ACTIONTYPE_NAME) != null) {
                if (request.getParameter(HandlerController.ACTIONTYPE_NAME).equals(HandlerController.ACTIONTYPE_VALUE_CREATE_EVENT)) {
                    this.createEvent(request, response);
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

    private void createEvent(HttpServletRequest request, HttpServletResponse response) {
        EventTransferData event=new EventTransferData();
        boolean stt=true;
        if(request.getParameter(TITLE_CONTROL_NAME)!=null){
            event.setTitle(request.getParameter(TITLE_CONTROL_NAME));
        }else stt=false;
        if(request.getParameter(ARTIST_CONTROL_NAME)!=null){
            event.setArtist(request.getParameter(ARTIST_CONTROL_NAME));

        }else stt=false;
        if(request.getParameter(CONTENT_CONTROL_NAME)!=null){
            event.setContent(request.getParameter(CONTENT_CONTROL_NAME));

        }else stt=false;
        if(request.getParameter(IMAGE_CONTROL_NAME)!=null){
            event.setImage(request.getParameter(IMAGE_CONTROL_NAME));

        }else stt=false;
        if(request.getParameter(CITY_CONTROL_NAME)!=null){
            event.setCityID(new Integer(request.getParameter(CITY_CONTROL_NAME)));

        }else stt=false;
        if(request.getParameter(VENUE_CONTROL_NAME)!=null){
            event.setVenueID(new Integer(request.getParameter(VENUE_CONTROL_NAME)));

        }else stt=false;
        if(request.getParameter(EVENTTYPE_CONTROL_NAME)!=null){
            event.setEventTypeID(new Integer(request.getParameter(EVENTTYPE_CONTROL_NAME)));

        }else stt=false;
        

        if(stt){
            try {
                Event.createEvent(event);
                response.sendRedirect(request.getContextPath() + "/Form/Admin/admin.jsp?name=ticket");
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        else{
            try {
                request.getRequestDispatcher("/Form/Admin/admin.jsp?name=ticket").forward(request, response);
            } catch (ServletException ex) {
                ex.printStackTrace();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

}
