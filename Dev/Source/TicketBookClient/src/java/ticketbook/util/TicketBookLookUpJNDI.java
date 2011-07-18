/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ticketbook.util;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import ticketbook.ejb.bmp.CityRemoteHome;
import ticketbook.ejb.bmp.EventTypeRemoteHome;
import ticketbook.ejb.bmp.TicketRemoteHome;
import ticketbook.ejb.bmp.UserRemoteHome;
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

    public static UserRemoteHome getUserRemoteHome(){
        try{
            Config.settingSystemPropertiesForEntityBean();
            Context ctx=new InitialContext();
            Object ref=ctx.lookup("User");
            UserRemoteHome home=(UserRemoteHome)
                            javax.rmi.PortableRemoteObject.narrow(
                             ref,UserRemoteHome.class);
            return home;
        } catch (ConfigException ex) {
            ex.printStackTrace();
        }catch(NamingException namingException){
            namingException.printStackTrace();
        }
        return null;
    }

    public static TicketRemoteHome getTicketRemoteHome(){
        try{
            Config.settingSystemPropertiesForEntityBean();
            Context ctx=new InitialContext();
            Object ref=ctx.lookup("Ticket");
            TicketRemoteHome home=(TicketRemoteHome)
                            javax.rmi.PortableRemoteObject.narrow(
                             ref,TicketRemoteHome.class);
            return home;
        } catch (ConfigException ex) {
            ex.printStackTrace();
        }catch(NamingException namingException){
            namingException.printStackTrace();
        }
        return null;
    }

    public static CityRemoteHome getCityRemoteHome(){
        try{
            Config.settingSystemPropertiesForEntityBean();
            Context ctx=new InitialContext();
            Object ref=ctx.lookup("City");
            CityRemoteHome home=(CityRemoteHome)
                            javax.rmi.PortableRemoteObject.narrow(
                             ref,CityRemoteHome.class);
            return home;
        } catch (ConfigException ex) {
            ex.printStackTrace();
        }catch(NamingException namingException){
            namingException.printStackTrace();
        }
        return null;
    }

}
