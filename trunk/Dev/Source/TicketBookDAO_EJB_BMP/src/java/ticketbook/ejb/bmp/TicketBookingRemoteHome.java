/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ticketbook.ejb.bmp;

import java.rmi.RemoteException;
import java.util.Collection;
import javax.ejb.CreateException;
import javax.ejb.EJBHome;
import javax.ejb.FinderException;
import ticketbook.transfer.TicketBookingTransferData;

/**
 *
 * @author Admin
 */
public interface TicketBookingRemoteHome extends EJBHome {

    ticketbook.ejb.bmp.TicketBookingRemote findByPrimaryKey(java.lang.Integer key)  throws FinderException, RemoteException;

    TicketBookingRemote create(TicketBookingTransferData data) throws CreateException,RemoteException;
    Collection findAllByStatus(String status,int indexStart,int totalRecord) throws FinderException,RemoteException;
}
