/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.openxdata.immunizations.iis.xml;

import java.io.StringWriter;
import java.util.Vector;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.openxdata.immunizations.iis.IISAppointment;
import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

/**
 *
 * @author soyfactor
 */
public class AppointmentsUtil {

    //create xml representation of the submission stuff
    public static String iisAppointments2Submit(Vector appointments){
        DocumentBuilder builder=null;
        try {
            builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
        } catch (ParserConfigurationException ex) {
            ex.printStackTrace();
        }
        
        DOMImplementation impl = builder.getDOMImplementation();

        Document doc = impl.createDocument(null,null,null);
        Element request = doc.createElement("request");
        request.setAttribute("type", "appointments_submit");
        doc.appendChild(request);

        Element user = doc.createElement("user");
        Element uname = doc.createElement("uname");
        user.appendChild(uname);
        request.appendChild(user);

        Element params = doc.createElement("params");
        Element apptments = doc.createElement("appoinments");
        params.appendChild(apptments);
        request.appendChild(params);


        Element el=null;
        for (int i = 0; i < appointments.size(); i++) {
            IISAppointment tmpApp = (IISAppointment)appointments.elementAt(i);

            Element app = doc.createElement("appointment");
            apptments.appendChild(app);

            el = doc.createElement("iis_id");
            el.setTextContent(String.valueOf(tmpApp.getIis_id()));
            app.appendChild(el);

            el=doc.createElement("child_id");
            el.setTextContent(String.valueOf(tmpApp.getChild_id()));
            app.appendChild(el);

            el=doc.createElement("child_name");
            el.setTextContent(tmpApp.getChild_name());
            app.appendChild(el);

            el =doc.createElement("vaccine_name");
            el.setTextContent(tmpApp.getVaccine_name());
            app.appendChild(el);

            el = doc.createElement("schedule_date");
            el.setTextContent(tmpApp.getSchedule_date());
            app.appendChild(el);

            el = doc.createElement("caretaker_name");
            el.setTextContent(tmpApp.getCaretaker_name());
            app.appendChild(el);

            el = doc.createElement("caretaker_phone");
            el.setTextContent(tmpApp.getCaretaker_phone());
            app.appendChild(el);

            el = doc.createElement("vaccine_dose");
            el.setTextContent(tmpApp.getVaccine_dose());
            app.appendChild(el);


        }

        // transform the Document into a String
        DOMSource domSource = new DOMSource(doc);
        TransformerFactory tf = TransformerFactory.newInstance();
        Transformer transformer=null;
        
        try {
            transformer = tf.newTransformer();
        } catch (TransformerConfigurationException ex) {
            ex.printStackTrace();
        }

        transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "yes");
        transformer.setOutputProperty(OutputKeys.METHOD, "xml");
        transformer.setOutputProperty(OutputKeys.ENCODING,"ISO-8859-1");
        transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");
        transformer.setOutputProperty(OutputKeys.INDENT, "yes");

        StringWriter sw = new StringWriter();
        StreamResult sr = new StreamResult(sw);
        try {
            transformer.transform(domSource, sr);
        } catch (TransformerException ex) {
            ex.printStackTrace();
        }

        String xml = sw.toString();


        return xml;
    }

}
