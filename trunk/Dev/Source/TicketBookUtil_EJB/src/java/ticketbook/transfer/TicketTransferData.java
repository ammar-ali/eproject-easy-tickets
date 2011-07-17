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
public class TicketTransferData implements  Serializable{
    
    private Integer ID;
    private String promotion;
    private String discount;
    private String price;
    private Integer ticketTotal;
    private String createDate;
    private String viewDate;
    private String viewTime;
    private String createUsername;
    private Integer eventID;
    private String title;
    private String content;
    private String artist;
    private String image;
    private Integer eventTypeID;
    private String viewStatus;

  
    private Integer venueID;
    private Integer cityID;
    private String cityName;
    private String venueAddress;

    private String venueName;

    public TicketTransferData(){
        this.ID=Constant.ID_FALSE_INTETER;
        this.artist=Constant.DEFAULT_VALUE_STRING;
        this.cityID=Constant.ID_FALSE_INTETER;
        this.cityName=Constant.DEFAULT_VALUE_STRING;
        this.content=Constant.DEFAULT_VALUE_STRING;
        this.createDate=Constant.DEFAULT_VALUE_STRING;
        this.createUsername=Constant.DEFAULT_VALUE_STRING;
        this.discount=Constant.DEFAULT_VALUE_STRING;
        this.eventID=Constant.ID_FALSE_INTETER;
        this.eventTypeID=Constant.ID_FALSE_INTETER;
        this.image=Constant.DEFAULT_VALUE_STRING;
        this.price=Constant.DEFAULT_VALUE_STRING;
        this.promotion=Constant.DEFAULT_VALUE_STRING;
        this.ticketTotal=Constant.DEFAULT_VALUE_INTEGER;
        this.title=Constant.DEFAULT_VALUE_STRING;
        this.venueAddress=Constant.DEFAULT_VALUE_STRING;
        this.venueID=Constant.ID_FALSE_INTETER;
        this.viewStatus=Constant.DEFAULT_VALUE_STRING;

    }

    public String getViewStatus() {
        return viewStatus;
    }

    public void setViewStatus(String viewStatus) {
        this.viewStatus = viewStatus;
    }

    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public Integer getCityID() {
        return cityID;
    }

    public void setCityID(Integer cityID) {
        this.cityID = cityID;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public String getCreateUsername() {
        return createUsername;
    }

    public void setCreateUsername(String createUsername) {
        this.createUsername = createUsername;
    }

    public String getDiscount() {
        return discount;
    }

    public void setDiscount(String discount) {
        this.discount = discount;
    }

    public Integer getEventID() {
        return eventID;
    }

    public void setEventID(Integer eventID) {
        this.eventID = eventID;
    }

    public Integer getEventTypeID() {
        return eventTypeID;
    }

    public void setEventTypeID(Integer eventTypeID) {
        this.eventTypeID = eventTypeID;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getPromotion() {
        return promotion;
    }

    public void setPromotion(String promotion) {
        this.promotion = promotion;
    }

    public Integer getTicketTotal() {
        return ticketTotal;
    }

    public void setTicketTotal(Integer ticketTotal) {
        this.ticketTotal = ticketTotal;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getVenueAddress() {
        return venueAddress;
    }

    public void setVenueAddress(String venueAddress) {
        this.venueAddress = venueAddress;
    }

    public Integer getVenueID() {
        return venueID;
    }

    public void setVenueID(Integer venueID) {
        this.venueID = venueID;
    }

    public String getVenueName() {
        return venueName;
    }

    public void setVenueName(String venueName) {
        this.venueName = venueName;
    }

    public String getViewDate() {
        return viewDate;
    }

    public void setViewDate(String viewDate) {
        this.viewDate = viewDate;
    }

    public String getViewTime() {
        return viewTime;
    }

    public void setViewTime(String viewTime) {
        this.viewTime = viewTime;
    }
    

}
