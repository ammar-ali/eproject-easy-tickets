/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ticketbook.ejb.bmp;

import java.rmi.RemoteException;
import java.util.Enumeration;
import javax.ejb.EJBHome;
import javax.ejb.FinderException;

/**
 *
 * @author Admin
 */
public interface EventTypeRemoteHome extends EJBHome {

    ticketbook.ejb.bmp.EventTypeRemote findByPrimaryKey(java.lang.Integer key)  throws FinderException, RemoteException;
    Enumeration findAll() throws FinderException,RemoteException;
}
