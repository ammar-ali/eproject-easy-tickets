/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ticketbook.util;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.ResourceBundle;

/**
 *
 * @author Admin
 */
public class Constant implements Serializable {

    public static final Integer ID_FALSE_INTETER=new Integer(0);
    public static final String ID_FALSE_STRING=null;
    public static final String DEFAULT_VALUE_STRING = "";
    public static final Integer DEFAULT_VALUE_INTEGER = new Integer(0);
    public static final Timestamp DEFAULT_VALUE_TIMESTAMP = null;
    public static final ResourceBundle QUERY_DAO=PropertiesBundle.getSQLQuery();
    public static final ResourceBundle SETTING_DB_DAO=PropertiesBundle.getSQLSettingDatabase();
    public static final ResourceBundle ERROR_UTIL_EXCEPTION=PropertiesBundle.getErrorUtilException();

}
