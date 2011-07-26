/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ticketbook.model;

import java.rmi.RemoteException;
import java.util.ArrayList;
import javax.ejb.CreateException;
import ticketbook.ejb.cmp.ContactSessionBeanRemote;
import ticketbook.util.TicketBookLookUpJNDI;

/**
 *
 * @author QuocHai
 */
public class Contact {
    private Contact(){}
    public static ArrayList getAll(){
        try {
            ContactSessionBeanRemote remote = TicketBookLookUpJNDI.getContactSessionBeanRemoteHome().create();
            ArrayList contact = (ArrayList) remote.ejbFindAllContact();
            return contact;
        } catch (CreateException ce) {
            ce.printStackTrace();
        }catch (RemoteException re){
            re.printStackTrace();
        }
        return new ArrayList();
    }

}
