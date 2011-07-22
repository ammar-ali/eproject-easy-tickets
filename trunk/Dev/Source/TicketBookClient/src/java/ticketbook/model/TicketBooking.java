/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ticketbook.model;

import java.rmi.RemoteException;
import java.util.ArrayList;
import javax.ejb.CreateException;
import javax.ejb.FinderException;
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

    public static ArrayList getAllBookingByStatus(String status,Integer indexStart,Integer totalRecord){
        try {
            TicketBookingRemoteHome home = TicketBookLookUpJNDI.getTicketBookingRemoteHome();
            return (ArrayList)home.findAllByStatus(status,indexStart.intValue(), totalRecord.intValue());
        } catch (FinderException ex) {
            ex.printStackTrace();
        } catch (RemoteException ex) {
            ex.printStackTrace();
        }
        return new ArrayList();
    }
}
