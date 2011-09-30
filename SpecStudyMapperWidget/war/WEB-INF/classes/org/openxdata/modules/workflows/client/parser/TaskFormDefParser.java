package org.openxdata.modules.workflows.client.parser;

import java.util.ArrayList;
import java.util.List;

import org.openxdata.modules.workflows.client.maps.SpecStudyMap;
import org.openxdata.modules.workflows.client.maps.TaskFormDefMap;
import org.openxdata.modules.workflows.client.maps.TaskFormVersionMap;
import org.openxdata.server.admin.model.FormDef;

import com.google.gwt.xml.client.Element;
import com.google.gwt.xml.client.Node;
import com.google.gwt.xml.client.NodeList;

public class TaskFormDefParser
{

    // TaskId="Patient_3" FormId="0"
    List<TaskFormVersionParser> taskFormVParsers = new ArrayList<TaskFormVersionParser>();
    private String taskId;
    private String formId;

    public TaskFormDefParser(Node item)
    {
        Element elem = (Element) item;
        if (!item.getNodeName().equals("TaskFormDef")) {
            throw new RuntimeException("Expecting TaskFormDef");
        }
        taskId = elem.getAttribute("TaskId");
        formId = elem.getAttribute("FormId");

        populateTaskFormVersionParser(item);
    }

    private void populateTaskFormVersionParser(Node item)
    {
        Element taskFormVersionMaps = (Element) ((Element) item).getElementsByTagName("TaskFormVersionMaps").item(0);
        if (!taskFormVersionMaps.getNodeName().equals("TaskFormVersionMaps")) {
            throw new RuntimeException("Expecting TaskFormVersionMaps");
        }

        NodeList taskFormVerMaps = taskFormVersionMaps.getElementsByTagName("TaskFormVersion");

        for (int i = 0; i < taskFormVerMaps.getLength(); i++) {
            taskFormVParsers.add(new TaskFormVersionParser(taskFormVerMaps.item(i)));
        }

    }

    public String getTaskId()
    {
        return taskId;
    }

    public String getFormId()
    {
        return formId;
    }

    public TaskFormDefMap putInTaskFormMaps(SpecStudyMap map)
    {
        FormDef formWithId = map.getFormWithId(Integer.parseInt(this.formId));
        if (formWithId == null) {
            throw new RuntimeException("Form with id " + formId
                    + ". Does not exist");
        }

        TaskFormDefMap taskFormMap = map.addTaskFormDefMap(taskId, formWithId.getName());

        List<TaskFormVersionMap> formVersionMaps = taskFormMap.getFormVersionMaps();

        //Get all all form versions and get which parser it corresponds to
        //then inject in the question maps
        for (TaskFormVersionMap taskFormVersionMap : formVersionMaps) {
            for (TaskFormVersionParser taskFormVerP : taskFormVParsers) {
                if (taskFormVerP.isFor(taskFormVersionMap)) {
                    taskFormVerP.buildQuestionMapsFor(taskFormVersionMap);
                }
            }

        }
        return taskFormMap;
    }
}
