/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ticketbook.util;

/**
 *
 * @author Admin
 */
public class TicketBookParameter {

    String pathImageEvent="";
    int recordNumberNeedShow=0;
    int pageNumberNeedShow=0;
    int topIndexShow=0;
    int customerRoleID=0;
    int adminRoleID=0;
    public TicketBookParameter(){
        try{
            pathImageEvent=TicketBookBundle.getSystemParameter().getString("path_image_event");

            recordNumberNeedShow=Integer.parseInt(TicketBookBundle.getSystemParameter().getString("record_number_need_show"));

            pageNumberNeedShow=Integer.parseInt(TicketBookBundle.getSystemParameter().getString("page_number_need_show"));
            customerRoleID=Integer.parseInt(TicketBookBundle.getSystemParameter().getString("customer_roleID"));
            adminRoleID=Integer.parseInt(TicketBookBundle.getSystemParameter().getString("admin_roleID"));
            if(recordNumberNeedShow>=topIndexShow)
                topIndexShow=Integer.parseInt(TicketBookBundle.getSystemParameter().getString("top_index_show"));
        }
        catch(Exception ex){
            
        }
    }

    public int getAdminRoleID() {
        return adminRoleID;
    }

    public int getCustomerRoleID() {
        return customerRoleID;
    }

    public String getPathImageEvent() {
        return pathImageEvent;
    }

    public int getTopIndexShow() {
        return topIndexShow;
    }

    public int getPageNumberNeedShow() {
        return pageNumberNeedShow;
    }

    public int getRecordNumberNeedShow() {
        return recordNumberNeedShow;
    }



}
