/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ticketbook.transfer;

import java.io.Serializable;
import ticketbook.util.Constant;

/**
 *
 * @author Admin
 */
public class EventTypeTransferData implements  Serializable   {

    Integer ID;
    String name;

    public EventTypeTransferData(){
        this.ID=Constant.DEFAULT_VALUE_INTEGER;
        this.name=Constant.DEFAULT_VALUE_STRING;
    }

    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    

   
}
