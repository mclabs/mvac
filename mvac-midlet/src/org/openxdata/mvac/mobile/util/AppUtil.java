/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.openxdata.mvac.mobile.util;

import com.sun.lwuit.Font;
import com.sun.lwuit.plaf.Style;
import java.util.Hashtable;
import javax.microedition.lcdui.Display;
import javax.microedition.midlet.MIDlet;
import org.openxdata.mvac.mobile.api.MvacController;
import org.openxdata.mvac.mobile.util.view.api.IDisplay;
import org.openxdata.mvac.mobile.util.view.api.IView;
import org.openxdata.mvac.mobile.util.view.api.LWUITDisplay;

/**
 *
 * @author soyfactor
 */
public class AppUtil {
    private static AppUtil instance;
    private Hashtable registry = new Hashtable();
    private static IDisplay display;
    static Style selc = null;

    private AppUtil(){
        

        
        
    }

    public static void init(MIDlet parent){
        System.out.println("init");
        get().putItem(Constants.MIDLET, parent);
        System.out.println("init");
        get().putItem(Constants.MIDP_DISPLAY, Display.getDisplay(parent));
        System.out.println("init");
        get().putItem(Constants.CONTROLLER, new MvacController());
        System.out.println("init");


        //change this to appropriate display object. e.g for LWUIT specific stuff LWUITDisplay or MIDP specific stuff
        display=new LWUITDisplay(parent);

    }

    public static AppUtil get(){
        if (instance!=null) {
            return instance;
        }else{
            instance = new AppUtil();

        }
        return instance;
    }

    public void putItem(String key, Object obj){
        registry.put(key, obj);
    }

    public Object getItem(String key){

        return registry.get(key);
    }

    public void setView(IView view){

        display.setView(view);

    }

    public Style getMVACSelectStyle() {
//        if(!(selc != null) ){
        if(selc == null){
            selc=new Style(0xffffff, 0x69b510, Font.getBitmapFont("NokiaSansWide14Bold"), (byte)255);
        
        }
        return selc;
    }
    
    


    

}
