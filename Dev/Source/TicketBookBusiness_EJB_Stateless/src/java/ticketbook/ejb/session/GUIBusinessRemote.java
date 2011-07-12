/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ticketbook.ejb.session;

import java.rmi.RemoteException;
import java.util.ArrayList;

import javax.ejb.EJBObject;

/**
 *
 * @author Admin
 */
public interface GUIBusinessRemote extends EJBObject {

    public ArrayList getEventTypes() throws RemoteException;
}
