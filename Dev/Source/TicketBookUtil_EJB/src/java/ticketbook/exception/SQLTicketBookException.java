/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ticketbook.exception;

import ticketbook.sql.SQLTicketBookConnection;
import ticketbook.util.Constant;

/**
 *
 * @author Admin
 */
public class SQLTicketBookException extends Exception {

    private String err;
    private String message;

    public SQLTicketBookException(String err){
        super(SQLTicketBookException.class.getName()+":"+Constant.ERROR_UTIL_EXCEPTION.getString(err));
        this.message=Constant.ERROR_UTIL_EXCEPTION.getString(err);
        this.err = err;
        try{
            this.execute(err);
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
    }

    public void execute(String error) throws SQLTicketBookException{
        if(err.equals("sqlparentconnection.func.init.isfailed")){
            SQLTicketBookConnection.getInstance().closeConnection();
        }
        else if(err.equals("sqlparentconnection.var.systemparam.isnull")){
            SQLTicketBookConnection.getInstance().closeConnection();
        }
    }


    public void printStrackTrace() throws SQLTicketBookException{
        throw (new SQLTicketBookException(this.err));
    }

    public String getMessage(){
        return this.message;
    }
}
