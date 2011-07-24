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
public interface VenueRemoteHome extends EJBHome {

    ticketbook.ejb.bmp.VenueRemote findByPrimaryKey(java.lang.Integer key)  throws FinderException, RemoteException;
    Collection findAllVenue() throws FinderException,RemoteException;
}
