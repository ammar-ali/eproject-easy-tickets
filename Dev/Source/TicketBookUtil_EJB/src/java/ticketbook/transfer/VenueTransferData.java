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
public class VenueTransferData implements Serializable {
    private Integer ID;
    private String name;
    private String address;

    public VenueTransferData(){
        this.ID=Constant.ID_FALSE_INTETER;
        this.name=Constant.DEFAULT_VALUE_STRING;
        this.address=Constant.DEFAULT_VALUE_STRING;
    }
    public void setAddress(String address) {
        this.address = address;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getID() {
        return ID;
    }

    public String getAddress() {
        return address;
    }

    public String getName() {
        return name;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }
}
