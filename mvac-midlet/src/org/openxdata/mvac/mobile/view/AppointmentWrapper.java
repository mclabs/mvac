/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.openxdata.mvac.mobile.view;

import java.util.Vector;
import org.openxdata.workflow.mobile.model.MWorkItem;

/**
 *
 * @author soyfactor
 */
public class AppointmentWrapper {
    private String name;
    private String caretaker;
    private String child_dob;
    private String caretaker_nid;

    private Vector appointments = new Vector(0);
    private Vector workItems = new Vector(0);


    public void addElement(Appointment app){
        appointments.addElement(app);

    }

    public void addWorkItem(MWorkItem workItem){
        workItems.addElement(workItem);

    }

    public MWorkItem WorkItemAt(int i){

        if(workItems.size()>0 && workItems.size()>=i&&i>-1){
            return (MWorkItem)workItems.elementAt(i);
        }else{
            return null;
        }

    }

    public Appointment elementAt(int i){

        if(appointments.size()>0 && appointments.size()>=i&&i>-1){
            return (Appointment)appointments.elementAt(i);
        }else{
            return null;
        }

    }


    public String getChild_dob() {
        return child_dob;
    }


    public String getCaretaker_nid() {
        return caretaker_nid;
    }


    public Vector getAppointments(){
        return appointments;
    }
    
    public Vector getWorkItems(){
        return workItems;
    }

    public String getCaretaker() {
        return caretaker;
    }

    public String getName() {
        return name;
    }

    public void setCaretaker_nid(String caretaker_nid) {
        this.caretaker_nid = caretaker_nid;
    }

    public void setChild_dob(String child_dob) {
        this.child_dob = child_dob;
    }

    
    public void setCaretaker(String caretaker) {
        this.caretaker = caretaker;
    }

    public void setName(String name) {
        this.name = name;
    }

    

    

}
