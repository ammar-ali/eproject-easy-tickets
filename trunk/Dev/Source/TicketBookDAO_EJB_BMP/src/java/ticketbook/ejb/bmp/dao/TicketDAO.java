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

    public ArrayList getTicketIDsByEventTypeID(Integer eventTypeID,Integer cityID, int indexRecord, int totalRecord) throws SQLTicketBookException {
        ArrayList lst = new ArrayList();
        try {

            CallableStatement csmt = connection.getConnection().prepareCall("{call sp_get_ticket(?,?,?,?)}");

            csmt.setInt("event_typeID", eventTypeID.intValue());
            csmt.setInt("cityID",cityID.intValue());
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
        finally{
            connection.closeConnection();
        }
        return lst;
    }

    

    public ArrayList getTopTicketIDsByEventTypeID(Integer eventTypeID, Integer top) throws SQLTicketBookException {
        ArrayList lst = new ArrayList();
        try {
            String sql="SELECT TOP "+top+" ticket.ID FROM ticket,event WHERE ticket.eventID=[event].ID AND [event].event_typeID=? ORDER BY ticket.ID DESC";
            PreparedStatement pre = connection.getConnection().prepareStatement(sql);
            pre.setInt(1,top.intValue());
            pre.setInt(1,eventTypeID.intValue());
            ResultSet rs = pre.executeQuery();
            while (rs.next()) {
                Integer ticketID = new Integer(rs.getInt("ID"));
                lst.add(ticketID);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        finally{
            connection.closeConnection();
        }
        return lst;
    }

    public ArrayList getAvailableReferenceTicketIDsByTitle(String title) throws SQLTicketBookException {
        ArrayList lst = new ArrayList();
        try {
            String sql="SELECT ticket.ID FROM ticket,[event] "
                    +" WHERE [event].title = ? AND ticket.eventID=event.ID "
                    + " AND ticket_total !=0 AND  view_date>GETDATE() "
                    +" ORDER BY ticket.ID DESC ";
            PreparedStatement pre = connection.getConnection().prepareStatement(sql);
            pre.setString(1,StringUtil.convertToUTF8(title));
           
            ResultSet rs = pre.executeQuery();
            while (rs.next()) {
                Integer ticketID = new Integer(rs.getInt("ID"));
                lst.add(ticketID);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        finally{
            connection.closeConnection();
        }
        return lst;
    }
    
    public TicketTransferData getTicketByID(Integer ticketID) throws SQLTicketBookException {
        TicketTransferData ticket = new TicketTransferData();
        try {
            String sql = "SELECT ticket.ID AS ID,promotion,discount,price,ticket_total,create_date,view_date,view_time,create_username,[ticket].eventID "
                          +  " ,title,[content], artist,[image],event_typeID,venueID,cityID,city.name AS city_name,venue.name AS venue_name,venue.address AS venue_address,'view_status' = CASE WHEN DATEDIFF(dd,GETDATE(),ticket.view_date) > 0 AND ticket_total >0 THEN 'New' ELSE 'Old' END "
                    +" FROM [ticket],[event],[city],[venue] WHERE [ticket].eventID=[event].ID AND ticket.ID=? AND cityID=city.ID AND venueID=venue.ID";
            PreparedStatement pre = connection.getConnection().prepareStatement(sql);
            pre.setInt(1, ticketID.intValue());
            ResultSet rs = pre.executeQuery();
            while (rs.next())
                ticket=this.mapping(rs);
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }finally{
            connection.closeConnection();
        }
        return ticket;
    }

     public Integer countRecordFindByEventTypeID(Integer eventTypeID,Integer cityID) throws SQLTicketBookException {
       
        try {
            String sql = "SELECT COUNT(ticket.ID) AS TOTAL"
                    +" FROM [ticket],[event] WHERE [ticket].eventID=[event].ID AND [event].event_typeID = ?";
            Integer o=new Integer(0);
            if(!cityID.equals(o))
                    sql=sql+" "+" AND event.cityID=? ";
            PreparedStatement pre = connection.getConnection().prepareStatement(sql);
            pre.setInt(1, eventTypeID.intValue());
            if(!cityID.equals(o))
                 pre.setInt(2, cityID.intValue());
            ResultSet rs = pre.executeQuery();
            while (rs.next()){
                return new Integer(rs.getInt("Total"));
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }finally{
            connection.closeConnection();
        }
        return new Integer(0);
    }

    private TicketTransferData mapping(ResultSet rs) throws SQLException {
        TicketTransferData ticket = new TicketTransferData();
        ticket.setID(new Integer(rs.getInt("ID")));
        ticket.setPromotion(rs.getNString("promotion"));
        ticket.setPrice(rs.getString("price"));
        ticket.setTicketTotal(new Integer(rs.getInt("ticket_total")));
        ticket.setCreateDate(rs.getString("create_date"));
        ticket.setViewDate(rs.getString("view_date"));
        ticket.setViewTime(rs.getString("view_time"));
        ticket.setCreateUsername(rs.getString("create_username"));
        ticket.setEventID(new Integer(rs.getInt("eventID")));
        ticket.setTitle(rs.getNString("title"));
        ticket.setContent(rs.getNString("content"));
        ticket.setArtist(rs.getNString("artist"));
        ticket.setImage(rs.getString("image"));
        ticket.setEventTypeID(new Integer(rs.getInt("event_typeID")));
        ticket.setVenueID(new Integer(rs.getInt("venueID")));
        ticket.setCityID(new Integer(rs.getInt("cityID")));
        ticket.setCityName(rs.getNString("city_name"));
        ticket.setVenueAddress(rs.getNString("venue_address"));
        ticket.setVenueName(rs.getNString("venue_name"));
        if(rs.getString("view_status")!=null)
            ticket.setViewStatus(rs.getString("view_status"));
        return ticket;
    }
//
//
//    public static void main(String[] arg){
//        try {
//            Integer c = TicketDAO.getInstance(SQLTicketBookConnection.getInstance()).countRecordFindByEventTypeID(new Integer(1),new Integer(0));
//            System.out.print(c);
//        } catch (SQLTicketBookException ex) {
//            ex.printStackTrace();
//        }
//    }
}
