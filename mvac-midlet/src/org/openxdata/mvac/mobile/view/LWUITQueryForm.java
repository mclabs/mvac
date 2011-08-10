/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.openxdata.mvac.mobile.view;

import com.sun.lwuit.ButtonGroup;
import com.sun.lwuit.Command;
import com.sun.lwuit.Dialog;
import com.sun.lwuit.Form;
import com.sun.lwuit.RadioButton;
import com.sun.lwuit.events.ActionEvent;
import com.sun.lwuit.layouts.BoxLayout;
import java.util.Hashtable;
import javax.microedition.midlet.MIDletStateChangeException;
import org.openxdata.mvac.mobile.MvacMidlet;
import org.openxdata.mvac.mobile.util.AppUtil;
import org.openxdata.mvac.mobile.util.Constants;
import org.openxdata.mvac.mobile.util.view.api.IDialog;
import org.openxdata.mvac.mobile.util.view.api.IDialogListener;
import org.openxdata.mvac.mobile.util.view.api.IView;

/**
 *
 * @author mutahi
 */
public class LWUITQueryForm extends Form implements IView , IDialog {
    
    private ButtonGroup btngrp;
    private RadioButton rb_one;
    private RadioButton rb_two;
    private RadioButton rb_three;
    private RadioButton rb_four;


    public LWUITQueryForm() {
        super("Download Appointments");
        initQueryForm();
    }

    private void initQueryForm(){
        setLayout(new BoxLayout(BoxLayout.Y_AXIS));

       rb_one = new RadioButton("One Week");
       rb_two = new RadioButton("Two Weeks");
       rb_three = new RadioButton("Three Weeks");
       rb_four = new RadioButton("Four Weeks");

       btngrp = new ButtonGroup();
       btngrp.add(rb_one);
       btngrp.add(rb_two);
       btngrp.add(rb_three);
       btngrp.add(rb_four);

       this.addComponent(rb_one);
       this.addComponent(rb_two);
       this.addComponent(rb_three);
       this.addComponent(rb_four);

       btngrp.setSelected(rb_one);

       this.addCommand(new Command("Download"){
           public void actionPerformed(ActionEvent ae){
 System.out.println("Download Command");
               int selectedIndex = btngrp.getSelectedIndex();
               RadioButton selected = btngrp.getRadioButton(selectedIndex);
  System.out.println("Selected = "+ selected.getText());

                //Put code Here
   
           }
       });

       this.addCommand(new Command("Exit"){
           private void sctionPerformed(ActionEvent ae){
   System.out.println("Exit Command");
   try {
                    ((MvacMidlet) AppUtil.get().getItem(Constants.MIDLET)).exitApp(true);
                } catch (MIDletStateChangeException ex) {
                    ex.printStackTrace();
                }

            //Put Code Here

           }
       });


    }

    public Object getScreenObject() {
        return this;
    }

    public void resume(Hashtable args) {
        AppUtil.get().setView(this);
    }

    public void setParent(IDialogListener listener) {
    }

    public void dialogReturned(Dialog dialog, boolean yesNo) {
    }

  



}
