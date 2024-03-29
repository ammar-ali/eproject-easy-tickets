/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ticketbook.ejb.bmp;

import java.util.Collection;
import javax.ejb.EntityBean;
import javax.ejb.EntityContext;
import javax.ejb.FinderException;
import ticketbook.ejb.bmp.dao.EventDAO;
import ticketbook.exception.SQLTicketBookException;
import ticketbook.sql.SQLTicketBookConnection;
import ticketbook.transfer.EventTransferData;
import ticketbook.util.Constant;

/**
 *
 * @author Admin
 */
public class Event extends EventTransferData implements EntityBean {

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
            EventTransferData event = EventDAO.getInstance(SQLTicketBookConnection.getInstance()).getEventByID(this.getID());
            if(event!=null){
                this.setID(event.getID());
                this.setArtist(event.getArtist());
                this.setTitle(event.getTitle());
                this.setContent(event.getContent());
                this.setImage(event.getImage());
                this.setEventTypeID(event.getEventTypeID());
                this.setVenueID(event.getVenueID());
                this.setCityID(event.getCityID());
                this.setEventTypeName(event.getEventTypeName());
                this.setVenueName(event.getVenueName());
                this.setCityName(event.getCityName());
                this.setVenueAddress(event.getVenueAddress());
            }
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
        // TODO add code to locate aKey from persistent storage
        // throw javax.ejb.ObjectNotFoundException if aKey is not in
        // persistent storage.
        return aKey;
    }
    public Integer ejbCreate(EventTransferData event){
        if(event!=null){
            try {
                EventDAO.getInstance(SQLTicketBookConnection.getInstance()).insertEvent(event);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
            return event.getID();
        }
        else
            return Constant.ID_FALSE_INTETER;
    }
    public void ejbPostCreate(EventTransferData event){

    }
    public Collection ejbFindAllEvent(int indexRecord,int totalRecord){
        try {
             return  EventDAO.getInstance(SQLTicketBookConnection.getInstance()).getAllEventID(indexRecord,totalRecord);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }
    public Integer countAllEvent(){
        try {
           return  EventDAO.getInstance(SQLTicketBookConnection.getInstance()).countAllEvent();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return new Integer(0);
    }
}
