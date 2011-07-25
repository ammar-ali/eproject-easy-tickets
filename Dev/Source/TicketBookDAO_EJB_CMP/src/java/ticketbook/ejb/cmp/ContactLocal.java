/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ticketbook.ejb.cmp;

import java.sql.Timestamp;
import javax.ejb.EJBLocalObject;

/**
 *
 * @author QuocHai
 */
public interface ContactLocal extends EJBLocalObject {

    Integer getId();

    void setId(Integer id);

    String getTitle();

    void setTitle(String title);

    String getContent();

    void setContent(String content);

    String getAnswer();

    void setAnswer(String answer);

    String getEmail();

    void setEmail(String email);

    Timestamp getCreateDate();

    void setCreateDate(Timestamp createDate);

    String getUsername();

    void setUsername(String username);

}
