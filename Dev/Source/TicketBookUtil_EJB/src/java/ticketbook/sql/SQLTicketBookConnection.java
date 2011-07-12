/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ticketbook.sql;

import java.io.Serializable;
import ticketbook.exception.SQLTicketBookException;
import ticketbook.sql.transfer.SysParamTransferData;
import ticketbook.util.Constant;

/**
 *
 * @author Admin
 */
public class SQLTicketBookConnection extends SQLParentConnection implements  Serializable{

    static SQLTicketBookConnection tbConnection;

    
    private SQLTicketBookConnection(){
        SQLParentConnection.sysParam=new SysParamTransferData(Constant.SETTING_DB_DAO.getString("DRIVER"),
                Constant.SETTING_DB_DAO.getString("URL"),
                Constant.SETTING_DB_DAO.getString("USERNAME"),
                Constant.SETTING_DB_DAO.getString("PASSWORD"));
    }

    public static SQLTicketBookConnection getInstance() throws SQLTicketBookException{
        if(tbConnection==null){
            tbConnection=new SQLTicketBookConnection();
            SQLTicketBookConnection.getInstance(sysParam);
        }
        return tbConnection;
    }

    public SysParamTransferData getSysParam(){
        return SQLTicketBookConnection.sysParam;
    }


}
