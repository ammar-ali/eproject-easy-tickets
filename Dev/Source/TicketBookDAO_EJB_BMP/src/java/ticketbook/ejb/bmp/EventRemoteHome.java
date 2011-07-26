/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ticketbook.ejb.bmp;

import java.rmi.RemoteException;
import javax.ejb.CreateException;
import javax.ejb.EJBHome;
import javax.ejb.FinderException;
import ticketbook.transfer.EventTransferData;

/**
 *
 * @author Admin
 */
public interface EventRemoteHome extends EJBHome {

    ticketbook.ejb.bmp.EventRemote findByPrimaryKey(java.lang.Integer key)  throws FinderException, RemoteException;
    EventRemote create(EventTransferData event) throws CreateException,RemoteException;
}
