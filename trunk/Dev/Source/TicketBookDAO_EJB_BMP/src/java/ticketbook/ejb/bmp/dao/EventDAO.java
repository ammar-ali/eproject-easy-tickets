/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ticketbook.ejb.bmp.dao;

import java.sql.CallableStatement;
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
}
