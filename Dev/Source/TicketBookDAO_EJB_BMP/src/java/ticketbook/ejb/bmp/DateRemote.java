/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ticketbook.ejb.bmp;

import java.rmi.RemoteException;
import javax.ejb.EJBObject;

/**
 *
 * @author vostro
 */
public interface DateRemote extends EJBObject {
    public String getDateCurrent() throws RemoteException;
    public int diffDate(String date1,String date2) throws RemoteException;
}
