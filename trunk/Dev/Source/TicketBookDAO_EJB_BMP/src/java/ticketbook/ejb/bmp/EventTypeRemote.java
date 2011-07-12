/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ticketbook.ejb.bmp;

import java.rmi.RemoteException;
import javax.ejb.EJBObject;

/**
 *
 * @author Admin
 */
public interface EventTypeRemote extends EJBObject {

    public Integer getID() throws RemoteException;

    public void setID(Integer ID) throws RemoteException ;

    public String getName() throws RemoteException;

    public void setName(String name) throws RemoteException;
}
