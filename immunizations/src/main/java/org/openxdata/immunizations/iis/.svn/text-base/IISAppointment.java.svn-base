/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.openxdata.immunizations.iis;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import org.openxdata.db.util.Persistent;

/**
 *
 * @author soyfactor
 */
public class IISAppointment implements Persistent {

    private int iis_id;
    private int child_id;
    private String child_name;
    private String vaccine_name;
    private String schedule_date;
    private String caretaker_name;
    private String caretaker_phone;
    private String vaccine_dose;



    public int getChild_id() {
        return child_id;
    }

    public void setChild_id(int child_id) {
        this.child_id = child_id;
    }

    public String getCaretaker_name() {
        return caretaker_name;
    }

    public void setCaretaker_name(String caretaker_name) {
        this.caretaker_name = caretaker_name;
    }

    public String getCaretaker_phone() {
        return caretaker_phone;
    }

    public void setCaretaker_phone(String caretaker_phone) {
        this.caretaker_phone = caretaker_phone;
    }

    public String getChild_name() {
        return child_name;
    }

    public void setChild_name(String child_name) {
        this.child_name = child_name;
    }

    public int getIis_id() {
        return iis_id;
    }

    public void setIis_id(int iis_id) {
        this.iis_id = iis_id;
    }

    public String getSchedule_date() {
        return schedule_date;
    }

    public void setSchedule_date(String schedule_date) {
        this.schedule_date = schedule_date;
    }

    public String getVaccine_dose() {
        return vaccine_dose;
    }

    public void setVaccine_dose(String vaccine_dose) {
        this.vaccine_dose = vaccine_dose;
    }

    public String getVaccine_name() {
        return vaccine_name;
    }

    public void setVaccine_name(String vaccine_name) {
        this.vaccine_name = vaccine_name;
    }

    



    public void write(DataOutputStream dos) throws IOException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void read(DataInputStream dis) throws IOException, InstantiationException, IllegalAccessException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public String toString() {
        return iis_id+" "+caretaker_name+" "+caretaker_phone+" "+child_name+" "+schedule_date+" "+vaccine_dose+" "+vaccine_name+" "+child_id;
    }



}
