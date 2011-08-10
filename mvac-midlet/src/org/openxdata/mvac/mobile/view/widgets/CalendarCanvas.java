/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.openxdata.mvac.mobile.view.widgets;

import java.util.Date;
import java.util.Hashtable;
import javax.microedition.lcdui.Alert;
import javax.microedition.lcdui.AlertType;
import javax.microedition.lcdui.Canvas;
import javax.microedition.lcdui.Display;
import javax.microedition.lcdui.Font;
import javax.microedition.lcdui.Graphics;
import javax.microedition.midlet.MIDlet;
import org.openxdata.mvac.mobile.util.AppUtil;
import org.openxdata.mvac.mobile.util.Constants;
import org.openxdata.mvac.mobile.util.view.api.IView;

/**
 *
 * @author openmrs
 */
public class CalendarCanvas extends Canvas {
    CalendarWidget calendar = null;
	MIDlet midlet = null;
        IView parent;
	
	public CalendarCanvas(IView parent)
	{
		this.midlet = (MIDlet)AppUtil.get().getItem(Constants.MIDLET);
                this.parent = parent;
		
		calendar = new CalendarWidget(new Date());
		
		calendar.headerFont = Font.getFont(Font.FACE_PROPORTIONAL, Font.STYLE_BOLD, Font.SIZE_LARGE);
		calendar.weekdayFont = Font.getFont(Font.FACE_PROPORTIONAL, Font.STYLE_BOLD, Font.SIZE_MEDIUM);
		calendar.weekdayBgColor = 0xccccff;
		calendar.weekdayColor = 0x0000ff;
		calendar.headerColor = 0xffffff;
		
		calendar.initialize();
	}
	protected void keyPressed(int key)
	{
		int keyCode = getGameAction(key);
		
		if(keyCode == FIRE)
		{
//			Display.getDisplay(midlet).setCurrent(
//				new Alert("Selected date", calendar.getSelectedDate().toString(), null, AlertType.CONFIRMATION)
//			);
                    Hashtable args = new Hashtable();
                    args.put("date", calendar.getSelectedDate());
                    parent.resume(args);
		}
		else
		{
			calendar.keyPressed(keyCode);
			
			repaint();
		}
	}
	
	protected void paint(Graphics g)
	{
		g.setColor(0xffffff);
		g.fillRect(0, 0, getWidth(), getHeight());
		
		calendar.paint(g);
	}
    
}
