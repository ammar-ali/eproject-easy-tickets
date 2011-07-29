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
    public static ArrayList getAll(int index, int total){
        ArrayList arr = new ArrayList();
        try {
            FaqRemoteHome home = TicketBookLookUpJNDI.getFaqRemoteHome();
            arr = (ArrayList) home.findAll(index, total);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return arr;
    }
}
