package org.openxdata.modules.workflows.client.maps;

import java.io.Serializable;

import org.openxdata.modules.workflows.model.shared.OParameter;
import org.purc.purcforms.client.model.QuestionDef;

public class ParamQuestionMap implements Serializable
{

    private static final long serialVersionUID = 1L;
    private OParameter parameter;
    private QuestionDef questionDef;
    private TaskFormVersionMap tFormVersionMap;

    public ParamQuestionMap(OParameter parameter, QuestionDef questionDef,
                            TaskFormVersionMap tFormVersionMap)
    {
        this.parameter = parameter;
        this.questionDef = questionDef;
        this.tFormVersionMap = tFormVersionMap;
    }

    public String getUniqueName()
    {
        return parameter.getName() + "/" + questionDef.getVariableName();
    }

    public OParameter getOParameter()
    {
        return parameter;
    }

    public QuestionDef getQuestionDef()
    {
        return questionDef;
    }

    public TaskFormVersionMap gettFormVersionMap()
    {
        return tFormVersionMap;
    }

    public String asXml()
    {
        StringBuilder builder = new StringBuilder();
        builder.append("<ParamQuestion ");
        builder.append("Question='").append(questionDef.getVariableName()).append("' ");
        builder.append("Parameter='").append(parameter.getName()).append("'>");
        builder.append("</ParamQuestion>");
        return builder.toString();
    }
}
