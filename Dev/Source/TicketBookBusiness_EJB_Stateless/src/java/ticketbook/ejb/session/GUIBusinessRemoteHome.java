/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ticketbook.ejb.session;

import java.rmi.RemoteException;
import javax.ejb.CreateException;
import javax.ejb.EJBHome;

/**
 *
 * @author Admin
 */
public interface GUIBusinessRemoteHome extends EJBHome {

    ticketbook.ejb.session.GUIBusinessRemote create()  throws CreateException, RemoteException;
    
}
