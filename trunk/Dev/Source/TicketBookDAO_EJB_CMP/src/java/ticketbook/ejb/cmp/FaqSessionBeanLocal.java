/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ticketbook.ejb.cmp;

import java.rmi.RemoteException;
import java.util.Collection;
import javax.ejb.EJBLocalObject;
import javax.ejb.FinderException;

/**
 *
 * @author QuocHai
 */
public interface FaqSessionBeanLocal extends EJBLocalObject {

    void insertFAQs(String question, String answer, String create_date, String username);

    void updateFAQs(int id, String question, String answer, String username);

    void deleteFAQs(String id);

    Collection ejbFindAllFAQs() throws FinderException;
    
}
