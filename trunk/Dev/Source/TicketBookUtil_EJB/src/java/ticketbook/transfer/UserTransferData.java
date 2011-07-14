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

    private String username;
    private String password;
    private String fullname;
    private String phone;
    private String address;
    private String email;
    private String createDate;
    private String birthDate;
    private String personCardNumber;
    private Integer roleID;
    private String roleName;

    public UserTransferData() {
        this.username = Constant.ID_FALSE_STRING;
        this.password = Constant.DEFAULT_VALUE_STRING;
        this.fullname = Constant.DEFAULT_VALUE_STRING;
        this.phone = Constant.DEFAULT_VALUE_STRING;
        this.address = Constant.DEFAULT_VALUE_STRING;
        this.email = Constant.DEFAULT_VALUE_STRING;
        this.createDate = Constant.DEFAULT_VALUE_STRING;
        this.birthDate = Constant.DEFAULT_VALUE_STRING;
        this.personCardNumber = Constant.DEFAULT_VALUE_STRING;
        this.roleID = Constant.ID_FALSE_INTETER;
        this.roleName = Constant.DEFAULT_VALUE_STRING;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPersonCardNumber() {
        return personCardNumber;
    }

    public void setPersonCardNumber(String personCardNumber) {
        this.personCardNumber = personCardNumber;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Integer getRoleID() {
        return roleID;
    }

    public void setRoleID(Integer roleID) {
        this.roleID = roleID;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
