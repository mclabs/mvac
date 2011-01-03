
package org.openxdata.workflow.mobile.model;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.Vector;
import org.openxdata.db.util.AbstractRecord;
import org.openxdata.db.util.PersistentHelper;

/**
 *
 * @author kay
 */
public class MWorkItem extends AbstractRecord
{
    private String taskName;
    private String taskId;
    private String caseId;
    private Integer studyId;
    private Integer formId;
    private String description;
    private Integer dataRecId = new Integer(-1);
    private Vector prefilledQns;

    public void write(DataOutputStream dos) throws IOException
    {
        PersistentHelper.writeUTF(dos, taskName);
        PersistentHelper.writeUTF(dos, taskId);
        PersistentHelper.writeUTF(dos, caseId);
        PersistentHelper.writeInteger(dos, studyId);
        PersistentHelper.writeInteger(dos, formId);
        PersistentHelper.writeUTF(dos, description);
        PersistentHelper.writeInteger(dos, dataRecId);
        PersistentHelper.writeBig(prefilledQns, dos);
    }

    public void read(DataInputStream dis) throws IOException, InstantiationException, IllegalAccessException
    {
        taskName = PersistentHelper.readUTF(dis);
        taskId = PersistentHelper.readUTF(dis);
        caseId = PersistentHelper.readUTF(dis);
        studyId = PersistentHelper.readInteger(dis);
        formId = PersistentHelper.readInteger(dis);
        description = PersistentHelper.readUTF(dis);
        dataRecId = PersistentHelper.readInteger(dis);
        prefilledQns = PersistentHelper.readBig(dis, new MQuestionMap().getClass());
    }

    public String getDisplayName()
    {
        StringBuffer builder = new StringBuffer(getTaskName());
        String prefilledString = getPrefilledString();
        if (prefilledString.length() != 0)
            builder.append('{').append(prefilledString).append('}');

        return builder.toString();
    }

    public String getPrefilledString()
    {
        StringBuffer builder = new StringBuffer();
        for (int i = 0; i < prefilledQns.size(); i++) {
            MQuestionMap mQuestionMap = (MQuestionMap) prefilledQns.elementAt(i);
            if (mQuestionMap.isForTitle()) {
                if (builder.length() == 0)
                    builder.append(mQuestionMap.getValue());
                else
                    builder.append('-').append(mQuestionMap.getValue());
            }
        }
        return builder.toString();
    }

    public int getDataRecId()
    {
        return dataRecId.intValue();
    }

    public void setDataRecId(Integer dataRecId)
    {
        this.dataRecId = dataRecId;
    }

    public String getDescription()
    {
        return description;
    }



    public void setDescription(String description)
    {
        this.description = description;
    }

    public int getFormId()
    {
        return formId.intValue();
    }

    public void setFormId(Integer formId)
    {
        this.formId = formId;
    }

    public int getStudyId()
    {
        return studyId.intValue();
    }

    public void setStudyId(Integer studyId)
    {
        this.studyId = studyId;
    }

    public String getTaskName()
    {
        return taskName;
    }

    public void setTaskName(String taskName)
    {
        this.taskName = taskName;
    }

    public String getWorkItemId()
    {
        return caseId + ":" + taskId;
    }

    public Vector getPrefilledQns()
    {
        return prefilledQns;
    }

    public void setPrefilledQns(Vector prefilledQns)
    {
        this.prefilledQns = prefilledQns;
    }

    public String getCaseId()
    {
        return caseId;
    }

    public void setCaseId(String caseId)
    {
        this.caseId = caseId;
    }

    public String getTaskId()
    {
        return taskId;
    }

    public void setTaskId(String taskId)
    {
        this.taskId = taskId;
    }

    public boolean equals(Object obj)
    {
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        final MWorkItem other = (MWorkItem) obj;
        if ((this.taskId == null) ? (other.taskId != null) : !this.taskId.equals(other.taskId))
            return false;
        if ((this.caseId == null) ? (other.caseId != null) : !this.caseId.equals(other.caseId))
            return false;
        return true;
    }

    public int hashCode()
    {
        int hash = 3;
        hash = 59 * hash + (this.taskId != null ? this.taskId.hashCode() : 0);
        hash = 59 * hash + (this.caseId != null ? this.caseId.hashCode() : 0);
        return hash;
    }

  
}
