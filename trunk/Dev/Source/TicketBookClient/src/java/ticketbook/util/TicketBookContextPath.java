/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ticketbook.util;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Admin
 */
public class TicketBookContextPath {

    boolean enable=false;

    String pathBack="";
    String pathTo="";

    public void setPath(String pathTo,String pathBack){
        this.pathBack=pathBack;
        this.pathTo=pathTo;
    }

    public void request(){
        this.enable = true;
    }

    public void closeRequest(){
        this.enable=false;
    }

    public void forward(HttpServletRequest request,HttpServletResponse response){
        if(this.enable){
            try {
                request.getRequestDispatcher(pathTo).forward(request, response);
            } catch (ServletException ex) {
                ex.printStackTrace();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

    public void response(HttpServletResponse response){
        try {
            this.enable = false;
            response.sendRedirect(pathBack);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
