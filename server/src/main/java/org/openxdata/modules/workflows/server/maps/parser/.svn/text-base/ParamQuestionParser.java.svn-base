package org.openxdata.modules.workflows.server.maps.parser;

import org.w3c.dom.Element;
import org.w3c.dom.Node;

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

    boolean isFor(String parameter)
    {
       return this.parameter.equals(parameter);
   }
}
