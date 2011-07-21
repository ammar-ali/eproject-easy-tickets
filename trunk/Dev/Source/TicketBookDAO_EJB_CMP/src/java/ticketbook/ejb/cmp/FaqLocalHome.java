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

    Collection findById(Integer id) throws FinderException;

    Collection findByQuestion(String question) throws FinderException;

    Collection findByAnswer(String answer) throws FinderException;

    ticketbook.ejb.cmp.FaqLocal create(Integer id, String answer, String question, Timestamp create_date, Integer username) throws CreateException;

}
