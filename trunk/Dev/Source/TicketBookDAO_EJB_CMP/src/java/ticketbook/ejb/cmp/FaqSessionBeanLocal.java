/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ticketbook.ejb.cmp;

import java.sql.Timestamp;
import java.util.Vector;
import javax.ejb.EJBLocalObject;
import javax.ejb.FinderException;

/**
 *
 * @author QuocHai
 */
public interface FaqSessionBeanLocal extends EJBLocalObject {

    void insertFAQs(String question, String answer, Timestamp create_date, String username);

    void updateFAQs(Integer id, String question, String answer, String username);

    void deleteFAQs(Integer id);

    Vector ejbFindAllFAQs() throws FinderException;
    
}
