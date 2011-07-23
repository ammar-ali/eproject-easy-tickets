/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ticketbook.transfer;

import java.io.Serializable;
import ticketbook.util.Constant;

/**
 *
 * @author QuocHai
 */
public class FaqTransferData implements Serializable {
    Integer id;
    String question;
    String answer;
    String create_date;
    String username;

    public FaqTransferData(){
        this.id= Constant.DEFAULT_VALUE_INTEGER;
        this.question = Constant.DEFAULT_VALUE_STRING;
        this.answer = Constant.DEFAULT_VALUE_STRING;
        this.create_date = Constant.DEFAULT_VALUE_STRING;
        this.username = Constant.DEFAULT_VALUE_STRING;
    }

    public Integer getID() {
        return id;
    }

    public String getAnswer() {
        return answer;
    }

    public String getCreate_date() {
        return create_date;
    }

    public String getQuestion() {
        return question;
    }

    public String getUsername() {
        return username;
    }

    public void setID(Integer ID) {
        this.id = ID;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public void setCreate_date(String create_date) {
        this.create_date = create_date;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public void setUsername(String username) {
        this.username = username;
    }

}
