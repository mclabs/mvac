/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.openxdata.mvac.mobile.view;

import com.sun.lwuit.AnimatedGIF;
import com.sun.lwuit.Command;
import com.sun.lwuit.Container;
import com.sun.lwuit.Dialog;
import com.sun.lwuit.Label;
import com.sun.lwuit.TextArea;
import com.sun.lwuit.events.ActionListener;
import com.sun.lwuit.layouts.BorderLayout;
import com.sun.lwuit.layouts.BoxLayout;
import com.sun.lwuit.layouts.CoordinateLayout;
import java.io.IOException;
import javax.microedition.lcdui.TextBox;

/**
 *
 * @author soyfactor
 */
public class FBProgressIndicator extends Dialog {

private AnimatedGIF image;
    private Label imagelbl = new Label("");
    private ActionListener listener;
    public Command cancel;
    private String msg;

    private Container container = null;



    public FBProgressIndicator(ActionListener listener,String msg) {
        super("Please Wait...");
        
        this.msg=msg;
        this.listener = listener;
        this.setAutoDispose(false);
        this.getStyle().setPadding(5, 5, 5, 5);
        addCommandListener(this.listener);
        
        
        setLayout(new BorderLayout());

        init();


       
    }

    private void init(){
        int w = getWidth();
        int h = getHeight();

        container = new Container(new CoordinateLayout(w, h));


        try {
            image = AnimatedGIF.createAnimatedGIF(getClass().getResourceAsStream("/progress2.gif"));
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        cancel = new Command("Cancel", 1);

        imagelbl.getStyle().setBgColor(0xffffff);
        imagelbl.setIcon(image);
        imagelbl.setText(this.msg);

        imagelbl.setFocusable(false);
        imagelbl.setAlignment(CENTER);
        imagelbl.setX(5);
        imagelbl.setY(h/3);
        imagelbl.setPreferredW(140);

        container.addComponent(imagelbl);

        addComponent(BorderLayout.CENTER, container);

        addCommand(cancel);
    }


    
}
