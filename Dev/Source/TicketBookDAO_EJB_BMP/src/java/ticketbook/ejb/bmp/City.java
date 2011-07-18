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
import ticketbook.ejb.bmp.dao.CityDAO;
import ticketbook.exception.SQLTicketBookException;
import ticketbook.sql.SQLTicketBookConnection;
import ticketbook.transfer.CityTransferData;

/**
 *
 * @author Admin
 */
public class City extends CityTransferData implements EntityBean {

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
            CityTransferData city = CityDAO.getInstance(SQLTicketBookConnection.getInstance()).getCityByID(this.getID());
            if(city!=null){
                this.setID(city.getID());
                this.setName(city.getName());
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

    public Collection ejbFindAll() throws FinderException{
        ArrayList lst=new ArrayList();
        try {
            lst = CityDAO.getInstance(SQLTicketBookConnection.getInstance()).getCityIDs();
        } catch (SQLTicketBookException ex) {
            ex.printStackTrace();
        }
        return lst;
    }

}
