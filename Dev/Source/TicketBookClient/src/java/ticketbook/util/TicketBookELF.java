/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ticketbook.util;

import java.rmi.RemoteException;
import ticketbook.ejb.bmp.EventTypeRemote;
import ticketbook.model.EventType;

/**
 *
 * @author Admin
 */
public class TicketBookELF {
    public static Integer getIndexEventTypesByID(java.lang.Integer ID){
        if(EventType.getInstanceValue()!=null){
            int total=EventType.getInstanceValue().size();
            for(int i=0;i<total;i++){
                try {
                    if (ID.intValue() == ((EventTypeRemote) EventType.getInstanceValue().get(i)).getID().intValue()) {
                        return new Integer(i);
                    }
                } catch (RemoteException ex) {
                    ex.printStackTrace();
                }
            }
        }
        return new Integer(-1);
    }

}
