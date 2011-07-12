/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ticketbook.sql;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import ticketbook.exception.SQLTicketBookException;
import ticketbook.sql.transfer.SysParamTransferData;

/**
 *
 * @author Admin
 */
public class SQLParentConnection implements Serializable {

    Connection conn;
    protected static SysParamTransferData sysParam;
    private static SQLParentConnection parentConnect;

    protected SQLParentConnection() {
    }

    public static SQLParentConnection getInstance(SysParamTransferData sysParam) throws SQLTicketBookException {

        SQLParentConnection.sysParam = sysParam;
        if (parentConnect == null) {
            parentConnect = new SQLParentConnection();
        }

        return parentConnect;
    }

    public void init() throws SQLTicketBookException {
        try {
            Class.forName(SQLParentConnection.sysParam.getDriver());
            this.conn = DriverManager.getConnection(SQLParentConnection.sysParam.getUrl(), SQLParentConnection.sysParam.getUsername(), SQLParentConnection.sysParam.getPassword());
        } catch (Exception e) {
            throw new SQLTicketBookException("sqlparentconnection.func.init.isfailed");
        }
    }

    public void closeConnection() {
        try {
            if (conn != null) {
                conn.close();
                conn = null;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Connection getConnection() throws SQLTicketBookException {
        closeConnection();
        init();
        return conn;
    }

    public static void clear() {
        parentConnect = null;
    }
}
