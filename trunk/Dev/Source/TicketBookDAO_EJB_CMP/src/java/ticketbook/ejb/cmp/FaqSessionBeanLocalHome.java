/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ticketbook.ejb.cmp;

import javax.ejb.CreateException;
import javax.ejb.EJBLocalHome;

/**
 *
 * @author QuocHai
 */
public interface FaqSessionBeanLocalHome extends EJBLocalHome {
    
    ticketbook.ejb.cmp.FaqSessionBeanLocal create()  throws CreateException;

}
