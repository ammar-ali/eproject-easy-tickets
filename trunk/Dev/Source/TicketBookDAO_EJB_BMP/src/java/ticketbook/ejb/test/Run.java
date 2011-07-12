/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ticketbook.ejb.test;

import java.util.Enumeration;
import javax.swing.event.DocumentEvent.EventType;
import ticketbook.ejb.bmp.dao.EventTypeDAO;
import ticketbook.exception.SQLTicketBookException;
import ticketbook.sql.SQLTicketBookConnection;
import ticketbook.transfer.EventTypeTransferData;
import ticketbook.transfer.UserTransferData;

/**
 *
 * @author Admin
 */
public class Run {
    public static void main(String[] args){
        try {
            Enumeration events = EventTypeDAO.getInstance(SQLTicketBookConnection.getInstance()).getEventTypes();
            while(events.hasMoreElements()){
                System.out.print(((EventTypeTransferData)events.nextElement()).getName());
            }
        } catch (SQLTicketBookException ex) {
            ex.printStackTrace();
        }
    }
 }
