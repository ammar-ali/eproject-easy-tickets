/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ticketbook.ejb.bmp.dao;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import ticketbook.exception.SQLTicketBookException;
import ticketbook.sql.SQLTicketBookConnection;
import ticketbook.transfer.EventTransferData;
import ticketbook.util.Constant;
import ticketbook.util.StringUtil;

/**
 *
 * @author Admin
 */
public class EventDAO {

    static EventDAO eventDAO;
    static SQLTicketBookConnection connection;

    private EventDAO() {
    }

    public static EventDAO getInstance(SQLTicketBookConnection conn) {
        EventDAO.connection = conn;
        if (eventDAO == null) {
            eventDAO = new EventDAO();
        }
        return eventDAO;
    }

    public void insertEvent(EventTransferData event) {
        try {
            CallableStatement cs = connection.getConnection().prepareCall("{call sp_insert_event(?,?,?,?,?,?,?,?)}");
            cs.registerOutParameter("ID", java.sql.Types.INTEGER);
            cs.setString("title", StringUtil.convertToUTF8(event.getTitle()));
            cs.setString("content", StringUtil.convertToUTF8(event.getContent()));
            cs.setString("artist", StringUtil.convertToUTF8(event.getArtist()));
            cs.setString("image", event.getImage());
            cs.setInt("eventTypeID", event.getEventTypeID().intValue());
            cs.setInt("venueID", event.getVenueID().intValue());
            cs.setInt("cityID", event.getCityID().intValue());
            cs.execute();
            if (cs.getInt("ID") != Constant.ID_FALSE_INTETER.intValue()) {
                event.setID(new Integer(cs.getInt("ID")));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            connection.closeConnection();
        }
    }
    public ArrayList getAllEventID(int indexRecord,int totalRecord){
 
        try {
            ArrayList listID=new ArrayList();
            CallableStatement csmt = connection.getConnection().prepareCall("{call sp_get_event(?,?)}");
            csmt.setInt("index_start", indexRecord);
            csmt.setInt("total_record", totalRecord);
            ResultSet rs=csmt.executeQuery();
            while(rs.next()){
                listID.add(new Integer(rs.getInt("ID")));
            }
            return listID;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return new ArrayList();
    }
    public EventTransferData getEventByID(Integer ID){
        String sql="SELECT event.ID,event.title,event.content,event.artist,event.image,event.event_typeID,event.venueID,event.cityID,event_type.name AS eventTypeName,venue.name AS venueName,city.name AS cityName,address AS venueAddress FROM [event],event_type,venue,city WHERE event.event_typeID=event_type.ID AND event.venueID=venue.ID AND event.cityID=city.ID AND event.ID=?";
        PreparedStatement pre;
        EventTransferData eventData=new EventTransferData();
        try {
            pre = connection.getConnection().prepareCall(sql);
            pre.setInt(1, ID.intValue());
            ResultSet rs=pre.executeQuery();
            while(rs.next()){
                eventData.setID(new Integer(rs.getInt("ID")));
                eventData.setArtist(StringUtil.convertToUTF8(rs.getString("artist")));
                eventData.setContent(StringUtil.convertToUTF8(rs.getString("content")));
                eventData.setTitle(StringUtil.convertToUTF8(rs.getString("title")));
                eventData.setImage(rs.getString("image"));
                eventData.setEventTypeID(new Integer(rs.getInt("event_typeID")));
                eventData.setVenueID(new Integer(rs.getInt("venueID")));
                eventData.setCityID(new Integer(rs.getInt("cityID")));
                eventData.setEventTypeName(StringUtil.convertToUTF8(rs.getString("eventTypeName")));
                eventData.setVenueName(StringUtil.convertToUTF8(rs.getString("venueName")));
                eventData.setVenueAddress(StringUtil.convertToUTF8(rs.getString("venueAddress")));
                eventData.setCityName(StringUtil.convertToUTF8( rs.getString("cityName")));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return eventData;
    }
    public Integer countAllEvent(){
        String sql="SELECT COUNT(*) AS count FROM event";
        PreparedStatement pre;
        try {
            
            pre = connection.getConnection().prepareCall(sql);
             ResultSet rs=pre.executeQuery();
             while(rs.next()){
                return new Integer(rs.getInt("count"));
             }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return new Integer(0);
    }
}
