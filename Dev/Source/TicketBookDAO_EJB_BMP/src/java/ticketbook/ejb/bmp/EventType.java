/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ticketbook.ejb.bmp;

import java.util.ArrayList;
import java.util.Collection;
import javax.ejb.EntityBean;
import javax.ejb.EntityContext;
import javax.ejb.FinderException;
import ticketbook.ejb.bmp.dao.EventTypeDAO;
import ticketbook.exception.SQLTicketBookException;
import ticketbook.sql.SQLTicketBookConnection;
import ticketbook.transfer.EventTypeTransferData;

/**
 *
 * @author Admin
 */
public class EventType extends EventTypeTransferData implements EntityBean {

    private EntityContext context;
    
    // <editor-fold defaultstate="collapsed" desc="EJB infrastructure methods. Click the + sign on the left to edit the code.">

    // TODO Add code to acquire and use other enterprise resources (DataSource, JMS, enterprise beans, Web services)
    // TODO Add business methods
    // TODO Add create methods

    /**
     * @see javax.ejb.EntityBean#setEntityContext(javax.ejb.EntityContext)
     */
    public void setEntityContext(EntityContext aContext) {
        context = aContext;
    }
    
    /**
     * @see javax.ejb.EntityBean#ejbActivate()
     */
    public void ejbActivate() {
        this.setID((Integer)context.getPrimaryKey());
    }
    
    /**
     * @see javax.ejb.EntityBean#ejbPassivate()
     */
    public void ejbPassivate() {
        this.setID(null);
    }
    
    /**
     * @see javax.ejb.EntityBean#ejbRemove()
     */
    public void ejbRemove() {
        
    }
    
    /**
     * @see javax.ejb.EntityBean#unsetEntityContext()
     */
    public void unsetEntityContext() {
        context = null;
    }
    
    /**
     * @see javax.ejb.EntityBean#ejbLoad()
     */
    public void ejbLoad() {
        try {
            // TODO add code to retrieve data
            EventTypeTransferData eventTrans = EventTypeDAO.getInstance(SQLTicketBookConnection.getInstance()).getEventTypeByID(this.getID());
            this.setID(eventTrans.getID());
            this.setName(eventTrans.getName());
        } catch (SQLTicketBookException ex) {
            ex.printStackTrace();
        }
        
    }
    
    /**
     * @see javax.ejb.EntityBean#ejbStore()
     */
    public void ejbStore() {
        // TODO add code to persist data
    }

    // </editor-fold>  
    /**
     * See EJB 2.0 and EJB 2.1 section 12.2.5
     */
    public java.lang.Integer ejbFindByPrimaryKey(java.lang.Integer aKey) throws FinderException {
//         TODO add code to locate aKey from persistent storage
//         throw javax.ejb.ObjectNotFoundException if aKey is not in
//         persistent storage.
        this.setID(aKey);
        return aKey;
    }

    public Collection ejbFindAll() throws FinderException {
        
        Collection lst=new ArrayList();
        try {
           ArrayList eventTypes=new ArrayList();
           lst=new ArrayList();
           eventTypes=EventTypeDAO.getInstance(SQLTicketBookConnection.getInstance()).getEventTypes();
           for(int i=0;i<eventTypes.size();i++)
               lst.add(((EventTypeTransferData)eventTypes.get(i)).getID());
        } catch (SQLTicketBookException ex) {
            ex.printStackTrace();
        }
        return lst;
    }

}
