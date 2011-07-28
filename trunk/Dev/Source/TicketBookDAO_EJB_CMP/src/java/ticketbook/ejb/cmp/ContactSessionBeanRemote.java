/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ticketbook.ejb.cmp;

import java.rmi.RemoteException;
import java.sql.Timestamp;
import java.util.Vector;
import javax.ejb.EJBObject;

/**
 *
 * @author QuocHai
 */
public interface ContactSessionBeanRemote extends EJBObject {

    void insertContact(String title, String content, String email, Timestamp create_date, String username) throws RemoteException;

    void answerContact(Integer id, String title, String content, String answer, String email, String username) throws RemoteException;

    void deleteContact(Integer id) throws RemoteException;

    Vector ejbFindAllContact() throws RemoteException;
    
}
