/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.openxdata.mvac.mobile.view;

import com.sun.lwuit.Command;
import com.sun.lwuit.Dialog;
import com.sun.lwuit.TextArea;
import com.sun.lwuit.events.ActionEvent;
import com.sun.lwuit.events.ActionListener;
import com.sun.lwuit.layouts.BorderLayout;

/**
 *
 * @author mutahi
 */
public class ValidSearchAlert extends Dialog implements ActionListener{
    
    private Command cmdView = null;
    private Command cmdDiscard = null;
    
    private TextArea txtLabel = null;
    private int results = 0 ;

    public ValidSearchAlert(int resp) {
        super();
        this.results = resp ;
        this.setLayout(new BorderLayout());
        this.setAutoDispose(false);
        this.addCommandListener(this);
        init();
    }

    private void init(){
        cmdView = new Command("View");
        cmdDiscard = new Command("Discard");

        txtLabel = new TextArea(2, 6);
        txtLabel.setText(results + " Results found . \n Do you want to view ?");
        txtLabel.setAlignment(CENTER);
        txtLabel.setEditable(false);

        this.addComponent(BorderLayout.CENTER ,txtLabel);

        this.addCommand(cmdDiscard);
        this.addCommand(cmdView);


    }

    public void actionPerformed(ActionEvent actionEvent) {
        if(actionEvent.getSource() == cmdDiscard){
System.out.println("Discard");
        }else if(actionEvent.getSource() == cmdView){
System.out.println("View");
        }
    }



}
