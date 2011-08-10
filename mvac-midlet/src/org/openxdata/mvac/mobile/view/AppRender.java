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
public class AppRender extends Container implements ListCellRenderer {
    private Label scheduledlbl = new Label("Scheduled:");
    private Label administeredlbl = new Label("Administered:");

    private Label vaccine_name=new Label("");
    private Label scheduled_date = new Label("");
    private Label focus = new Label("");
    private Label dose = new Label("");
    private Container cnt;
    private Container childcnt;
    private Container caretakercnt;
    private Container Administeredcnt;
    private Font lblFont = Font.getBitmapFont("mvaccalibri13");
    private String vaccine_dose = new String();

    public AppRender(){
        cnt = new Container(new BoxLayout(BoxLayout.Y_AXIS));
        childcnt = new Container(new BoxLayout(BoxLayout.X_AXIS));
        caretakercnt = new Container(new BoxLayout(BoxLayout.X_AXIS));
        Administeredcnt = new Container(new BoxLayout(BoxLayout.X_AXIS));

        scheduledlbl.getStyle().setFont(lblFont, true);
        administeredlbl.getStyle().setFont(lblFont,true);

        vaccine_name.getStyle().setFont(lblFont,true);
        scheduled_date.getStyle().setBgTransparency(0);
        dose.getStyle().setBgTransparency(0);
        
        setLayout(new BorderLayout());


        childcnt.addComponent(vaccine_name);
       

        caretakercnt.addComponent(scheduledlbl);
        caretakercnt.addComponent(scheduled_date);

        Administeredcnt.addComponent(administeredlbl);
        //Administeredcnt.addComponent(dose);
        
        
        cnt.addComponent(childcnt);
        cnt.addComponent(caretakercnt);
        cnt.addComponent(Administeredcnt);
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
        Appointment appointment = (Appointment)value;
        

        if(appointment.getVaccine_name() != null && appointment.getDose() != null){
            vaccine_dose = appointment.getVaccine_name() +" : "+ appointment.getDose();
        }else{
            if(appointment.getVaccine_name()!= null){
                vaccine_dose = appointment.getVaccine_name();
            }else if(appointment.getDose() != null){
                vaccine_dose = appointment.getDose();
            }
        }


        vaccine_name.setText(vaccine_dose);

        String date = appointment.getSchedule_date();
        date = date.substring(0, date.indexOf("T"));

        scheduled_date.setText(date);
        dose.setText(appointment.getDose());

        return this;

    }

    public Component getListFocusComponent(List list) {
        return focus;
    }

    public String getVaccine_dose() {
        return vaccine_dose;
    }
    

}
