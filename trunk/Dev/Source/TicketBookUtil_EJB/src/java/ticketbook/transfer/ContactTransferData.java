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
public class ContactTransferData implements Serializable{
    Integer ID;
    String title;
    String content;
    String answer;
    String email;
    String createDate;
    String username;

    public ContactTransferData(){
        this.ID = Constant.ID_FALSE_INTETER;
        this.title = Constant.DEFAULT_VALUE_STRING;
        this.content = Constant.DEFAULT_VALUE_STRING;
        this.answer = Constant.DEFAULT_VALUE_STRING;
        this.email = Constant.DEFAULT_VALUE_STRING;
        this.createDate = Constant.DEFAULT_VALUE_STRING;
        this.username = Constant.DEFAULT_VALUE_STRING;
    }

    public ContactTransferData(Integer id, String title, String content, String answer, String email, String createDate, String username){
        this.ID = id;
        this.title = title;
        this.content = content;
        this.answer = answer;
        this.email = email;
        this.createDate = createDate;
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

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
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

    public String getCreateDate() {
        return createDate;
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
