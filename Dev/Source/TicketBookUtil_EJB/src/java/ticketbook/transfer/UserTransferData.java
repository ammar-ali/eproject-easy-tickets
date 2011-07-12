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
public class UserTransferData implements Serializable {

    Integer ID;
    String name;
    String password;
    Integer role;

    public UserTransferData() {
        this.ID = Constant.DEFAULT_VALUE_INTEGER;
        this.name = Constant.DEFAULT_VALUE_STRING;
        this.password = Constant.DEFAULT_VALUE_STRING;
        this.role = Constant.DEFAULT_VALUE_INTEGER;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getRole() {
        return role;
    }

    public void setRole(Integer role) {
        this.role = role;
    }
}
