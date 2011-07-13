/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ticketbook.util;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import ticketbook.ejb.bmp.EventTypeRemoteHome;
import ticketbook.exception.ConfigException;

/**
 *
 * @author Admin
 */
public class TicketBookLookUpJNDI {
    
    

    public static EventTypeRemoteHome getEventTypeRemoteHome(){
        try{
            Config.settingSystemPropertiesForEntityBean();
            Context ctx=new InitialContext();
            Object ref=ctx.lookup("EventType");
            EventTypeRemoteHome home=(EventTypeRemoteHome)
                            javax.rmi.PortableRemoteObject.narrow(
                             ref,EventTypeRemoteHome.class);
            return home;
        } catch (ConfigException ex) {
            ex.printStackTrace();
        }catch(NamingException namingException){
            namingException.printStackTrace();
        }
        return null;
    }

}
