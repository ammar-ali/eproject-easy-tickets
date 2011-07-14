/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ticketbook.ejb.cmp;

import java.rmi.RemoteException;
import javax.ejb.EJBObject;

/**
 *
 * @author QuocHai
 */
public interface FaqSessionBeanRemote extends EJBObject {

    void insertFAQs(String answer, String question, String create_date) throws RemoteException;

    void updateFAQs(Integer id, String answer, String question) throws RemoteException;

    void deleteFAQs(Integer id) throws RemoteException;
    
}
