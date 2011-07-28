/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ticketbook.model;

import java.rmi.RemoteException;
import java.util.Vector;
import ticketbook.ejb.cmp.FaqSessionBeanRemote;
import ticketbook.util.TicketBookLookUpJNDI;

/**
 *
 * @author QuocHai
 */
public class FAQ {

    private FAQ(){}
    public static Vector getAll(){
        try {
            FaqSessionBeanRemote remote = TicketBookLookUpJNDI.getFaqSessionBeanRemote();
             Vector faq = (Vector) remote.ejbFindAllFAQs();
            return faq;
        } catch (RemoteException ex) {
            ex.printStackTrace();
        }
        return new Vector();

    }
}
