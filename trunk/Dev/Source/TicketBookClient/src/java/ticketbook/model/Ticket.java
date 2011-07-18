/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ticketbook.model;

import java.rmi.RemoteException;
import java.util.ArrayList;
import javax.ejb.FinderException;
import ticketbook.ejb.bmp.TicketRemoteHome;
import ticketbook.util.TicketBookLookUpJNDI;

/**
 *
 * @author Admin
 */
public class Ticket {

    private Ticket(){}

    public static ArrayList getTicketsByEventTypeID(Integer eventTypeID,Integer cityID,Integer indexRecord,Integer totalRecord){
        TicketRemoteHome home=TicketBookLookUpJNDI.getTicketRemoteHome();
        try {
            return (ArrayList) home.findByEventTypeID(eventTypeID,cityID,indexRecord.intValue(), totalRecord.intValue());
        } catch (FinderException ex) {
            ex.printStackTrace();
        } catch (RemoteException ex) {
            ex.printStackTrace();
        }
        return new ArrayList();
    }

    public static ArrayList getTopTicketsByEventTypeID(Integer eventTypeID,Integer top){
        TicketRemoteHome home=TicketBookLookUpJNDI.getTicketRemoteHome();
        try {
            return (ArrayList) home.findTopByEventTypeID(eventTypeID,top.intValue());
        } catch (FinderException ex) {
            ex.printStackTrace();
        } catch (RemoteException ex) {
            ex.printStackTrace();
        }
        return new ArrayList();
    }

}
