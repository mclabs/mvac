/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.openxdata.mvac.mobile.view;

import com.sun.lwuit.Button;
import com.sun.lwuit.CheckBox;
import com.sun.lwuit.Command;
import com.sun.lwuit.Dialog;
import com.sun.lwuit.Label;
import com.sun.lwuit.TextArea;
import com.sun.lwuit.TextField;
import com.sun.lwuit.events.ActionEvent;
import com.sun.lwuit.layouts.BorderLayout;
import java.util.Calendar;
import java.util.Date;
import org.openxdata.model.QuestionData;
import org.openxdata.model.QuestionDef;
import org.openxdata.mvac.mobile.api.MvacController;
import org.openxdata.mvac.mobile.util.AppUtil;
import org.openxdata.mvac.mobile.util.Constants;
import org.openxdata.mvac.mobile.util.view.api.IView;
import org.openxdata.mvac.mobile.view.GroupList;

/**
 *
 * @author soyfactor
 */
public class TextQuestionView extends QuestionView {
    private Label questionPrompt; 
    private TextField answerField;
    private TextArea answerArea ;
    private Label dateanswer;
    private Button selDate;
    private Command dateCmd = new Command("SelectDate", 1);
    private CalendarForm calendarFrm;

    private CheckBox checkBox = null;
    

    public TextQuestionView(QuestionData qtData){
        super(qtData);

    }

    public void initView() {
        //commands
        addCommand(done);
        addCommand(next);
        addCommand(prev);
        addCommand(back);
        setLayout(new BorderLayout());

        setCommandListener(this);
        //commands
        calendarFrm=new CalendarForm();
        selDate=new Button("Set Date");
        questionPrompt = new Label("");
        answerField = new TextField("", 50);
        answerArea = new TextArea();
        checkBox = new CheckBox("Done");
        questionPrompt.setText(questionObj.getText());
        if (questionObj.getText().equals("Date of Immunization")) {

            Calendar calendar = Calendar.getInstance();
            calendar.get(Calendar.YEAR);
            String today = calendar.get(Calendar.DAY_OF_MONTH) + "/" + calendar.get(Calendar.MONTH) + "/" + calendar.get(Calendar.YEAR);
System.out.println("Today is :" + today);

            String ans = questionObj.getTextAnswer();
            if(ans!=null){
                answerField.setText(ans);
            }else{
                answerField.setText("");
            }
            
            answerField.setConstraint(TextField.ANY);
            answerField.setEditable(false);
            answerField.setFocusable(false);
            answerField.setText(today);
            selDate.addActionListener(this);
            calendarFrm.setListener(this);
            queContainer.addComponent(questionPrompt);
            queContainer.addComponent(answerField);
            queContainer.addComponent(selDate);
        }else if(questionObj.getText().equals("Status")){
            //Setup checkbox here
            String ans = questionObj.getTextAnswer();
            if(ans != null){
                if(ans.equals("true")){
                    checkBox.setSelected(true);
                }else{
                    checkBox.setSelected(false);
                }
            }else{
                checkBox.setSelected(false);
            }
            queContainer.addComponent(checkBox);
        } else if(questionObj.getText().equals("Note")){

            String ans = questionObj.getTextAnswer();

            answerArea.setConstraint(TextField.ANY);
            answerArea.setColumns(4);

            queContainer.addComponent(questionPrompt);
            queContainer.addComponent(answerArea);


        }

        else{
             String ans = questionObj.getTextAnswer();
            if(ans!=null){
                answerField.setText(ans);
            }else{
                answerField.setText("");
            }
            answerField.setConstraint(TextField.ANY);
            queContainer.addComponent(questionPrompt);
            queContainer.addComponent(answerField);

        }
        
        
        addComponent(BorderLayout.NORTH, queContainer);
        getStyle().setBgColor(0xffffff);
        
    }

    

    private String getAnswer(){
        return answerField.getText();
    }

    public boolean setAnswer(){
        String ans ="";
        ans = getAnswer();
        QuestionDef qdef = questionObj.getDef();
        if(qdef.isMandatory()&&(ans!=null&&ans!="")){
            questionObj.setTextAnswer(ans);
            System.out.println("Just Set The ans");
            return true;
        }else if(!qdef.isMandatory()){
            boolean blnif=true;
            if(ans!=null&&ans!=""){
                questionObj.setTextAnswer(ans);
                System.out.println("Just Set The ans");
                blnif= true;
            }
            return blnif;
        } else {
            System.out.println("Because =>"+qdef.isMandatory());
            return false;
        }

        
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource()==selDate) {
            AppUtil.get().setView(calendarFrm);

        }else if(ae.getSource()==calendarFrm||ae.getSource()==calendarFrm.okcmd){
            answerField.setText(calendarFrm.getDate());

        }
        Command cmd = ae.getCommand();
        if(cmd==done){
            if(setAnswer()){
                ((MvacController)AppUtil.get().getItem(Constants.CONTROLLER)).saveQtnData(questionObj);
            }
            ((MvacController)AppUtil.get().getItem(Constants.CONTROLLER)).lastScreen();
            
            
        }else if(cmd ==next){
            if(setAnswer()){
                ((MvacController)AppUtil.get().getItem(Constants.CONTROLLER)).nextQtn(questionObj);
            }
            

        }else if(cmd==prev){
            if(setAnswer()){
                ((MvacController)AppUtil.get().getItem(Constants.CONTROLLER)).prevQtn(questionObj);
            }
            
        }else if(cmd==calendarFrm.okcmd){
            answerField.setText(calendarFrm.getDate());
            resume(null);
        }
    }

    public void dialogReturned(Dialog dialog, boolean yesNo) {
    }


    

}
