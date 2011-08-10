/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.openxdata.mvac.mobile.util;

import com.sun.lwuit.Button;
import com.sun.lwuit.Command;
import com.sun.lwuit.Container;
import com.sun.lwuit.Dialog;
import com.sun.lwuit.Font;
import com.sun.lwuit.Form;
import com.sun.lwuit.Label;
import com.sun.lwuit.TextField;
import com.sun.lwuit.events.ActionEvent;
import com.sun.lwuit.events.ActionListener;
import com.sun.lwuit.layouts.BorderLayout;
import com.sun.lwuit.layouts.BoxLayout;
import com.sun.lwuit.plaf.Style;
import java.util.Hashtable;
import javax.microedition.midlet.MIDletStateChangeException;
import org.openxdata.mvac.mobile.MvacMidlet;
import org.openxdata.mvac.mobile.util.view.api.IView;
import org.openxdata.mvac.mobile.view.GenericAlert;
import org.openxdata.mvac.mobile.view.LWUITMainMenu;

/**
 *
 * @author openmrs
 */
public class NurseSettings extends Form implements IView,ActionListener{
    Label uname;
    TextField unametxt = null;
    Button login;
    Command loginCmd;
    Command exitCmd;
    Container loginCont;
    

    public NurseSettings() {
        
        initview();
    }
    
    private void initview() {
        setTitle("Nurse Login");
        setLayout(new BorderLayout());
        loginCont = new Container(new BoxLayout(BoxLayout.Y_AXIS));
        uname = new Label("Nurse Username:");
        unametxt = new TextField("");
        unametxt.setConstraint(TextField.ANY);
        loginCmd = new Command("Proceed");
        exitCmd = new Command("Exit");
        login = new Button(loginCmd);
        login.addActionListener(this);
        
        loginCont.addComponent(uname);
        loginCont.addComponent(unametxt);
        
        login.setSelectedStyle(new Style(0xffffff, 0x69b510, Font.getBitmapFont("NokiaSansWide14Bold"), (byte)255));
        loginCont.addComponent(login);    
        addCommand(exitCmd);
        addComponent(BorderLayout.CENTER, loginCont);
    }

    public Object getScreenObject() {
        return this;
    }

    public void dialogReturned(Dialog dialog, boolean yesNo) {
        //do Nothign
    }

    public void resume(Hashtable args) {
       //do Nothing
    }

    public void actionPerformed(ActionEvent ae) {
        Command cmd = ae.getCommand();
        if(cmd==loginCmd){
            //login command
             
             int length = unametxt.getText().length();
            if(unametxt.getText()!="" && unametxt.getText()!=null && length>0){                
//                AppUtil.get().putItem(Constants.USERNAME,"admin");
//                AppUtil.get().putItem(Constants.PASSWROD,"admin");
                AppUtil.get().putItem(Constants.NURSENAME, unametxt.getText());
                LWUITMainMenu mainMenu = new LWUITMainMenu();
                AppUtil.get().setView(mainMenu);
                
            }else{
                GenericAlert alert = new GenericAlert(this, "Enter username");
                alert.show();
            }
            
            
        }else if (cmd==exitCmd){
            //exit here
             System.out.println("Exit Command Pressed");
                try {
                    ((MvacMidlet) AppUtil.get().getItem(Constants.MIDLET)).exitApp(true);
                } catch (MIDletStateChangeException ex) {
                    ex.printStackTrace();
                }
            
        }
    }

   

    
    
}
