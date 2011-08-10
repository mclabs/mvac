/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.openxdata.mvac.mobile.view;

import com.sun.lwuit.ComboBox;
import com.sun.lwuit.Command;
import com.sun.lwuit.Container;
import com.sun.lwuit.Dialog;
import com.sun.lwuit.Form;
import com.sun.lwuit.Label;
import com.sun.lwuit.TextArea;
import com.sun.lwuit.events.ActionEvent;
import com.sun.lwuit.events.ActionListener;
import com.sun.lwuit.layouts.BorderLayout;
import com.sun.lwuit.layouts.BoxLayout;
import java.util.Hashtable;
import org.openxdata.mvac.mobile.util.view.api.IView;


/**
 *
 * @author mutahi
 */
public class DownloadDialog extends Form implements ActionListener , IView{
    
    private Command cmdYes = null;
    private Command cmdNo = null;
    private Form parent = null;

    //Dialogs
    private Container container = null;
    private TextArea txtLabel = null;
    private TextArea txtConfirm = null;
    private ComboBox cbChoices = null;
    private String[] choices = {"1 Week" , "2 Weeks" , "3 Weeks" , "4 Weeks"};

    public DownloadDialog(Form form) {
        super();
        this.parent = form;
        this.setLayout(new BorderLayout());

        this.addCommandListener(this);
        init();

        this.addComponent(BorderLayout.CENTER, container);
    }

    private void init(){
        container = new Container(new BoxLayout(BoxLayout.Y_AXIS));
        txtLabel = new TextArea(3, 5);
        txtLabel.setEditable(false);
        txtLabel.setText("You will send all done \n "
                + "appointments and receive open \n "
                + "appointments for next :");
        txtLabel.setAlignment(CENTER);

        cbChoices = new ComboBox(choices);
        cbChoices.setSelectedIndex(3);
        cbChoices.setFocus(true);
        cbChoices.getStyle().setFgColor(0Xff0000);

        txtConfirm = new TextArea(1, 5);
        txtConfirm.setText("Are you sure ?");
        txtConfirm.setEditable(false);
        txtConfirm.setAlignment(CENTER);

        container.addComponent(txtLabel);
        container.addComponent(cbChoices);
        container.addComponent(txtConfirm);

        this.cmdYes = new Command("Yes");
        this.cmdNo = new Command ("No");

        this.addCommand(cmdYes);
        this.addCommand(cmdNo);
    }

    public void actionPerformed(ActionEvent actionEvent) {
        if(actionEvent.getSource() == cmdYes){
            //Show Download Dialog
            //Call Download Function


        }else if(actionEvent.getSource() == cmdNo){

            parent.show();
        }
    }

    public Object getScreenObject() {
        return this;
    }

    public void resume(Hashtable args) {
    }

    public void dialogReturned(Dialog dialog, boolean yesNo) {
    }



    



}
