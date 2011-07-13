/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ticketbook.model;

import java.rmi.RemoteException;
import javax.ejb.FinderException;
import ticketbook.ejb.bmp.UserRemote;
import ticketbook.ejb.bmp.UserRemoteHome;
import ticketbook.util.TicketBookLookUpJNDI;

/**
 *
 * @author Admin
 */
public class User {

    private User(){}

    public static UserRemote getByUsernameAndpassword(String username,String password) throws FinderException, RemoteException{
        UserRemoteHome home=TicketBookLookUpJNDI.getUserRemoteHome();
        return home.findByUsernameAndPassword(username, password);
    }
    
}
