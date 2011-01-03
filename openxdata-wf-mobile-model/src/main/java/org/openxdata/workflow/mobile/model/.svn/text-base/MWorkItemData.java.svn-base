
package org.openxdata.workflow.mobile.model;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import org.openxdata.db.util.Persistent;
import org.openxdata.db.util.PersistentHelper;
import org.openxdata.model.FormData;
import org.openxdata.model.StudyData;
import org.openxdata.model.StudyDataList;

/**
 *
 * @author kay
 */
public class MWorkItemData implements Persistent
{
    private String taskName;
    private String taskId;
    private String caseId;
    private StudyDataList formData;

    public MWorkItemData()
    {
    }

    public void write(DataOutputStream dos) throws IOException
    {
        PersistentHelper.writeUTF(dos, taskName);
        PersistentHelper.writeUTF(dos, taskId);
        PersistentHelper.writeUTF(dos, caseId);
        formData.write(dos);
    }

    public void read(DataInputStream dis) throws IOException, InstantiationException, IllegalAccessException
    {
        taskName = PersistentHelper.readUTF(dis);
        taskId = PersistentHelper.readUTF(dis);
        caseId = PersistentHelper.readUTF(dis);
        formData = new StudyDataList();
        formData.read(dis);
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

    public StudyDataList getFormData()
    {
        return formData;
    }

    public void setFormData(StudyDataList formData)
    {
        this.formData = formData;
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

    public int getFormId()
    {
        FormData data = getFormDataData();
        return data.getDefId();
    }

    public FormData getFormDataData()
    {
        StudyData studyData = (StudyData) formData.getStudies().elementAt(0);
        FormData data = (FormData) studyData.getForms().elementAt(0);
        return data;
    }
}
