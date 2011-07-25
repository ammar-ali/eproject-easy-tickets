/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ticketbook.ejb.cmp;

import java.rmi.RemoteException;
import java.sql.Timestamp;
import java.util.Collection;
import javax.ejb.EJBObject;

/**
 *
 * @author QuocHai
 */
public interface FaqSessionBeanRemote extends EJBObject {

    void insertFAQs(String question, String answer, Timestamp create_date, String username) throws RemoteException;

    void updateFAQs(Integer id, String question, String answer, String username) throws RemoteException;

    void deleteFAQs(Integer id) throws RemoteException;

    Collection ejbFindAllFAQs() throws RemoteException;
    
}
