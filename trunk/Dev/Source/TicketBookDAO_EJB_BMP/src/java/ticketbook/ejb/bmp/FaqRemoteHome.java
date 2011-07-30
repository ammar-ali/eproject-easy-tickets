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
import ticketbook.transfer.FaqTransferData;

/**
 *
 * @author QuocHai
 */
public interface FaqRemoteHome extends EJBHome {

    ticketbook.ejb.bmp.FaqRemote findByPrimaryKey(java.lang.Integer key)  throws FinderException, RemoteException;

    Collection findAll(int index, int total) throws FinderException, RemoteException;

    FaqRemote create(FaqTransferData data) throws CreateException, RemoteException;
    
}
