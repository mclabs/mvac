/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.openxdata.mvac.mobile.view;

import com.sun.lwuit.Calendar;
import java.util.Date;

/**
 *
 * @author soyfactor
 */
public class CustomCalendar extends Calendar {
    final long MILLIS_PER_DAY = 24 * 60 * 60 * 1000L;
    long selecteddate = new Date().getTime();

    public CustomCalendar() {
        setScrollable(true);
    }




    public void keyPressed(int keyCode) {
        System.out.println("Key pressed");
        super.keyPressed(keyCode);
//        if (keyCode==LEFT) {
//
//            long update2= selecteddate-MILLIS_PER_DAY;
//            setDate(new Date(update2));
//            selecteddate=update2;
//            repaint();
//
//        }else if(keyCode==RIGHT){
//            long update = selecteddate+MILLIS_PER_DAY;
//            setDate(new Date(update));
//            selecteddate=update;
//            repaint();
//
//        }else{
//            super.keyPressed(keyCode);
//        }
    }

    public void keyReleased(int keyCode) {
        System.out.println("Key pressed");
        super.keyReleased(keyCode);
    }





}
