/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.openxdata.mvac.mobile.view;

import com.sun.lwuit.ComboBox;
import com.sun.lwuit.Command;
import com.sun.lwuit.Container;
import com.sun.lwuit.Dialog;
import com.sun.lwuit.TextArea;
import com.sun.lwuit.events.ActionEvent;
import com.sun.lwuit.events.ActionListener;
import com.sun.lwuit.layouts.BorderLayout;
import com.sun.lwuit.layouts.BoxLayout;
import com.sun.lwuit.list.DefaultListCellRenderer;
import java.util.Calendar;
import java.util.Date;
import org.openxdata.mvac.mobile.util.AppUtil;
import org.openxdata.mvac.mobile.util.Constants;
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
    //date Stuff
    private Calendar calendar = Calendar.getInstance();
    private Date d;
    private int day ;
    private int month ;
    private int year ;
    private long millisec = 1000;
    private long secondsInDay;
    
    private String finaldate = "";
    


    public AppointmentsDownloadDialog(IView parentForm) {
        super();
        this.parent = parentForm;
        secondsInDay=1000*60*60*24;
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
            calendar = Calendar.getInstance();
            year = calendar.get(Calendar.YEAR);
            month = calendar.get(Calendar.MONTH);
            day = calendar.get(Calendar.DAY_OF_MONTH);
            
            finaldate = year + "-"+month + "-" + day ;
            //System.out.println("Finale date is :" + finaldate);
            
            
            if(selected.trim().equals("1 Week")){
                
                calendar.setTime(new Date(calendar.getTime().getTime()+(7*secondsInDay)));
            }else if((selected.trim().equals("2 Weeks"))){
               calendar.setTime(new Date(calendar.getTime().getTime()+(14*secondsInDay)));
            }else if(selected.trim().equals("3 Weeks")){
                calendar.setTime(new Date(calendar.getTime().getTime()+(21*secondsInDay)));
            }else if(selected.trim().equals("4 Weeks")){
                calendar.setTime(new Date(calendar.getTime().getTime()+(28*secondsInDay)));
            }
            
            year = calendar.get(Calendar.YEAR);
            month = calendar.get(Calendar.MONTH);
            day = calendar.get(Calendar.DAY_OF_MONTH);
            
            String m = "";
            String d = "";
            
            if(month<10){
                m = "0"+ String.valueOf(month);
            }else{
                m = String.valueOf(month);
            }
            if(day < 10){
                d = "0"+ String.valueOf(day);
            }else{
                d = String.valueOf(day);
            }
            
            finaldate = year + "-"+m + "-" + d ;
            System.out.println("Final date is :" + finaldate);
            
            //String downDate = "2010-09-02";
           AppUtil.get().putItem(Constants.DOWNLOAD_DATE, finaldate);
            parent.dialogReturned(this, true);


        }
    }

}
