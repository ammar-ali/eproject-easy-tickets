/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ticketbook.util;

import java.util.ResourceBundle;

/**
 *
 * @author Admin
 */
public class TicketBookBundle {

    static ResourceBundle SYSTEM_PARAM;
    
    public static ResourceBundle getSystemParameter() {
        if (SYSTEM_PARAM == null) {
            SYSTEM_PARAM = ResourceBundle.getBundle("system_parameter");
        }
        return SYSTEM_PARAM;
    }
}
