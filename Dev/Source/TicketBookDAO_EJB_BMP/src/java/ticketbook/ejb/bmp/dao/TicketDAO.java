/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ticketbook.ejb.bmp.dao;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import ticketbook.exception.SQLTicketBookException;
import ticketbook.sql.SQLTicketBookConnection;
import ticketbook.transfer.TicketTransferData;
import ticketbook.util.StringUtil;

/**
 *
 * @author Admin
 */
public class TicketDAO {

    static TicketDAO ticketDAO;
    static SQLTicketBookConnection connection;

    private TicketDAO() {
    }

    public static TicketDAO getInstance(SQLTicketBookConnection conn) {
        TicketDAO.connection = conn;
        if (ticketDAO == null) {
            ticketDAO = new TicketDAO();
        }
        return ticketDAO;
    }

    public ArrayList getTicketIDsByEventTypeID(Integer eventTypeID, int indexRecord, int totalRecord) throws SQLTicketBookException {
        ArrayList lst = new ArrayList();
        try {

            CallableStatement csmt = connection.getConnection().prepareCall("{call sp_get_ticket(?,?,?)}");

            csmt.setInt("event_typeID", eventTypeID.intValue());
            csmt.setInt("index_start", indexRecord);
            csmt.setInt("total_record", totalRecord);
            ResultSet rs = csmt.executeQuery();
            while (rs.next()) {
                Integer ticketID = new Integer(rs.getInt("ID"));
                lst.add(ticketID);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return lst;
    }

    public TicketTransferData getTicketByID(Integer ticketID) throws SQLTicketBookException {
        TicketTransferData ticket = new TicketTransferData();
        try {
            String sql = "SELECT ticket.ID AS ID,promotion,discount,price,ticket_total,create_date,view_date,view_time,create_username,[ticket].eventID "
                          +  " ,title,[content], artist,[image],event_typeID,venueID,cityID,city.name AS city_name,venue.name AS venue_name,venue.address AS venue_address "
                    +" FROM [ticket],[event],[city],[venue] WHERE [ticket].eventID=[event].ID AND ticket.ID=? AND event.cityID=city.ID AND event.venueID=venue.ID";
            PreparedStatement pre = connection.getConnection().prepareStatement(sql);
            pre.setInt(1, ticketID.intValue());
            ResultSet rs = pre.executeQuery();
            while (rs.next())
                ticket=this.mapping(rs);
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return ticket;
    }

    private TicketTransferData mapping(ResultSet rs) throws SQLException {
        TicketTransferData ticket = new TicketTransferData();
        ticket.setID(new Integer(rs.getInt("ID")));
        ticket.setPromotion(StringUtil.convertToUTF8(rs.getString("promotion")));
        ticket.setPrice(rs.getString("price"));
        ticket.setTicketTotal(new Integer(rs.getInt("ticket_total")));
        ticket.setCreateDate(rs.getString("create_date"));
        ticket.setViewDate(rs.getString("view_date"));
        ticket.setViewTime(rs.getString("view_time"));
        ticket.setCreateUsername(rs.getString("create_username"));
        ticket.setEventID(new Integer(rs.getInt("eventID")));
        ticket.setTitle(StringUtil.convertToUTF8(rs.getString("title")));
        ticket.setContent(StringUtil.convertToUTF8(rs.getString("content")));
        ticket.setArtist(StringUtil.convertToUTF8(rs.getString("artist")));
        ticket.setImage(rs.getString("image"));
        ticket.setEventTypeID(new Integer(rs.getInt("event_typeID")));
        ticket.setVenueID(new Integer(rs.getInt("venueID")));
        ticket.setCityID(new Integer(rs.getInt("cityID")));
        ticket.setCityName(StringUtil.convertToUTF8(rs.getString("city_name")));
        ticket.setVenueAddress(StringUtil.convertToUTF8(rs.getString("venue_address")));
        ticket.setVenueName(StringUtil.convertToUTF8(rs.getString("venue_name")));
        return ticket;
    }
}
