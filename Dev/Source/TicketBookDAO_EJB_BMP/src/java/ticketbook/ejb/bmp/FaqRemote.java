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
public interface FaqRemote extends EJBObject {

    public Integer getID() throws RemoteException;


    public String getAnswer() throws RemoteException;


    public String getCreateDate()throws RemoteException;


    public String getQuestion()throws RemoteException;


    public String getUsername()throws RemoteException;


    public void setID(Integer ID)throws RemoteException;


    public void setAnswer(String answer)throws RemoteException;


    public void setCreateDate(String createDate)throws RemoteException;


    public void setQuestion(String question)throws RemoteException;


    public void setUsername(String username)throws RemoteException;

    public Integer countFindAll() throws RemoteException;
    

}
