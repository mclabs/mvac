/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.openxdata.modules.workflows.server.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import org.openxdata.immunizations.iis.xml.IISAppointmentParser;
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
        //return code for processing input params after fixing
        List<String> appointments = new ArrayList<String>();
        IISAppointmentParser parser = new IISAppointmentParser();
        appointments = (List<String>)parser.getObjects(getMyXML(), "appointments");


        return appointments;
        
    }

    @Override
    public List<String> launchcases(YSpecificationID specID,String xml){

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
