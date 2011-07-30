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
import ticketbook.transfer.ContactTransferData;

/**
 *
 * @author QuocHai
 */
public class ContactDAO {
    static ContactDAO contactDAO;
    static  SQLTicketBookConnection connection;

    private ContactDAO(){
    }

    public static ContactDAO getInstance(SQLTicketBookConnection conn){
        ContactDAO.connection = conn;
        if(contactDAO == null){
            contactDAO = new ContactDAO();
        }
        return contactDAO;
    }

    public ArrayList getAll(int index, int total) throws SQLTicketBookException{
        ArrayList lst = new ArrayList();
        try {
            CallableStatement csmt = connection.getConnection().prepareCall("{call sp_get_contact(?,?)}");
            csmt.setInt("index_start", index);
            csmt.setInt("total_record", total);
            ResultSet rs = csmt.executeQuery();
            while (rs.next()) {
                Integer contactID = new Integer(rs.getInt("ID"));
                lst.add(contactID);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            connection.closeConnection();
        }
        return lst;
   }

    public ContactTransferData getContactByID(Integer contactID) throws SQLTicketBookException {
            ContactTransferData contact = new ContactTransferData();
            try {
                String sql = "SELECT ID, title, content, answer, email, CONVERT(VARCHAR(20),create_date,101) AS create_date, username"
                        +" FROM [contact] WHERE ID = ?";
                PreparedStatement pre = connection.getConnection().prepareStatement(sql);
                pre.setInt(1, contactID.intValue());
                ResultSet rs = pre.executeQuery();
                while (rs.next()){
                    contact.setID(new Integer(rs.getInt("ID")));
                    contact.setTitle(rs.getNString("title"));
                    contact.setContent(rs.getNString("[content]"));
                    contact.setAnswer(rs.getNString("answer"));
                    contact.setEmail(rs.getString("email"));
                    contact.setCreateDate(rs.getString("create_date"));
                    contact.setUsername(rs.getString("username"));
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }finally{
                connection.closeConnection();
            }
            return contact;
        }

    public Integer countRecordFindAll() throws SQLTicketBookException {
        Integer o = new Integer(0);
        try {
            String sql = "SELECT COUNT(ID) AS COUNT "
                    +" FROM [contact]";

            PreparedStatement pre = connection.getConnection().prepareStatement(sql);
            ResultSet rs = pre.executeQuery();
            while (rs.next()){
                return new Integer(rs.getInt("COUNT"));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }finally{
            connection.closeConnection();
        }
        return o;
    }
}
