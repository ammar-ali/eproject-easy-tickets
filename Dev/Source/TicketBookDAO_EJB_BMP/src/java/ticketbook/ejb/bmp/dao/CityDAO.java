/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ticketbook.ejb.bmp.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import ticketbook.sql.SQLTicketBookConnection;
import ticketbook.transfer.CityTransferData;

/**
 *
 * @author Admin
 */
public class CityDAO{

    static CityDAO cityDAO;
    static SQLTicketBookConnection connection;
    private CityDAO(){}

    public static CityDAO getInstance(SQLTicketBookConnection conn){
        CityDAO.connection=conn;
        if(cityDAO==null)
            cityDAO=new CityDAO();
        return cityDAO;
    }

    public ArrayList getCityIDs(){
        ArrayList v=new ArrayList();
        try{
           String sql="SELECT * FROM [city]";
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


    public CityTransferData getCityByID(Integer ID){
       CityTransferData city=new CityTransferData();

        try{
           String sql="SELECT * FROM [city] WHERE id=?";
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
