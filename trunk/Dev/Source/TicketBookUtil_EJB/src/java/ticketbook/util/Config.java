/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ticketbook.util;

import java.io.Serializable;
import ticketbook.exception.ConfigException;


/**
 *
 * @author Admin
 */
public class Config implements  Serializable{
    
    public static void settingSystemPropertiesForEntityBean() throws ConfigException{
        String[][] lst=Setting.SYSTEMPROPERTIES_CONFIG_FOR_ENTITYBEAN;
        settingSystemProperties(lst);
    }

    public static void settingSystemPropertiesForSessionBean() throws ConfigException{
        String[][] lst=Setting.SYSTEMPROPERTIES_CONFIG_FOR_SESSIONBEAN;
        Config.settingSystemProperties(lst);
    }

    public static void settingSystemProperties(String[][] lst) throws ConfigException{
         for(int i=0;i<lst.length;i++){
             if(lst[i]!=null){
                 if(lst[i].length==2){
                    String index0=lst[i][0];
                    String index1=lst[i][1];
                    if(index0!=null&&index1!=null)
                        System.setProperty(index0,index1);
                    else{
                        String str="; ";
                        if(index0==null)
                            str="Array[i]["+0+"] is null";
                        else if(index1==null)
                            str="Array[i]["+1+"] is null";
                        throw new ConfigException("setting.var.systemproperties.config.for.entitybean.isnull"+";"+str);
                    }
                 }
                 else{
                     i=lst.length;
                     throw new ConfigException("setting.var.systemproperties.config.for.entitybean.notmatch");
                 }
             }else{
                throw new ConfigException("setting.var.systemproperties.config.for.entitybean.isnull"+"; Array["+i+"][] is null;");
             }
         }
    }
}
