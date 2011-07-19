/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ticketbook.model;

import java.rmi.RemoteException;
import java.util.ArrayList;
import javax.ejb.FinderException;
import ticketbook.ejb.bmp.PaymentTypeRemoteHome;
import ticketbook.util.TicketBookLookUpJNDI;

/**
 *
 * @author Admin
 */
public class PaymentType {
    static ArrayList paymentTypes;
    private PaymentType(){}

    public static ArrayList getInstanceValue(){
        if(paymentTypes==null)
            paymentTypes=PaymentType.values();
        return paymentTypes;
    }

    public static ArrayList values(){
        ArrayList lst = new ArrayList();
        try {
            PaymentTypeRemoteHome home = TicketBookLookUpJNDI.getPaymentTypeRemoteHome();
            lst = (ArrayList) home.findAll();
            return lst;
        } catch (FinderException ex) {
            ex.printStackTrace();
        } catch (RemoteException ex) {
            ex.printStackTrace();
        }
        return lst;
    }
}
