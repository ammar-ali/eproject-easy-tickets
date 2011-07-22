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
import ticketbook.ejb.bmp.dao.TicketBookingDAO;
import ticketbook.exception.SQLTicketBookException;
import ticketbook.sql.SQLTicketBookConnection;
import ticketbook.transfer.TicketBookingTransferData;
import ticketbook.util.Constant;

/**
 *
 * @author Admin
 */
public class TicketBooking extends TicketBookingTransferData implements EntityBean {

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
            // TODO add code to retrieve data
            TicketBookingTransferData data = TicketBookingDAO.getInstance(SQLTicketBookConnection.getInstance()).getTicketBookingByID(this.getID());
            if(data!=null){
                this.setID(data.getID());
                this.setAcceptStatus(data.getAcceptStatus());
                this.setAdmin(data.getAdmin());
                this.setCardNumber(data.getCardNumber());
                this.setDeliveryDate(data.getDeliveryDate());
                this.setDiscount(data.getDiscount());
                this.setPaymentDetailID(data.getPaymentDetailID());
                this.setPaymentTypeID(data.getPaymentTypeID());
                this.setPriceTotal(data.getPriceTotal());
                this.setTicketID(data.getTicketID());
                this.setTicketTotal(data.getTicketTotal());
                this.setUsername(data.getUsername());
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

    public Integer ejbCreate(TicketBookingTransferData data){
        try {
            TicketBookingDAO.getInstance(SQLTicketBookConnection.getInstance()).insert(data);
            return data.getID();
        } catch (SQLTicketBookException ex) {
            ex.printStackTrace();
        }
        return Constant.ID_FALSE_INTETER;
    }
    public void ejbPostCreate(TicketBookingTransferData data){
        
    }

    public Collection ejbFindAllByStatus(String status,int indexStart,int totalRecord){
        try {
            return TicketBookingDAO.getInstance(SQLTicketBookConnection.getInstance()).getTicketBookingIDsByStatus(status,indexStart, totalRecord);
        } catch (SQLTicketBookException ex) {
            ex.printStackTrace();
        }
        return new ArrayList();
    }

}
