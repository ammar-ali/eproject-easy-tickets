/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ticketbook.ejb.bmp;

import javax.ejb.EntityBean;
import javax.ejb.EntityContext;
import javax.ejb.FinderException;
import ticketbook.ejb.bmp.dao.UserDAO;
import ticketbook.exception.SQLTicketBookException;
import ticketbook.sql.SQLTicketBookConnection;
import ticketbook.transfer.UserTransferData;
import ticketbook.util.Constant;

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
        this.setUsername((String)context.getPrimaryKey());
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
    public void ejbLoad() throws IllegalArgumentException{
        // TODO add code to retrieve data
        try {
            UserTransferData data = UserDAO.getInstance(SQLTicketBookConnection.getInstance()).getUserByUsername(this.getUsername());
            if(data!=null){
                this.setUsername(data.getUsername());
                this.setPassword(data.getPassword());
                this.setAddress(data.getAddress());
                this.setPhone(data.getPhone());
                this.setBirthDate(data.getBirthDate());
                this.setPersonCardNumber(data.getPersonCardNumber());
                this.setFullname(data.getFullname());
                this.setEmail(data.getEmail());
                this.setCreateDate(data.getCreateDate());
                this.setRoleID(data.getRoleID());
            }
            else throw new IllegalArgumentException("Account doesn't correct");
        } catch (SQLTicketBookException ex) {
            ex.printStackTrace();
        }
    }
    
    /**
     * @see javax.ejb.EntityBean#ejbStore()
     */
    public void ejbStore() {
        // TODO add code to persist data
        try {
            if(this!=null)
                UserDAO.getInstance(SQLTicketBookConnection.getInstance()).update(this);
        } catch (SQLTicketBookException ex) {
            ex.printStackTrace();
        }
    }

    // </editor-fold>
    
    /**
     * See EJB 2.0 and EJB 2.1 section 12.2.5
     */
    public java.lang.String ejbFindByPrimaryKey(java.lang.String aKey) throws FinderException {
        // TODO add code to locate aKey from persistent storage
        // throw javax.ejb.ObjectNotFoundException if aKey is not in
        // persistent storage.
       
        return aKey;
    }
    public java.lang.String ejbFindByUsernameAndPassword(String username,String password){
        try {
            UserTransferData data = UserDAO.getInstance(SQLTicketBookConnection.getInstance()).getUserByUsernameAndPassword(username, password);
            if(!data.getRoleID().equals(Constant.ID_FALSE_INTETER))
                this.setUsername(data.getUsername());
            else
                username="";
        } catch (SQLTicketBookException ex) {
            ex.printStackTrace();
        }
        return username;
    }
    public String ejbCreate(UserTransferData user)
    {
        try
        {
            UserDAO.getInstance(SQLTicketBookConnection.getInstance()).insert(user);
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
        return user.getUsername();
    }
    public void ejbPostCreate(UserTransferData user)
    {

    }

   

}
