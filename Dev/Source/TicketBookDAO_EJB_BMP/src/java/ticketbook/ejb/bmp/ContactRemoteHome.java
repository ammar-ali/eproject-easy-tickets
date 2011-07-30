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
import ticketbook.transfer.ContactTransferData;

/**
 *
 * @author QuocHai
 */
public interface ContactRemoteHome extends EJBHome {

    ticketbook.ejb.bmp.ContactRemote findByPrimaryKey(java.lang.Integer key)  throws FinderException, RemoteException;

    Collection findAll(int index, int total) throws FinderException, RemoteException;

    ContactRemote create(ContactTransferData data) throws CreateException, RemoteException;
}
