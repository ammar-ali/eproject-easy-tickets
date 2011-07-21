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
public class TicketBookingTransferData implements  Serializable {

    Integer ID;
    Integer ticketID;
    String username;
    String admin;
    Integer ticketTotal;
    String priceTotal;
    String discount;
    String acceptStatus;    
    String deliveryDate;
    
    Integer paymentDetailID;
    String cardNumber;
    Integer paymentTypeID;

    public TicketBookingTransferData(){
        this.ID=Constant.ID_FALSE_INTETER;
        this.ticketID=Constant.ID_FALSE_INTETER;
        this.username=Constant.ID_FALSE_STRING;
        this.admin=Constant.ID_FALSE_STRING;
        this.ticketTotal=Constant.DEFAULT_VALUE_INTEGER;
        this.priceTotal=Constant.DEFAULT_VALUE_STRING;
        this.discount=Constant.DEFAULT_VALUE_STRING;
        this.acceptStatus=Constant.DEFAULT_VALUE_STRING;
        this.deliveryDate=Constant.DEFAULT_VALUE_STRING;
        this.paymentDetailID=Constant.ID_FALSE_INTETER;
        this.cardNumber=Constant.DEFAULT_VALUE_STRING;
        this.paymentTypeID=Constant.ID_FALSE_INTETER;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public Integer getPaymentDetailID() {
        return paymentDetailID;
    }

    public void setPaymentDetailID(Integer paymentDetailID) {
        this.paymentDetailID = paymentDetailID;
    }

    public Integer getPaymentTypeID() {
        return paymentTypeID;
    }

    public void setPaymentTypeID(Integer paymentTypeID) {
        this.paymentTypeID = paymentTypeID;
    }

    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public String getAcceptStatus() {
        return acceptStatus;
    }

    public void setAcceptStatus(String acceptStatus) {
        this.acceptStatus = acceptStatus;
    }

    public String getAdmin() {
        return admin;
    }

    public void setAdmin(String admin) {
        this.admin = admin;
    }

    public String getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(String deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public String getDiscount() {
        return discount;
    }

    public void setDiscount(String discount) {
        this.discount = discount;
    }


    public String getPriceTotal() {
        return priceTotal;
    }

    public void setPriceTotal(String priceTotal) {
        this.priceTotal = priceTotal;
    }

    public Integer getTicketTotal() {
        return ticketTotal;
    }

    public void setTicketTotal(Integer ticketTotal) {
        this.ticketTotal = ticketTotal;
    }

    public Integer getTicketID() {
        return ticketID;
    }

    public void setTicketID(Integer ticketID) {
        this.ticketID = ticketID;
    }


    public void setUsername(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }
}
