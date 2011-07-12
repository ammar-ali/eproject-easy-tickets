/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ticketbook.model;

import java.util.ArrayList;
import javax.naming.NamingException;
import ticketbook.ejb.session.GUIBusinessRemote;
import ticketbook.ejb.session.GUIBusinessRemoteHome;
import ticketbook.exception.ConfigException;
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
            GUIBusinessRemoteHome home = TicketBookLookUpJNDI.getGUIBusinessRemoteHome();
            GUIBusinessRemote remote = home.create();
            eventTypes = remote.getEventTypes();

        } catch (Exception ex) {
            ex.printStackTrace();
        } 
        return eventTypes;
    }

 
}
