/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ticketbook.model;

import java.rmi.RemoteException;
import ticketbook.ejb.bmp.DateRemote;
import ticketbook.ejb.bmp.DateRemoteHome;
import ticketbook.util.TicketBookLookUpJNDI;

/**
 *
 * @author vostro
 */
public class Date {
    public static String getDateCurrent(){
        try {
            DateRemoteHome home = TicketBookLookUpJNDI.getDateRemoteHome();
            DateRemote remote = home.create();
            return remote.getDateCurrent();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return "";
    }
     public static int diffDate(String date1,String date2){
        try {
            DateRemoteHome home = TicketBookLookUpJNDI.getDateRemoteHome();
            DateRemote remote = home.create();
            return remote.diffDate(date1, date2);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return 0;
    }
}
