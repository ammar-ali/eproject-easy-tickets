/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ticketbook.transfer;

import java.io.Serializable;
import java.sql.Timestamp;
import ticketbook.util.Constant;

/**
 *
 * @author QuocHai
 */
public class ContactTransferData implements Serializable{
    Integer ID;
    String title;
    String content;
    String answer;
    String email;
    String create_date;
    String username;

    public ContactTransferData(){
        this.ID = Constant.ID_FALSE_INTETER;
        this.title = Constant.DEFAULT_VALUE_STRING;
        this.content = Constant.DEFAULT_VALUE_STRING;
        this.answer = Constant.DEFAULT_VALUE_STRING;
        this.email = Constant.DEFAULT_VALUE_STRING;
        this.create_date = Constant.DEFAULT_VALUE_STRING;
        this.username = Constant.DEFAULT_VALUE_STRING;
    }

    public ContactTransferData(Integer id, String title, String content, String answer, String email, String create_date, String username){
        this.ID = id;
        this.title = title;
        this.content = content;
        this.answer = answer;
        this.email = email;
        this.create_date = create_date;
        this.username = username;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setCreate_date(String create_date) {
        this.create_date = create_date;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getID() {
        return ID;
    }

    public String getAnswer() {
        return answer;
    }

    public String getContent() {
        return content;
    }

    public String getCreate_date() {
        return create_date;
    }

    public String getEmail() {
        return email;
    }

    public String getTitle() {
        return title;
    }

    public String getUsername() {
        return username;
    }
}
