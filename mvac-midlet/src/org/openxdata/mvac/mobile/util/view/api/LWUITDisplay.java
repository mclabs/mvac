/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.openxdata.mvac.mobile.util.view.api;

import com.sun.lwuit.Display;
import com.sun.lwuit.Form;
import com.sun.lwuit.plaf.UIManager;
import com.sun.lwuit.util.Resources;
import java.io.DataInputStream;
import java.io.IOException;
import javax.microedition.midlet.MIDlet;

/**
 *
 * @author soyfactor
 */
public class LWUITDisplay implements IDisplay {

    public LWUITDisplay(MIDlet parent) {
        //ImplementationFactory.setInstance(new MobrizImplementationFactory());
        Display.init(parent);
        System.out.println("Initing the display");
//        Display.getInstance().callSerially(new Runnable() {
//				public void run() {
//					initTheme();
//				}
//			});
        initTheme();
    }

    //initalize LWUIT theme here
    private void initTheme() {
        Resources r;
        try {


//            DataInputStream dis = new DataInputStream(this.getClass().getResourceAsStream("/NDG.res"));
//            System.out.println("Loaded Dis of size ->" + dis.available());
//            Resources r = Resources.open(dis);
//            UIManager.getInstance().setThemeProps(r.getTheme("mvac_theme"));
            
            
            r = Resources.open("/NDG.res");
            UIManager.getInstance().setThemeProps(r.getTheme(r.getThemeResourceNames()[0]));




        } catch (IOException ioe) {
            ioe.printStackTrace();

        }
    }

    public void setView(IView view) {
        ((Form) view).show();

    }

    public Object getDisplayObject() {
        //Not supported by LWUIT. OR can return LWUIT display stuff. Whatever... :P
        return null;
    }
}
