/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.openxdata.mvac.mobile;

import javax.microedition.midlet.MIDlet;
import javax.microedition.midlet.MIDletStateChangeException;
import org.openxdata.mvac.mobile.util.AppUtil;
import org.openxdata.mvac.mobile.util.NurseSettings;
import org.openxdata.mvac.mobile.view.LWUITLoginForm;

/**
 *
 * @author soyfactor
 */
public class MvacMidlet extends MIDlet {

    public MvacMidlet() {
        System.out.println("org init");
        AppUtil.init(this);
    }


    
    
    protected void startApp() throws MIDletStateChangeException {
        LWUITLoginForm loginForm = new LWUITLoginForm("User Login");
        AppUtil.get().setView(loginForm);
//        NurseSettings loginForm = new NurseSettings();
//        AppUtil.get().setView(loginForm);
        //FBProgressIndicator sb =new FBProgressIndicator();
        //sb.show();

    }

    protected void pauseApp() {
    }

    protected void destroyApp(boolean bln) throws MIDletStateChangeException {
    }

    public void exitApp(boolean bln) throws MIDletStateChangeException{
        this.destroyApp(bln);
    }


}
