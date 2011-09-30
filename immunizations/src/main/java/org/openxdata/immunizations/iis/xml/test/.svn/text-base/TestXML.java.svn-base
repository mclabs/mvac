/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.openxdata.immunizations.iis.xml.test;

import java.util.Vector;
import org.openxdata.immunizations.iis.IISAppointment;
import org.openxdata.immunizations.iis.xml.AppointmentsUtil;
import org.openxdata.immunizations.iis.xml.IISAppointmentParser;

/**
 *
 * @author soyfactor
 */
public class TestXML {



    public static void main(String[] args){
        String xml = "<response>"
                + "<data>"
                + "<appointments>"
                + "<appointment>"
                + "<iis_id></iis_id>"
                + "<child_id>12345</child_id>"
                + "<child_name>Geoffrey Mimano</child_name>"
                + "<vaccine_name>OPV</vaccine_name>"
                + "<schedule_date>2010-5-12</schedule_date>"
                + "<caretaker_name>Mother Mimano</caretaker_name>"
                + "<caretaker_phone>2010-5-12</caretaker_phone>"
                + "<vaccine_dose>dose</vaccine_dose>"
                + "</appointment>"
                + "<appointment>"
                + "<iis_id>334</iis_id>"
                + "<child_id>23345</child_id>"
                + "<child_name>John Mimano</child_name>"
                + "<vaccine_name>OPV</vaccine_name>"
                + "<schedule_date>2010-5-12</schedule_date>"
                + "<caretaker_name>Mother Mimano</caretaker_name>"
                + "<caretaker_phone>2010-5-12</caretaker_phone>"
                + "<vaccine_dose>dose</vaccine_dose>"
                + "</appointment>"
                + "</appointments>"
                + "</data>"
                + "</response>";

        System.out.println("Running the code");

        IISAppointmentParser parser = new IISAppointmentParser();
        Vector appointments = (Vector)parser.getObjects(xml, "appointments");

        System.out.println("Done Running code results are of count -> "+appointments.size());

        System.out.println("Done Running code results are of type -> "+((appointments.size()>0)?appointments.elementAt(0).getClass():"NULL"));

        for (int i = 0; i < appointments.size(); i++) {
            IISAppointment app = ((IISAppointment)appointments.elementAt(i));
            System.out.println(app.toString());

        }

        System.out.println(AppointmentsUtil.iisAppointments2Submit(appointments));

    }

    

    


}
