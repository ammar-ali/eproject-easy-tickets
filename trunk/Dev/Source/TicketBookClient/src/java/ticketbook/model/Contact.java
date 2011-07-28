/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ticketbook.model;

import java.rmi.RemoteException;    
import java.util.Vector;
import ticketbook.ejb.cmp.ContactSessionBeanRemote;
import ticketbook.util.TicketBookLookUpJNDI;

/**
 *
 * @author QuocHai
 */
public class Contact {
    private Contact(){}
    public static Vector getAll(){
        try {
            ContactSessionBeanRemote remote = TicketBookLookUpJNDI.getContactSessionBeanRemote();
            Vector contact = (Vector) remote.ejbFindAllContact();
            return contact;
        }catch (RemoteException re){
            re.printStackTrace();
        }
        return new Vector();
    }

}
