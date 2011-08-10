/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.openxdata.mvac.mobile.view.widgets;

import com.sun.lwuit.Dialog;
import com.sun.lwuit.Font;
import com.sun.lwuit.Form;
import com.sun.lwuit.Graphics;
import java.util.Date;
import java.util.Hashtable;
import javax.microedition.lcdui.Alert;
import javax.microedition.lcdui.AlertType;
import javax.microedition.lcdui.Canvas;
import javax.microedition.lcdui.Display;
import javax.microedition.midlet.MIDlet;
import org.openxdata.mvac.mobile.util.AppUtil;
import org.openxdata.mvac.mobile.util.Constants;
import org.openxdata.mvac.mobile.util.view.api.IView;

/**
 *
 * @author openmrs
 */
public class LWUITCalendarForm extends Form implements IView{
    
    LWUITCalendarWidget calendar = null;
    MIDlet midlet = null;
    IView parent;

    public LWUITCalendarForm(IView parent) {
        this.midlet = (MIDlet)AppUtil.get().getItem(Constants.MIDLET);
        this.parent = parent;
		
		calendar = new LWUITCalendarWidget(new Date());
		
		calendar.headerFont = Font.createSystemFont(Font.FACE_PROPORTIONAL, Font.STYLE_BOLD, Font.SIZE_LARGE);
		calendar.weekdayFont = Font.createSystemFont(Font.FACE_PROPORTIONAL, Font.STYLE_BOLD, Font.SIZE_MEDIUM);
		calendar.weekdayBgColor = 0xccccff;
		calendar.weekdayColor = 0x0000ff;
		calendar.headerColor = 0xffffff;
		
		calendar.initialize();
    }
    
    
    

    public void paint(Graphics g) {
        g.setColor(0xffffff);
		g.fillRect(0, 0, getWidth(), getHeight());
		
		calendar.paint(g);
    }

    public void keyPressed(int keyCode) {
        //int keyCode = getGameAction(key);
		
		if(keyCode == Canvas.FIRE)
		{
//			Display.getDisplay(midlet).setCurrent(
//				new Alert("Selected date", calendar.getSelectedDate().toString(), null, AlertType.CONFIRMATION)
//			);
                    Hashtable args = new Hashtable();
                    args.put("date", calendar.getSelectedDate().toString());
                    parent.resume(args);
		}
		else
		{
			calendar.keyPressed(keyCode);
			
			repaint();
		}
    }

    public Object getScreenObject() {
        return this;
    }

    public void dialogReturned(Dialog dialog, boolean yesNo) {
        //throw new UnsupportedOperationException("Not supported yet.");
    }

    public void resume(Hashtable args) {
        //throw new UnsupportedOperationException("Not supported yet.");
    }
    
    
    
    
}
