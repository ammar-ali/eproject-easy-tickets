/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ticketbook.ejb.bmp.dao;

import com.arjuna.ats.internal.arjuna.recovery.Connection;
import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import ticketbook.sql.SQLTicketBookConnection;
import ticketbook.exception.SQLTicketBookException;
import ticketbook.transfer.UserTransferData;

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
        try{
           String sql="INSERT INTO [user]([id],[name],[password],[role]) VALUES(?,?,?,?)";
           PreparedStatement preparedStatement=connection.getConnection().prepareStatement(sql);
           preparedStatement.setInt(1,user.getID().intValue());
           preparedStatement.setString(2,user.getName());
           preparedStatement.setString(3,user.getName());
           preparedStatement.setInt(4,user.getRole().intValue());

           preparedStatement.execute();
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
        finally{
            connection.closeConnection();
        }
    }

    public void update(UserTransferData user) throws SQLTicketBookException{
        try{
           String sql="UPDATE [user] SET [name]=?,[password]=?,[role]=? WHERE id=?";
          
           PreparedStatement preparedStatement=connection.getConnection().prepareStatement(sql);
           preparedStatement.setString(1,user.getName());
           preparedStatement.setString(2,user.getPassword());
           preparedStatement.setInt(3,user.getRole().intValue());
           preparedStatement.setInt(4,user.getID().intValue());
           
           preparedStatement.execute();
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
        finally{
            connection.closeConnection();
        }
    }

    public void deleteByUserID(Integer userID) throws SQLTicketBookException{
        try{
           String sql="DELETE [user] WHERE id="+userID;
           PreparedStatement preparedStatement=connection.getConnection().prepareStatement(sql);
           preparedStatement.execute();
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
        finally{
            connection.closeConnection();
        }
    }

    public UserTransferData getUserByID(Integer userID) throws SQLTicketBookException{
        try{
           String sql="SELECT * FROM [user] WHERE id="+userID;
           PreparedStatement preparedStatement=connection.getConnection().prepareStatement(sql);

           ResultSet rs=preparedStatement.executeQuery();

            while(rs.next()){
                UserTransferData user=new UserTransferData();
                user.setID(new Integer(rs.getInt("id")));
                user.setName(rs.getNString("name"));
                user.setPassword(rs.getNString("password"));
                user.setRole(new Integer(rs.getInt("role")));
                return user;
            }

        }
        catch(Exception ex){
            ex.printStackTrace();
        }
        finally{
            connection.closeConnection();
        }
        return null;
    }

    public ArrayList getUsers() throws SQLTicketBookException{
        ArrayList users=new ArrayList();
        try{
           String sql="SELECT * FROM [user]";
           PreparedStatement preparedStatement=connection.getConnection().prepareStatement(sql);

           ResultSet rs=preparedStatement.executeQuery();

            while(rs.next()){
                UserTransferData user=new UserTransferData();
                user.setID(new Integer(rs.getInt("id")));
                user.setName(rs.getNString("name"));
                user.setPassword(rs.getNString("password"));
                user.setRole(new Integer(rs.getInt("role")));
                users.add(user);
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
}
