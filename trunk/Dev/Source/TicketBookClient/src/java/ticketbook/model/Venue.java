/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ticketbook.model;

import java.rmi.RemoteException;
import java.util.ArrayList;
import javax.ejb.FinderException;
import ticketbook.ejb.bmp.VenueRemoteHome;
import ticketbook.util.TicketBookLookUpJNDI;

/**
 *
 * @author Admin
 */
public class Venue {
    private Venue(){

    }
    public static ArrayList getAllVenue(){
        VenueRemoteHome venueHome=TicketBookLookUpJNDI.getVenueRemoteHome();
        try {
            return (ArrayList) venueHome.findAllVenue();
        } catch (FinderException ex) {
            ex.printStackTrace();
        } catch (RemoteException ex) {
            ex.printStackTrace();
        }
        return new ArrayList();
    }
}
