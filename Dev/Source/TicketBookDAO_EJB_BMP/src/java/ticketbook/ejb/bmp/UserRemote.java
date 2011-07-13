/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ticketbook.ejb.bmp;

import java.rmi.RemoteException;
import javax.ejb.EJBObject;

/**
 *
 * @author Admin
 */
public interface UserRemote extends EJBObject {
    public String getAddress() throws RemoteException;
    public void setAddress(String address) throws RemoteException;
    public String getBirthDate() throws RemoteException;
    public void setBirthDate(String birthDate) throws RemoteException;
    public String getCreateDate() throws RemoteException;
    public void setCreateDate(String createDate) throws RemoteException;
    public String getEmail() throws RemoteException;
    public void setEmail(String email) throws RemoteException;
    public String getFullname() throws RemoteException;
    public void setFullname(String fullname) throws RemoteException;
    public String getPassword() throws RemoteException;
    public void setPassword(String password)throws RemoteException;
    public String getPersonCardNumber() throws RemoteException;
    public void setPersonCardNumber(String personCardNumber) throws RemoteException;
    public String getPhone() throws RemoteException;
    public void setPhone(String phone) throws RemoteException;
    public Integer getRoleID() throws RemoteException;
    public void setRoleID(Integer roleID) throws RemoteException;
    public String getRoleName() throws RemoteException;
    public void setRoleName(String roleName) throws RemoteException;
    public String getUsername() throws RemoteException;
    public void setUsername(String username) throws RemoteException;
}
