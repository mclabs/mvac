package org.openxdata.mvac.mobile.util;

//~--- non-JDK imports --------------------------------------------------------

import org.openxdata.util.AlertMessageListener;

//~--- JDK imports ------------------------------------------------------------

import javax.microedition.lcdui.Display;
import javax.microedition.lcdui.Displayable;

public class AlertMsgListenerImpl implements AlertMessageListener {
    private final Display     display;
    private final Displayable displayable;

    public AlertMsgListenerImpl(Display display, Displayable displayable) {
        this.display     = display;
        this.displayable = displayable;
    }

    public void onAlertMessage(byte msg) {
        display.setCurrent(displayable);
        
    }
}


//~ Formatted by Jindent --- http://www.jindent.com
