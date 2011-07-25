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
public interface ContactLocalHome extends EJBLocalHome {

    ticketbook.ejb.cmp.ContactLocal findByPrimaryKey(java.lang.Integer key)  throws FinderException;
    
    ticketbook.ejb.cmp.ContactLocal create(java.lang.Integer key)  throws CreateException;

    Collection findById(Integer id) throws FinderException;

    Collection findByTitle(String title) throws FinderException;

    Collection findByContent(String content) throws FinderException;

    Collection findByAnswer(String answer) throws FinderException;

    Collection findByEmail(String email) throws FinderException;

    Collection findAllContact()throws FinderException;

    ticketbook.ejb.cmp.ContactLocal create( String title, String content, String email, Timestamp create_date, String username) throws CreateException;

}
