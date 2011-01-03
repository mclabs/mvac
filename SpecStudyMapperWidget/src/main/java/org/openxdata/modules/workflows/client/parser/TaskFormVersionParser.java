package org.openxdata.modules.workflows.client.parser;

import com.google.gwt.user.client.Window;
import java.util.ArrayList;
import java.util.List;
import org.openxdata.modules.workflows.shared.exception.TypeMisMatchException;

import org.openxdata.modules.workflows.client.maps.TaskFormVersionMap;
import org.purc.purcforms.client.model.QuestionDef;

import com.google.gwt.xml.client.Element;
import com.google.gwt.xml.client.Node;
import com.google.gwt.xml.client.NodeList;

public class TaskFormVersionParser
{
    // TaskId="Patient_3" FormVersionId="0"
    private List<ParamQuestionParser> paramQuestionParsers = new ArrayList<ParamQuestionParser>();
    private String taskId;
    private String formVersionId;

    public TaskFormVersionParser(Node item)
    {
        if (!item.getNodeName().equals("TaskFormVersion"))
            throw new RuntimeException("Expecting TaskFormVersion");

        Element elem = (Element) item;
        taskId = elem.getAttribute("TaskId");
        formVersionId = elem.getAttribute("FormVersionId");

        buildParamQuestionParsers(item);
    }

    private void buildParamQuestionParsers(Node item)
    {
        Element elem = (Element) item;
        NodeList paramQns = elem.getElementsByTagName("ParamQuestion");

        for (int i = 0; i < paramQns.getLength(); i++) {
            paramQuestionParsers.add(new ParamQuestionParser(paramQns.item(i)));
        }
    }

    public boolean isFor(TaskFormVersionMap taskFormVersionMap)
    {
        return (taskFormVersionMap.getTask().getId().equals(taskId))
                && (taskFormVersionMap.getFormVersion().getFormDefVersionId() == Integer.parseInt(formVersionId));

    }

    public void buildQuestionMapsFor(TaskFormVersionMap taskFormVersionMap)
    {
        for (ParamQuestionParser paramQnParser : paramQuestionParsers) {
            QuestionDef question = taskFormVersionMap.getQuestionWithBinding(paramQnParser.getQuestion());
            try {
                taskFormVersionMap.addParamQuestionMap(paramQnParser.getParameter(), question.getVariableName());
            } catch (TypeMisMatchException ex) {
                Window.alert("Error while Parsing XML Map: "+ ex.getMessage());
                ex.printStackTrace();
            }
        }
    }
}
