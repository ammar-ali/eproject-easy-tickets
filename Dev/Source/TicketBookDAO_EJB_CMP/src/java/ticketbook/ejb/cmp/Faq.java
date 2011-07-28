/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ticketbook.ejb.cmp;

import java.sql.Timestamp;
import javax.ejb.CreateException;
import javax.ejb.EntityBean;
import javax.ejb.EntityContext;

/**
 *
 * @author QuocHai
 */
public abstract class Faq implements EntityBean {

    private EntityContext context;
    
    // <editor-fold defaultstate="collapsed" desc="EJB infrastructure methods. Click on the + sign on the left to edit the code.">

    // TODO Consider creating Transfer Object to encapsulate data
    // TODO Review finder methods

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
        
    }
    
    /**
     * @see javax.ejb.EntityBean#ejbStore()
     */
    public void ejbStore() {
        
    }

    // </editor-fold>
    
    
    public java.lang.Integer ejbCreate(java.lang.Integer key)  throws CreateException {
        if (key == null) {
            throw new CreateException("The field \"key\" must not be null");
        }
        
        // TODO add additional validation code, throw CreateException if data is not valid

        return null;
    }

    public void ejbPostCreate(java.lang.Integer key) {
        // TODO populate relationships here if appropriate
    }

    public Integer ejbCreate(String answer, String question, Timestamp create_date, String username) throws CreateException{
        if(question == null){
            throw new CreateException("The field \"key\" must not be null");
        }
        setAnswer(answer);
        setQuestion(question);
        setCreateDate(create_date);
        setUsername(username);
        return null;
    }

     public void ejbPostCreate(String answer, String question, Timestamp create_date, String username) {
        // TODO populate relationships here if appropriate
    }

    public abstract Integer getId();

    public abstract void setId(Integer id);

    public abstract String getQuestion();

    public abstract void setQuestion(String question);

    public abstract String getAnswer();

    public abstract void setAnswer(String answer);

    public abstract Timestamp getCreateDate();

    public abstract void setCreateDate(Timestamp createDate);

    public abstract String getUsername();

    public abstract void setUsername(String username);

}
