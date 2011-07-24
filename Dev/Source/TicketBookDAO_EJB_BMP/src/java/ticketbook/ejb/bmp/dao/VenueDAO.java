/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ticketbook.ejb.bmp.dao;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import ticketbook.sql.SQLTicketBookConnection;
import ticketbook.transfer.VenueTransferData;
import ticketbook.util.StringUtil;

/**
 *
 * @author Admin
 */
public class VenueDAO {
    static VenueDAO venueDAO;
    static SQLTicketBookConnection connection;
    private VenueDAO(){}

    public static VenueDAO getInstance(SQLTicketBookConnection conn){
        VenueDAO.connection=conn;
        if(venueDAO==null)
            venueDAO=new VenueDAO();
        return venueDAO;
    }
    public ArrayList getAllVenueID(){
        ArrayList listID=new ArrayList();
        try {
            String sl = "SELECT ID FROM venue ORDER BY ID DESC";
            PreparedStatement pre = connection.getConnection().prepareStatement(sl);
            ResultSet rs=pre.executeQuery();
            while(rs.next()){
                listID.add(new Integer(rs.getInt("ID")));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
       return listID;
    }
    public VenueTransferData getVenueByID(Integer ID){
        VenueTransferData venueData=new VenueTransferData();
        try{
            String sql="SELECT * FROM venue WHERE ID=?";
            PreparedStatement pre=connection.getConnection().prepareStatement(sql);
            pre.setInt(1,ID.intValue());
            ResultSet rs=pre.executeQuery();
            while(rs.next()){
                venueData.setID(new Integer(rs.getInt("ID")));
                venueData.setName(StringUtil.convertToUTF8(rs.getString("name")));
                venueData.setAddress(StringUtil.convertToUTF8(rs.getString("address")));
            }

        }
        catch(Exception ex){
            ex.printStackTrace();
        }
        return venueData;
    }
}
