package org.openxdata.modules.workflows.server.maps.parser;

import java.util.ArrayList;
import java.util.List;

import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

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

    public List<ParamQuestionParser> getParamQuestionParsers()
    {
        return new ArrayList<ParamQuestionParser>(paramQuestionParsers);
    }

    public String getFormVersionId()
    {
        return formVersionId;
    }

    public String getTaskId()
    {
        return taskId;
    }

    String getQuestionFor(String parameter)
    {
        for (ParamQuestionParser paramQuestionParser : paramQuestionParsers) {
            if(paramQuestionParser.isFor(parameter))
                return paramQuestionParser.getQuestion();
        }
        return null;
    }



//    public boolean isFor(TaskFormVersionMap taskFormVersionMap)
//    {
//	return (taskFormVersionMap.getTask().getId().equals(taskId))
//		&& (taskFormVersionMap.getFormVersion().getFormDefVersionId() == Integer
//			.parseInt(formVersionId));
//
//    }
//
//    public void buildQuestionMapsFor(TaskFormVersionMap taskFormVersionMap)
//    {
//	for (ParamQuestionParser paramQnParser : paramQuestionParsers) {
//	    QuestionDef question = taskFormVersionMap.getQuestionWithBinding(paramQnParser.getQuestion());
//	    taskFormVersionMap.addParamQuestionMap(paramQnParser.getParameter(), question.getText());
//	}
//    }

}
