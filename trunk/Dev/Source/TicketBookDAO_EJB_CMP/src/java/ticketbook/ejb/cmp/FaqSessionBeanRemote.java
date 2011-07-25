/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ticketbook.ejb.cmp;

import java.rmi.RemoteException;
import java.util.Collection;
import javax.ejb.EJBObject;

/**
 *
 * @author QuocHai
 */
public interface FaqSessionBeanRemote extends EJBObject {

    void insertFAQs(String question, String answer, String create_date, String username) throws RemoteException;

    void updateFAQs(Integer id, String question, String answer, String username) throws RemoteException;

    void deleteFAQs(String id) throws RemoteException;

    Collection ejbFindAllFAQs() throws RemoteException;
    
}
