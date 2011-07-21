/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ticketbook.ejb.cmp;

import java.rmi.RemoteException;
import java.sql.Timestamp;
import javax.ejb.EJBObject;

/**
 *
 * @author QuocHai
 */
public interface FAQSessionBeanRemote extends EJBObject {

    void insertFAQs(Integer id, String answer, String question, Timestamp create_date, Integer username) throws RemoteException;

    void updateFAQs(Integer id, String answer, String question) throws RemoteException;

    void deleteFAQs(Integer id) throws RemoteException;
}
