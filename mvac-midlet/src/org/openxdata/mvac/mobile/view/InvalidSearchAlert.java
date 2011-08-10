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
public class InvalidSearchAlert extends Dialog implements ActionListener {

    private Command cmdOk = null;
    private Command cmdCancel = null;
    
    private TextArea txtLabel = null;

    public InvalidSearchAlert() {
        super();
        this.setLayout(new BorderLayout());
        this.setAutoDispose(false);
        this.addCommandListener(this);
        init();
    }

    private void init() {
        System.out.println("Is autodispose :" + this.isAutoDispose());
        

        cmdCancel = new Command("Cancel");
        cmdOk = new Command("Ok");

        txtLabel = new TextArea(3, 5);
        txtLabel.setText("Invalid search results. \n Please refine the \n search criteria ");
        txtLabel.setAlignment(CENTER);

        this.addComponent(BorderLayout.CENTER, txtLabel);
        this.addCommand(cmdOk);
        this.addCommand(cmdCancel);
        



    }

    public void actionPerformed(ActionEvent actionEvent) {
        if (actionEvent.getSource() == cmdCancel) {
            System.out.println("Discard Command");
        } else if (actionEvent.getSource() == cmdOk) {
            System.out.println("View Command");
        }
    }
}
