/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ticketbooi.ejb.test;

import java.util.ArrayList;
import ticketbook.ejb.bmp.dao.EventTypeDAO;
import ticketbook.exception.SQLTicketBookException;
import ticketbook.sql.SQLTicketBookConnection;

/**
 *
 * @author Admin
 */
public class Run {
    public static void main(String[] args){
        try {
            ArrayList lst = EventTypeDAO.getInstance(SQLTicketBookConnection.getInstance()).getEventTypes();
            for (int i = 0; i < lst.size(); i++) {
                
            }
        } catch (SQLTicketBookException ex) {
            ex.printStackTrace();
        }
    }
}
