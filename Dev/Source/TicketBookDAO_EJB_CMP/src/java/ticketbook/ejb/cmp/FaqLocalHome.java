/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ticketbook.ejb.cmp;

import java.sql.Timestamp;
import java.util.Collection;
import javax.ejb.CreateException;
import javax.ejb.EJBLocalHome;
import javax.ejb.FinderException;

/**
 *
 * @author QuocHai
 */
public interface FaqLocalHome extends EJBLocalHome {

    ticketbook.ejb.cmp.FaqLocal findByPrimaryKey(java.lang.Integer key)  throws FinderException;
    
    ticketbook.ejb.cmp.FaqLocal create(java.lang.Integer key)  throws CreateException;

    Collection findById(Integer id) throws FinderException;

    Collection findByQuestion(String question) throws FinderException;

    Collection findByAnswer(String answer) throws FinderException;

    Collection findAllFAQs() throws FinderException;

    ticketbook.ejb.cmp.FaqLocal create(String question, String answer, Timestamp create_date, String username) throws CreateException;

}
