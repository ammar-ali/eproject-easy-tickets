/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ticketbook.model;

import java.util.ArrayList;
import ticketbook.ejb.bmp.ContactRemoteHome;
import ticketbook.util.TicketBookLookUpJNDI;


/**
 *
 * @author QuocHai
 */
public class Contact {
   private Contact(){}
    public static ArrayList getAll(Integer index, Integer total){
        ArrayList arr = new ArrayList();
        try {
            ContactRemoteHome home = TicketBookLookUpJNDI.getContactRemoteHome();
            arr = (ArrayList) home.findAll(index.intValue(), total.intValue());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return arr;
    }

    public static Integer countFindAll(){
        try {
            ContactRemoteHome home = TicketBookLookUpJNDI.getContactRemoteHome();
            return home.create(null).countFindAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new Integer(0);
    }
}
