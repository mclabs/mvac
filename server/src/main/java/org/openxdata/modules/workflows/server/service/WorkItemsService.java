package org.openxdata.modules.workflows.server.service;

import java.util.List;
import java.util.Map;
import org.openxdata.modules.workflows.model.shared.WorkItemQuestion;
import org.yawlfoundation.yawl.elements.data.YParameter;

import org.yawlfoundation.yawl.engine.interfce.WorkItemRecord;

public interface WorkItemsService
{
    public void saveWorkItem(WorkItemRecord workItemRecord);

    public void deleteWorkItem(WorkItemRecord workItemRecord);

    public List<WorkItemRecord> getWorkItems();

    public List<WorkItemRecord> getEnabledWorkItems();

    public WorkItemRecord getWorkitem(String caseId, String taskId);

    public Map<String, YParameter> getOutputParam(WorkItemRecord wir);

    public void submitWorkItem(WorkItemRecord workitem, List<WorkItemQuestion> qnList);

    public List<WorkItemRecord> getMappedWorkItems(String status);

    public void deleteWorkItemInCase(String caseId);
}
