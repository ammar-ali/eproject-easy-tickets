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
import ticketbook.transfer.FaqTransferData;

/**
 *
 * @author QuocHai
 */
public class FaqDAO {
     static FaqDAO faqDAO;
    static SQLTicketBookConnection connection;

    private FaqDAO() {
    }

    public static FaqDAO getInstance(SQLTicketBookConnection conn) {
        FaqDAO.connection = conn;
        if (faqDAO == null) {
            faqDAO = new FaqDAO();
        }
        return faqDAO;
    }

    public ArrayList getAll(int index,int total) throws SQLTicketBookException{
        ArrayList lst = new ArrayList();
        try {
            CallableStatement csmt = connection.getConnection().prepareCall("{call sp_get_faq(?,?)}");

            csmt.setInt("index_start", index);
            csmt.setInt("total_record", total);
            ResultSet rs = csmt.executeQuery();
            while (rs.next()) {
                Integer faqID = new Integer(rs.getInt("ID"));
                lst.add(faqID);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            connection.closeConnection();
        }
        return lst;
    }

    public FaqTransferData getFaqByID(Integer faqID) throws SQLTicketBookException {
        FaqTransferData faq = new FaqTransferData();
        try {
            String sql = "SELECT ID, question, answer, CONVERT(VARCHAR(20),create_date,101) AS create_date, username"
                    +" FROM [FAQ] WHERE ID = ?";
            PreparedStatement pre = connection.getConnection().prepareStatement(sql);
            pre.setInt(1, faqID.intValue());
            ResultSet rs = pre.executeQuery();
            while (rs.next()){
                faq.setID(new Integer(rs.getInt("ID")));
                faq.setQuestion(rs.getNString("question"));
                faq.setAnswer(rs.getNString("answer"));
                faq.setCreateDate(rs.getString("create_date"));
                faq.setUsername(rs.getString("username"));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }finally{
            connection.closeConnection();
        }
        return faq;
    }

    public Integer countRecordFindAll() throws SQLTicketBookException {
        Integer o = new Integer(0);
        try {
            String sql = "SELECT COUNT(ID) AS COUNT "
                    +" FROM [FAQ]";
            
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
