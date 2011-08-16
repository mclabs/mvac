/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.openxdata.mvac.mobile.view;

import com.sun.lwuit.Command;
import com.sun.lwuit.Dialog;
import com.sun.lwuit.Form;
import com.sun.lwuit.Label;
import com.sun.lwuit.events.ActionListener;
import com.sun.lwuit.layouts.BorderLayout;
import java.util.Hashtable;
import org.openxdata.mvac.mobile.util.AppUtil;
import org.openxdata.mvac.mobile.util.view.api.IView;
//import org.openxdata.mvac.mobile.view.date.MobrizDateField;

/**
 *
 * @author soyfactor
 */
public class NewCalendarForm extends Form implements IView {
    //public MobrizDateField dateField;
    public Command okcmd = new Command("OK",1);
    public Label dateField = new Label("sdsd");


    public NewCalendarForm() {
        //dateField = new MobrizDateField("", 10,MobrizDateField.DATE, "dmy");
        addCommand(okcmd);
        initView();
    }

    private void initView(){
        
        this.addComponent(BorderLayout.CENTER ,dateField);
        
    }

    public String getDate(){
        //setCommandListener(null);
//        java.util.Calendar cal = java.util.Calendar.getInstance();
//        cal.setTime(dateField.getDate());
//        int d= cal.get(java.util.Calendar.DAY_OF_MONTH);
//        int mon= cal.get(java.util.Calendar.MONTH);
//        int year = cal.get(java.util.Calendar.YEAR);
    return"";
//       return  d+"/"+mon+"/"+year;
        //return dateField.getDateString();
    }
    
    public void setListener(ActionListener listener){
        setCommandListener(listener);
        //dateField.addActionListener(listener);
        
    }




    public Object getScreenObject() {
        return this;
    }

    public void resume(Hashtable args) {
        AppUtil.get().setView(this);
    }

    public void dialogReturned(Dialog dialog, boolean yesNo) {
    }

}
