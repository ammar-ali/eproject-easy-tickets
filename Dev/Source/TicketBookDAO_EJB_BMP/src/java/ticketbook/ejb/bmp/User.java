/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ticketbook.ejb.bmp;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Vector;
import javax.ejb.CreateException;
import javax.ejb.EntityBean;
import javax.ejb.EntityContext;
import javax.ejb.FinderException;
import ticketbook.ejb.bmp.dao.UserDAO;
import ticketbook.exception.SQLTicketBookException;
import ticketbook.sql.SQLTicketBookConnection;
import ticketbook.transfer.UserTransferData;

/**
 *
 * @author Admin
 */
public class User extends UserTransferData implements EntityBean {

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
        try {
            UserDAO.getInstance(SQLTicketBookConnection.getInstance()).deleteByUserID(this.getID());
        } catch (SQLTicketBookException ex) {
            ex.printStackTrace();
        }
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
            UserTransferData userTrans = UserDAO.getInstance(SQLTicketBookConnection.getInstance()).getUserByID(this.getID());
            this.setID(userTrans.getID());
            this.setName(userTrans.getName());
            this.setPassword(userTrans.getPassword());
            this.setRole(userTrans.getRole());
        } catch (SQLTicketBookException ex) {
            ex.printStackTrace();
        }
    }
    
    /**
     * @see javax.ejb.EntityBean#ejbStore()
     */
    public void ejbStore() {
        try {
            // TODO add code to persist data
            UserDAO.getInstance(SQLTicketBookConnection.getInstance()).update(this);
        } catch (SQLTicketBookException ex) {
            ex.printStackTrace();
        }
    }
    // </editor-fold>
    
    /**
     * See EJB 2.0 and EJB 2.1 section 12.2.5
     */
    public java.lang.Integer ejbFindByPrimaryKey(java.lang.Integer aKey) throws FinderException {
       this.setID(aKey);     
        return aKey;
    }

    public Enumeration ejbFindAll() throws FinderException {
        try {
            Vector lst = new Vector();
            ArrayList lstUser = UserDAO.getInstance(SQLTicketBookConnection.getInstance()).getUsers();
            for (int i = 0; i < lstUser.size(); i++) {
                lst.add(((UserTransferData) lstUser.get(i)).getID());
            }
            return  lst.elements();
        } catch (SQLTicketBookException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public java.lang.Integer ejbCreate(UserTransferData user) throws CreateException{
        try {
            SQLTicketBookConnection conn=SQLTicketBookConnection.getInstance();
            UserDAO.getInstance(conn).insert(user);
            this.setID(user.getID());
        } catch (SQLTicketBookException ex) {
            ex.printStackTrace();
        }
        return this.getID();
    }

    public void ejbPostCreate(UserTransferData user){
        
    }



}
