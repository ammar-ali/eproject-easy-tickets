/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ticketbook.ejb.bmp;

import java.rmi.RemoteException;
import java.util.Enumeration;

import javax.ejb.CreateException;

import javax.ejb.EJBHome;
import javax.ejb.FinderException;
import ticketbook.transfer.UserTransferData;

/**
 *
 * @author Admin
 */
public interface UserRemoteHome extends EJBHome {

    ticketbook.ejb.bmp.UserRemote findByPrimaryKey(java.lang.Integer key)  throws FinderException, RemoteException;
    ticketbook.ejb.bmp.UserRemote create(UserTransferData user) throws CreateException,RemoteException;
    Enumeration findAll() throws FinderException,RemoteException;
}
