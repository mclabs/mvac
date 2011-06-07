/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.openxdata.mvac.mobile.view;

import com.sun.lwuit.Calendar;
import com.sun.lwuit.Command;
import com.sun.lwuit.Dialog;
import com.sun.lwuit.Font;
import com.sun.lwuit.Form;
import com.sun.lwuit.events.ActionListener;
import com.sun.lwuit.layouts.BorderLayout;
import com.sun.lwuit.layouts.BoxLayout;
import com.sun.lwuit.plaf.Style;
import java.util.Date;
import java.util.Hashtable;
import javax.microedition.lcdui.Canvas;
import org.openxdata.mvac.mobile.util.AppUtil;
import org.openxdata.mvac.mobile.util.view.api.IView;

/**
 *
 * @author soyfactor
 */
public class CalendarForm extends Form implements IView {

    public Calendar calendar;
    public Command okcmd = new Command("OK", 1);
    public Command cmdBack = new Command("Back");
    final long MILLIS_PER_DAY = 24 * 60 * 60 * 1000L;
    long selecteddate;
    ScreenMon scrMon = new ScreenMon();


    private String sourceText = "";

    public CalendarForm() {
        this.calendar = new Calendar();
        
        selecteddate = calendar.getDate().getTime();
        addCommand(okcmd);
        addCommand(cmdBack);
        initView();
    }

    private void refreshCal(long t){
        this.removeAll();
        this.calendar = new Calendar(t);
        selecteddate = calendar.getDate().getTime();
        addCommand(okcmd);
        initView();
        repaint();

    }

    private void initView() {
        setScrollable(false);
        calendar.setFocus(true);
        calendar.setLayout(new BoxLayout(BoxLayout.Y_AXIS));
                
        //calendar.
        setLayout(new BorderLayout());
        this.addComponent(BorderLayout.CENTER, calendar);

    }

    public String getDate() {
        //setCommandListener(null);
        java.util.Calendar cal = java.util.Calendar.getInstance();
        cal.setTime(new Date(calendar.getDate().getTime()));
        int d = cal.get(java.util.Calendar.DAY_OF_MONTH);
        int mon = cal.get(java.util.Calendar.MONTH);
        int year = cal.get(java.util.Calendar.YEAR);

        return d + "/" + mon + "/" + year;
    }

    public void setListener(ActionListener listener) {
        addCommandListener(listener);
        //calendar.addActionListener(listener);

    }

    public Object getScreenObject() {
        return this;
    }

    public void resume(Hashtable args) {
        AppUtil.get().setView(this);
    }

    public void keyPressed(int keyCode) {
        int gameAction = scrMon.getGameAction(keyCode);
        System.out.println("Key pressed-->"+keyCode);
        System.out.println("Game action-->"+gameAction);
        System.out.println("cLeft-->"+Canvas.LEFT);
                System.out.println("cRight-->"+Canvas.RIGHT);
                System.out.println("cUp-->"+Canvas.UP);
                System.out.println("cDown-->"+Canvas.DOWN);
                if (gameAction == Canvas.LEFT) {

                    long update2 = selecteddate - MILLIS_PER_DAY;
                    refreshCal(update2);
//                    calendar.setDate(new Date(update2));
//                    selecteddate = update2;
//                    calendar.revalidate();
//                    calendar.repaint();
                    //CalendarForm.this.repaint();

                } else if (gameAction == Canvas.RIGHT) {
                    long update = selecteddate +MILLIS_PER_DAY;
                    refreshCal(update);
//                    calendar.setDate(new Date(update));
//                    selecteddate = update;
//                    calendar.revalidate();
//                    calendar.repaint();
                   //CalendarForm.this.repaint();

                } else if (gameAction == Canvas.DOWN) {
                    long update3 = selecteddate + (MILLIS_PER_DAY*7);
                    refreshCal(update3);
//                    calendar.setDate(new Date(update));
//                    selecteddate = update;
//                    calendar.revalidate();
//                    calendar.repaint();
                   //CalendarForm.this.repaint();

                }else if (gameAction == Canvas.UP) {
                    long update = selecteddate - (MILLIS_PER_DAY*7);
                    refreshCal(update);
//                    calendar.setDate(new Date(update));
//                    selecteddate = update;
//                    calendar.revalidate();
//                    calendar.repaint();
                   //CalendarForm.this.repaint();

                } else {
                    super.keyPressed(keyCode);
                }
    }

    public String getSourceText() {
        return sourceText;
    }

    public void setSourceText(String sourceText) {
        this.sourceText = sourceText;
    }

    public void dialogReturned(Dialog dialog, boolean yesNo) {
    }



    
}
