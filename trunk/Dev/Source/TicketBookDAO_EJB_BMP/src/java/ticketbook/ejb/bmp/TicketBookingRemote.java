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
public interface TicketBookingRemote extends EJBObject {
 
 
    public Integer getID() throws RemoteException;
    public void setID(Integer ID) throws RemoteException;
    public String getAcceptStatus() throws RemoteException;
    public void setAcceptStatus(String acceptStatus) throws RemoteException;
    public String getAdmin() throws RemoteException;
    public void setAdmin(String admin) throws RemoteException;
    public String getDeliveryDate() throws RemoteException;
    public void setDeliveryDate(String deliveryDate) throws RemoteException;
    public String getDiscount() throws RemoteException;
    public void setDiscount(String discount) throws RemoteException;
    public String getPriceTotal() throws RemoteException;
    public void setPriceTotal(String priceTotal) throws RemoteException;
    public Integer getTicketTotal() throws RemoteException;
    public void setTicketTotal(Integer ticketTotal) throws RemoteException;
    public Integer getTicketID() throws RemoteException;
    public void setTicketID(Integer ticketID) throws RemoteException;
    public void setUsername(String username) throws RemoteException;
    public String getUsername() throws RemoteException;
    public String getCardNumber() throws RemoteException;
    public void setCardNumber(String cardNumber) throws RemoteException;
    public Integer getPaymentDetailID() throws RemoteException;
    public void setPaymentDetailID(Integer paymentDetailID) throws RemoteException;
    public Integer getPaymentTypeID() throws RemoteException;
    public void setPaymentTypeID(Integer paymentTypeID) throws RemoteException;
}
