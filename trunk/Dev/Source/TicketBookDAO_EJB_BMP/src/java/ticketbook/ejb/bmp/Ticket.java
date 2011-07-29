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
import ticketbook.ejb.bmp.dao.TicketDAO;
import ticketbook.exception.SQLTicketBookException;
import ticketbook.sql.SQLTicketBookConnection;
import ticketbook.transfer.TicketTransferData;

/**
 *
 * @author Admin
 */
public class Ticket extends TicketTransferData implements EntityBean {

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
           
            TicketTransferData data = TicketDAO.getInstance(SQLTicketBookConnection.getInstance()).getTicketByID(this.getID());
            if(data!=null){
                this.setID(data.getID());
                this.setArtist(data.getArtist());
                this.setCityID(data.getCityID());
                this.setCityName(data.getCityName());
                this.setContent(data.getContent());
                this.setCreateDate(data.getCreateDate());
                this.setCreateUsername(data.getCreateUsername());
                this.setDiscount(data.getDiscount());
                this.setEventID(data.getEventID());
                this.setEventTypeID(data.getEventTypeID());
                this.setImage(data.getImage());
                this.setPrice(data.getPrice());
                this.setPromotion(data.getPromotion());
                this.setTicketTotal(data.getTicketTotal());
                this.setTitle(data.getTitle());
                this.setVenueAddress(data.getVenueAddress());
                this.setVenueID(data.getVenueID());
                this.setVenueID(data.getVenueID());
                this.setVenueName(data.getVenueName());
                this.setViewDate(data.getViewDate());
                this.setViewTime(data.getViewTime());
                this.setViewStatus(data.getViewStatus());
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
        this.setID(aKey);
        return aKey;
    }

    public Collection ejbFindByEventTypeID(Integer eventTypeID,Integer cityID,int indexRecord,int totalRecord){
        ArrayList lst=new ArrayList();
        try {
            lst= TicketDAO.getInstance(SQLTicketBookConnection.getInstance()).getTicketIDsByEventTypeID(eventTypeID, cityID,indexRecord, totalRecord);
        } catch (SQLTicketBookException ex) {
            ex.printStackTrace();
        }
        return lst;
    }

    public Integer countByEventTypeID(Integer eventTypeID,Integer cityID){
        try {
            return TicketDAO.getInstance(SQLTicketBookConnection.getInstance()).countRecordFindByEventTypeID(eventTypeID,cityID);
        } catch (SQLTicketBookException ex) {
            ex.printStackTrace();
        }
        return new Integer(0);
    }

    public Collection ejbFindTopByEventTypeID(Integer eventTypeID,int top){
        try {
            return TicketDAO.getInstance(SQLTicketBookConnection.getInstance()).getTopTicketIDsByEventTypeID(eventTypeID, new Integer(top));
        } catch (SQLTicketBookException ex) {
            ex.printStackTrace();
        }
        return new ArrayList();
    }

    public Collection ejbFindAvailableReferenceTicketByTitle(String title){
        try{
            return TicketDAO.getInstance(SQLTicketBookConnection.getInstance()).getAvailableReferenceTicketIDsByTitle(title);
        }
        catch(SQLTicketBookException ex){
           ex.printStackTrace();
        }
        return new ArrayList();
    }

    public Collection ejbFindAvailableReferenceTicketIDsByEventID(Integer eventID){
        try{
            return TicketDAO.getInstance(SQLTicketBookConnection.getInstance()).getAvailableReferenceTicketIDsByEventID(eventID);
        }
        catch(SQLTicketBookException ex){
           ex.printStackTrace();
        }
        return new ArrayList();
    }
    public Integer ejbCreate(TicketTransferData data){
        if(data!=null){
            try {
               TicketDAO.getInstance(SQLTicketBookConnection.getInstance()).insertTicket(data);
               return data.getID();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        return new Integer(0);
    }
    public void ejbPostCreate(TicketTransferData data){
    
    }
}
