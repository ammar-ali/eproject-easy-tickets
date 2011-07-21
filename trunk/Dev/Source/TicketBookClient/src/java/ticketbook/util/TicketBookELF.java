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


    public static String filterTicketBookDate(String date){
        if(date!=null){
            String[] str=date.split(" ");
            if(str.length>0){
                String[] strs=str[0].split("-");
                if(strs.length==3){
                    return strs[1]+"/"+strs[2]+"/"+strs[0];
                }
            }
        }
        return date;
    }

    public static String filterTicketBookMoney(String money){
        if(money!=null){
            String str="";
            if(money.length()>=5)
                str=money.toString().subSequence(0,money.length()-5).toString();
            return str;
        }
        return money;
    }

}
