/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ticketbook.ejb.bmp;

import java.rmi.RemoteException;
import javax.ejb.EJBHome;
import javax.ejb.FinderException;

/**
 *
 * @author Admin
 */
public interface TicketRemoteHome extends EJBHome {

    ticketbook.ejb.bmp.TicketRemote findByPrimaryKey(java.lang.Integer key)  throws FinderException, RemoteException;
    java.util.Collection findByEventTypeID(Integer eventTypeID,int indexRecord,int totalRecord) throws FinderException,RemoteException;
    java.util.Collection findTopByEventTypeID(Integer eventTypeID,int top) throws FinderException,RemoteException;
}
