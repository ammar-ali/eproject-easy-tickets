/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ticketbook.model;

import java.util.ArrayList;
import ticketbook.ejb.bmp.EventTypeRemote;
import ticketbook.ejb.bmp.EventTypeRemoteHome;
import ticketbook.transfer.EventTypeTransferData;
import ticketbook.util.TicketBookLookUpJNDI;
 

/**
 *
 * @author Admin
 */
public class EventType {

    static ArrayList eventTypes;

    // using a private constructor to force use of the factory method.
    private EventType() {
    }

    public static ArrayList getInstanceValue(){
        if(eventTypes==null)
            eventTypes=EventType.values();
        return eventTypes;
    }

    public static String getEventTypeNameByID(Integer ID){
        ArrayList events=getInstanceValue();
        try{
            for(int i=0;i<events.size();i++){
                EventTypeRemote remote=(EventTypeRemote)events.get(i);
                if(ID.equals(remote.getID())){
                    return remote.getName();
                }
            }
        }
        catch(Exception ex){
            ex.printStackTrace();
        }

        return "";
    }

    public static EventTypeRemote getEventTypeRemoteByIndex(Integer index){
        if(eventTypes!=null){
            if(index.intValue()>=0&&index.intValue()<eventTypes.size()){
                return (EventTypeRemote)eventTypes.get(index.intValue());
            }
        }
        return null;
    }

    public static void add(EventTypeTransferData data){
        if(eventTypes!=null){
            eventTypes.add(data);
        }else{
            eventTypes=new ArrayList();
            eventTypes.add(data);
        }
    }
   
    private static ArrayList values(){
        ArrayList types=new ArrayList();
        try {
            EventTypeRemoteHome home = TicketBookLookUpJNDI.getEventTypeRemoteHome();
            types=(ArrayList) home.findAll();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return types;
    }

 
}
