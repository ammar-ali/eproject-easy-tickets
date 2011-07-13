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
public interface UserRemoteHome extends EJBHome {

    ticketbook.ejb.bmp.UserRemote findByPrimaryKey(java.lang.String key)  throws FinderException, RemoteException;
    ticketbook.ejb.bmp.UserRemote findByUsernameAndPassword(String username,String password) throws FinderException,RemoteException;
}
