/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ticketbook.ejb.bmp;

import java.rmi.RemoteException;
import javax.ejb.EJBObject;

/**
 *
 * @author QuocHai
 */
public interface ContactRemote extends EJBObject {

     public void setID(Integer ID) throws RemoteException;

    public void setAnswer(String answer) throws RemoteException;

    public void setContent(String content) throws RemoteException;

    public void setCreateDate(String createDate) throws RemoteException;

    public void setEmail(String email) throws RemoteException;

    public void setTitle(String title) throws RemoteException;

    public void setUsername(String username) throws RemoteException;

    public Integer getID() throws RemoteException;

    public String getAnswer() throws RemoteException;

    public String getContent() throws RemoteException;

    public String getCreateDate() throws RemoteException;

    public String getEmail() throws RemoteException;

    public String getTitle() throws RemoteException;

    public String getUsername() throws RemoteException;

    public Integer countFindAll() throws RemoteException;
}
