/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ticketbook.ejb.cmp;

import java.util.Collection;
import javax.ejb.EJBLocalObject;
import javax.ejb.FinderException;

/**
 *
 * @author QuocHai
 */
public interface ContactSessionBeanLocal extends EJBLocalObject {

    void insertContact(String title, String content, String email, String create_date, String username);

    void answerContact(Integer id, String title, String content, String answer, String email, String username);

    void deleteContact(Integer id);

    Collection findAllContact()throws FinderException;
    
}
