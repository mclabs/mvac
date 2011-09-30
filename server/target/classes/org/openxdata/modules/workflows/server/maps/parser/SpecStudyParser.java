package org.openxdata.modules.workflows.server.maps.parser;

import java.util.ArrayList;
import java.util.List;
import org.openxdata.server.util.XmlUtil;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

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

    public SpecStudyParser(String mapXML)
    {
        this(XmlUtil.fromString2Doc(mapXML).getFirstChild());
    }

    private void constructTaskFormDefParsers(Element doc)
    {

        NodeList taskFormMaps = doc.getElementsByTagName("TaskFormMaps");
        if (taskFormMaps.getLength() < 1) {
            throw new RuntimeException("Expecting <TaskFormMaps>");
        }
        NodeList taskFormDefMaps = ((Element) (taskFormMaps.item(0))).getElementsByTagName("TaskFormDef");
        for (int i = 0; i < taskFormDefMaps.getLength(); i++) {
            taskFormDefParsers.add(new TaskFormDefParser((Element) taskFormDefMaps.item(i)));
        }
    }

    public List<TaskFormDefParser> getTaskFormDefParsers()
    {
        return new ArrayList<TaskFormDefParser>(taskFormDefParsers);
    }

    public String getFormIdForTask(String taskId)
    {
        for (TaskFormDefParser taskFormDefParser : taskFormDefParsers) {
            if (taskFormDefParser.getTaskId().equals(taskId))
                return taskFormDefParser.getFormId();
        }
        return null;
    }

    public String getSpecId()
    {
        return specId;
    }

    public String getStudyId()
    {
        return studyId;
    }

    public String getId()
    {
        return id;
    }

    public String getQuestionText(String taskId,String formVId, String parameter)
    {
        for (TaskFormDefParser taskFDefParser : taskFormDefParsers) {
            if (taskFDefParser.isFor(taskId)) {
                String qnText = taskFDefParser.getQuestionText(formVId,parameter);
                return qnText;
            }
        }
        return null;
    }
}
