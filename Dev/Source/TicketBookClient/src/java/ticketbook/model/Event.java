/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ticketbook.model;

import java.rmi.RemoteException;
import javax.ejb.CreateException;
import ticketbook.ejb.bmp.EventRemote;
import ticketbook.ejb.bmp.EventRemoteHome;
import ticketbook.transfer.EventTransferData;
import ticketbook.util.TicketBookLookUpJNDI;

/**
 *
 * @author Admin
 */
public class Event{
    public static EventRemote createEvent(EventTransferData event){
        EventRemoteHome eventHome=TicketBookLookUpJNDI.getEventRemoteHome();
        try {
            return eventHome.create(event);
        } catch (CreateException ex) {
            ex.printStackTrace();
        } catch (RemoteException ex) {
            ex.printStackTrace();
        }
        return null;
    }
}
