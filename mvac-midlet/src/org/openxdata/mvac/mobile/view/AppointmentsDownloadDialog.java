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
import com.sun.lwuit.TextArea;
import com.sun.lwuit.events.ActionEvent;
import com.sun.lwuit.events.ActionListener;
import com.sun.lwuit.layouts.BorderLayout;
import com.sun.lwuit.layouts.BoxLayout;
import com.sun.lwuit.list.DefaultListCellRenderer;
import org.openxdata.mvac.mobile.util.AppUtil;
import org.openxdata.mvac.mobile.util.view.api.IView;

/**
 *
 * @author mutahi
 */
public class AppointmentsDownloadDialog extends Dialog implements ActionListener{
    
    private ComboBox cbOptions = null;
    private String[] options = {"1 Week" , "2 Weeks" , "3 Weeks" , "4 Weeks"};

    private TextArea txtLabel = null;
    private TextArea txtConfirm = null;

    private Container container = null;

    private Command cmdYes = null;
    private Command cmdNo = null;

    private IView parent = null;


    public AppointmentsDownloadDialog(IView parentForm) {
        super();
        this.parent = parentForm;
        setAutoDispose(false);
        setLayout(new BorderLayout());
        init();
        addCommandListener(this);
    }

    private void init(){
        cbOptions = new ComboBox(options);
        cbOptions.setSelectedIndex(3);
        cbOptions.setFocus(true);
        cbOptions.getStyle().setFgColor(0Xff0001);
        cbOptions.getStyle().setBgColor(150);
        DefaultListCellRenderer dlcr =
                (DefaultListCellRenderer)cbOptions.getRenderer();
        dlcr.getStyle().setFgColor(0x0000ff);




        txtLabel = new TextArea(3, 5);
        txtLabel.setEditable(false);
        txtLabel.setText("You will send all done \n "
                + "appointments and receive open \n "
                + "appointments for next :");
        txtLabel.setAlignment(CENTER);
        txtLabel.setFocusable(false);

        txtConfirm = new TextArea(1, 5);
        txtConfirm.setText("Are you sure ?");
        txtConfirm.setEditable(false);
        txtConfirm.setAlignment(CENTER);
        txtConfirm.setFocusable(false);

        container = new Container(new BoxLayout(BoxLayout.Y_AXIS));

        container.addComponent(txtLabel);
        container.addComponent(cbOptions);
        container.addComponent(txtConfirm);

        this.addComponent(BorderLayout.CENTER, container);

        cmdYes = new Command("Yes");
        cmdNo = new Command("No");

        this.addCommand(cmdYes);
        this.addCommand(cmdNo);

    }

    public void actionPerformed(ActionEvent actionEvent) {
        if(actionEvent.getSource() == cmdNo){
            AppUtil.get().setView(parent);

        }else if(actionEvent.getSource() == cmdYes){

            String selected = cbOptions.getSelectedItem().toString();
            System.out.println("Selected Object :" + selected);
            parent.dialogReturned(this, true);


        }
    }

}
