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
    Integer ID;
    String question;
    String answer;
    String createDate;
    String username;

    public FaqTransferData(){
        this.ID= Constant.ID_FALSE_INTETER;
        this.question = Constant.DEFAULT_VALUE_STRING;
        this.answer = Constant.DEFAULT_VALUE_STRING;
        this.createDate = Constant.DEFAULT_VALUE_STRING;
        this.username = Constant.DEFAULT_VALUE_STRING;
    }

    public FaqTransferData(Integer id, String question, String answer, String create_date, String username){
    this.ID = id;
    this.question = question;
    this.answer = answer;
    this.createDate = create_date;
    this.username = username;
    }
    
    public Integer getID() {
        return ID;
    }

    public String getAnswer() {
        return answer;
    }

    public String getCreateDate() {
        return createDate;
    }

    public String getQuestion() {
        return question;
    }

    public String getUsername() {
        return username;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public void setUsername(String username) {
        this.username = username;
    }

}
