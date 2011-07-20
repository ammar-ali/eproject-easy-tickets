/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ticketbook.ejb.bmp;

import java.rmi.RemoteException;
import javax.ejb.CreateException;
import javax.ejb.EJBHome;
import javax.ejb.FinderException;

/**
 *
 * @author vostro
 */
public interface DateRemoteHome extends EJBHome {

    ticketbook.ejb.bmp.DateRemote findByPrimaryKey(java.lang.String key)  throws FinderException, RemoteException;
    
    DateRemote create() throws CreateException,RemoteException;
}
