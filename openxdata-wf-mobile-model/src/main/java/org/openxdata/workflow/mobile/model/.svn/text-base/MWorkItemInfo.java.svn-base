
package org.openxdata.workflow.mobile.model;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import org.openxdata.db.util.Persistent;
import org.openxdata.db.util.PersistentHelper;

/**
 *
 * @author kay
 */
public class MWorkItemInfo implements Persistent
{
    private String caseId;
    private String taskId;
    private String description;

    public void write(DataOutputStream dos) throws IOException
    {
        PersistentHelper.writeUTF(dos, caseId);
        PersistentHelper.writeUTF(dos, taskId);
        PersistentHelper.writeUTF(dos, description);
    }

    public void read(DataInputStream dis) throws IOException, InstantiationException, IllegalAccessException
    {
        caseId = PersistentHelper.readUTF(dis);
        taskId = PersistentHelper.readUTF(dis);
        description = PersistentHelper.readUTF(dis);
    }

    public String getDescription()
    {
        return description;
    }

    public void setDescription(String description)
    {
        this.description = description;
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

    public MWorkItemInfo submissionWIR(){
        MWorkItemInfo info = new MWorkItemInfo();
        info.caseId = caseId;
        info.taskId = taskId;
        return info;
    }


}
