package org.openxdata.modules.workflows.model.shared;

import java.io.Serializable;

/**
 *
 * @author kay
 */
public class WorkItemQuestion implements Serializable
{
    private String type;
    private String question;
    private String answer;

    public WorkItemQuestion(String type, String question, String answer)
    {
        this.type = type;
        this.question = question;
        this.answer = answer;
    }

    public WorkItemQuestion(String question, String answer)
    {
        this.question = question;
        this.answer = answer;
    }

    public String getAnswer()
    {
        return answer;
    }

    public void setAnswer(String answer)
    {
        this.answer = answer;
    }

    public String getQuestion()
    {
        return question;
    }

    public void setQuestion(String question)
    {
        this.question = question;
    }

    public String getType()
    {
        return type;
    }

    public void setType(String type)
    {
        this.type = type;
    }

    public String toXML()
    {
        StringBuilder builder = new StringBuilder();
        builder.append("<").append(question).append(">");
        builder.append(answer);
        builder.append("</").append(question).append(">");
        return builder.toString();
    }
}
