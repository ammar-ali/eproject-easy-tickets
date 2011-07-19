/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ticketbook.ejb.bmp;

import java.rmi.RemoteException;
import java.util.Collection;
import javax.ejb.EJBHome;
import javax.ejb.FinderException;

/**
 *
 * @author Admin
 */
public interface PaymentTypeRemoteHome extends EJBHome {

    ticketbook.ejb.bmp.PaymentTypeRemote findByPrimaryKey(java.lang.Integer key)  throws FinderException, RemoteException;
    Collection findAll() throws FinderException,RemoteException;
}
