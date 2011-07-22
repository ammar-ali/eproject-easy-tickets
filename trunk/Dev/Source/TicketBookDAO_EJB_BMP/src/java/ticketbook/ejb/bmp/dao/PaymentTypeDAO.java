/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ticketbook.ejb.bmp.dao;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import ticketbook.sql.SQLTicketBookConnection;
import ticketbook.transfer.PaymentTypeTransferData;

/**
 *
 * @author Admin
 */
public class PaymentTypeDAO{
    static PaymentTypeDAO paymentTypeDAO;
    static SQLTicketBookConnection connection;
    private PaymentTypeDAO(){}

    public static PaymentTypeDAO getInstance(SQLTicketBookConnection conn){
        PaymentTypeDAO.connection=conn;
        if(paymentTypeDAO==null)
            paymentTypeDAO=new PaymentTypeDAO();
        return paymentTypeDAO;
    }

    public ArrayList getPaymentTypeIDs(){
        ArrayList v=new ArrayList();
        try{
           String sql="SELECT * FROM [payment_type]";
           PreparedStatement preparedStatement=connection.getConnection().prepareStatement(sql);
           ResultSet rs=preparedStatement.executeQuery();

            while(rs.next()){
                v.add(new Integer(rs.getInt("ID")));
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


    public PaymentTypeTransferData getPaymentTypeByID(Integer ID){
       PaymentTypeTransferData city=new PaymentTypeTransferData();

        try{
           String sql="SELECT * FROM [payment_type] WHERE id=?";
           PreparedStatement preparedStatement=connection.getConnection().prepareStatement(sql);
           preparedStatement.setInt(1,ID.intValue());
           ResultSet rs=preparedStatement.executeQuery();
            while(rs.next()){
                city.setID(new Integer(rs.getInt("id")));
                city.setName(rs.getNString("name"));
            }

        }
        catch(Exception ex){
            ex.printStackTrace();
        }
        finally{
            connection.closeConnection();
        }

        return city;
    }
}
