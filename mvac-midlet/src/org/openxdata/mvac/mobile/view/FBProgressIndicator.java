/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.openxdata.mvac.mobile.view;

import com.sun.lwuit.AnimatedGIF;
import com.sun.lwuit.Command;
import com.sun.lwuit.Dialog;
import com.sun.lwuit.Label;
import com.sun.lwuit.events.ActionListener;
import com.sun.lwuit.layouts.BorderLayout;
import java.io.IOException;

/**
 *
 * @author soyfactor
 */
public class FBProgressIndicator extends Dialog {

    AnimatedGIF image;
    Label imagelbl = new Label("");
    private ActionListener listener;
    public Command cancel;
    private String msg;



    public FBProgressIndicator(ActionListener listener,String msg) {
        super("Please Wait...");
        try {
            image = AnimatedGIF.createAnimatedGIF(getClass().getResourceAsStream("/progress2.gif"));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        this.msg=msg;
        this.listener = listener;
        cancel = new Command("Cancel", 1);
        addCommandListener(this.listener);
        addCommand(cancel);
        imagelbl.getStyle().setBgColor(0xffffff);
        imagelbl.setIcon(image);
        imagelbl.setText(this.msg);
        setLayout(new BorderLayout());
        addComponent(BorderLayout.NORTH, imagelbl);


       
    }


    
}
