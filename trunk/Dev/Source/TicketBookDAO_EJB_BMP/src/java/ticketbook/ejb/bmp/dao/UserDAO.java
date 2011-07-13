/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ticketbook.ejb.bmp.dao;

import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import ticketbook.sql.SQLTicketBookConnection;
import ticketbook.exception.SQLTicketBookException;
import ticketbook.transfer.UserTransferData;
import ticketbook.util.StringUtil;

/**
 *
 * @author Admin
 */
public class UserDAO implements Serializable{

    static UserDAO userDAO;
    static SQLTicketBookConnection connection;
    private UserDAO(){}

    public static UserDAO getInstance(SQLTicketBookConnection conn){
        UserDAO.connection=conn;
        if(userDAO==null)
            userDAO=new UserDAO();
        return userDAO;
    }

    public void insert(UserTransferData user) throws SQLTicketBookException{    
    }

    public UserTransferData getUserByUsername(String username) throws SQLTicketBookException{
        UserTransferData user=new UserTransferData();
        try{
           String sql="SELECT * FROM [account] WHERE username=?";
           PreparedStatement preparedStatement=connection.getConnection().prepareStatement(sql);
           preparedStatement.setString(1,username);
           ResultSet rs=preparedStatement.executeQuery();
            while(rs.next()){
                user=this.mapping(rs);
            }

        }
        catch(Exception ex){
            ex.printStackTrace();
        }
        finally{
            connection.closeConnection();
        }
        return user;
    }

    public UserTransferData getUserByUsernameAndPassword(String username,String password) throws SQLTicketBookException{
        UserTransferData user=new UserTransferData();
        try{
           String sql="SELECT * FROM [account] WHERE username=? and password=?";
           PreparedStatement preparedStatement=connection.getConnection().prepareStatement(sql);
           preparedStatement.setString(1,username);
           preparedStatement.setString(2,password);
           ResultSet rs=preparedStatement.executeQuery();
            while(rs.next()){
                user=this.mapping(rs);
            }

        }
        catch(Exception ex){
            ex.printStackTrace();
        }
        finally{
            connection.closeConnection();
        }
        return user;
    }

    public ArrayList getUsers() throws SQLTicketBookException{
        ArrayList users=new ArrayList();
        try{
           String sql="SELECT * FROM [user]";
           PreparedStatement preparedStatement=connection.getConnection().prepareStatement(sql);

           ResultSet rs=preparedStatement.executeQuery();

            while(rs.next()){
                users.add(this.mapping(rs));
            }

        }
        catch(Exception ex){
            ex.printStackTrace();
        }
        finally{
            connection.closeConnection();
        }
        return users;
    }

    private UserTransferData mapping(ResultSet rs){
        UserTransferData user = new UserTransferData();
        try {
            user.setUsername(rs.getString("username"));
            user.setPassword(rs.getString("password"));
            user.setPhone(rs.getString("phone"));
            user.setFullname(StringUtil.convertToUTF8(rs.getString("fullname")));
            user.setAddress(StringUtil.convertToUTF8(rs.getString("address")));
            user.setEmail(rs.getString("email"));
            user.setBirthDate(rs.getString("birth_date"));
            user.setCreateDate(rs.getString("create_date"));
            user.setPersonCardNumber(rs.getString("person_card_number"));
            user.setRoleID(new Integer(rs.getInt("roleID")));
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return user;
    }
}