/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.openxdata.immunizations.iis.xml.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.Vector;
import org.openxdata.immunizations.iis.IISAppointment;
import org.openxdata.immunizations.iis.xml.AppointmentsUtil;
import org.openxdata.immunizations.iis.xml.IISAppointmentParser;

/**
 *
 * @author soyfactor
 */
public class TestXML {



    public static void main(String[] args) throws MalformedURLException, IOException{
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


        String newXml = "<DocumentElement><Appointments><appointment_id>157</appointment_id><dose_id>256</dose_id><child_iis_id>41</child_iis_id><child_dob>2010-01-10T00:00:00+01:00</child_dob><child_name>Stivi Shyti</child_name><vaccine_name>BCG</vaccine_name><scheduled_date>2010-01-10T00:00:00+01:00</scheduled_date><caretaker_name>Kreshnik Shyti</caretaker_name><caretaker_nid /><caretaker_iis_id>3</caretaker_iis_id><dose_name>0 Dite</dose_name>  </Appointments>  <Appointments><appointment_id>157</appointment_id><dose_id>257</dose_id><child_iis_id>41</child_iis_id><child_dob>2010-01-10T00:00:00+01:00</child_dob><child_name>Stivi Shyti</child_name><vaccine_name>HepB</vaccine_name><scheduled_date>2010-01-10T00:00:00+01:00</scheduled_date><caretaker_name>Kreshnik Shyti</caretaker_name><caretaker_nid /><caretaker_iis_id>3</caretaker_iis_id><dose_name>0 Dite</dose_name></Appointments></DocumentElement>";

        System.out.println("Running the code");
        URL url;
        url = new URL("http://kmk.al/IIS.Web/IIS.Mobile/appointment.ashx?username=qesaraka&date=2011-04-01");
        //BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));
        InputStream in = url.openStream();
        IISAppointmentParser parser = new IISAppointmentParser();
        List<String> appointments = (List<String>)parser.getObjects(in, "DocumentElement");
        in.close();
        System.out.println("Done Running code results are of count -> "+appointments.size());

        System.out.println("Done Running code results are of type -> "+((appointments.size()>0)?appointments.get(0).getClass():"NULL"));

        for (int i = 0; i < appointments.size(); i++) {
            String app = ((String)appointments.get(i));
            System.out.println("IN***-------------***");

            System.out.println(app.toString());
            System.out.println("***-------------***");


        }

        //System.out.println(AppointmentsUtil.iisAppointments2Submit(appointments));

    }

    

    


}
