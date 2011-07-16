/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ticketbook.util;

/**
 *
 * @author Admin
 */
public class TicketBookParameter {

    String pathImageEvent;

    public TicketBookParameter(){
        pathImageEvent=TicketBookBundle.getSystemParameter().getString("path_image_event");
    }

    public String getPathImageEvent() {
        return pathImageEvent;
    }


}
