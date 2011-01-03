package org.openxdata.modules.workflows.client.parser;

import java.util.ArrayList;
import java.util.List;

import org.openxdata.modules.workflows.client.maps.SpecStudyMap;
import org.openxdata.server.admin.model.StudyDef;

import com.google.gwt.xml.client.Element;
import com.google.gwt.xml.client.Node;
import com.google.gwt.xml.client.NodeList;
import org.openxdata.modules.workflows.model.shared.OSpecification;

public class SpecStudyParser
{

    private List<TaskFormDefParser> taskFormDefParsers = new ArrayList<TaskFormDefParser>();
    private String specId;
    private String studyId;
    private String id;

    public SpecStudyParser(Node item)
    {
        Element doc = (Element) item;
        specId = doc.getAttribute("SpecId");
        studyId = doc.getAttribute("StudyId");
        id = doc.getAttribute("Id");
        constructTaskFormDefParsers(doc);
    }

    private void constructTaskFormDefParsers(Element doc)
    {

        NodeList taskFormMaps = doc.getElementsByTagName("TaskFormMaps");
        if (taskFormMaps.getLength() < 1) {
            throw new RuntimeException("Expecting <TaskFormMaps>");
        }
        NodeList taskFormDefMaps = ((Element) (taskFormMaps.item(0))).getElementsByTagName("TaskFormDef");
        for (int i = 0; i < taskFormDefMaps.getLength(); i++) {
            taskFormDefParsers.add(new TaskFormDefParser(taskFormDefMaps.item(i)));
        }
    }

    public SpecStudyMap construct(OSpecification spec, StudyDef study)
    {
        SpecStudyMap map = new SpecStudyMap(spec, study);
        if(id != null){
            map.setId(Integer.parseInt(id));
        }
        for (TaskFormDefParser tskForParser : taskFormDefParsers) {
            tskForParser.putInTaskFormMaps(map);

        }
        return map;
    }


    public String getSpecId()
    {
        return specId;
    }

    public String getStudyId()
    {
        return studyId;
    }
}
