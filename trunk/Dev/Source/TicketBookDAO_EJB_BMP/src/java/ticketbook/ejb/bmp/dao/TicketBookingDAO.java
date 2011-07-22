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
import ticketbook.transfer.TicketBookingTransferData;
import ticketbook.util.Constant;

/**
 *
 * @author Admin
 */
public class TicketBookingDAO{

    static TicketBookingDAO ticketBookingDAO;
    static SQLTicketBookConnection connection;

    private TicketBookingDAO() {
    }

    public static TicketBookingDAO getInstance(SQLTicketBookConnection conn) {
        TicketBookingDAO.connection = conn;
        if (ticketBookingDAO == null) {
            ticketBookingDAO = new TicketBookingDAO();
        }
        return ticketBookingDAO;
    }

    public TicketBookingTransferData getTicketBookingByID(Integer ID){
       TicketBookingTransferData booking=new TicketBookingTransferData();

        try{
           String sql="SELECT ticket_booking.ID,ticketID,username,[admin],ticket_total,price_total,discount,accept_status,payment_detailID,CONVERT(VARCHAR(20),delivery_date,101) As delivery_date,card_number,payment_typeID FROM [ticket_booking],payment_detail WHERE ticket_booking.id=? AND ticket_booking.payment_detailID=payment_detail.ID";
           PreparedStatement preparedStatement=connection.getConnection().prepareStatement(sql);
           preparedStatement.setInt(1,ID.intValue());
           ResultSet rs=preparedStatement.executeQuery();
           while(rs.next()){
                booking=this.mapping(rs);
           }

        }
        catch(Exception ex){
            ex.printStackTrace();
        }
        finally{
            connection.closeConnection();
        }

        return booking;
    }

    public ArrayList getTicketBookingIDsByStatus(String status, int indexStart,int totalRecord){
       ArrayList booking=new ArrayList();

        try{
           CallableStatement csmt = connection.getConnection().prepareCall("{call sp_get_ticketbooking(?,?,?)}");
           csmt.setString("accept_status", status);
           csmt.setInt("index_start", indexStart);
           csmt.setInt("total_record", totalRecord);
           ResultSet rs=csmt.executeQuery();
           while(rs.next()){
                booking.add(new Integer(rs.getInt("ID")));
           }

        }
        catch(Exception ex){
            ex.printStackTrace();
        }
        finally{
            connection.closeConnection();
        }

        return booking;
    }

    public void insert(TicketBookingTransferData data){
         try {

            CallableStatement csmt = connection.getConnection().prepareCall("{call sp_insert_ticketbooking(?,?,?,?,?,?,?,?,?)}");
            csmt.registerOutParameter("ID",java.sql.Types.INTEGER);
            csmt.registerOutParameter("payment_detailID",java.sql.Types.INTEGER);
            
            csmt.setInt("ticketID",data.getTicketID().intValue());
            csmt.setString("username",data.getUsername());
            csmt.setInt("ticket_total",data.getTicketTotal().intValue());
            csmt.setString("price_total",data.getPriceTotal());
            csmt.setString("discount",data.getDiscount());
            csmt.setString("card_number",data.getCardNumber());
            csmt.setInt("payment_typeID",data.getPaymentTypeID().intValue());
            csmt.execute();
            if(csmt.getInt("ID")!=Constant.ID_FALSE_INTETER.intValue()){
                data.setID(new Integer(csmt.getInt("ID")));
                data.setPaymentDetailID(new Integer(csmt.getInt("payment_detailID")));
            }
            
        } catch (SQLTicketBookException ex) {
            ex.printStackTrace();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        finally{
            connection.closeConnection();
        }
    }

    public TicketBookingTransferData mapping(ResultSet rs){
        TicketBookingTransferData data = new TicketBookingTransferData();
        try {
            data.setID(new Integer(rs.getInt("ID")));
            data.setTicketID(new Integer(rs.getInt("ticketID")));
            data.setUsername(rs.getString("username"));
            data.setAdmin(rs.getString("admin"));
            data.setTicketTotal(new Integer(rs.getInt("ticket_total")));
            data.setPriceTotal(rs.getString("price_total"));
            data.setDiscount(rs.getString("discount"));
            data.setAcceptStatus(rs.getString("accept_status"));
            data.setPaymentDetailID(new Integer(rs.getInt("payment_detailID")));
            data.setDeliveryDate(rs.getString("delivery_date"));
            data.setCardNumber(rs.getString("card_number"));
            data.setPaymentTypeID(new Integer(rs.getString("payment_typeID")));
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return data;
    }

    public void updateAcceptStatusByID(Integer ID,String status){
        try {
            String sql = "UPDATE ticket_booking SET accept_status=?,delivery_date=GETDATE() WHERE ID=?";
            PreparedStatement preparedStatement = connection.getConnection().prepareStatement(sql);
            preparedStatement.setString(1,status);
            preparedStatement.setInt(2, ID.intValue());
            ResultSet rs = preparedStatement.executeQuery();
        } catch (SQLTicketBookException ex) {
            ex.printStackTrace();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

}
