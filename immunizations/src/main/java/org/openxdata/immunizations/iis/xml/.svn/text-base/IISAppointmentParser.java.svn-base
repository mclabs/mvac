/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.openxdata.immunizations.iis.xml;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringWriter;
import java.util.Hashtable;
import java.util.logging.Level;
import java.util.logging.Logger;
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
import org.w3c.dom.Document;
import org.xml.sax.SAXException;


/**
 *class to parse IIS xml
 * @author soyfactor
 */
public class IISAppointmentParser {
    public Hashtable handlers;
    private DocumentBuilder builder;
    
    public IISAppointmentParser(){
        try {
            builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            
        } catch (ParserConfigurationException ex) {
            Logger.getLogger(IISAppointmentParser.class.getName()).log(Level.SEVERE, null, ex);
        }

        handlers = new Hashtable();
        initHandlers();

    }


    public Object getObjects(String xml,String type){
        Object result=null;

        Document doc = getDoc(xml);

        if (type.equals("appointments")) {
            result = ((IElementHandler)handlers.get(type)).handle(doc.getElementsByTagName(type));
        }

        return result;

    }

    private Document getDoc(String xml){
        Document doc=null;
        try {
            InputStream inputStream = getInputStream(xml);
            doc = builder.parse(inputStream);
        } catch (SAXException ex) {
            Logger.getLogger(IISAppointmentParser.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(IISAppointmentParser.class.getName()).log(Level.SEVERE, null, ex);
        }
        printXML(doc);
        return doc;

    }


    private InputStream getInputStream(String xml){
        byte [] data = xml.getBytes();

        ByteArrayInputStream bain = new ByteArrayInputStream(data);

        return bain;
    }

    private void initHandlers() {
        handlers.put("appointments", new AppointmentsElementHandler());
    }

    public void printXML(Document doc){
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
        System.out.println(xml);

    }


}
