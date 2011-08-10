/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.openxdata.mvac.mobile.view;

import com.sun.lwuit.Button;
import com.sun.lwuit.Command;
import com.sun.lwuit.Container;
import com.sun.lwuit.Dialog;
import com.sun.lwuit.Form;
import com.sun.lwuit.Label;
import com.sun.lwuit.TextField;
import com.sun.lwuit.events.ActionEvent;
import com.sun.lwuit.events.ActionListener;
import com.sun.lwuit.layouts.BorderLayout;
import com.sun.lwuit.layouts.BoxLayout;
import java.util.Hashtable;
import javax.microedition.lcdui.CommandListener;
import javax.microedition.lcdui.Displayable;
import javax.microedition.midlet.MIDlet;
import javax.microedition.midlet.MIDletStateChangeException;
import org.openxdata.mvac.mobile.MvacMidlet;
import org.openxdata.mvac.mobile.util.AppUtil;
import org.openxdata.mvac.mobile.util.Constants;
import org.openxdata.mvac.mobile.util.view.api.IDialogListener;
import org.openxdata.mvac.mobile.util.view.api.IView;
import org.openxdata.mvac.mobile.view.user.MVACUserManager;


/**
 *
 * @author soyfactor
 */
public class LWUITLoginForm extends Form implements IView,IDialogListener,ActionListener{
    MVACUserManager usermanager = new MVACUserManager();

    private final String usernameLbl = "Username";
    private final String passwordLbl = "Password";

    private Container container;

    private Label lblUsername;
    private Label lblPassword;

    private TextField txtUsername;
    private TextField txtPassword;



    public LWUITLoginForm(String title) {
        super(title);
        initView();
    }

    public Object getScreenObject() {
        return this;
    }

    public void resume(Hashtable args) {
        //process args
        //set next displayable
        AppUtil.get().setView(this);
    }

    private void initView() {
        //Button butt = new Button(null)
       
        setLayout(new BorderLayout());


        container = new Container(new BoxLayout(BoxLayout.Y_AXIS));


        lblUsername = new Label(usernameLbl);
        lblPassword = new Label(passwordLbl);

        txtUsername = new TextField(20);
        txtUsername.setConstraint(TextField.ANY);

        txtPassword = new TextField();
        txtPassword.setConstraint(TextField.PASSWORD);

        container.addComponent(lblUsername);
        container.addComponent(txtUsername);

        container.addComponent(lblPassword);
        container.addComponent(txtPassword);

        

        addComponent(BorderLayout.CENTER , container);

        
        
        addCommand(new Command("Login") {
            public void actionPerformed(ActionEvent evt) {
                //authenticate user
                //display main men
                AppUtil.get().putItem(Constants.USERNAME,"admin");
                AppUtil.get().putItem(Constants.PASSWROD,"admin");
                LWUITMainMenu mainMenu = new LWUITMainMenu();
                AppUtil.get().setView(mainMenu);
//                try{
//                    if (usermanager.isUserValid(getUsername(), getPassword())) {
//                        LWUITMainMenu mainMenu = new LWUITMainMenu();
//                        AppUtil.get().putItem(Constants.USERNAME, getUsername());
//                        AppUtil.get().putItem(Constants.PASSWROD, getPassword());
//                        AppUtil.get().setView(mainMenu);
//                    }else{
//                        //display error. return to Login form
//                        resume(null);
//                    }
//
//                }catch(Exception e){
//                    e.printStackTrace();
//                }
                
                

                // Put code here

            }
        });

        addCommand(new Command("Exit"){
            public void actionPerformed(ActionEvent ae){
                System.out.println("Exit Command Pressed");
                try {
                    ((MvacMidlet) AppUtil.get().getItem(Constants.MIDLET)).exitApp(true);
                } catch (MIDletStateChangeException ex) {
                    ex.printStackTrace();
                }
            }
        });
        

    }

    public void onDialogClose(Object obj) {
        //process the response from the Dialog
        //show the next Item
        AppUtil.get().setView(this);
    }

    public void actionPerformed(ActionEvent ae) {

        

        
    }

    public String getPassword(){
        return txtPassword.getText();
    }

    public String getUsername(){
        return txtUsername.getText();
    }

    public void dialogReturned(Dialog dialog, boolean yesNo) {
    }


    

}
