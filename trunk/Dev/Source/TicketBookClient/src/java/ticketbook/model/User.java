/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ticketbook.model;

import java.rmi.RemoteException;
import javax.ejb.CreateException;
import javax.ejb.FinderException;
import ticketbook.ejb.bmp.UserRemote;
import ticketbook.ejb.bmp.UserRemoteHome;
import ticketbook.transfer.UserTransferData;
import ticketbook.util.TicketBookLookUpJNDI;

/**
 *
 * @author Admin
 */
public class User {

    private User(){}

    public static UserRemote getByUsernameAndPassword(String username,String password) throws FinderException, RemoteException{
        UserRemoteHome home=TicketBookLookUpJNDI.getUserRemoteHome();
        return home.findByUsernameAndPassword(username, password);
    }


    public static UserRemote getByUsername(String username) throws FinderException, RemoteException{
        UserRemoteHome home=TicketBookLookUpJNDI.getUserRemoteHome();
        return home.findByPrimaryKey(username);
    }

    public static UserRemote create(UserTransferData data) throws FinderException, RemoteException{
        try {
            UserRemoteHome home = TicketBookLookUpJNDI.getUserRemoteHome();
            return home.create(data);
        } catch (CreateException ex) {
            ex.printStackTrace();
        }
        return null;
    }
    
}
