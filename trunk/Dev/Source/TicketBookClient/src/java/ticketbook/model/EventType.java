/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ticketbook.model;

import java.util.ArrayList;
import ticketbook.ejb.bmp.EventTypeRemoteHome;
import ticketbook.transfer.EventTypeTransferData;
import ticketbook.util.TicketBookLookUpJNDI;
 

/**
 *
 * @author Admin
 */
public class EventType {

    static ArrayList eventTypes;

    // using a private constructor to force use of the factory method.
    private EventType() {
    }

    public static ArrayList getInstanceValue(){
        if(eventTypes==null)
            eventTypes=EventType.values();
        return eventTypes;
    }

    public static void add(EventTypeTransferData data){
        if(eventTypes!=null){
            eventTypes.add(data);
        }else{
            eventTypes=new ArrayList();
            eventTypes.add(data);
        }
    }
   
    private static ArrayList values(){
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
