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
    String newStatusTicketBooking="0";
    String acceptStatusTicketBooking="0";

    static TicketBookParameter parameter;


    public static TicketBookParameter getInstance(){
        if(parameter==null)
            parameter=new TicketBookParameter();
        return parameter;
    }


    private TicketBookParameter(){
        try{
            pathImageEvent=TicketBookBundle.getSystemParameter().getString("path_image_event");

            recordNumberNeedShow=Integer.parseInt(TicketBookBundle.getSystemParameter().getString("record_number_need_show"));

            pageNumberNeedShow=Integer.parseInt(TicketBookBundle.getSystemParameter().getString("page_number_need_show"));
            customerRoleID=Integer.parseInt(TicketBookBundle.getSystemParameter().getString("customer_roleID"));
            adminRoleID=Integer.parseInt(TicketBookBundle.getSystemParameter().getString("admin_roleID"));
            if(recordNumberNeedShow>=topIndexShow)
                topIndexShow=Integer.parseInt(TicketBookBundle.getSystemParameter().getString("top_index_show"));

            newStatusTicketBooking=TicketBookBundle.getSystemParameter().getString("new_status_ticketbooking");
            acceptStatusTicketBooking=TicketBookBundle.getSystemParameter().getString("accept_status_ticketbooking");
        }
        catch(Exception ex){
            
        }
    }

    public String getAcceptStatusTicketBooking() {
        return acceptStatusTicketBooking;
    }

    public String getNewStatusTicketBooking() {
        return newStatusTicketBooking;
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
