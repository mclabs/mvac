/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.openxdata.mvac.mobile.view;

/**
 *
 * @author soyfactor
 */
public class QuestionListObj {
    private String question;
    private String value;
    private String type ;






    public QuestionListObj(){
        
    }

     public void setType(String type) {
        this.type = type;
    }


    public String getType() {
        return type;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    
    

}
