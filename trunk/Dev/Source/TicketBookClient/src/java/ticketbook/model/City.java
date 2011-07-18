/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ticketbook.model;

import java.rmi.RemoteException;
import java.util.ArrayList;
import javax.ejb.FinderException;
import ticketbook.ejb.bmp.CityRemoteHome;
import ticketbook.util.TicketBookLookUpJNDI;

/**
 *
 * @author Admin
 */
public class City {
    static ArrayList citys;
    private City(){}

    public static ArrayList getInstanceValue(){
        if(citys==null)
            citys=City.values();
        return citys;
    }

    public static ArrayList values(){
        ArrayList lst = new ArrayList();
        try {
            CityRemoteHome city = TicketBookLookUpJNDI.getCityRemoteHome();
            lst = (ArrayList) city.findAll();
            return lst;
        } catch (FinderException ex) {
            ex.printStackTrace();
        } catch (RemoteException ex) {
            ex.printStackTrace();
        }
        return lst;
    }
}
