/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.openxdata.mvac.mobile.view;

import com.sun.lwuit.Component;
import com.sun.lwuit.Container;
import com.sun.lwuit.Font;
import com.sun.lwuit.Label;
import com.sun.lwuit.List;
import com.sun.lwuit.layouts.BorderLayout;
import com.sun.lwuit.layouts.BoxLayout;
import com.sun.lwuit.list.ListCellRenderer;
import com.sun.lwuit.plaf.Border;

/**
 *
 * @author soyfactor
 */
public class AppGroupRender extends Container implements ListCellRenderer {
    
    private Label child_dob = new Label();
    private Label caretaker_id = new Label();

    private Label name=new Label("");
    private Label caretaker = new Label("");
    private Label focus = new Label("");
    private Container cnt;
    private Container childcnt;
    private Container caretakercnt;
//    private Font lblFont = Font.getBitmapFont("mvaccalibri13");

    public AppGroupRender(){
        cnt = new Container(new BoxLayout(BoxLayout.Y_AXIS));
        childcnt = new Container(new BoxLayout(BoxLayout.X_AXIS));
        caretakercnt = new Container(new BoxLayout(BoxLayout.X_AXIS));

//        name.getStyle().setFont(lblFont,true);
//        caretaker_id.getStyle().setFont(lblFont, true);

        name.getStyle().setBgTransparency(0);
        caretaker.getStyle().setBgTransparency(0);
        
        setLayout(new BorderLayout());

        childcnt.addComponent(name);
        childcnt.addComponent(child_dob);

        caretakercnt.addComponent(caretaker_id);
        caretakercnt.addComponent(caretaker);
        
        
        cnt.addComponent(childcnt);
        cnt.addComponent(caretakercnt);
        Border bd = Border.createLineBorder(1, 0x7799bb);
        
        cnt.getStyle().setBorder(bd, true);
        cnt.getStyle().setBgColor(0xffffff);
        cnt.getStyle().setFgColor(0xffffff);

        addComponent(BorderLayout.CENTER,cnt);

        focus.getStyle().setBgColor(0x7AE969,true);
        focus.getStyle().setFgColor(0x7AE969,true);
        focus.getStyle().setBgTransparency(100);
        
    }


    public Component getListCellRendererComponent(List list, Object value, int index, boolean isSelected) {
        AppointmentWrapper appointment = (AppointmentWrapper)value;

        name.setText(appointment.getName());
        child_dob.setText(appointment.getChild_dob());
        caretaker_id.setText(appointment.getCaretaker_nid());
        caretaker.setText(appointment.getCaretaker());

        return this;

    }

    public Component getListFocusComponent(List list) {
        return focus;
    }

}
