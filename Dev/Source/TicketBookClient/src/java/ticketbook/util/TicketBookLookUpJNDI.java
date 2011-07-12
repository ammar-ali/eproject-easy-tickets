/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ticketbook.util;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import ticketbook.ejb.session.GUIBusinessRemoteHome;
import ticketbook.exception.ConfigException;

/**
 *
 * @author Admin
 */
public class TicketBookLookUpJNDI {
    
    public static GUIBusinessRemoteHome getGUIBusinessRemoteHome() throws ConfigException, NamingException{
        Config.settingSystemPropertiesForSessionBean();
        Context context=new InitialContext();
        Object ref=context.lookup("GUIBusiness");
        GUIBusinessRemoteHome home=(GUIBusinessRemoteHome)ref;
        return home;
    }

}
