/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.openxdata.mvac.mobile.util.view.api;

import javax.microedition.lcdui.Display;
import javax.microedition.lcdui.Displayable;
import org.openxdata.mvac.mobile.util.AppUtil;
import org.openxdata.mvac.mobile.util.Constants;

/**
 *
 * @author soyfactor
 */
public class J2MEDisplay implements IDisplay{

    public void setView(IView view) {
            if(view instanceof Displayable) {
                    ((Display)getDisplayObject()).setCurrent((Displayable)view);
            } else if(view.getScreenObject() instanceof Displayable) {
                    ((Display)getDisplayObject()).setCurrent((Displayable)view.getScreenObject());
            }
            else {
                    //throw Exception
            }
    }

    public Object getDisplayObject() {
        return AppUtil.get().getItem(Constants.MIDP_DISPLAY);
    }

}
