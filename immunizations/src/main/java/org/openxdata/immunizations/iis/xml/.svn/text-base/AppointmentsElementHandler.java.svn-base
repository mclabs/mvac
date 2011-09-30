/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.openxdata.immunizations.iis.xml;

import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 *
 * @author soyfactor
 */
public class AppointmentsElementHandler implements IElementHandler {
    private List<String> appointments = new ArrayList<String>();

    public Object handle(Object handlerObject) {
        //process appointment xml elements
        if (handlerObject!=null) {
            NodeList appElems = (NodeList)handlerObject;
            if(appElems.getLength()>0){
                Element xmlappointments = (Element)appElems.item(0);
                parseElement(xmlappointments);

            }

        }else{
            return appointments;
        }
        

        
        return appointments;
    }

    private void parseElement(Element xmlappointments){
        NodeList children = xmlappointments.getChildNodes();
        for (int i=0;i<children.getLength();i++) {
            Node node = children.item(i);
            if (node.getNodeType()==Node.ELEMENT_NODE) {
                if(((Element)node).getTagName()=="appointment_net"){
                    parseAppointment(((Element)node));
                }

            }

        }


    }
    private void parseAppointment(Element appointment){

        TransformerFactory transFactory=null;
        Transformer transformer=null;
        StringWriter buffer = new StringWriter();

        transFactory= TransformerFactory.newInstance();
        try {
            transformer = transFactory.newTransformer();
            transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "yes");
            transformer.transform(new DOMSource(appointment),new StreamResult(buffer));
        } catch (TransformerException ex) {
            Logger.getLogger(AppointmentsElementHandler.class.getName()).log(Level.SEVERE, null, ex);
        }

        String str = buffer.toString();
        appointments.add(str);

    }
//    private void parseAppointment(Element appointment){
//
//        if(appointment.hasChildNodes()){
//            IISAppointment tempApp = new IISAppointment();
//            NodeList nodeList = appointment.getChildNodes();
//            for (int i = 0; i < nodeList.getLength(); i++) {
//                Node node = nodeList.item(i);
//                if(node.getNodeType()==Node.ELEMENT_NODE){
//                    if(node.getNodeName().equals("iis_id")&&node.getTextContent()!=""){
//                        tempApp.setIis_id(Integer.parseInt(node.getTextContent()));
//                    }
//                    if(node.getNodeName().equals("child_id")&&node.getTextContent()!=""){
//                        tempApp.setChild_id(Integer.parseInt(node.getTextContent()));
//                    }
//                    if(node.getNodeName().equals("child_name")&&node.getTextContent()!=""){
//                        tempApp.setChild_name(node.getTextContent());
//                    }
//                    if(node.getNodeName().equals("vaccine_name")&&node.getTextContent()!=""){
//                        tempApp.setVaccine_name(node.getTextContent());
//                    }
//                    if(node.getNodeName().equals("schedule_date")&&node.getTextContent()!=""){
//                        tempApp.setSchedule_date(node.getTextContent());
//                    }
//                    if(node.getNodeName().equals("caretaker_name")&&node.getTextContent()!=""){
//                        tempApp.setCaretaker_name(node.getTextContent());
//                    }
//                    if(node.getNodeName().equals("caretaker_phone")&&node.getTextContent()!=""){
//                        tempApp.setCaretaker_phone(node.getTextContent());
//                    }
//                    if(node.getNodeName().equals("vaccine_dose")&&node.getTextContent()!=""){
//                        tempApp.setVaccine_dose(node.getTextContent());
//                    }
//
//
//                }
//
//
//
//            }
//            appointments.addElement(tempApp);
//        }
//
//    }

}
