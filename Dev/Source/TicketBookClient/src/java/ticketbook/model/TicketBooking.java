/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ticketbook.model;

import java.rmi.RemoteException;
import javax.ejb.CreateException;
import ticketbook.ejb.bmp.TicketBookingRemote;
import ticketbook.ejb.bmp.TicketBookingRemoteHome;
import ticketbook.transfer.TicketBookingTransferData;
import ticketbook.util.TicketBookLookUpJNDI;

/**
 *
 * @author Admin
 */
public class TicketBooking {
    private TicketBooking(){}
    public static TicketBookingRemote insert(TicketBookingTransferData data){
        try {
            TicketBookingRemoteHome home = TicketBookLookUpJNDI.getTicketBookingRemoteHome();
            return home.create(data);
        } catch (CreateException ex) {
            ex.printStackTrace();
        } catch (RemoteException ex) {
            ex.printStackTrace();
        }
        return null;
    }
}
