/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ticketbook.ejb.session;

import java.util.ArrayList;
import java.util.Enumeration;
import javax.ejb.SessionBean;
import javax.ejb.SessionContext;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import ticketbook.ejb.bmp.EventTypeRemote;
import ticketbook.ejb.bmp.EventTypeRemoteHome;
import ticketbook.exception.ConfigException;
import ticketbook.transfer.EventTypeTransferData;
import ticketbook.util.Config;

/**
 *
 * @author Admin
 */
public class GUIBusiness implements SessionBean {
    
    private SessionContext context;
    
    // <editor-fold defaultstate="collapsed" desc="EJB infrastructure methods. Click the + sign on the left to edit the code.">;

    // TODO Add code to acquire and use other enterprise resources (DataSource, JMS, enterprise bean, Web services)
    // TODO Add business methods or web service operations

    /**
     * @see javax.ejb.SessionBean#setSessionContext(javax.ejb.SessionContext)
     */
    public void setSessionContext(SessionContext aContext) {
        context = aContext;
    }
    
    /**
     * @see javax.ejb.SessionBean#ejbActivate()
     */
    public void ejbActivate() {
        
    }
    
    /**
     * @see javax.ejb.SessionBean#ejbPassivate()
     */
    public void ejbPassivate() {
        
    }
    
    /**
     * @see javax.ejb.SessionBean#ejbRemove()
     */
    public void ejbRemove() {
        
    }
    
    // </editor-fold>;

    /**
     * See section 7.10.3 of the EJB 2.0 specification
     * See section 7.11.3 of the EJB 2.1 specification
     */
    public void ejbCreate() {
        // TODO implement ejbCreate if necessary, acquire resources
        // This method has access to the JNDI context so resource aquisition
        // spanning all methods can be performed here such as home interfaces
        // and data sources.
    }
    
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method" or "Web Service > Add Operation")

    private EventTypeRemoteHome lookupJNDIEventTypeRemoteHome(){
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

    public ArrayList getEventTypes(){
        ArrayList lst=new ArrayList();
        try {
            EventTypeRemoteHome home = this.lookupJNDIEventTypeRemoteHome();
            Enumeration enume= home.findAll();
            while(enume.hasMoreElements()){
                EventTypeTransferData data=new EventTypeTransferData();
                EventTypeRemote eventTypeRemote=(EventTypeRemote)enume.nextElement();
                data.setID(eventTypeRemote.getID());
                data.setName( eventTypeRemote.getName());
                lst.add(data);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return lst;
    }
}
