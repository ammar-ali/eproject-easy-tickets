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
public interface VenueRemote extends EJBObject {

    public void setAddress(String address) throws RemoteException;

    public void setName(String name) throws RemoteException;

    public Integer getID() throws RemoteException;

    public String getAddress() throws RemoteException;

    public String getName() throws RemoteException;

    public void setID(Integer ID) throws RemoteException;
}
