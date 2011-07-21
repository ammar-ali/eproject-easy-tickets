/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ticketbook.ejb.cmp;

import java.rmi.RemoteException;
import javax.ejb.CreateException;
import javax.ejb.EJBHome;

/**
 *
 * @author QuocHai
 */
public interface FAQSessionBeanRemoteHome extends EJBHome {

    ticketbook.ejb.cmp.FAQSessionBeanRemote create()  throws CreateException, RemoteException;
    
}
