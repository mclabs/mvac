/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.openxdata.mvac.mobile.view;

import java.util.Date;

/**
 *
 * @author soyfactor
 */
public class Appointment {
    private String child_id;
    private int record_id;
    private String name;
    private String caretaker;
    private String vaccine_name;
    private String schedule_date;
    private String dose;


    public Appointment(){
        
    }
   



    public String getCaretaker() {
        return caretaker;
    }

    public void setCaretaker(String caretaker) {
        this.caretaker = caretaker;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getChild_id() {
        return child_id;
    }

    public void setChild_id(String child_id) {
        this.child_id = child_id;
    }

    public int getRecord_id() {
        return record_id;
    }

    public void setRecord_id(int record_id) {
        this.record_id = record_id;
    }

    public String getSchedule_date() {
        return schedule_date;
    }

    public void setSchedule_date(String schedule_date) {
        this.schedule_date = schedule_date;
    }

    public String getVaccine_name() {
        return vaccine_name;
    }

    public void setVaccine_name(String vaccine_name) {
        this.vaccine_name = vaccine_name;
    }

    public String getDose() {
        return dose;
    }

    public void setDose(String dose) {
        this.dose = dose;
    }

    

    

    public Appointment(String child_id, int record_id, String name, String caretaker) {
        this.child_id = child_id;
        this.record_id = record_id;
        this.name = name;
        this.caretaker = caretaker;
    }





}
