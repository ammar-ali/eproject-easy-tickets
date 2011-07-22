/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ticketbook.ejb.bmp.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import ticketbook.exception.SQLTicketBookException;
import ticketbook.sql.SQLTicketBookConnection;

/**
 *
 * @author vostro
 */
public class DateDAO{

    static DateDAO dateDAO;
    static SQLTicketBookConnection connection;

    private DateDAO() {
    }

    public static DateDAO getInstance(SQLTicketBookConnection connection) {
        DateDAO.connection = connection;
        if (dateDAO == null) {
            dateDAO = new DateDAO();
        }
        return dateDAO;
    }

    public String getDateCurrent() throws SQLTicketBookException {
        String sql = "SELECT CONVERT(VARCHAR(20),GETDATE(),101) AS date";
        String date = "";
        try {
            PreparedStatement pre = connection.getConnection().prepareCall(sql);
            ResultSet rs = pre.executeQuery();
            while (rs.next()) {
                date = rs.getString("date");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return date;
    }

    public int diffDate(String date1, String date2) {
        String sql = "SELECT DATEDIFF(dd,?,?) AS result";
        PreparedStatement pre;
        int date=0;
        try {
            pre = connection.getConnection().prepareCall(sql);
            pre.setString(1, date1);
            pre.setString(2, date2);
            ResultSet rs=pre.executeQuery();
            while(rs.next()){
                date= rs.getInt("result");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return date;
    }
}
