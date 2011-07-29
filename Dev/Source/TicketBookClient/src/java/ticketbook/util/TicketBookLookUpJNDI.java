/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ticketbook.util;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import ticketbook.ejb.bmp.CityRemoteHome;
import ticketbook.ejb.bmp.DateRemoteHome;
import ticketbook.ejb.bmp.EventRemoteHome;
import ticketbook.ejb.bmp.EventTypeRemoteHome;
import ticketbook.ejb.bmp.FaqRemoteHome;
import ticketbook.ejb.bmp.PaymentTypeRemoteHome;
import ticketbook.ejb.bmp.TicketBookingRemoteHome;
import ticketbook.ejb.bmp.TicketRemoteHome;
import ticketbook.ejb.bmp.UserRemoteHome;
import ticketbook.ejb.bmp.VenueRemoteHome;

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
 public static DateRemoteHome getDateRemoteHome(){
        try{
            Config.settingSystemPropertiesForEntityBean();
            Context ctx=new InitialContext();
            Object ref=ctx.lookup("Date");
            DateRemoteHome home=(DateRemoteHome)
                            javax.rmi.PortableRemoteObject.narrow(
                             ref,DateRemoteHome.class);
            return home;
        } catch (ConfigException ex) {
            ex.printStackTrace();
        }catch(NamingException namingException){
            namingException.printStackTrace();
        }
        return null;
    }
    public static PaymentTypeRemoteHome getPaymentTypeRemoteHome(){
        try{
            Config.settingSystemPropertiesForEntityBean();
            Context ctx=new InitialContext();
            Object ref=ctx.lookup("PaymentType");
            PaymentTypeRemoteHome home=(PaymentTypeRemoteHome)
                            javax.rmi.PortableRemoteObject.narrow(
                             ref,PaymentTypeRemoteHome.class);
            return home;
        } catch (ConfigException ex) {
            ex.printStackTrace();
        }catch(NamingException namingException){
            namingException.printStackTrace();
        }
        return null;
    }

    public static TicketBookingRemoteHome getTicketBookingRemoteHome(){
        try{
            Config.settingSystemPropertiesForEntityBean();
            Context ctx=new InitialContext();
            Object ref=ctx.lookup("TicketBooking");
            TicketBookingRemoteHome home=(TicketBookingRemoteHome)
                            javax.rmi.PortableRemoteObject.narrow(
                             ref,TicketBookingRemoteHome.class);
            return home;
        } catch (ConfigException ex) {
            ex.printStackTrace();
        }catch(NamingException namingException){
            namingException.printStackTrace();
        }
        return null;
    }
    public static VenueRemoteHome getVenueRemoteHome(){
        try{
            Config.settingSystemPropertiesForEntityBean();
            Context ctx=new InitialContext();
            Object ref=ctx.lookup("Venue");
            VenueRemoteHome home=(VenueRemoteHome)
                            javax.rmi.PortableRemoteObject.narrow(
                             ref,VenueRemoteHome.class);
            return home;
        } catch (ConfigException ex) {
            ex.printStackTrace();
        }catch(NamingException namingException){
            namingException.printStackTrace();
        }
        return null;
    }
    
     public static EventRemoteHome getEventRemoteHome(){
        try{
            Config.settingSystemPropertiesForEntityBean();
            Context ctx=new InitialContext();
            Object ref=ctx.lookup("Event");
            EventRemoteHome home=(EventRemoteHome)
                            javax.rmi.PortableRemoteObject.narrow(
                             ref,EventRemoteHome.class);
            return home;
        } catch (ConfigException ex) {
            ex.printStackTrace();
        }catch(NamingException namingException){
            namingException.printStackTrace();
        }
        return null;
    }
     
      public static FaqRemoteHome getFaqRemoteHome(){
        try{
            Config.settingSystemPropertiesForEntityBean();
            Context ctx=new InitialContext();
            Object ref=ctx.lookup("Faq");
            FaqRemoteHome home=(FaqRemoteHome)
                            javax.rmi.PortableRemoteObject.narrow(
                             ref,FaqRemoteHome.class);
            return home;
        } catch (ConfigException ex) {
            ex.printStackTrace();
        }catch(NamingException namingException){
            namingException.printStackTrace();
        }
        return null;
    }
}
