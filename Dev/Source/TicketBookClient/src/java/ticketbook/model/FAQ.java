/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ticketbook.model;

import java.rmi.RemoteException;
import java.util.ArrayList;
import javax.ejb.CreateException;
import ticketbook.ejb.cmp.FaqSessionBeanRemote;
import ticketbook.util.TicketBookLookUpJNDI;

/**
 *
 * @author QuocHai
 */
public class FAQ {

    private FAQ(){}
    public static ArrayList getAll(){
        try {
            FaqSessionBeanRemote remote = TicketBookLookUpJNDI.getFaqSessionBeanRemoteHome().create();
            ArrayList faq = (ArrayList) remote.ejbFindAllFAQs();
            return faq;
        } catch (CreateException ex) {
            ex.printStackTrace();
        } catch (RemoteException ex) {
            ex.printStackTrace();
        }
        return new ArrayList();

    }
}
