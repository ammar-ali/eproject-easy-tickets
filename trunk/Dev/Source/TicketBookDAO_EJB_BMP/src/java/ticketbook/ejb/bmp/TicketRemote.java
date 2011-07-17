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
public interface TicketRemote extends EJBObject {

    public Integer getID() throws RemoteException;
    public void setID(Integer ID) throws RemoteException;
    public String getArtist() throws RemoteException;
    public void setArtist(String artist) throws RemoteException;
    public Integer getCityID() throws RemoteException;
    public void setCityID(Integer cityID) throws RemoteException;
    public String getCityName() throws RemoteException;
    public void setCityName(String cityName) throws RemoteException;
    public String getContent() throws RemoteException;
    public void setContent(String content) throws RemoteException;
    public String getCreateDate() throws RemoteException;
    public void setCreateDate(String createDate) throws RemoteException;
    public String getCreateUsername() throws RemoteException;
    public void setCreateUsername(String createUsername) throws RemoteException;
    public String getDiscount() throws RemoteException;
    public void setDiscount(String discount) throws RemoteException;
    public Integer getEventID() throws RemoteException;
    public void setEventID(Integer eventID) throws RemoteException;
    public Integer getEventTypeID() throws RemoteException;
    public void setEventTypeID(Integer eventTypeID) throws RemoteException;
    public String getImage() throws RemoteException;
    public void setImage(String image) throws RemoteException;
    public String getPrice() throws RemoteException;
    public void setPrice(String price) throws RemoteException;
    public String getPromotion() throws RemoteException;
    public void setPromotion(String promotion) throws RemoteException;
    public Integer getTicketTotal() throws RemoteException;
    public void setTicketTotal(Integer ticketTotal) throws RemoteException;
    public String getTitle() throws RemoteException;
    public void setTitle(String title) throws RemoteException;
    public String getVenueAddress() throws RemoteException;
    public void setVenueAddress(String venueAddress) throws RemoteException;
    public Integer getVenueID() throws RemoteException;
    public void setVenueID(Integer venueID) throws RemoteException;
    public String getVenueName() throws RemoteException;
    public void setVenueName(String venueName) throws RemoteException;
    public String getViewDate() throws RemoteException;
    public void setViewDate(String viewDate) throws RemoteException;
    public String getViewTime() throws RemoteException;
    public void setViewTime(String viewTime) throws RemoteException;
    public String getViewStatus() throws RemoteException;
    public void setViewStatus(String viewStatus) throws RemoteException;

    public Integer countByEventTypeID(Integer eventTypeID) throws RemoteException;
}
