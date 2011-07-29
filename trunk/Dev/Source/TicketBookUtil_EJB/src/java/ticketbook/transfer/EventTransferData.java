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
public class EventTransferData implements Serializable {
   private  Integer ID;
    private String title;
    private String content;
    private String artist;
    private String image;
    private Integer eventTypeID;
    private Integer venueID;
    private Integer cityID;
    private String eventTypeName;
    private String venueName;
    private String cityName;
    private String venueAddress;
    public EventTransferData(){
        this.ID=Constant.ID_FALSE_INTETER;
        this.title=Constant.DEFAULT_VALUE_STRING;
        this.artist=Constant.DEFAULT_VALUE_STRING;
        this.cityID=Constant.ID_FALSE_INTETER;
        this.content=Constant.DEFAULT_VALUE_STRING;
        this.eventTypeID=Constant.ID_FALSE_INTETER;
        this.image=Constant.DEFAULT_VALUE_STRING;
        this.venueID=Constant.ID_FALSE_INTETER;
        this.eventTypeName=Constant.DEFAULT_VALUE_STRING;
        this.venueName=Constant.DEFAULT_VALUE_STRING;
        this.cityName=Constant.DEFAULT_VALUE_STRING;
        this.venueAddress=Constant.DEFAULT_VALUE_STRING;
    }

    public String getVenueAddress() {
        return venueAddress;
    }

    public void setVenueAddress(String venueAddress) {
        this.venueAddress = venueAddress;
    }

    
    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getEventTypeName() {
        return eventTypeName;
    }

    public void setEventTypeName(String eventTypeName) {
        this.eventTypeName = eventTypeName;
    }

    public String getVenueName() {
        return venueName;
    }

    public void setVenueName(String venueName) {
        this.venueName = venueName;
    }

    public Integer getID() {
        return ID;
    }

    public String getArtist() {
        return artist;
    }

    public Integer getCityID() {
        return cityID;
    }

    public String getContent() {
        return content;
    }

    public Integer getEventTypeID() {
        return eventTypeID;
    }

    public String getImage() {
        return image;
    }

    public String getTitle() {
        return title;
    }

    public Integer getVenueID() {
        return venueID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public void setCityID(Integer cityID) {
        this.cityID = cityID;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setEventTypeID(Integer eventTypeID) {
        this.eventTypeID = eventTypeID;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setVenueID(Integer venueID) {
        this.venueID = venueID;
    }


}
