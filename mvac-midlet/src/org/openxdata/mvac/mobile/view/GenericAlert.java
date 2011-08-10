/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.openxdata.mvac.mobile.view;

import com.sun.lwuit.Command;
import com.sun.lwuit.Container;
import com.sun.lwuit.Dialog;
import com.sun.lwuit.Label;
import com.sun.lwuit.TextArea;
import com.sun.lwuit.events.ActionEvent;
import com.sun.lwuit.events.ActionListener;
import com.sun.lwuit.layouts.BorderLayout;
import com.sun.lwuit.layouts.CoordinateLayout;
import org.openxdata.mvac.mobile.util.AppUtil;
import org.openxdata.mvac.mobile.util.view.api.IView;

/**
 *
 * @author openmrs
 */
public class GenericAlert extends Dialog implements ActionListener{
    
    private Container container = null;
    private TextArea msg = null;
    private String message = null;
    private Command cmdOk = null;
    private IView parent = null;

    public GenericAlert(IView iView ,String message) {
        this.message = message ;
        this.parent = iView ;
        setAutoDispose(false);
        setLayout(new BorderLayout());
        init();
        addCommandListener(this);
    }
    
    private void init(){
        int w = getWidth();
        int h = getHeight();

        container = new Container(new CoordinateLayout(w, h));

        msg = new TextArea(3,3);
        msg.setText(message);
        msg.setAlignment(CENTER);
        msg.setFocusable(false);
        msg.setX(5);
        msg.setY(h/3);
        msg.setPreferredW(140);
        
        container.addComponent(msg);
        addComponent(BorderLayout.CENTER ,container);
        
        cmdOk = new Command("OK");
        
        addCommand(cmdOk);
        
        
    }

    public void actionPerformed(ActionEvent actionEvent) {
        if(actionEvent.getSource() == cmdOk){
            parent.resume(null);
        }
    }
    
   
    
}
