/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.openxdata.mvac.mobile.view;

import com.sun.lwuit.Component;
import com.sun.lwuit.Container;
import com.sun.lwuit.Font;
import com.sun.lwuit.Label;
import com.sun.lwuit.List;
import com.sun.lwuit.TextField;
import com.sun.lwuit.layouts.BorderLayout;
import com.sun.lwuit.layouts.BoxLayout;
import com.sun.lwuit.list.ListCellRenderer;
import com.sun.lwuit.plaf.Border;

/**
 *
 * @author soyfactor
 */
public class QueRender extends Container implements ListCellRenderer {
    
    private Label question=new Label("");
    private Label answer = new Label("");

    private Container cnt;
    private Container questioncnt;
    private Container answercnt;

    private Label focus = new Label("");
    private Font lblFont = Font.getBitmapFont("mvaccalibri13");
    private TextField notesText;

    public QueRender(){
        

        focus.getStyle().setBgColor(0x7AE969,true);
        focus.getStyle().setFgColor(0x7AE969,true);
        focus.getStyle().setBgTransparency(100);
        
    }


    public Component getListCellRendererComponent(List list, Object value, int index, boolean isSelected) {
        cnt = new Container(new BoxLayout(BoxLayout.Y_AXIS));
        questioncnt = new Container(new BoxLayout(BoxLayout.X_AXIS));
        answercnt = new Container(new BoxLayout(BoxLayout.X_AXIS));



        question.getStyle().setBgTransparency(0);
        answer.getStyle().setBgTransparency(0);
        
        setLayout(new BorderLayout());


        questioncnt.addComponent(question);
       

        answercnt.addComponent(answer);

        
        
        cnt.addComponent(questioncnt);
        cnt.addComponent(answercnt);

        Border bd = Border.createLineBorder(1, 0x7799bb);
        
        cnt.getStyle().setBorder(bd, true);
        cnt.getStyle().setBgColor(0xffffff);
        cnt.getStyle().setFgColor(0xffffff);

        addComponent(BorderLayout.CENTER,cnt);
        
        //this returns the cell for the list ihub
        QuestionListObj appointment = (QuestionListObj)value;
//System.out.println("@ QUE Render : appointment Question :" + appointment.getQuestion() + "  : appointment value :" + appointment.getValue());
        question.setText(appointment.getQuestion()== null ? "" : appointment.getQuestion());
        //answer.setText(appointment.getValue()== null ? "" : appointment.getValue());
        if("dropdown".equals(appointment.getType())){
          answer.setText(appointment.getValue()== null ? "dropdown" : appointment.getValue()+" dropdown");  
        }else if("Date".equals(appointment.getType())){
          answer.setText(appointment.getValue()== null ? "date" : appointment.getValue()+ " date");  
        }else if("Check box".equals(appointment.getType())){
          answer.setText(appointment.getValue()== null ? "check" : appointment.getValue()+ " check");  
        }else if("textarea".equals(appointment.getType())){
            notesText =new TextField(20);
            notesText.setConstraint(TextField.ANY);
            answercnt.addComponent(notesText);
          answer.setText(appointment.getValue()== null ? " text area" : appointment.getValue()+ " textarea");  
        }

        return this;

    }

    public Component getListFocusComponent(List list) {
        return focus;
    }

}
