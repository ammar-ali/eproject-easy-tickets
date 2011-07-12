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
public class PropertiesBundle {

    static ResourceBundle SQL_SETTING_DATABASE;
    static ResourceBundle SQLQUERY;
    static ResourceBundle ERROR_UTIL_EXCEPTION;

    public static ResourceBundle getSQLSettingDatabase() {
        if (SQL_SETTING_DATABASE == null) {
            SQL_SETTING_DATABASE = ResourceBundle.getBundle("sql_setting_database");
        }
        return SQL_SETTING_DATABASE;
    }

    public static ResourceBundle getSQLQuery() {
        if (SQLQUERY == null) {
            SQLQUERY = ResourceBundle.getBundle("sql_query");
        }
        return SQLQUERY;
    }

    public static ResourceBundle getErrorUtilException() {
        if (ERROR_UTIL_EXCEPTION == null) {
            ERROR_UTIL_EXCEPTION = ResourceBundle.getBundle("error_util_exception");
        }
        return ERROR_UTIL_EXCEPTION;
    }
}
