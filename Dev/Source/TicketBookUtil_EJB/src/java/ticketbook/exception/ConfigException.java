/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ticketbook.exception;

import ticketbook.util.Constant;



/**
 *
 * @author Admin
 */
public class ConfigException extends Exception{

    
    private String err;
    private String message;
    public ConfigException(String err){
        super(ConfigException.readError(err));
        this.err=err;
        this.message=ConfigException.readError(err);
    }

   
    public void printStrackTrace() throws ConfigException{
        throw (new ConfigException(this.err));
    }

    private static String readError(String err){
        String message="";
        String[] errs=err.split(";");
        try{
            if(errs.length!=0){
                message=Constant.ERROR_UTIL_EXCEPTION.getString(errs[0]);
                for(int i=1;i<errs.length;i++)
                    message+=errs[i];
            }
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
        return message;
    }

    public String getMessage(){
        return this.message;
    }
}
