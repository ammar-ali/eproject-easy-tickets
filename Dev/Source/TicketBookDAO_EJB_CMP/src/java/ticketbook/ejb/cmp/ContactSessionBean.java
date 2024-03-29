/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ticketbook.ejb.cmp;

import java.sql.Timestamp;
import java.util.Collection;
import java.util.Iterator;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.SessionBean;
import javax.ejb.SessionContext;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import ticketbook.transfer.ContactTransferData;

/**
 *
 * @author QuocHai
 */
public class ContactSessionBean implements SessionBean {
    
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

    private ContactLocalHome lookupContactLocal() {
        try {
            Context c = new InitialContext();
            ContactLocalHome rv = (ContactLocalHome) c.lookup("ContactLocalJNDI");
            return rv;
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }

    public void insertContact(String title, String content, String email, Timestamp create_date, String username) {
        try {
            ContactLocalHome home = lookupContactLocal();
            home.create(title, content, email, create_date, username);
        } catch (Exception e) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE,"exception caught", e);
        }
    }

    public void answerContact(Integer id, String title, String content, String answer, String email, String username) {
        try {
            ContactLocalHome home = lookupContactLocal();
            ContactLocal local = home.findByPrimaryKey(id);
            local.setAnswer(answer);
            local.getContent();
            local.getTitle();
            local.getEmail();
            local.setUsername(username);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deleteContact(Integer id) {
        try {
            ContactLocalHome home = lookupContactLocal();
            ContactLocal local = home.findByPrimaryKey(id);
            local.remove();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Vector ejbFindAllContact() {
        Collection col = null;
        Vector v = new Vector();
        try {
            ContactLocalHome home = lookupContactLocal();
            col = home.findAllContact();
            Iterator it = col.iterator();
            while (it.hasNext()){
                ContactLocal local = (ContactLocal)it.next();
                ContactTransferData contd = new ContactTransferData(local.getId(), local.getTitle(), local.getContent(),local.getAnswer() ,local.getEmail(), local.getCreateDate(), local.getUsername());
                v.add(contd);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return v;
    }
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method" or "Web Service > Add Operation")
    
}
