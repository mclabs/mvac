package org.openxdata.modules.workflows.model.shared;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author kay
 */
public class GWTFriendlyWorkItem  implements Serializable{

    private String workItemId;
    private String state;
    private String enabledTime;
    private String taskName;
    private ArrayList<WorkItemQuestion> inputParams = new ArrayList<WorkItemQuestion>();
    private ArrayList<WorkItemQuestion> outputParams = new ArrayList<WorkItemQuestion>();

    GWTFriendlyWorkItem()
    {
    }



    public GWTFriendlyWorkItem(String workItemId) {
        this.workItemId = workItemId;
    }

    public ArrayList<WorkItemQuestion> getInputParams() {
        return inputParams;
    }

    public ArrayList<WorkItemQuestion> getOutputParams() {
        return outputParams;
    }

    public String getWorkItemId() {
        return workItemId;
    }

    public void setState(String state)
    {
        this.state = state;
    }

    public String getState()
    {
        return state;
    }

    public String getEnabledTime()
    {
        return enabledTime;
    }

    public void setEnabledTime(String enabledTime)
    {
        this.enabledTime = enabledTime;
    }

    public String getTaskNames4Disp()
    {
        return taskName;
    }

    public void setTaskName4Disp(String taskName)
    {
        this.taskName = taskName;
    }


 
}
