/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ticketbook.model;

import java.util.ArrayList;
import ticketbook.ejb.bmp.FaqRemoteHome;
import ticketbook.util.TicketBookLookUpJNDI;

/**
 *
 * @author QuocHai
 */
public class Faq {
private Faq(){}
    public static ArrayList getAll(Integer index, Integer total){
        ArrayList arr = new ArrayList();
        try {
            FaqRemoteHome home = TicketBookLookUpJNDI.getFaqRemoteHome();
            arr = (ArrayList) home.findAll(index.intValue(), total.intValue());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return arr;
    }

    public static Integer countFindAll(){
        try {
            FaqRemoteHome home = TicketBookLookUpJNDI.getFaqRemoteHome();
            return home.create(null).countFindAll();
        } catch (Exception e) {
        }
        return new Integer(0);
    }
}
