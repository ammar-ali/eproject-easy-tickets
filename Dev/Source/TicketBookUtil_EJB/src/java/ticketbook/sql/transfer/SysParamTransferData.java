/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ticketbook.sql.transfer;

import java.io.Serializable;

/**
 *
 * @author Admin
 */
public class SysParamTransferData implements Serializable {

    private String driver;
    private String url;
    private String username;
    private String password;

    public SysParamTransferData(String driver, String url, String username, String password) {
        this.driver = driver;
        this.url = url;
        this.username = username;
        this.password = password;
    }

    public String getUrl() {
        return url;
    }

    public String getDriver() {
        return driver;
    }

    public String getPassword() {
        return password;
    }

    public String getUsername() {
        return username;
    }
}
