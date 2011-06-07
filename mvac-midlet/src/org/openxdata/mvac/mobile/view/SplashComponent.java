
/*
* To change this template, choose Tools | Templates
* and open the template in the editor.
 */
package org.openxdata.mvac.mobile.view;

//~--- JDK imports ------------------------------------------------------------

import java.io.IOException;

import java.util.Timer;
import java.util.TimerTask;

import javax.microedition.lcdui.Canvas;
import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.Image;

/**
 *
 * @author mutahi
 */
public class SplashComponent extends Canvas {
    private int   current;
    private int   factor;
    private int   height;
    private Image image;
    private Timer timer;
    private int   width;

    public SplashComponent() {
        height  = getHeight();
        width   = getWidth();
        factor  = width / 4;
        current = factor;
        timer   = new Timer();

        try {
            image = Image.createImage("/iis_logo.gif");
        } catch (IOException io) {}

        setFullScreenMode(true);
        timer.schedule(new draw(), 2000, 2000);
        repaint();
    }

    protected void paint(Graphics g) {

        // g.fillRect(0, 0, width, height);
        g.setColor(0x003399ff);

        // g.drawString("Powered by", 120, 10, Graphics.TOP | Graphics.HCENTER);
        g.drawImage(image, 120, 30, Graphics.VCENTER | Graphics.HCENTER);
        g.setColor(0x00FFFF66);
        g.fillRect(25, height / 2 + 130, width - 50, 2);
        g.setColor(0x003399ff);
        g.fillRect(25, height / 2 + 130, current, 2);
        g.drawString("Loading...", 120, (height / 2) + 160, Graphics.BOTTOM | Graphics.HCENTER);
    }

    private class draw extends TimerTask {
        public void run() {
            current = current + factor;

            if (current > width - 25) {
                timer.cancel();
            } else {
                repaint();
            }
        }
    }
}


//~ Formatted by Jindent --- http://www.jindent.com
