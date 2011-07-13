/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ticketbook.ejb.bmp.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import ticketbook.sql.SQLTicketBookConnection;
import ticketbook.transfer.EventTypeTransferData;

/**
 *
 * @author Admin
 */
public class EventTypeDAO {

    static EventTypeDAO eventTypeDAO;
    static SQLTicketBookConnection connection;
    private EventTypeDAO(){}
    
    public static EventTypeDAO getInstance(SQLTicketBookConnection conn){
        EventTypeDAO.connection=conn;
        if(eventTypeDAO==null)
            eventTypeDAO=new EventTypeDAO();
        return eventTypeDAO;
    }

    public ArrayList getEventTypes(){
        ArrayList v=new ArrayList();
        try{
           String sql="SELECT * FROM [event_type]";
           PreparedStatement preparedStatement=connection.getConnection().prepareStatement(sql);
           ResultSet rs=preparedStatement.executeQuery();

            while(rs.next()){
                EventTypeTransferData eventType=new EventTypeTransferData();
                eventType.setID(new Integer(rs.getInt("id")));
                eventType.setName(rs.getNString("name"));
                v.add(eventType);
            }

        }
        catch(Exception ex){
            ex.printStackTrace();
        }
        finally{
            connection.closeConnection();
        }
        
        return v;
    }

    public EventTypeTransferData getEventTypeByID(Integer ID){
       EventTypeTransferData eventType=new EventTypeTransferData();
       
        try{
           String sql="SELECT * FROM [event_type] WHERE id=?";
           PreparedStatement preparedStatement=connection.getConnection().prepareStatement(sql);
           preparedStatement.setInt(1,ID.intValue());
           ResultSet rs=preparedStatement.executeQuery();
            while(rs.next()){
                eventType.setID(new Integer(rs.getInt("id")));
                eventType.setName(rs.getNString("name"));
            }

        }
        catch(Exception ex){
            ex.printStackTrace();
        }
        finally{
            connection.closeConnection();
        }

        return eventType;
    }

}
