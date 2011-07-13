/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ticketbook.model;

import java.util.ArrayList;
import ticketbook.ejb.bmp.EventTypeRemoteHome;
import ticketbook.util.TicketBookLookUpJNDI;


/**
 *
 * @author Admin
 */
public class EventType {


    // using a private constructor to force use of the factory method.
    private EventType() {
    }

   
    public static ArrayList values(){
        ArrayList eventTypes=new ArrayList();
        try {
            EventTypeRemoteHome home = TicketBookLookUpJNDI.getEventTypeRemoteHome();
            eventTypes=(ArrayList) home.findAll();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return eventTypes;
    }

 
}
