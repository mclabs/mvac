/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.openxdata.modules.workflows.server.service.impl;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Random; 
import java.util.logging.Level;
import java.util.logging.Logger;
import org.openxdata.immunizations.iis.xml.IISAppointmentParser;
import org.openxdata.immunizations.server.util.Constants;
import org.openxdata.modules.workflows.server.YawlOXDCustomService;
import org.openxdata.modules.workflows.server.context.WFContext;
import org.openxdata.modules.workflows.server.service.LaunchCaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.yawlfoundation.yawl.engine.YSpecificationID;

/**
 *
 * @author soyfactor
 */
@Transactional
@Service("launchCaseService")
public class LaunchCaseServiceImpl implements LaunchCaseService {
    //dummy Data
    String myXml = "";
    Random generator = new Random();
    String nurseName=null;
    String downdate = null;

    private String getMyXML(){
        List<String> mynames = new ArrayList<String>();
        mynames.add("John Kamau");
        mynames.add("Peter Waweru");
        mynames.add("Jane Karangau");
        mynames.add("Milka Mukami");
        mynames.add("Charles Kithika");
        mynames.add("Mary Kariri");
        mynames.add("Samuel Kamau");
        mynames.add("Victoria Mimano");
        mynames.add("Susan waithiegeni");
        mynames.add("James Kamee");

        
        int one;
        int two;
        one = generator.nextInt(10);
        two=generator.nextInt(10);

        String nameone =mynames.get(one);
        String nametwo=mynames.get(two);




        myXml = "<response>"
                + "<data>"
                + "<appointments>"
                + "<appointment_net>"
                + "<iis_id></iis_id>"
                + "<child_id>12345</child_id>"
                + "<child_name>"+nameone+"</child_name>"
                + "<vaccine_name>OPV</vaccine_name>"
                + "<schedule_date>2010-5-12</schedule_date>"
                + "<caretaker_name>Mother Mimano</caretaker_name>"
                + "<caretaker_phone>2010-5-12</caretaker_phone>"
                + "<vaccine_dose>dose</vaccine_dose>"
                + "</appointment_net>"
                + "<appointment_net>"
                + "<iis_id>334</iis_id>"
                + "<child_id>23345</child_id>"
                + "<child_name>"+nametwo+"</child_name>"
                + "<vaccine_name>OPV</vaccine_name>"
                + "<schedule_date>2010-5-12</schedule_date>"
                + "<caretaker_name>Mother Mimano</caretaker_name>"
                + "<caretaker_phone>2010-5-12</caretaker_phone>"
                + "<vaccine_dose>dose</vaccine_dose>"
                + "</appointment_net>"
                + "</appointments>"
                + "</data>"
                + "</response>";

        return myXml;
    }

    @Autowired
    private YawlOXDCustomService yawlService;

    @Override
    public List<String> getInputPrams(YSpecificationID specID) {
        return new ArrayList<String>();
    }

    @Override
    public List<String> processCaseData(String xml, List<String> inputParams) {
        URL url=null;
        try {
            url = new URL("http://158.38.65.147/iis.mobile/Appointment.ashx?username="+nurseName+"&date="+downdate);
        } catch (MalformedURLException ex) {
            Logger.getLogger(LaunchCaseServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        //BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));
        InputStream in=null;
        try {
            in = url.openStream();
        } catch (IOException ex) {
            Logger.getLogger(LaunchCaseServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        //return code for processing input params after fixing
        List<String> appointments = new ArrayList<String>();
        IISAppointmentParser parser = new IISAppointmentParser();
        appointments = (List<String>)parser.getObjects(in, "DocumentElement");


        return appointments;
        
    }

    @Override
    public List<String> launchcases(YSpecificationID specID,String xml,Hashtable args){
        if(args!=null){
            nurseName=(String)args.get(Constants.NURSE_NAME);
            downdate=(String)args.get(Constants.DOWNLOAD_DATE);

        }
        //process
         List<String> caseData = processCaseData(xml,getInputPrams(specID));
         return getCustomService().launchcases(specID, caseData);

    }


    public YawlOXDCustomService getCustomService() {
        if (yawlService == null)
            yawlService = WFContext.getOXDCustomService();
        return yawlService;
    }

}
