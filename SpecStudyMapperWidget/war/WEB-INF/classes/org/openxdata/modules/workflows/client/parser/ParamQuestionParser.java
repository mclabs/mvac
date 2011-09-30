package org.openxdata.modules.workflows.client.parser;

import com.google.gwt.xml.client.Element;
import com.google.gwt.xml.client.Node;

public class ParamQuestionParser
{
    // <ParamQuestion Question="patientid" Parameter="weight"/>

    private String question;
    private String parameter;

    public ParamQuestionParser(Node item)
    {
	Element elem = (Element) item;
	question = elem.getAttribute("Question");
	parameter = elem.getAttribute("Parameter");
    }

    public String getQuestion()
    {
        return question;
    }

    public String getParameter()
    {
        return parameter;
    }

    
}
