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
public interface FaqLocal extends EJBLocalObject {

    Integer getId();

    void setId(Integer id);

    String getQuestion();

    void setQuestion(String question);

    String getAnswer();

    void setAnswer(String answer);

    Timestamp getCreateDate();

    void setCreateDate(Timestamp createDate);


}
