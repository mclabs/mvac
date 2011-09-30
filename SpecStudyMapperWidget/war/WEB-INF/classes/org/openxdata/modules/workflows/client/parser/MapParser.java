package org.openxdata.modules.workflows.client.parser;

import java.util.ArrayList;
import java.util.List;

import org.openxdata.modules.workflows.client.maps.SpecStudyMap;
import org.openxdata.server.admin.model.StudyDef;

import com.google.gwt.xml.client.Document;
import com.google.gwt.xml.client.Element;
import com.google.gwt.xml.client.Node;
import com.google.gwt.xml.client.NodeList;
import com.google.gwt.xml.client.XMLParser;
import org.openxdata.modules.workflows.model.shared.OSpecification;

public class MapParser
{

    public static List<SpecStudyMap> createMaps(List<OSpecification> specsLst,
                                                List<StudyDef> studyLst,
                                                String xmlMap)
    {

        List<SpecStudyParser> specStudyMapParsers = parseXMLMap(xmlMap);
        List<SpecStudyMap> specStudyMaps = new ArrayList<SpecStudyMap>();

        for (SpecStudyParser specStudyParser : specStudyMapParsers) {
            OSpecification spec = getSpecWithId(specsLst, specStudyParser.getSpecId());
            StudyDef study = getStudyWithName(studyLst, specStudyParser.getStudyId());
            if (spec != null && study != null) {
                specStudyMaps.add(specStudyParser.construct(spec, study));
            }
        }
        return specStudyMaps;
    }

    public static List<SpecStudyParser> parseXMLMap(String xml)
    {
        ArrayList<SpecStudyParser> specStudyParsers = new ArrayList<SpecStudyParser>();

        Document doc = XMLParser.parse(xml);
        NodeList specStudyXMLMaps = doc.getElementsByTagName("SpecStudyMap");

        int length = specStudyXMLMaps.getLength();

        for (int i = 0; i < length; i++) {
            specStudyParsers.add(parseSpecStudy(specStudyXMLMaps.item(i)));
        }
        return specStudyParsers;
    }

    public static SpecStudyParser parseSpecStudy(Node specStudyXML)
    {
        Element specStudyNode = (Element) specStudyXML;
        SpecStudyParser parser = new SpecStudyParser(specStudyNode);
        return parser;
    }

    private static StudyDef getStudyWithName(List<StudyDef> studies,
                                             String studyId)
    {
        for (StudyDef studyDef : studies) {
            if (studyDef.getName().equals(studyId)) {
                return studyDef;
            }
        }
        return null;
    }

    private static OSpecification getSpecWithId(List<OSpecification> specs,
                                                String specId)
    {
        for (OSpecification oSpecification : specs) {
            if (oSpecification.getUniqueName().equals(specId)) {
                return oSpecification;
            }
        }
        return null;
    }
}
