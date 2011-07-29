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
public interface EventRemote extends EJBObject {

    public Integer getID() throws RemoteException;

    public String getArtist() throws RemoteException;

    public Integer getCityID() throws RemoteException;

    public String getContent() throws RemoteException;

    public Integer getEventTypeID() throws RemoteException;

    public String getImage() throws RemoteException;

    public String getTitle() throws RemoteException;

    public Integer getVenueID() throws RemoteException;

    public void setID(Integer ID) throws RemoteException;

    public void setArtist(String artist) throws RemoteException;

    public void setCityID(Integer cityID) throws RemoteException;

    public void setContent(String content) throws RemoteException;

    public void setEventTypeID(Integer eventTypeID) throws RemoteException;

    public void setImage(String image) throws RemoteException;

    public void setTitle(String title) throws RemoteException;

    public void setVenueID(Integer venueID) throws RemoteException;

    public String getCityName() throws RemoteException;

    public void setCityName(String cityName) throws RemoteException;

    public String getEventTypeName() throws RemoteException;

    public void setEventTypeName(String eventTypeName) throws RemoteException;

    public String getVenueName() throws RemoteException;

    public void setVenueName(String venueName) throws RemoteException;

    public String getVenueAddress() throws RemoteException;

    public void setVenueAddress(String venueAddress) throws RemoteException;
    
    public Integer countAllEvent() throws RemoteException;
}
